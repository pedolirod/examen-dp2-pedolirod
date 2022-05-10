package acme.features.authenticated.announcements;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import acme.entities.announcement.Announcement;
import acme.features.administrator.announcements.AdministratorAnnouncementsShowService;
import acme.framework.controllers.AbstractController;
import acme.framework.roles.Authenticated;

@Controller
public class authenticatedAnnouncementsController extends AbstractController<Authenticated, Announcement> {

	// Internal state ---------------------------------------------------------

	@Autowired
	protected authenticatedAnnouncementsListService	listService;

	@Autowired
	protected authenticatedAnnouncementsShowService	showService;
	
	@Autowired
	protected AdministratorAnnouncementsShowService	createService;

	// Constructors -----------------------------------------------------------


	@PostConstruct
	protected void initialise() {
		super.addCommand("list", this.listService);
		super.addCommand("show", this.showService);
		super.addCommand("create", this.createService);
	}

}
