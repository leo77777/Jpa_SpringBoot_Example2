package fr.leo.tpjpaassoc.entities;

public interface UtilisateurService {
	
	Utilisateur saveUser(Utilisateur utilisateur);
	Groupe saveGroupe(Groupe groupe);
	void addUserToGroup(String userName, String GroupeName);
	Utilisateur findByUserName(String userName);
	void addGroupToUser(String userName, String groupeName);

}
