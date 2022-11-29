package fr.leo.tpjpaassoc.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.leo.tpjpaassoc.entities.Cours;
import fr.leo.tpjpaassoc.entities.Inscription;

public interface InscriptionRepository extends JpaRepository<Inscription, Long> {

	List<Inscription> findByCours(Cours cours);
	//List<Inscription> findByEtudiant(Etudiant etudiant);
}
