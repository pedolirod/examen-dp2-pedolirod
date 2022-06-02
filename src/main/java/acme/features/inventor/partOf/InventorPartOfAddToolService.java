package acme.features.inventor.partOf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.artifact.Artifact;
import acme.artifact.ArtifactType;
import acme.artifact.PartOf;
import acme.artifact.ToolKit;
import acme.framework.components.models.Model;
import acme.framework.controllers.Errors;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractCreateService;
import acme.roles.Inventor;

@Service
public class InventorPartOfAddToolService implements AbstractCreateService<Inventor, PartOf> {

	// Internal state ---------------------------------------------------------

	@Autowired
	protected InventorPartOfRepository repository;

	// AbstractCreateService<Inventor, PartOf> interface --------------


	@Override
	public boolean authorise(final Request<PartOf> request) {
		assert request != null;

		return true;
	}

	@Override
	public PartOf instantiate(final Request<PartOf> request) {
		assert request != null;

		PartOf result;

		result = new PartOf();
		final int masterId = request.getModel().getInteger("masterId");
		final ToolKit toolKit = this.repository.findOneToolKitById(masterId);
		result.setToolkit(toolKit);

		return result;
	}

	@Override
	public void bind(final Request<PartOf> request, final PartOf entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		
		request.bind(entity, errors, "quantity");
		entity.setArtifact((Artifact) request.getModel().getAttribute("artifact"));
		
	}

	@Override
	public void validate(final Request<PartOf> request, final PartOf entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

	}

	@Override
	public void unbind(final Request<PartOf> request, final PartOf entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "quantity", "artifact", "toolkit");
		final int i = request.getPrincipal().getActiveRoleId();
		final Inventor inv = this.repository.findOneInventorByInventorId(i);
		model.setAttribute("artifacts", this.repository.findArtifactsByTypeToolKitInventor(ArtifactType.TOOL, entity.getToolkit(), inv));
	}

	@Override
	public void create(final Request<PartOf> request, final PartOf entity) {
		assert request != null;
		assert entity != null;

		
		this.repository.save(entity);
	}

}
