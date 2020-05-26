package ma.gov.pfe.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import ma.gov.pfe.modeles.Abonnees;

@Repository
public class AbonneeDao implements InterfaceAbonne{

	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Pltform_Idtf_Client_Potentiel");
	static EntityManager em = emf.createEntityManager();
	static EntityTransaction ettr = null;	
	
	@Override
	public boolean insert(Abonnees abonnee) {
		try {
			ettr = em.getTransaction();
			ettr.begin();
			em.persist(abonnee);
			ettr.commit();
			System.out.println("INSERTION ABONNEE SUCCESS");
			return true;
			} catch (Exception e) {
				e.printStackTrace();
				ettr.rollback();
				return false;
			}

	}

	@Override
	public boolean update(Abonnees abonnee) {
		try {
			ettr=em.getTransaction();
			ettr.begin();
			Abonnees abonnee1 =(Abonnees) em.find(abonnee.getClass(),abonnee.getId_abonnee());
	//--------------------
			abonnee1.setPassword(abonnee.getPseudo());
			abonnee1.setPassword(abonnee.getPassword());
			abonnee1.setNom(abonnee.getNom());
			abonnee1.setPrenom(abonnee.getPrenom());
			abonnee1.setDatenaissance(abonnee.getDatenaissance());
			abonnee1.setSexe(abonnee.getSexe());
			abonnee1.setWhatsapp(abonnee.getWhatsapp());
			abonnee1.setProfession(abonnee.getProfession());
			abonnee1.setQuartier(abonnee.getQuartier());
	//---------------------
			ettr.commit();
			System.out.println("UPDATE ABONNEE SUCCESS");
			return true;
			} catch (Exception e) {
				e.printStackTrace();
				ettr.rollback();
				return false;
			}
	}

	@Override
	public boolean delete(Abonnees abonnee) {
		try {
			ettr = em.getTransaction();
			ettr.begin();
			Abonnees abonnee1 =(Abonnees) em.find(abonnee.getClass(),abonnee.getId_abonnee());
			em.remove(abonnee1);
			ettr.commit();
			System.out.println("DELETE ABONNEE SUCCESS");
			return true;
			} catch (Exception e) {
				e.printStackTrace();
				ettr.rollback();
				return false;
			}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Abonnees> selectAll(Abonnees abonnee ) {
		Query q=em.createQuery("from "+abonnee.getClass().getSimpleName()+" a");
		return  q.getResultList();
	}

	@Override
	public Object selectById(Long id) {
		Abonnees abonnee1 =(Abonnees) em.find(Abonnees.class,id);
		return abonnee1;
	}

	
	@Override
	public Object getAbonnee(String pseudo) {
		Query q=em.createQuery("from "+Abonnees.class.getSimpleName()+" a where a.pseudo=?")
				.setParameter(0, pseudo);
			
		return  q.getSingleResult();
	}
	
	
	
	
	

}
