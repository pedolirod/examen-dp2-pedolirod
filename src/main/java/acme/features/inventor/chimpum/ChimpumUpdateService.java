package acme.features.inventor.chimpum;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.artifact.Artifact;
import acme.entities.chimpum.Chimpum;
import acme.framework.components.models.Model;
import acme.framework.controllers.Errors;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractUpdateService;
import acme.roles.Inventor;

@Service
public class ChimpumUpdateService implements AbstractUpdateService<Inventor, Chimpum>{

	@Autowired
	protected ChimpumRepository repository;

	@Override
	public boolean authorise(final Request<Chimpum> request) {
		assert request != null;

		return true;
	}

	@Override
	public void unbind(final Request<Chimpum> request, final Chimpum entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "code", "creationMoment", "title", "description", "period", "budget", "link");
		model.setAttribute("isNew", false);
		List<Artifact> listArt = this.repository.findArtifactList();
		Artifact a = new Artifact();
		listArt.add(0, a);
		a = entity.getArtefact();
		if(entity.getArtefact() != null) {
			listArt.add(0, a);
		}
		
		model.setAttribute("artifact", listArt);
	}

	@Override
	public Chimpum findOne(final Request<Chimpum> request) {
		assert request != null;

		Chimpum result;
		int id;

		id = request.getModel().getInteger("id");
		result = this.repository.findOneChimpumById(id);

		return result;
	}

	@Override
	public void bind(Request<Chimpum> request, Chimpum entity, Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		
		request.bind(entity, errors, "code", "creationMoment", "title", "description", "period", "budget", "link");
	}

	@Override
	public void validate(Request<Chimpum> request, Chimpum entity, Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		
		errors.state(request, entity.getBudget().getAmount() > 0, "budget", "inventor.Chimpum.code.repeated.retailPrice.non-negative");
		errors.state(request, entity.getPeriod().after(entity.getCreationMoment()), "period", "inventor.Chimpum.period.order-error");
		
		final LocalDateTime startDate = entity.getPeriod().toInstant()
		      .atZone(ZoneId.systemDefault())
		      .toLocalDateTime();
		
		final LocalDateTime finishDate = entity.getCreationMoment().toInstant()
		      .atZone(ZoneId.systemDefault())
		      .toLocalDateTime();
		errors.state(request, Duration.between(finishDate, startDate).toDays() > 30, "period", "inventor.Chimpum.period.duration-error");
		
		Chimpum ch = this.repository.findAnyChimpumByCode(entity.getCode());
		errors.state(request, ch==null, "code", "inventor.Chimpum.period.code-error");
	}

	@Override
	public void update(Request<Chimpum> request, Chimpum entity) {
		assert request !=null;
		assert entity !=null;
		
		final Artifact art=this.repository.findArtifactById(request.getModel().getInteger("artifactId"));
		
		entity.setArtefact(art);
		
		this.repository.save(entity);
		
	}
	
	

}
