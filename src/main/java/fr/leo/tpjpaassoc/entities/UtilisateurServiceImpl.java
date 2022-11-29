package fr.leo.tpjpaassoc.entities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.leo.tpjpaassoc.repositories.GroupeRepository;
import fr.leo.tpjpaassoc.repositories.UtilisateurRepository;

@Service
@Transactional
public class UtilisateurServiceImpl implements UtilisateurService {
	
	@Autowired
	GroupeRepository groupeRepository ;
	@Autowired
	UtilisateurRepository utilisateurRepository ;	

	@Override
	public Utilisateur saveUser(Utilisateur utilisateur) {
		return  utilisateurRepository.save(utilisateur); 
	}

	@Override
	public Groupe saveGroupe(Groupe groupe) {	 	
		return groupeRepository.save(groupe);
	}

	@Override
	public void addUserToGroup(String userName, String groupeName) {
		Groupe groupe =  groupeRepository.findByGroupName(groupeName);
		Utilisateur utilisateur = utilisateurRepository.findByUsername(userName);
		groupe.getUtilisateurs().add(utilisateur);
	}
	
	@Override
	public void addGroupToUser(String userName, String groupeName) {
		Groupe groupe =  groupeRepository.findByGroupName(groupeName);
		Utilisateur utilisateur = utilisateurRepository.findByUsername(userName);
		utilisateur.getGroupes().add(groupe);
	}

	@Override
	public Utilisateur findByUserName(String userName) {
		return utilisateurRepository.findByUsername(userName);
	}

}
