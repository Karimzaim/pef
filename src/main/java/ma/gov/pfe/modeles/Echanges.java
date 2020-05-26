package ma.gov.pfe.modeles;


import java.sql.Timestamp;

import javax.persistence.*;

@Entity
@Table(name="T_Echanges")
public class Echanges {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id_echange;
	private String contenu;
	private Timestamp dateHeur_msg;
	
	@ManyToOne
    @JoinColumn(name="id_abonnee")
    private Abonnees abonnee;
	
	@ManyToOne
    @JoinColumn(name="id_room")
    private Rooms room;

	public Abonnees getAbonnee() {
		return abonnee;
	}

	public void setAbonnee(Abonnees abonnee) {
		this.abonnee = abonnee;
	}

	public Rooms getRoom() {
		return room;
	}
	
	public void setRoom(Rooms room) {
		this.room = room;
	}


	public Echanges() {
		super();
	}

	public Echanges(Long id_echange) {
		super();
		this.id_echange = id_echange;
	}

	public Echanges(Abonnees abonnee, Rooms room) {
		this.abonnee = abonnee;
		this.room = room;
	}
	
	public Echanges(String contenu, Timestamp dateHeur_msg, Abonnees abonnee, Rooms room) {
		super();
		this.contenu = contenu;
		this.dateHeur_msg = dateHeur_msg;
		this.abonnee = abonnee;
		this.room = room;
	}

	public Long getId_echange() {
		return id_echange;
	}

	public void setId_echange(Long id_echange) {
		this.id_echange = id_echange;
	}

	public String getContenu() {
		return contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
	}

	public Timestamp getDateHeur_msg() {
		return dateHeur_msg;
	}

	public void setDateHeur_msg(Timestamp dateHeur_msg) {
		this.dateHeur_msg = dateHeur_msg;
	}

	@Override
	public String toString() {
		return "Echanges [id_echange=" + id_echange + ", contenu=" + contenu + ", dateHeur_msg=" + dateHeur_msg
				+ ", abonnee=" + abonnee + ", room=" + room + "]";
	}

	
	
	

}
