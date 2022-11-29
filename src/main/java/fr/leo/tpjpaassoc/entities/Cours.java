package fr.leo.tpjpaassoc.entities;


import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Cours {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;	

	private String nom;
	private int volumeHoraire;
	
	@OneToMany(mappedBy = "cours")
	private Collection<Inscription>	inscriptions ;
}
