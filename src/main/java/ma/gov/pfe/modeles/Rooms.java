package ma.gov.pfe.modeles;


import javax.persistence.*;

@Entity
@Table(name="T_Rooms")
public class Rooms {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id_room;
	private String nomproduit_service;
	
    @ManyToOne
    @JoinColumn(name="id_categorier")
	private Categoriers categorier=new Categoriers();

		
	public Categoriers getCategorier() {
		return categorier;
	}
	
	
	public Rooms() {
		super();
	}
	
	

	public Long getId_room() {
		return id_room;
	}

	public String getNomproduit_service() {
		return nomproduit_service;
	}

	@Override
	public String toString() {
		return "Rooms [id_room=" + id_room + ", nomproduit_service=" + nomproduit_service + ", categorier=" + categorier+ "]\n";
	}
	
	
	
	

}
