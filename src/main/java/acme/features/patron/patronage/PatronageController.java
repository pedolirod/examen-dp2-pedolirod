package acme.features.patron.patronage;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import acme.entities.announcement.Announcement;
import acme.entities.chirp.Chirp;
import acme.entities.patronage.Patronage;
import acme.features.authenticated.announcements.authenticatedAnnouncementsListService;
import acme.features.authenticated.announcements.authenticatedAnnouncementsShowService;
import acme.framework.controllers.AbstractController;
import acme.framework.roles.Any;
import acme.framework.roles.Authenticated;
import acme.roles.Patron;

@Controller
public class PatronageController extends AbstractController<Patron, Patronage>{
	// Internal state ---------------------------------------------------------

		@Autowired
		protected PatronageListService	listService;

		@Autowired
		protected PatronageShowService	showService;

		// Constructors -----------------------------------------------------------


		@PostConstruct
		protected void initialise() {
			super.addCommand("list", this.listService);
			super.addCommand("show", this.showService);
		}

}
