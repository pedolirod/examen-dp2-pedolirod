package acme.features.inventor.chimpum;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.chimpum.Chimpum;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractListService;
import acme.roles.Inventor;

@Service
public class ChimpumListService implements AbstractListService<Inventor, Chimpum>{
	
	// Internal state ---------------------------------------------------------

		@Autowired
		protected ChimpumRepository repository;

		// AbstractListService<Patron, Chimpum>  interface -------------------------


		@Override
		public boolean authorise(final Request<Chimpum> request) {
			assert request != null;

			return true;
		}
		
		@Override
		public Collection<Chimpum> findMany(final Request<Chimpum> request) {
			assert request != null;

			Collection<Chimpum> result;

			result = this.repository.findManyChimpum();

			return result;
		}
		
		@Override
		public void unbind(final Request<Chimpum> request, final Chimpum entity, final Model model) {
			assert request != null;
			assert entity != null;
			assert model != null;

			request.unbind(entity, model, "code", "title", "description");
		}

}
