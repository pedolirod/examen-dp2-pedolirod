package acme.features.inventor.hustle;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.artifact.Artifact;
import acme.artifact.ArtifactType;
import acme.entities.hustle.Hustle;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface HustleRepository extends AbstractRepository{
	
	@Query("select c from Hustle c where c.id = :id")
	Hustle findOneHustleById(int id);

	@Query("select c from Hustle c")
	Collection<Hustle> findManyHustle();
	
	@Query("select a from Artifact a LEFT JOIN Hustle h ON h.component=a WHERE h IS NULL and a.type=:type")
	List<Artifact> findComponentList(ArtifactType type);
	
	@Query("select a from Artifact a where a.id = :id and a.type=:type")
	Artifact findComponentById(int id, ArtifactType type);
	
	@Query("select c from Hustle c where c.code = :code")
	Hustle findAnyHustleByCode(String code);
	
}
