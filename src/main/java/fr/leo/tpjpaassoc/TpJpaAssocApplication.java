package fr.leo.tpjpaassoc;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.apache.el.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.leo.tpjpaassoc.entities.Consultation;
import fr.leo.tpjpaassoc.entities.Cours;
import fr.leo.tpjpaassoc.entities.Enseignant;
import fr.leo.tpjpaassoc.entities.Etudiant;
import fr.leo.tpjpaassoc.entities.Groupe;
import fr.leo.tpjpaassoc.entities.Inscription;
import fr.leo.tpjpaassoc.entities.Medecin;
import fr.leo.tpjpaassoc.entities.Patient;
import fr.leo.tpjpaassoc.entities.RendezVous;
import fr.leo.tpjpaassoc.entities.Student;
import fr.leo.tpjpaassoc.entities.Utilisateur;
import fr.leo.tpjpaassoc.entities.UtilisateurService;
import fr.leo.tpjpaassoc.repositories.ConsultationRepository;
import fr.leo.tpjpaassoc.repositories.CoursRepository;
import fr.leo.tpjpaassoc.repositories.EtudiantRepository;
import fr.leo.tpjpaassoc.repositories.InscriptionRepository;
import fr.leo.tpjpaassoc.repositories.MedecinRepository;
import fr.leo.tpjpaassoc.repositories.PatientRepository;
import fr.leo.tpjpaassoc.repositories.PersonneRepository;
import fr.leo.tpjpaassoc.repositories.RendezVousRepository;

@SpringBootApplication
public class TpJpaAssocApplication implements CommandLineRunner{
	
