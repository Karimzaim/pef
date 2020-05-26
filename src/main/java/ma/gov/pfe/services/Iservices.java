package ma.gov.pfe.services;

import java.util.List;

import ma.gov.pfe.modeles.Abonnees;
import ma.gov.pfe.modeles.Echanges;
import ma.gov.pfe.modeles.Rooms;

public interface Iservices {
	
	boolean insert(Object obj);
	boolean update(Object obj);
	boolean delete(Object obj);
	List<?> selectAll(Object obj);
	Object selectById(Object obj,long id);
	List<Echanges> selectByIDAbonnee(Long id);
	List<Echanges> selectByRoom(Rooms r);
	
     Abonnees getAbonnee(String pseudo);
     boolean findByRoomAbonnee(Long id_room,Long id_abonne);
     Long getIdVisite(Long id_room, Long id_abonne);
     boolean datevidebyabonnee(Long id);

}
