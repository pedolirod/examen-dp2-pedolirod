package acme.features.authenticated.announcements;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import acme.entities.announcement.Announcement;
import acme.framework.controllers.AbstractController;
import acme.framework.roles.Authenticated;

@Controller
public class authenticatedAnnouncementsController extends AbstractController<Administrator, Announcement> {

	// Internal state ---------------------------------------------------------

	@Autowired
	protected administratorAnnouncementsListService	listService;

	@Autowired
	protected administratorAnnouncementsShowService	showService;
	
	@Autowired
	protected AnnouncementCreateService	createService;

	// Constructors -----------------------------------------------------------


	@PostConstruct
	protected void initialise() {
		super.addCommand("list", this.listService);
		super.addCommand("show", this.showService);
		super.addCommand("create", this.createService);
	}

}
