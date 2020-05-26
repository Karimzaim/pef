package ma.gov.pfe.dao;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import ma.gov.pfe.modeles.Visites;

@Repository
public class VisiteDao implements InterfaceVisite {

	
	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Pltform_Idtf_Client_Potentiel");
	static EntityManager em = emf.createEntityManager();
	static EntityTransaction ettr = null;	
	
	
	@Override
	public boolean insert(Visites visite) {
		try {
			ettr=em.getTransaction();
			ettr.begin();
			em.persist(visite);
			
			String strng_dateTime= new SimpleDateFormat("yyy-MM-dd HH:mm:ss").format(new Date());
			Timestamp timeStamp = java.sql.Timestamp.valueOf( strng_dateTime) ;
			visite.setDateHeur_entree(timeStamp);
			
			ettr.commit();
			System.out.println("INSERTION VISITE SUCCESS");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			ettr.rollback();
			return false;
		}
	}

	
	@Override
	public boolean update(Visites visite) {
		try {
			ettr=em.getTransaction();
			ettr.begin();
			Visites visite1= (Visites)em.find(visite.getClass(),visite.getId_visite());
			
			String strng_dateTime= new SimpleDateFormat("yyy-MM-dd HH:mm:ss").format(new Date());
			Timestamp timeStamp = java.sql.Timestamp.valueOf( strng_dateTime) ;
			visite1.setDateHeur_sortie(timeStamp);
			
			ettr.commit();
			System.out.println("Delete VISITE SUCCESS");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			ettr.rollback();
			return false;
			}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Visites> selectByAbonnee(Visites visite) {
		Query q= em.createQuery("from "+visite.getClass().getSimpleName()+" v where id_abonnee=?");
		q.setParameter(0,visite.getAbonnee().getId_abonnee());
		return (List<Visites>) q.getResultList();
	}

	@Override
	public boolean findByRoomAbonnee(Long id_room, Long id_abonne) {
		Query q= null;
		boolean v=false;
		
		try {
			
			q=em.createQuery("from "+Visites.class.getSimpleName()+" v where id_room=? and id_abonnee=? and dateHeur_sortie!=null");
			q.setParameter(0,id_room);
			q.setParameter(1,id_abonne);
			
			
			System.out.println(q.getSingleResult());
			if(q!=null){		v=true;}
				System.out.println(v);

			return v;
		} catch (Exception e) {
			return false;
		}
		
	}

	@Override
	public Long getIdVisite(Long id_room, Long id_abonne) {
		
		try {
			Query q= em.createQuery("from "+Visites.class.getSimpleName()+" v where id_room=? and id_abonnee=?");
			q.setParameter(0,id_room);
			q.setParameter(1,id_abonne);
			
			Visites v=(Visites) q.getSingleResult();
		
			return v.getId_visite();
			
		} catch (Exception e) {
			return null;
		}
		
	}


	@Override
	public boolean datevidebyabonnee(Long id) {
			
		try {
			boolean v=false;
			Query q= em.createQuery("from "+Visites.class.getSimpleName()+" v where id_abonnee=? and dateHeur_sortie!=null");
			q.setParameter(0,id);
			
			System.out.println(q.getSingleResult());
			
			if(q!=null){		v=true;}
				System.out.println(v);

			return v;
		} catch (Exception e) {
			return false;
		}
	}

}
