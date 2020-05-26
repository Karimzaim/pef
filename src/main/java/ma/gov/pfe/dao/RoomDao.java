package ma.gov.pfe.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import ma.gov.pfe.modeles.Rooms;

@Repository
public class RoomDao {
	
	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Pltform_Idtf_Client_Potentiel");
	static EntityManager em = emf.createEntityManager();
	static EntityTransaction ettr = null;
	
	@SuppressWarnings("unchecked")
	public List<Rooms> selectAll(Rooms room) {
		
		Query q=em.createQuery("from "+room.getClass().getSimpleName()+" r");
		return  q.getResultList();
	}
	
	public Rooms selectById(Long id_room) {		
		Rooms room= em.find(Rooms.class,id_room);
		return  room;
	}
	
	


}
