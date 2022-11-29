package fr.leo.tpjpaassoc.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import fr.leo.tpjpaassoc.entities.Groupe;

public interface GroupeRepository extends JpaRepository<Groupe, Long> {
	public Groupe findByGroupName(String groupName);
}





