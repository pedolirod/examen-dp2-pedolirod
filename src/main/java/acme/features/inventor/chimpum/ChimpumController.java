package acme.features.inventor.chimpum;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import acme.entities.chimpum.Chimpum;
import acme.framework.controllers.AbstractController;
import acme.roles.Inventor;

@Controller
public class ChimpumController extends AbstractController<Inventor, Chimpum>{
	// Internal state ---------------------------------------------------------

		@Autowired
		protected ChimpumListService	listService;

		@Autowired
		protected ChimpumShowService	showService;
		
		@Autowired
		protected ChimpumUpdateService	updateService;
		
		@Autowired
		protected ChimpumCreateService	createService;
		
		@Autowired
		protected ChimpumDeleteService	deleteService;

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
