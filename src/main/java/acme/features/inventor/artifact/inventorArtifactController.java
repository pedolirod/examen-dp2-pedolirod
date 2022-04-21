package acme.features.inventor.artifact;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import acme.artifact.Artifact;
import acme.framework.controllers.AbstractController;
import acme.framework.roles.Any;
import acme.roles.Inventor;

@Controller
public class inventorArtifactController extends AbstractController<Inventor, Artifact> {

	// Internal state ---------------------------------------------------------

	@Autowired
	protected inventorToolListService	listToolService;
	
	@Autowired
	protected inventorComponentListService	listComponentService;

	@Autowired
	protected inventorArtifactShowService	showService;

	// Constructors -----------------------------------------------------------


	@PostConstruct
	protected void initialise() {
		super.addCommand("list-tool","list", this.listToolService);
		super.addCommand("list-component","list", this.listComponentService);
		super.addCommand("show", this.showService);
	}

}
