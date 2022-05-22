package acme.features.inventor.toolKit;

import org.springframework.stereotype.Service;

import acme.artifact.ToolKit;
import acme.framework.components.models.Model;
import acme.framework.controllers.Errors;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractCreateService;
import acme.roles.Inventor;

@Service
public class InventorToolKitCreateService implements AbstractCreateService<Inventor, ToolKit>{
	
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
		model.setAttribute("masterId", request.getModel().getAttribute("masterId"));
	}

	@Override
	public ToolKit instantiate(final Request<ToolKit> request) {
		//final int masterId = request.getModel().getInteger("masterId");
		final ToolKit res = new ToolKit();
		res.setCode("");
		res.setDescription("");
		res.setLink("");
		res.setTitle("");
		res.setAssemblyNotes("");
		return res;
	}

	@Override
	public void validate(final Request<ToolKit> request, final ToolKit entity, final Errors errors) {
		assert request !=null;
		assert entity !=null;
		assert errors !=null;
	}

	@Override
	public void create(final Request<ToolKit> request, final ToolKit entity) {
		assert request !=null;
		assert entity !=null;
		
		this.repository.save(entity);
	}



}
