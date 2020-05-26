package ma.gov.pfe.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import ma.gov.pfe.dao.AuthDaoImpl;
import ma.gov.pfe.dao.IDao;
import ma.gov.pfe.modeles.Abonnees;
import ma.gov.pfe.modeles.Echanges;
import ma.gov.pfe.modeles.Rooms;

@Service
public class ServiceImple implements Iservices {
	
	
	@Autowired(required=true)
	@Qualifier(value="JPA")
	IDao dao;


	@Override
	public boolean insert(Object obj) {
		return dao.insert(obj);
	}

	@Override
	public boolean update(Object obj) {
		return dao.update(obj);
	}

	@Override
	public boolean delete(Object obj) {
		return dao.delete(obj);
	}

	@Override
	public List<?> selectAll(Object obj) {
		return dao.selectAll(obj);
	}

	@Override
	public Object selectById(Object obj, long id) {
		return dao.selectById(obj, id);
	}

	@Override
	public List<Echanges> selectByIDAbonnee(Long id) {
	
		return dao.selectByIDAbonnee(id);
	}

	@Override
	public List<Echanges> selectByRoom(Rooms r) {
		
		return dao.selectByRoom(r);
	}

	//@Autowired
	//IAuthDao authdao;
	AuthDaoImpl authdao= new AuthDaoImpl();
	
	@Override
	public Abonnees getAbonnee(String pseudo) {
		
		return authdao.getAbonnee(pseudo);
	}

	@Override
	public boolean findByRoomAbonnee(Long id_room, Long id_abonne) {
		return dao.findByRoomAbonnee(id_room, id_abonne) ;
	}

	@Override
	public Long getIdVisite(Long id_room, Long id_abonne) {
		return dao.getIdVisite(id_room, id_abonne);
	}

	@Override
	public boolean datevidebyabonnee(Long id) {
		
		return dao.datevidebyabonnee(id);
	}
	
	

}
