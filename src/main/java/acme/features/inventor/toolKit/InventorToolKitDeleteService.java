package acme.features.inventor.toolKit;

import org.springframework.stereotype.Service;

import acme.artifact.ToolKit;
import acme.framework.components.models.Model;
import acme.framework.controllers.Errors;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractDeleteService;
import acme.roles.Inventor;

@Service
public class InventorToolKitDeleteService implements AbstractDeleteService<Inventor, ToolKit> {
	
	protected InventorToolKitRepository repository;
	
	@Override
	public boolean authorise(final Request<ToolKit> request) {
		return true;
	}

	@Override
	public void bind(final Request<ToolKit> request, final ToolKit entity, final Errors errors) {
		assert request !=null;
		assert entity !=null;
		assert errors !=null;
		
		request.bind(entity, errors, "code", "title", "description", "assemblyNotes", "link");
	}

	@Override
	public void unbind(final Request<ToolKit> request, final ToolKit entity, final Model model) {
		assert request !=null;
		assert entity !=null;
				
		request.unbind(entity, model, "code", "title", "description", "assemblyNotes", "link");
	}

	@Override
	public ToolKit findOne(final Request<ToolKit> request) {
		assert request != null;
		final int id = request.getModel().getInteger("id");
		final ToolKit result = this.repository.findOneToolKitById(id);
		return result;
	}

	@Override
	public void validate(final Request<ToolKit> request, final ToolKit entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
	}

	@Override
	public void delete(final Request<ToolKit> request, final ToolKit entity) {
		assert request != null;
		assert entity != null;
		
		this.repository.delete(entity);		
	}



}
