package acme.features.inventor.artifact;

import org.springframework.beans.factory.annotation.Autowired;

import acme.artifact.Artifact;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractShowService;
import acme.roles.Inventor;

public class InventorArtifactShowService implements AbstractShowService<Inventor, Artifact>{
	
	@Autowired
	protected InventorArtifactRepository repository;
	

	@Override
	public boolean authorise(final Request<Artifact> request) {
		
		assert request != null;

		return true;
	}

	@Override
	public Artifact findOne(final Request<Artifact> request) {
		assert request != null;
		
		Artifact result;
		int id;
		
		id=request.getModel().getInteger("id");
		result= this.repository.findOneArtifactlById(id); 
		
		
		return result;
	}

	@Override
	public void unbind(final Request<Artifact> request, final Artifact entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "name", "code", "technology", "description", "retailPrice", "link");
		
	}

}