	@Autowired
	PatientRepository patientRepository;
	@Autowired
	MedecinRepository medecinRepository;
	@Autowired
	ConsultationRepository consultationRepository;
	@Autowired
	RendezVousRepository rendezVousRepository ;
	@Autowired
	UtilisateurService utilisateurService;
	@Autowired
	EtudiantRepository etudiantRepository;
	@Autowired
	CoursRepository coursRepository;
	@Autowired
	InscriptionRepository inscriptionRepository;
	@Autowired
	PersonneRepository personneRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(TpJpaAssocApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Cela est un test");		
		
		Patient p1 = new Patient();
		p1.setEmail("rere@free.re");
		p1.setNom("Rere");
		Collection<RendezVous> list = new ArrayList<RendezVous>();
		//p1.setRendezVous(list);
		patientRepository.save(p1);
		
		Collection<RendezVous> list2 = new ArrayList<RendezVous>();
		Medecin m1 = new Medecin(null, "Med1", "Spec1", "med1@free.fr", list2);
		medecinRepository.save(m1);
		
		Collection<RendezVous> list3 = new ArrayList<RendezVous>();
		Medecin m2 = new Medecin(null, "Med2", "Spec2", "med2@free.fr", list3);
		medecinRepository.save(m2);
		
		Consultation consult1 = new Consultation();
		consult1.setDateConsultation(new Date());
		consult1.setPrixConsultation(10.2);
		consult1.setRapportConsultation("rapport1");
		consult1.setRendezVous(null);		
		consultationRepository.save(consult1); 
		
		Consultation consult2 = new Consultation();
		consult2.setDateConsultation(new Date());
		consult2.setPrixConsultation(10.4);
		consult2.setRapportConsultation("rapport2");
		consult2.setRendezVous(null);		
		consultationRepository.save(consult2); 
		
		RendezVous rdv1 = new RendezVous(null, new Date(), m1, p1, consult1);
		RendezVous rdv2 = new RendezVous(null, new Date(2021, 12, 21), m2, p1, consult1);
		rendezVousRepository.save(rdv1);	
		rendezVousRepository.save(rdv2);	
		consult1.setRendezVous(rdv1);
		consult1.setRendezVous(rdv2);
		
		System.out.println("**************** GROUPE ***************************");		
		
		utilisateurService.saveUser(new Utilisateur(null, "rere", "passrere", null));
		utilisateurService.saveUser(new Utilisateur(null, "vyvy", "passvyvy", null));
		utilisateurService.saveGroupe(new Groupe(null, "groupe1", null));
		utilisateurService.saveGroupe(new Groupe(null, "groupe2", null)); 
		
		utilisateurService.addUserToGroup("rere", "groupe1");
		utilisateurService.addUserToGroup("rere", "groupe2");
		utilisateurService.addUserToGroup("vyvy", "groupe1");
		utilisateurService.addUserToGroup("vyvy", "groupe2");
		
//		utilisateurService.addGroupToUser("rere", "groupe1");
//		utilisateurService.addGroupToUser("rere", "groupe2");
//		utilisateurService.addGroupToUser("vyvy", "groupe1");
//		utilisateurService.addGroupToUser("vyvy", "groupe2");
		
		Utilisateur rere = utilisateurService.findByUserName("rere");
//		System.out.println("Nom : " + rere.getUsername());
//		System.out.println("Password : " + rere.getPassword());
//		System.out.println("Groupes :");
//		
		Utilisateur vyvy = utilisateurService.findByUserName("vyvy");
		for (Groupe group : vyvy.getGroupes()) {
			System.out.println("RERE " + group.getGroupName());
		}
		
		for (Groupe group2 : rere.getGroupes()) {
			System.out.println("VYVY " + group2.getGroupName());
		}
				
		List<Groupe> listg =  (List<Groupe>) rere.getGroupes();
		Groupe g1 = listg.get(1);
		System.out.println(g1.getGroupName());
		
		for (Utilisateur group : g1.getUtilisateurs()) {
			System.out.println("RERE " + group.getUsername());
		}
		
		
		System.out.println("********************* ETUDIANT *********************");
		Etudiant etud1 = new Etudiant(null, "Desprairies", "Rere", null);
		Etudiant etud2 = new Etudiant(null, "Descollines", "Vyvy", null);
		etudiantRepository.save(etud1);
		etudiantRepository.save(etud2);
		
		Cours cours1 = new Cours(null, "Math", 10, null);
		Cours cours2 = new Cours(null, "Francais", 14, null);
		
		Inscription insc1 = new Inscription(null, new Date(), 100, etud1, cours1);
		Inscription insc2 = new Inscription(null, new Date(), 200, etud1, cours2);
		Inscription insc3 = new Inscription(null, new Date(), 300, etud2, cours1);
		Inscription insc4 = new Inscription(null, new Date(), 500, etud2, cours2);
		
		coursRepository.save(cours1);
		coursRepository.save(cours2);	

		
		inscriptionRepository.save(insc1);
		inscriptionRepository.save(insc2);
		inscriptionRepository.save(insc3);
		inscriptionRepository.save(insc4);
		
		
		
		// Attention, tout ce qui est purement Objet, n'est pas
		//  initialisé automatiquement !
		// Il faut le faire à la main !
		cours1.setInscriptions(new ArrayList<Inscription>());
		cours2.setInscriptions(new ArrayList<Inscription>());
		cours1.getInscriptions().add(insc1);
		cours1.getInscriptions().add(insc3);
		cours2.getInscriptions().add(insc2);
		cours2.getInscriptions().add(insc4); 
		
		System.out.println(cours2.getInscriptions().size());
		
		for (Inscription ins : cours2.getInscriptions()) {
			System.out.println(ins.getDateInscription());
		}
		
		coursRepository.save(cours1);
		coursRepository.save(cours2);
		
		List<Inscription> listInscrisCours2 =   inscriptionRepository.findByCours(cours2);
		for (Inscription inscription : listInscrisCours2) {
			System.out.println(inscription.getEtudiant().getNom());
		}
		System.out.println(listInscrisCours2.getClass());
		System.out.println(listInscrisCours2.size());
		listInscrisCours2.forEach(p->{ Cours c = p.getCours(); System.out.println(c.getNom()); });
		
		System.out.println("Liste des inscriptions pour le cours 2 : ");
		cours2.getInscriptions().forEach(p->{ System.out.println( p.getId()); });
		
//		for (Inscription inscription : cours2.getInscriptions()) {
//			System.out.println(inscription.getEtudiant());
//		}
		
		System.out.println("Liste des inscriptions pour l'étudiant etud1");
		etud1.setInscriptions(new ArrayList<Inscription>());
		etud1.getInscriptions().add(insc4);
		ArrayList<Inscription> listeInsEtud1 = (ArrayList<Inscription>) etud1.getInscriptions(); 
		System.out.println("Liste : " + listeInsEtud1.size());
		System.out.println("Liste : " + listeInsEtud1.get(0).getScore());
		
		System.out.println("****************** EXEMPLE ETUDIANTS *******************");
		Cours coursMath = coursRepository.findById(1L).get();
		System.out.println("**************************");
		System.out.println("ID Cours : " + coursMath.getId());
		System.out.println("Nom Cours : " + coursMath.getNom());
		System.out.println("Inscriptions : ");
		System.out.println("ID\tDate Inscrip\tNom \tPrénom \tScore \t");
		inscriptionRepository.findByCours(coursMath).forEach(
					insc->{
						System.out.println("----------------------------------");
						System.out.print(insc.getId() + "\t");
						System.out.print(DateFormat.getDateInstance(DateFormat.MEDIUM).format(
								insc.getDateInscription()
								) + "\t");
						System.out.print(insc.getEtudiant().getNom() + "\t");
						System.out.print(insc.getEtudiant().getPrenom() + "\t");
						System.out.println(insc.getScore() + "\t");
						
					} 
				);
		
		
			System.out.println();
			System.out.println("*********** HERITAGE 1, 2 ET 3 *****************");
			Student stud1 = new Student(20);
			stud1.setDateNaissance(new Date());
			stud1.setNom("Rere");
			Student stud2 = new Student(19);
			stud2.setDateNaissance(new Date());
			stud2.setNom("Vyvy");
			personneRepository.save(stud1);
			personneRepository.save(stud2);

			Enseignant prof1 = new Enseignant("Math");
			prof1.setDateNaissance(new Date());
			prof1.setNom("Prof1");
			Enseignant prof2 = new Enseignant("Francais");
			prof2.setDateNaissance(new Date());
			prof2.setNom("Prof2");
			personneRepository.save(prof1);
			personneRepository.save(prof2);
			
			personneRepository.findAll().forEach(pers->{
				if (pers instanceof Enseignant ) {
					System.out.println(pers.getNom() + " est prof de " 
								+ (( Enseignant) pers).getMatiere());
				}else {
					System.out.println(pers.getNom() + " a eu la note de  " 
							+ (( Student) pers).getNote());
				}
			});
			
			System.out.println(prof1.getMatiere());
			System.out.println(prof2.getMatiere());
			
			System.out.println(stud1.getNote());
			System.out.println(stud2.getNote()); 
			
			java.util.stream.Stream.of("rere","vyvy","lala").forEach(p->{
				System.out.println("Voila " + p );
			});
			
			java.util.stream.Stream.of(stud1, stud2).forEach(p->{
				System.out.println("Voila " + p.getNote() );
			});
			
			
	}
}
