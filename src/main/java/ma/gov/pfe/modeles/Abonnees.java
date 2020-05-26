package ma.gov.pfe.modeles;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="T_Abonnees")
public class Abonnees {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id_abonnee;
	@Column(unique=true)
	private String pseudo;
	private String password;
	private String nom;
	private String prenom;
	private String whatsapp;
	private String datenaissance;
    private String sexe;
    
    
    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name="id_profession")
    private Professions profession;
    
    @ManyToOne
    @JoinColumn(name="id_quartier")
    private Quartiers quartier;
    
    @ManyToMany()
    @JoinTable(name = "abonnee_role", joinColumns = @JoinColumn(name = "abonnee_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Role> role;
    

	public List<Role> getRole() {
		return role;
	}
	
	public void setRole(List<Role> role) {
		this.role = role;
	}


	public Professions getProfession() {
		return profession;
	}

	public void setProfession(Professions profession) {
		this.profession = profession;
	}

	public Quartiers getQuartier() {
		return quartier;
	}

	public void setQuartier(Quartiers quartier) {
		this.quartier = quartier;
	}

	
	
	
	
	public Abonnees() {
		super();
	}


	
	

	
	public Abonnees(Long id_abonnee, String pseudo, String password, String nom, String prenom, String whatsapp,
			String datenaissance, String sexe, Professions profession, Quartiers quartier, List<Role> role) {
		super();
		this.id_abonnee = id_abonnee;
		this.pseudo = pseudo;
		this.password = password;
		this.nom = nom;
		this.prenom = prenom;
		this.whatsapp = whatsapp;
		this.datenaissance = datenaissance;
		this.sexe = sexe;
		this.profession = profession;
		this.quartier = quartier;
		this.role = role;
	}

	public Long getId_abonnee() {
		return id_abonnee;
	}

	public void setId_abonnee(Long id_abonnee) {
		this.id_abonnee = id_abonnee;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getWhatsapp() {
		return whatsapp;
	}

	public void setWhatsapp(String whatsapp) {
		this.whatsapp = whatsapp;
	}

	public String getDatenaissance() {
		return datenaissance;
	}

	public void setDatenaissance(String datenaissance) {
		this.datenaissance = datenaissance;
	}

	

	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	@Override
	public String toString() {
		return "Abonnees [id_abonnee=" + id_abonnee + ", pseudo=" + pseudo + ", password=" + password + ", nom=" + nom
				+ ", prenom=" + prenom + ", whatsapp=" + whatsapp + ", datenaissance=" + datenaissance + ", sexe=" + sexe+" role="+role
				+ ", profession=" + profession + ", quartier=" + quartier + "]";
	}
    
       
    

}