package acme.features.inventor.hustle;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.artifact.Artifact;
import acme.artifact.ArtifactType;
import acme.entities.hustle.Hustle;
import acme.framework.components.models.Model;
import acme.framework.controllers.Errors;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractCreateService;
import acme.roles.Inventor;

@Service
public class HustleCreateService implements AbstractCreateService<Inventor, Hustle> {

	// Internal state ---------------------------------------------------------

	@Autowired
	protected HustleRepository repository;

	// AbstractCreateService<Inventor, Hustle> interface --------------


	@Override
	public boolean authorise(final Request<Hustle> request) {
		assert request != null;

		return true;
	}

	@Override
	public Hustle instantiate(final Request<Hustle> request) {
		assert request != null;

		Hustle result;

		result = new Hustle();
		result.setComponent(this.repository.findComponentList(ArtifactType.COMPONENT).get(0));

		return result;
	}

	@Override
	public void bind(final Request<Hustle> request, final Hustle entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		final Date moment= new Date(System.currentTimeMillis() - 1);

		request.bind(entity, errors, "code", "theme", "summary", "period", "share", "furtherInfo");
		
		entity.setCreationMoment(moment);
		
	}

	@Override
	public void validate(final Request<Hustle> request, final Hustle entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		
		errors.state(request, entity.getShare().getAmount() > 0, "share", "inventor.Hustle.code.repeated.share.non-negative");
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
	public void unbind(final Request<Hustle> request, final Hustle entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "code", "theme", "summary", "period", "share", "furtherInfo");
		model.setAttribute("isNew", true);
		final List<Artifact> listArt = this.repository.findComponentList(ArtifactType.COMPONENT);
		final Artifact a = new Artifact();
		listArt.add(a);
		model.setAttribute("artifact", listArt);
	}

	@Override
	public void create(final Request<Hustle> request, final Hustle entity) {
		assert request != null;
		assert entity != null;

		final Artifact art=this.repository.findComponentById(request.getModel().getInteger("artifactId"),ArtifactType.COMPONENT);
		
		entity.setComponent(art);
		
		this.repository.save(entity);
	}

}
