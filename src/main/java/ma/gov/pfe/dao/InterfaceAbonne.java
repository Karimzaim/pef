package ma.gov.pfe.dao;

import java.util.List;

import ma.gov.pfe.modeles.Abonnees;

public interface InterfaceAbonne {
	
	boolean insert(Abonnees abonnee);
	boolean update(Abonnees abonnee);
	boolean delete(Abonnees abonnee);
	List<Abonnees> selectAll(Abonnees abonnee);
	Object selectById(Long id);
	
	Object getAbonnee(String pseudo);
}
