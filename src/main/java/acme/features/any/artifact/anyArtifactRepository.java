package acme.features.any.artifact;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.artifact.Artifact;
import acme.artifact.ArtifactType;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface anyArtifactRepository extends AbstractRepository {

	@Query("select a from Artifact a where a.id = :id")
	Artifact findOneToolById(int id);

	@Query("select a from Artifact a where a.type = :arifact_type")
	Collection<Artifact> findManyTool(ArtifactType arifact_type);

}
