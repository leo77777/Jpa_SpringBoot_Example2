package fr.leo.tpjpaassoc.repositories;



import org.springframework.data.jpa.repository.JpaRepository;

import fr.leo.tpjpaassoc.entities.Consultation;

public interface ConsultationRepository extends JpaRepository<Consultation, Long> {
	//public List<Consultation> findByNomContains(String name);
}





