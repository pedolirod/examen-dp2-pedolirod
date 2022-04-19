package acme.features.inventor.components;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;

import acme.artifact.Artifact;
import acme.framework.repositories.AbstractRepository;
import acme.roles.Inventor;

public interface InventorComponentsRepository extends AbstractRepository{

	@Query("select a from Artifact a where a.id= :id")
	Artifact findOneComponentById(int id);
	
	
	@Query("select a from Inventor a where a.id= :id")
	Inventor findOneInventorById(int id);
	
	
	@Query("SELECT a FROM Artifact a WHERE a.inventor.id= :id AND a.type=COMPONENT")
	Collection<Artifact> findManyComponentsByInventorId(int id);
	
}
