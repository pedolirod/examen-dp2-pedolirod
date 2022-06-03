package acme.features.inventor.hustle;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.artifact.Artifact;
import acme.artifact.ArtifactType;
import acme.entities.hustle.Hustle;
import acme.framework.components.models.Model;
import acme.framework.controllers.Errors;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractUpdateService;
import acme.roles.Inventor;

@Service
public class HustleUpdateService implements AbstractUpdateService<Inventor, Hustle>{

	@Autowired
	protected HustleRepository repository;

	@Override
	public boolean authorise(final Request<Hustle> request) {
		assert request != null;

		return true;
	}

	@Override
	public void unbind(final Request<Hustle> request, final Hustle entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "code", "creationMoment", "theme", "summary", "period", "share", "furtherInfo");
		model.setAttribute("isNew", false);
		final List<Artifact> listArt = this.repository.findComponentList(ArtifactType.COMPONENT);
		Artifact a = new Artifact();
		listArt.add(0, a);
		a = entity.getComponent();
		if(entity.getComponent() != null) {
			listArt.add(0, a);
		}
		
		model.setAttribute("artifact", listArt);
	}

	@Override
	public Hustle findOne(final Request<Hustle> request) {
		assert request != null;

		Hustle result;
		int id;

		id = request.getModel().getInteger("id");
		result = this.repository.findOneHustleById(id);

		return result;
	}

	@Override
	public void bind(final Request<Hustle> request, final Hustle entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		
		request.bind(entity, errors, "code", "creationMoment", "title", "description", "period", "budget", "link");
	}

	@Override
	public void validate(final Request<Hustle> request, final Hustle entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		
		errors.state(request, entity.getShare().getAmount() > 0, "budget", "inventor.hustle.code.repeated.share.non-negative");
		errors.state(request, entity.getPeriod().after(entity.getCreationMoment()), "period", "inventor.Hustle.period.order-error");
		
		final LocalDateTime startDate = entity.getPeriod().toInstant()
		      .atZone(ZoneId.systemDefault())
		      .toLocalDateTime();
		
		final LocalDateTime finishDate = entity.getCreationMoment().toInstant()
		      .atZone(ZoneId.systemDefault())
		      .toLocalDateTime();
		errors.state(request, Duration.between(finishDate, startDate).toDays() > 30, "period", "inventor.Hustle.period.duration-error");
		
		final Hustle ch = this.repository.findAnyHustleByCode(entity.getCode());
		errors.state(request, ch==null, "code", "inventor.hustle.period.code-error");
	}

	@Override
	public void update(final Request<Hustle> request, final Hustle entity) {
		assert request !=null;
		assert entity !=null;
		
		final Artifact art=this.repository.findComponentById(request.getModel().getInteger("artifactId"), ArtifactType.COMPONENT);
		
		entity.setComponent(art);
		
		this.repository.save(entity);
		
	}
	
	

}
