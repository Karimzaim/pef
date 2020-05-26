package ma.gov.pfe.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import ma.gov.pfe.modeles.Professions;



@Repository
public class ProfessionDao {
	
	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Pltform_Idtf_Client_Potentiel");
	static EntityManager em = emf.createEntityManager();
	

	
	@SuppressWarnings("unchecked")
	public List<Professions> selectAll(Professions profession) {
		Query q=em.createQuery("from "+profession.getClass().getSimpleName()+" p");
		return  q.getResultList();
	}
}
