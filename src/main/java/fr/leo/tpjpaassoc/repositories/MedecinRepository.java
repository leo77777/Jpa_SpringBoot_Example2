package fr.leo.tpjpaassoc.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.leo.tpjpaassoc.entities.Medecin;

public interface MedecinRepository extends JpaRepository<Medecin, Long> {
	public List<Medecin> findByNomContains(String name);
}





