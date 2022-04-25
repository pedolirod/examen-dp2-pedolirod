package acme.features.inventor.patronage;

import java.util.Collection;

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
import acme.framework.services.AbstractListService;
import acme.roles.Inventor;
import acme.roles.Patron;

@Service
public class PatronageListServiceInv implements AbstractListService<Inventor, Patronage>{
	
	// Internal state ---------------------------------------------------------

		@Autowired
		protected PatronageRepositoryInv repository;

		// AbstractListService<Anonymous, Announcement>  interface -------------------------


		@Override
		public boolean authorise(final Request<Patronage> request) {
			assert request != null;

			return true;
		}
		
		@Override
		public Collection<Patronage> findMany(final Request<Patronage> request) {
			assert request != null;

			Collection<Patronage> result;

			result = this.repository.findManyPatronage();

			return result;
		}
		
		@Override
		public void unbind(final Request<Patronage> request, final Patronage entity, final Model model) {
			assert request != null;
			assert entity != null;
			assert model != null;

			request.unbind(entity, model, "code", "budget");
		}

}
