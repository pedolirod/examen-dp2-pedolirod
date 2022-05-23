package acme.features.patron.patronage;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.patronage.Patronage;
import acme.framework.repositories.AbstractRepository;
import acme.roles.Patron;

@Repository
public interface PatronageRepository extends AbstractRepository{
	
	@Query("select a from Patronage a where a.id = :id")
	Patronage findOnePatronageById(int id);

	@Query("select a from Patronage a")
	Collection<Patronage> findManyPatronage();
	
	@Query("select patron from Patron patron where patron.id = :id")
	Patron findPatronById(int id);

}
