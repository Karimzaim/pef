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

import ma.gov.pfe.modeles.Echanges;
import ma.gov.pfe.modeles.Rooms;

@Repository
public class EchangeDao implements InterfaceEchange  {

	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Pltform_Idtf_Client_Potentiel");
	static EntityManager em = emf.createEntityManager();
	static EntityTransaction ettr = null;
	
	@Override
	public boolean echanger(Echanges echange) {
		try {
			ettr = em.getTransaction();
			ettr.begin();
			em.persist(echange);
			
			String strng_dateTime= new SimpleDateFormat("yyy-MM-dd HH:mm:ss").format(new Date());
			Timestamp timeStamp = java.sql.Timestamp.valueOf( strng_dateTime) ;
			echange.setDateHeur_msg(timeStamp);
			
			ettr.commit();
			System.out.println("INSERTION ECHANGE SUCCESS");
			return true;
			} catch (Exception e) {
				e.printStackTrace();
				ettr.rollback();
				return false;
			}
	}
	
	@Override
	public boolean update(Echanges echange) {
		try {
			ettr = em.getTransaction();
			ettr.begin();
			
			Echanges echange1= em.find(echange.getClass(),echange.getId_echange());
			echange1.setContenu(echange.getContenu());
			echange1.setDateHeur_msg(echange.getDateHeur_msg());
			
			ettr.commit();
			System.out.println("UPDATE ECHANGE SUCCESS");
			return true;
			} catch (Exception e) {
				e.printStackTrace();
				ettr.rollback();
				return false;
			}
	}
	@Override
	public boolean delete(Echanges echange) {
		
		try{
			ettr = em.getTransaction();
			ettr.begin();
			Echanges echange1= em.find(echange.getClass(),echange.getId_echange());
			em.remove(echange1);		
			ettr.commit();
			System.out.println("DELETE ECHANGE SUCCESS");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			ettr.rollback();
			return false;
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Echanges> selectByRoom(Rooms r) {
		Query q=em.createQuery("from "+Echanges.class.getSimpleName()+" e where id_room=? ");
		q.setParameter(0,r.getId_room());
		return ((List<Echanges>) q.getResultList());
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
//	FROM mysqldbs.t_echanges where id_room=1 and id_abonnee=1
	public List<Echanges> selectByIDAbonnee(Long id) {
		 Query q= em.createQuery("from "+Echanges.class.getSimpleName()+" e where  id_abonnee=?");
		 q.setParameter(0,id);
		 return (List<Echanges>) q.getResultList() ;
	}
	@Override
	public Object selectById(Long id) {
		Echanges echange1= (Echanges) em.find(Echanges.class,id);
		return echange1;
	}	
	
	
	
	
}
