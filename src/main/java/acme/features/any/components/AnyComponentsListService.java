package acme.features.any.components;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

import acme.artifact.Artifact;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.roles.Any;
import acme.framework.services.AbstractListService;

public class AnyComponentsListService implements AbstractListService<Any, Artifact> {
	
	
	
	@Autowired
	protected AnyComponentsRepository repository;
	
	
	
	// AbstractListService<Any, Artifact>  interface -------------------------


		@Override
		public boolean authorise(final Request<Artifact> request) {
			assert request != null;

			return true;
		}
		
		
		@Override
		public Collection<Artifact> findMany(final Request<Artifact> request){
			
			final Collection<Artifact> result= this.repository.findManyComponents();
			
			return result;
			
			
		}


		@Override
		public void unbind(final Request<Artifact> request, final Artifact entity, final Model model) {
			
			assert request != null;
			assert entity != null;
			assert model != null;

			request.unbind(entity, model, "name", "code", "technology", "description", "retailPrice", "link", "type", "inventor");
			
		}

}
