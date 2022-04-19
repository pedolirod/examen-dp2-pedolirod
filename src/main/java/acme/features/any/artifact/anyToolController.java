package acme.features.any.artifact;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import acme.artifact.Artifact;
import acme.framework.controllers.AbstractController;
import acme.framework.roles.Any;

@Controller
public class anyToolController extends AbstractController<Any, Artifact> {

	// Internal state ---------------------------------------------------------

	@Autowired
	protected anyToolListService	listService;

	@Autowired
	protected anyToolShowService	showService;

	// Constructors -----------------------------------------------------------


	@PostConstruct
	protected void initialise() {
		super.addCommand("list", this.listService);
		super.addCommand("show", this.showService);
	}

}
