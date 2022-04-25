package acme.features.any.chirp;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import acme.entities.announcement.Announcement;
import acme.entities.chirp.Chirp;
import acme.features.authenticated.announcements.authenticatedAnnouncementsListService;
import acme.features.authenticated.announcements.authenticatedAnnouncementsShowService;
import acme.framework.controllers.AbstractController;
import acme.framework.roles.Any;
import acme.framework.roles.Authenticated;

@Controller
public class ChirpController extends AbstractController<Any, Chirp>{
	// Internal state ---------------------------------------------------------

		@Autowired
		protected ChirpListService	listService;

		@Autowired
		protected ChirpShowService	showService;

		// Constructors -----------------------------------------------------------


		@PostConstruct
		protected void initialise() {
			super.addCommand("list", this.listService);
			super.addCommand("show", this.showService);
		}

}
