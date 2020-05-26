package ma.gov.pfe.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import ma.gov.pfe.modeles.Abonnees;

@Repository
public class AuthDaoImpl  implements IAuthDao{
	
	EntityManagerFactory emf= Persistence.createEntityManagerFactory("Pltform_Idtf_Client_Potentiel");
	EntityManager em = emf.createEntityManager();
	

	@Override
	public Abonnees getAbonnee(String pseudo) {
			
		try {
			Query q=em.createQuery("from "+ Abonnees.class.getSimpleName()+" a where a.pseudo=?");
			q.setParameter(0,pseudo);
			
			return (Abonnees) q.getSingleResult();
		} catch (Exception ex) {

			System.out.println("PSEUDO EXEPRION DAO  ....."+pseudo);
			System.out.println("EXEPTION DAO  ....."+ex.getMessage());
			return null;// should have proper handling of Exception
			}
	}

}
