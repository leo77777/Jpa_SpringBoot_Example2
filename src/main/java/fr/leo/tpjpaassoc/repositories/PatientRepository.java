package fr.leo.tpjpaassoc.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.leo.tpjpaassoc.entities.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long> {
	public List<Patient> findByNomContains(String name);
}





