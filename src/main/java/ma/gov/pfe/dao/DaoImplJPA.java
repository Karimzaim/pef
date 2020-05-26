package ma.gov.pfe.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import ma.gov.pfe.modeles.Abonnees;
import ma.gov.pfe.modeles.Echanges;
import ma.gov.pfe.modeles.Professions;
import ma.gov.pfe.modeles.Quartiers;
import ma.gov.pfe.modeles.Rooms;
import ma.gov.pfe.modeles.Visites;

@Qualifier("JPA")
@Repository
public class DaoImplJPA implements IDao {

	

	AbonneeDao ad= new AbonneeDao();
	EchangeDao ed=new EchangeDao();
	VisiteDao vd=new VisiteDao();
	ProfessionDao pd=new ProfessionDao();
	RoomDao rd= new RoomDao();
	QuartierDao qd= new QuartierDao();
	
	
	
	@Override
	public boolean insert(Object obj) {

		if(obj instanceof Abonnees) {
			System.out.println("insertion abonnee .....");
            return ad.insert((Abonnees) obj);
            
		}else if(obj instanceof Echanges) {
			System.out.println("insertion echange.....");
            return ed.echanger((Echanges) obj);     
            
		}else if(obj instanceof Visites) {
			System.out.println("insertion visite .....");
            return vd.insert((Visites) obj);    
       
            }else{	return false;}
	}


	@Override
	public boolean update(Object obj) {
		
		if(obj instanceof Abonnees) {
			System.out.println("modefecation abonnee .....");
            return ad.update((Abonnees) obj);
            
		}else if(obj instanceof Echanges) {
			System.out.println("modefecation echange .....");
            return ed.update((Echanges) obj);     
            
		}else if(obj instanceof Visites) {
			System.out.println("modefecation echange .....");
            return vd.update((Visites) obj);     
            
		}else{	return false;}
	}

	@Override
	public boolean delete(Object obj) {
		
		if(obj instanceof Abonnees) {
			System.out.println("supression abonnee..");
            return ad.delete((Abonnees) obj);
            
		}else if(obj instanceof Echanges) {
			System.out.println("supression echange .....");
            return ed.delete((Echanges) obj);     
            
		}else 	return false;
		
	}

	@Override
	public List<?> selectAll(Object obj) {
		
		if(obj instanceof Abonnees) {
			System.out.println("select abonnee..");
            return ad.selectAll((Abonnees) obj);
            
		}else if(obj instanceof Professions) {
    			System.out.println("select profession .....");
                return pd.selectAll((Professions) obj);    
           
                }else if(obj instanceof Quartiers) {
        			System.out.println("select quartier .....");
                    return qd.selectAll((Quartiers) obj);    
               
                    } else if(obj instanceof Rooms) {
            			System.out.println("select rooms .....");
                        return rd.selectAll((Rooms) obj);    
                   
                        } else{	return null;}
		
	}

	@Override
	public Object selectById(Object obj, long id) {
		
		if(obj instanceof Abonnees) {
			
            return ad.selectById(id);
            
			}else if(obj instanceof Echanges) {
				
				return ed.selectById(id);   
            
			}else if(obj instanceof Rooms) {
				
				return rd.selectById(id);   
            
				}else{	return null;}
	}


	@Override
	public List<Echanges> selectByIDAbonnee(Long id) {
			return ed.selectByIDAbonnee(id);
	}


	@Override
	public List<Echanges> selectByRoom(Rooms r) {
		return ed.selectByRoom(r);
	}


	@Override
	public boolean findByRoomAbonnee(Long id_room, Long id_abonne) {
		return vd.findByRoomAbonnee(id_room, id_abonne);
	}


	@Override
	public Long getIdVisite(Long id_room, Long id_abonne) {
		return vd.getIdVisite(id_room, id_abonne);
	}


	@Override
	public boolean datevidebyabonnee(Long id) {
		return vd.datevidebyabonnee(id);
	}
	
	

}
