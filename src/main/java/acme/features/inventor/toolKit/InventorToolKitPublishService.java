package acme.features.inventor.toolKit;

import org.springframework.stereotype.Service;

import acme.artifact.ToolKit;
import acme.framework.components.models.Model;
import acme.framework.controllers.Errors;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractUpdateService;
import acme.roles.Inventor;

@Service
public class InventorToolKitPublishService implements AbstractUpdateService<Inventor, ToolKit> {

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
		final int id = request.getModel().getInteger("id");
		
		return this.repository.findOneToolKitById(id);
	}

	@Override
	public void validate(final Request<ToolKit> request, final ToolKit entity, final Errors errors) {
		assert request !=null;
		assert entity !=null;
		assert errors !=null;
		
		if(!errors.hasErrors("code")) {
			final ToolKit existing = this.repository.findOneToolKitById(entity.getId());
			errors.state(request, existing==null || existing.getId() == entity.getId() , "code", "inventor.toolKit.form.duplicated");
		}	
	}

	@Override
	public void update(final Request<ToolKit> request, final ToolKit entity) {
		assert request !=null;
		assert entity !=null;
		
		entity.setPublish(true);
		this.repository.save(entity);
	}


}
