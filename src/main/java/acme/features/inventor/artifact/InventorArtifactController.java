package acme.features.inventor.artifact;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;

import acme.artifact.Artifact;
import acme.framework.controllers.AbstractController;
import acme.roles.Inventor;

public class InventorArtifactController extends AbstractController<Inventor, Artifact>{

	@Autowired
	protected InventorComponentListService componentListService;
	
	@Autowired
	protected InventorToolListService toolListService;
	
	@Autowired
	protected InventorArtifactShowService showService;
	
	
		
	
	
	@PostConstruct
	protected void initialise() {
		super.addCommand("list-component","list", this.componentListService);
		super.addCommand("list-tool", "list", this.toolListService);
		super.addCommand("show", this.showService);
	}
	
}
