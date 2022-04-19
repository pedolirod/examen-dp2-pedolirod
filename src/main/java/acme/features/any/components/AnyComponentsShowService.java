package acme.features.any.components;

import org.springframework.beans.factory.annotation.Autowired;

import acme.artifact.Artifact;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.roles.Any;
import acme.framework.services.AbstractShowService;

public class AnyComponentsShowService implements AbstractShowService<Any, Artifact>{
	
	@Autowired
	protected AnyComponentsRepository repository;
	


	@Override
	public boolean authorise(final Request<Artifact> request) {
		// TODO Auto-generated method stub
		assert request != null;
		
		return true;
	}

	@Override
	public Artifact findOne(final Request<Artifact> request) {
		// TODO Auto-generated method stub
		assert request != null;
		
		Artifact result;
		int id;
		
		id= request.getModel().getInteger("id");
		result= this.repository.findOneComponentById(id);
		
		
		return result;
	}

	@Override
	public void unbind(final Request<Artifact> request, final Artifact entity, final Model model) {
		// TODO Auto-generated method stub
		assert request != null;
		assert entity != null;
		assert model != null;
		
		request.unbind(entity, model, "name", "code", "technology", "description", "retailPrice", "link", "type", "inventor"); 
		
	}

	
	
}
