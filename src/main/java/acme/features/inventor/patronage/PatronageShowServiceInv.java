package acme.features.inventor.patronage;

import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.announcement.Announcement;
import acme.entities.chirp.Chirp;
import acme.entities.patronage.Patronage;
import acme.features.authenticated.announcements.authenticatedAnnouncementsRepository;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.roles.Any;
import acme.framework.roles.Authenticated;
import acme.framework.services.AbstractShowService;
import acme.roles.Inventor;
import acme.roles.Patron;

@Service
public class PatronageShowServiceInv implements AbstractShowService<Inventor, Patronage>{
	
	// Internal state ---------------------------------------------------------

		@Autowired
		protected PatronageRepositoryInv repository;

		// AbstractShowService<Anonymous, Announcement> interface --------------------------

		@Override
		public boolean authorise(final Request<Patronage> request) {
			assert request != null;

			return true;
		}

		@Override
		public void unbind(final Request<Patronage> request, final Patronage entity, final Model model) {
			assert request != null;
			assert entity != null;
			assert model != null;

			request.unbind(entity, model, "status", "code", "legalStuff", "budget", "startDate", "link", "patron.userAccount.id", "inventor.userAccount.id");
			model.setAttribute("patronId", entity.getPatron().getUserAccount().getId());
		}

		@Override
		public Patronage findOne(final Request<Patronage> request) {
			assert request != null;

			Patronage result;
			int id;

			id = request.getModel().getInteger("id");
			result = this.repository.findOnePatronageById(id);

			return result;
		}

		

}
