package acme.features.inventor.artifact;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import acme.artifact.Artifact;
import acme.framework.controllers.AbstractController;
import acme.framework.roles.Any;
import acme.roles.Inventor;

@Controller
public class InventorArtifactController extends AbstractController<Inventor, Artifact> {

	// Internal state ---------------------------------------------------------

	@Autowired
	protected InventorToolListService	listToolService;
	
	@Autowired
	protected InventorComponentListService	listComponentService;

	@Autowired
	protected InventorArtifactShowService	showService;

	// Constructors -----------------------------------------------------------


	@PostConstruct
	protected void initialise() {
		super.addCommand("list-tool","list", this.listToolService);
		super.addCommand("list-component","list", this.listComponentService);
		super.addCommand("show", this.showService);
	}

}
