package acme.features.any.chirp;

import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.announcement.Announcement;
import acme.entities.chirp.Chirp;
import acme.features.authenticated.announcements.authenticatedAnnouncementsRepository;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.roles.Any;
import acme.framework.roles.Authenticated;
import acme.framework.services.AbstractShowService;

@Service
public class ChirpShowService implements AbstractShowService<Any, Chirp>{
	
	// Internal state ---------------------------------------------------------

		@Autowired
		protected ChirpRepository repository;

		// AbstractShowService<Anonymous, Announcement> interface --------------------------

		@Override
		public boolean authorise(final Request<Chirp> request) {
			assert request != null;

			return true;
		}

		@Override
		public void unbind(final Request<Chirp> request, final Chirp entity, final Model model) {
			assert request != null;
			assert entity != null;
			assert model != null;

			request.unbind(entity, model, "creationMoment", "title", "author", "body", "email");
		}

		@Override
		public Chirp findOne(final Request<Chirp> request) {
			assert request != null;

			Chirp result;
			int id;

			id = request.getModel().getInteger("id");
			result = this.repository.findOneChirpById(id);

			return result;
		}

		

}
