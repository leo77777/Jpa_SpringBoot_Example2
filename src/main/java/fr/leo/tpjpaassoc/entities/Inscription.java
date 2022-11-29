package fr.leo.tpjpaassoc.entities;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Inscription {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;	

	private Date dateInscription;
	private double score;
	
	@ManyToOne
	private Etudiant etudiant;
	@ManyToOne
	private Cours cours;
}
