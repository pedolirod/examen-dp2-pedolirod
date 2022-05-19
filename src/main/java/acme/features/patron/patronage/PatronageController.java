package acme.features.patron.patronage;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import acme.entities.patronage.Patronage;
import acme.framework.controllers.AbstractController;
import acme.roles.Patron;

@Controller
public class PatronageController extends AbstractController<Patron, Patronage>{
	// Internal state ---------------------------------------------------------

		@Autowired
		protected PatronageListService	listService;

		@Autowired
		protected PatronageShowService	showService;
		
		@Autowired
		protected PatronageUpdateService	updateService;

		// Constructors -----------------------------------------------------------


		@PostConstruct
		protected void initialise() {
			super.addCommand("list", this.listService);
			super.addCommand("show", this.showService);
			super.addCommand("update", this.updateService);
		}

}
