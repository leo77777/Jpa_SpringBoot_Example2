package fr.leo.tpjpaassoc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import fr.leo.tpjpaassoc.entities.Personne;

public interface PersonneRepository extends JpaRepository<Personne, Long> {
	
}
