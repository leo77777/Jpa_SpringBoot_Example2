package fr.leo.tpjpaassoc.entities;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Groupe {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique = true)
	private String groupName;
	
	@ManyToMany( fetch = FetchType.EAGER)
	private Collection<Utilisateur> utilisateurs = new ArrayList<>(); 
}
