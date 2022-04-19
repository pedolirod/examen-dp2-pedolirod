package acme.features.any.components;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;

import acme.artifact.Artifact;
import acme.framework.controllers.AbstractController;
import acme.framework.roles.Any;

public class AnyComponentsController extends AbstractController<Any, Artifact>{

	
	@Autowired 
	protected AnyComponentsListService listService;
	
	
	@Autowired
	protected AnyComponentsShowService showService;
	
	
	@PostConstruct
	protected void initialise() {
		super.addCommand("show", this.showService);
		super.addCommand("list", this.listService);
	}
	
	
	
	
}
