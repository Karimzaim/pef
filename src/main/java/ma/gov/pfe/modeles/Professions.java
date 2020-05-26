package ma.gov.pfe.modeles;


import javax.persistence.*;


@Entity
@Table(name="T_Professions")
public class Professions {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id_profession;
	private String profession;
	
	
	
	
	@ManyToOne
	@JoinColumn(name="id_secteur")
	private Secteur_Activites SecteurActivites;
	
	
	public Secteur_Activites getSecteurActivites() {
		return SecteurActivites;
	}
	public void setSecteurActivites(Secteur_Activites secteurActivites) {
		SecteurActivites = secteurActivites;
	}
	
	
	public Professions() {
		super();
	}
	public Professions(Long id_profession) {
		this.id_profession = id_profession;
	}
	
	public Professions(String profession) {
		this.profession = profession;
	}

	public Professions(Long id_profession, String profession) {
		this.id_profession = id_profession;
		this.profession = profession;
	}
	
	
	
	public Professions(String profession, Secteur_Activites secteurActivites) {
		super();
		this.profession = profession;
		SecteurActivites = secteurActivites;
	}
	
	public Professions(Long id_profession, String profession, Secteur_Activites secteurActivites) {
		super();
		this.id_profession = id_profession;
		this.profession = profession;
		SecteurActivites = secteurActivites;
	}
	public Long getId_profession() {
		return id_profession;
	}
	public void setId_profession(Long id_profession) {
		this.id_profession = id_profession;
	}
	public String getProfession() {
		return profession;
	}
	public void setProfession(String profession) {
		this.profession = profession;
	}
	@Override
	public String toString() {
		return "Professions [id_profession=" + id_profession + ", profession=" + profession + ", SecteurActivites="
				+ SecteurActivites + "]";
	}
	@Override
	public int hashCode() {
		int result = 1;
		result =  result + ((profession == null) ? 0 : profession.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this.hashCode() == obj.hashCode())
			return true;
		else 
			return false;
	}
	
	
	
	
		

}
