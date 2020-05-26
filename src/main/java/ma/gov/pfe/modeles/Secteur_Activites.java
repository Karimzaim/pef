package ma.gov.pfe.modeles;

import javax.persistence.*;


@Entity
@Table(name="T_Secteurs_Activites")
public class Secteur_Activites {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id_secteur;
	private  String secteur_activite;

	
	public Secteur_Activites() {}
	
	public Secteur_Activites(Long id_secteur, String secteur_activite) {
		this.id_secteur = id_secteur;
		this.secteur_activite = secteur_activite;
	}
	public Secteur_Activites(Long id_secteur) {
		this.id_secteur = id_secteur;
	}
	
	public Secteur_Activites( String secteur_activite) {
		this.secteur_activite = secteur_activite;
	}
	

	public Long getId_secteur() {
		return id_secteur;
	}

	public String getSecteur_activite() {
		return secteur_activite;
	}

	@Override
	public String toString() {
		return "T_Secteur_Activites [id_secteur=" + id_secteur + ", secteur_activite=" + secteur_activite + "]\n";
	}

	
	
	
	
	
	
	
	
	
	
	
	
}
