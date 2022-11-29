package fr.leo.tpjpaassoc.repositories;



import org.springframework.data.jpa.repository.JpaRepository;

import fr.leo.tpjpaassoc.entities.Utilisateur;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
	public Utilisateur findByUsername(String userName);
}





