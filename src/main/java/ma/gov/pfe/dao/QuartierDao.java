package ma.gov.pfe.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import ma.gov.pfe.modeles.Professions;
import ma.gov.pfe.modeles.Quartiers;

@Repository
public class QuartierDao {

	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Pltform_Idtf_Client_Potentiel");
	static EntityManager em = emf.createEntityManager();
	static EntityTransaction ettr = null;
	
		

	@SuppressWarnings("unchecked")
	public List<Professions> selectAll(Quartiers quartier) {
		Query q=em.createQuery("from "+quartier.getClass().getSimpleName()+" q");
		return q.getResultList();
	}
	
	
}
