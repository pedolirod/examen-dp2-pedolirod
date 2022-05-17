package acme.features.inventor.patronage;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import acme.entities.patronage.Patronage;
import acme.features.patron.patronage.PatronageUpdateService;
import acme.framework.controllers.AbstractController;
import acme.roles.Inventor;

@Controller
public class PatronageControllerInv extends AbstractController<Inventor, Patronage>{
	// Internal state ---------------------------------------------------------

		@Autowired
		protected PatronageListServiceInv	listService;

		@Autowired
		protected PatronageShowServiceInv	showService;
		
		@Autowired
		protected PatronageUpdateServiceInv	updateService;

		// Constructors -----------------------------------------------------------


		@PostConstruct
		protected void initialise() {
			super.addCommand("list", this.listService);
			super.addCommand("show", this.showService);
			super.addCommand("update", this.updateService);
		}

}
