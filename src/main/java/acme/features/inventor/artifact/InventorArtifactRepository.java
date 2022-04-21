package acme.features.inventor.artifact;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;

import acme.artifact.Artifact;
import acme.artifact.ArtifactType;
import acme.framework.repositories.AbstractRepository;

public interface InventorArtifactRepository extends AbstractRepository{

	
	@Query("select a from Artifact a where a.id = :id")
	Artifact findOneArtifactlById(int id);

	@Query("select a from Artifact a where a.type = :artifactType")
	Collection<Artifact> findManyArtifact(ArtifactType artifactType);
}
