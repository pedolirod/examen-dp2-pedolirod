package acme.features.inventor.artifact;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.artifact.Artifact;
import acme.artifact.ArtifactType;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface InventorArtifactRepository extends AbstractRepository {

	@Query("select a from Artifact a where a.id = :id")
	Artifact findOneToolById(int id);

	@Query("select a from Artifact a where a.type = :arifact_type and a.inventor.id = :id")
	Collection<Artifact> findManyTool(ArtifactType arifact_type, int id);

}
