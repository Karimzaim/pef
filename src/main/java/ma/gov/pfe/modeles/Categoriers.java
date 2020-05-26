package ma.gov.pfe.modeles;

import javax.persistence.*;

@Entity
@Table(name="T_categoriers")
public class Categoriers {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id_categorier;
	private String nomcategorier;

	
	public Categoriers() {
		super();
	}
	public Categoriers(Long id_categorier) {
		super();
		this.id_categorier = id_categorier;
	}
	
	public Categoriers(String nomcategorier) {
		super();
		this.nomcategorier = nomcategorier;
	}

	public Categoriers(Long id_categorier, String nomcategorier) {
		super();
		this.id_categorier = id_categorier;
		this.nomcategorier = nomcategorier;
	}

	public Long getId_categorier() {
		return id_categorier;
	}

	

	public String getNomcategorier() {
		return nomcategorier;
	}

	
	@Override
	public String toString() {
		return "Categoriers [id_categorier=" + id_categorier + ", nomcategorier=" + nomcategorier + "]\n";
	}
	
	
	
	

}
