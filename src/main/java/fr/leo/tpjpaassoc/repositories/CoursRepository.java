package fr.leo.tpjpaassoc.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import fr.leo.tpjpaassoc.entities.Cours;

public interface CoursRepository extends JpaRepository<Cours, Long> {
	
}
