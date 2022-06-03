package acme.features.inventor.hustle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.hustle.Hustle;
import acme.framework.components.models.Model;
import acme.framework.controllers.Errors;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractDeleteService;
import acme.roles.Inventor;

@Service
public class HustleDeleteService implements AbstractDeleteService<Inventor, Hustle> {

	// Internal state ---------------------------------------------------------

	@Autowired
	protected HustleRepository repository;


	@Override
	public boolean authorise(final Request<Hustle> request) {
		assert request != null;
		
		return true;
	}

	@Override
	public void validate(final Request<Hustle> request, final Hustle entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		
	}

	@Override
	public void bind(final Request<Hustle> request, final Hustle entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors, "code", "title", "description", "period", "budget", "link");
		
	}

	@Override
	public void unbind(final Request<Hustle> request, final Hustle entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "code", "title", "description", "period", "budget", "link");
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
	public void delete(final Request<Hustle> request, final Hustle entity) {
		assert request != null;
		assert entity != null;
		
		
		this.repository.delete(entity);
		
	}

	

}
