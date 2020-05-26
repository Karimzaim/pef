package ma.gov.pfe.modeles;

import java.sql.*;

import javax.persistence.*;

@Entity
@Table(name="T_Visites")
public class Visites {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id_visite;
	private Timestamp dateHeur_entree;
	private Timestamp dateHeur_sortie;
	
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
	
	
	
	public Visites() {
		super();
	}
	
	
	
	public Visites(Long id_visite) {
		super();
		this.id_visite = id_visite;
	}

	public Visites(Abonnees abonnee, Rooms room) {
		super();
		this.abonnee = abonnee;
		this.room = room;
	}

	public Rooms getRoom() {
		return room;
	}

	public void setRoom(Rooms room) {
		this.room = room;
	}

	

	
	public Long getId_visite() {
		return id_visite;
	}

	public void setId_visite(Long id_visite) {
		this.id_visite = id_visite;
	}

	public Timestamp getDateHeur_entree() {
		return dateHeur_entree;
	}

	public void setDateHeur_entree(Timestamp dateHeur_entree) {
		this.dateHeur_entree = dateHeur_entree;
	}

	public Timestamp getDateHeur_sortie() {
		return dateHeur_sortie;
	}

	public void setDateHeur_sortie(Timestamp dateHeur_sortie) {
		this.dateHeur_sortie = dateHeur_sortie;
	}

	@Override
	public String toString() {
		return "Visites id_visite=" + id_visite + ", dateHeur_entree=" + dateHeur_entree + ", dateHeur_sortie="
				+ dateHeur_sortie + ", abonnee=" + abonnee + ", room=" + room ;
	}
	
	
	

}
