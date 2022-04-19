package acme.features.any.components;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;

import acme.artifact.Artifact;
import acme.framework.repositories.AbstractRepository;

public interface AnyComponentsRepository extends AbstractRepository {

	
	@Query("select a from Artifact a where a.id = :id ")
	Artifact findOneComponentById(int id);
	
	
	
	@Query("select a from Artifact a where a.type=COMPONENT")
	Collection<Artifact> findManyComponents();
	
}
