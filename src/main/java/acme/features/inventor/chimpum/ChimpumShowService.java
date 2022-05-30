package acme.features.inventor.chimpum;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.chimpum.Chimpum;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractShowService;
import acme.roles.Inventor;

@Service
public class ChimpumShowService implements AbstractShowService<Inventor, Chimpum>{
	
	// Internal state ---------------------------------------------------------

		@Autowired
		protected ChimpumRepository repository;

		// AbstractShowService<Inventor, Chimpum> interface --------------------------

		@Override
		public boolean authorise(final Request<Chimpum> request) {
			assert request != null;

			return true;
		}

		@Override
		public void unbind(final Request<Chimpum> request, final Chimpum entity, final Model model) {
			assert request != null;
			assert entity != null;
			assert model != null;

			request.unbind(entity, model, "code", "creationMoment", "title", "description", "period", "budget", "link");
			model.setAttribute("isNew", false);
			model.setAttribute("artifact", this.repository.findArtifactList());
		}

		@Override
		public Chimpum findOne(final Request<Chimpum> request) {
			assert request != null;

			Chimpum result;
			int id;

			id = request.getModel().getInteger("id");
			result = this.repository.findOneChimpumById(id);

			return result;
		}

		

}
