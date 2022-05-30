package acme.features.inventor.chimpum;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.artifact.Artifact;
import acme.entities.chimpum.Chimpum;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface ChimpumRepository extends AbstractRepository{
	
	@Query("select c from Chimpum c where c.id = :id")
	Chimpum findOneChimpumById(int id);

	@Query("select c from Chimpum c")
	Collection<Chimpum> findManyChimpum();
	
	@Query("select a from Artifact a")
	List<Artifact> findArtifactList();
	
	@Query("select a from Artifact a where a.id = :id")
	Artifact findArtifactById(int id);
	
}
