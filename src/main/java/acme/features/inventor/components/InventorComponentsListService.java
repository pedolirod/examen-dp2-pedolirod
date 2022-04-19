package acme.features.inventor.components;

import java.util.Collection;

import acme.artifact.Artifact;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractListService;
import acme.roles.Inventor;

public class InventorComponentsListService implements AbstractListService<Inventor, Artifact>{

	@Override
	public boolean authorise(final Request<Artifact> request) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Collection<Artifact> findMany(final Request<Artifact> request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void unbind(final Request<Artifact> request, final Artifact entity, final Model model) {
		// TODO Auto-generated method stub
		
	}

}
