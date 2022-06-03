package acme.features.inventor.hustle;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import acme.entities.hustle.Hustle;
import acme.framework.controllers.AbstractController;
import acme.roles.Inventor;

@Controller
public class HustleController extends AbstractController<Inventor, Hustle>{
	// Internal state ---------------------------------------------------------

		@Autowired
		protected HustleListService	listService;

		@Autowired
		protected HustleShowService	showService;
		
		@Autowired
		protected HustleUpdateService	updateService;
		
		@Autowired
		protected HustleCreateService	createService;
		
		@Autowired
		protected HustleDeleteService	deleteService;

		// Constructors -----------------------------------------------------------


		@PostConstruct
		protected void initialise() {
			super.addCommand("list", this.listService);
			super.addCommand("show", this.showService);
			super.addCommand("update", this.updateService);
			super.addCommand("create", this.createService);
			super.addCommand("delete", this.deleteService);
		}

}
