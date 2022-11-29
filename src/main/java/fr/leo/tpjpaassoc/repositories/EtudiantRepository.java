package fr.leo.tpjpaassoc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.leo.tpjpaassoc.entities.Etudiant;

public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {

}
