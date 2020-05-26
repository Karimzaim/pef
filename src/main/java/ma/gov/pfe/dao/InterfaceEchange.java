package ma.gov.pfe.dao;

import java.util.List;

import ma.gov.pfe.modeles.*;
public interface InterfaceEchange {
	
	boolean echanger(Echanges echange);
	boolean update(Echanges echange);
	boolean delete(Echanges echange);
	List<Echanges> selectByRoom(Rooms r);
	List<Echanges> selectByIDAbonnee(Long id);
	Object selectById(Long id);

}
