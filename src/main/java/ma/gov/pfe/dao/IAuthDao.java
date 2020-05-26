package ma.gov.pfe.dao;

import ma.gov.pfe.modeles.Abonnees;


public interface IAuthDao {

  Abonnees getAbonnee(String pseudo);
	
}
