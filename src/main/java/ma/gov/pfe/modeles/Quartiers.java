package ma.gov.pfe.modeles;


import javax.persistence.*;


@Entity
@Table(name="T_Quartiers")
public class Quartiers {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id_quartier;
	private String quartier;
	
	
	public Quartiers() {
		super();	
	}
	public Quartiers(Long id_quartier) {
		super();
		this.id_quartier = id_quartier;
	}
	
	
	public Quartiers(Long id_quartier, String quartier){
		super();
		this.id_quartier = id_quartier;
		this.quartier = quartier;
	}
	public Long getId_quartier() {
		return id_quartier;
	}
	
	public String getQuartier() {
		return quartier;
	}
	
	@Override
	public String toString() {
		return "Quartier [id_quartier=" + id_quartier + ", quartier=" + quartier + "]\n";
	}
	@Override
	public int hashCode() {
		int result = 1;
		result = result + ((quartier == null) ? 0 : quartier.hashCode());
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
