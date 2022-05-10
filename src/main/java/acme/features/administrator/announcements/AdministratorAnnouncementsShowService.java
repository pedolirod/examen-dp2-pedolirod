package acme.features.administrator.announcements;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.announcement.Announcement;
import acme.entities.chirp.Chirp;
import acme.features.authenticated.announcements.authenticatedAnnouncementsRepository;
import acme.framework.components.models.Model;
import acme.framework.controllers.Errors;
import acme.framework.controllers.Request;
import acme.framework.roles.Administrator;
import acme.framework.roles.Any;
import acme.framework.services.AbstractCreateService;

@Service
public class AdministratorAnnouncementsShowService implements AbstractCreateService<Administrator, Announcement> {

	// Internal state ---------------------------------------------------------

	@Autowired
	protected authenticatedAnnouncementsRepository repository;

	// AbstractCreateService<Administrator, Chirp> interface --------------


	@Override
	public boolean authorise(final Request<Announcement> request) {
		assert request != null;

		return true;
	}

	@Override
	public Announcement instantiate(final Request<Announcement> request) {
		assert request != null;

		Announcement result = new Announcement();

		return result;
	}

	@Override
	public void bind(final Request<Announcement> request, final Announcement entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		Date moment= new Date(System.currentTimeMillis() - 1);
    
		request.bind(entity, errors, "title", "creationMoment", "body", "flag", "link");
		entity.setCreationMoment(moment);
	}

	@Override
	public void validate(final Request<Announcement> request, final Announcement entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

	}

	@Override
	public void unbind(final Request<Announcement> request, final Announcement entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "creationMoment", "body", "flag", "link");
		model.setAttribute("isNew", true);
	}

	@Override
	public void create(final Request<Announcement> request, final Announcement entity) {
		assert request != null;
		assert entity != null;

		this.repository.save(entity);
	}

}
