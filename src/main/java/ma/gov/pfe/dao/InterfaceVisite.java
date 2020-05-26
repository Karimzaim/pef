package ma.gov.pfe.dao;

import java.util.List;

import ma.gov.pfe.modeles.Visites;

public interface InterfaceVisite {
	
	boolean insert(Visites visite);
	boolean update(Visites visite);
	List<Visites> selectByAbonnee(Visites visite);
	boolean findByRoomAbonnee(Long id_room,Long id_abonne);
	Long getIdVisite(Long id_room, Long id_abonne);
	boolean datevidebyabonnee(Long id);

}
 