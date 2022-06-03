package acme.features.inventor.hustle;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.hustle.Hustle;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractListService;
import acme.roles.Inventor;

@Service
public class HustleListService implements AbstractListService<Inventor, Hustle>{
	
	// Internal state ---------------------------------------------------------

		@Autowired
		protected HustleRepository repository;

		// AbstractListService<Patron, Hustle>  interface -------------------------


		@Override
		public boolean authorise(final Request<Hustle> request) {
			assert request != null;

			return true;
		}
		
		@Override
		public Collection<Hustle> findMany(final Request<Hustle> request) {
			assert request != null;

			Collection<Hustle> result;

			result = this.repository.findManyHustle();

			return result;
		}
		
		@Override
		public void unbind(final Request<Hustle> request, final Hustle entity, final Model model) {
			assert request != null;
			assert entity != null;
			assert model != null;

			request.unbind(entity, model, "code", "theme", "summary");
		}

}
