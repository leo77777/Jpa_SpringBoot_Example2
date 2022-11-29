package fr.leo.tpjpaassoc.repositories;



import org.springframework.data.jpa.repository.JpaRepository;
import fr.leo.tpjpaassoc.entities.RendezVous;

public interface RendezVousRepository extends JpaRepository<RendezVous, Long> {
	//public List<Consultation> findByNomContains(String name);
}





