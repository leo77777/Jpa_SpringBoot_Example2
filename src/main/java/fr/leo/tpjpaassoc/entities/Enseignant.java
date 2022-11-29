package fr.leo.tpjpaassoc.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// 1 @DiscriminatorValue("PROF")
@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Enseignant extends Personne {
	private String matiere;
}
