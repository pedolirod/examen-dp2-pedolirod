package acme.features.inventor.hustle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.artifact.Artifact;
import acme.artifact.ArtifactType;
import acme.entities.hustle.Hustle;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractShowService;
import acme.roles.Inventor;

@Service
public class HustleShowService implements AbstractShowService<Inventor, Hustle>{
	
	// Internal state ---------------------------------------------------------

		@Autowired
		protected HustleRepository repository;

		// AbstractShowService<Inventor, Hustle> interface --------------------------

		@Override
		public boolean authorise(final Request<Hustle> request) {
			assert request != null;

			return true;
		}

		@Override
		public void unbind(final Request<Hustle> request, final Hustle entity, final Model model) {
			assert request != null;
			assert entity != null;
			assert model != null;

			request.unbind(entity, model, "code", "creationMoment", "theme", "summary", "period", "share", "furtherInfo");
			model.setAttribute("isNew", false);
			final List<Artifact> listArt = this.repository.findComponentList(ArtifactType.COMPONENT);
			Artifact a = new Artifact();
			listArt.add(0, a);
			a = entity.getComponent();
			if(entity.getComponent() != null) {
				listArt.add(0, a);
			}
			
			model.setAttribute("artifact", listArt);
		}

		@Override
		public Hustle findOne(final Request<Hustle> request) {
			assert request != null;

			Hustle result;
			int id;

			id = request.getModel().getInteger("id");
			result = this.repository.findOneHustleById(id);

			return result;
		}

		

}
