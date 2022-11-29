package fr.leo.tpjpaassoc.entities;

import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// 1 @Inheritance(strategy = InheritanceType.SINGLE_TABLE)
// 1 @DiscriminatorColumn(name = "TYPE" , length = 4	)

// 2 @Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Entity
@Data @NoArgsConstructor @AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Personne {
	
	// 1 @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	// 2 @Id @GeneratedValue(strategy = GenerationType.TABLE) 
	@Id @GeneratedValue(strategy = GenerationType.TABLE)
	private Long id;
	
	private String nom;
	private Date dateNaissance;
	

}
