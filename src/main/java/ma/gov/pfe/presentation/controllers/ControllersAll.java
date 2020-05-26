 package ma.gov.pfe.presentation.controllers;

import java.security.Principal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ma.gov.pfe.modeles.Abonnees;
import ma.gov.pfe.modeles.Echanges;
import ma.gov.pfe.modeles.Professions;
import ma.gov.pfe.modeles.Quartiers;
import ma.gov.pfe.modeles.Rooms;
import ma.gov.pfe.modeles.Visites;
import ma.gov.pfe.services.Iservices;

@Controller
@RequestMapping("/hello")
public class ControllersAll {
	
	@Autowired
	Iservices service;

	
	@RequestMapping(value="/create")
	public ModelAndView open( @ModelAttribute("abonnee") Abonnees abonnee, Quartiers quartier, Professions profession) {
		System.out.println("Call Contoller Method.....");
		if (quartier == null && profession==null && abonnee==null){
			quartier = new Quartiers();
			profession = new Professions();
			abonnee= new Abonnees();
		}
		@SuppressWarnings("unchecked")
		List<Quartiers> listq = (List<Quartiers>) service.selectAll(quartier);
		
		@SuppressWarnings("unchecked")
		List<Professions> listp = (List<Professions>) service.selectAll(profession);
		
		 Set<Professions> sp= new HashSet<>();
	     for(Professions pf: listp){  	sp.add(pf);    }
	     
	     Set<Quartiers> sq= new HashSet<>();
	     for(Quartiers qrt: listq){  	sq.add(qrt);    }
		
		ModelAndView mv = new ModelAndView("create_abonnee");
		mv.addObject("quartiers", listq);
		mv.addObject("professions", sp);
		return mv;
	}
	
	@RequestMapping(value="/inscrier" , method=RequestMethod.POST)
	public ModelAndView insertabonnee( @ModelAttribute("abonnee") Abonnees abonnee) {
		ModelAndView mv = null;
		try {
			System.out.println("Call Contoller INSERT ...");
			service.insert(abonnee);
			mv = new ModelAndView("login");
		} catch (Exception e) {
			
			System.out.println(e.getStackTrace());
			System.out.println(e.getMessage());
			mv = new ModelAndView("redirect:/hello/create"); 
		}
		return mv;
	}	
	

		
	@RequestMapping(value="/visiter/{id_room}")
	public ModelAndView insertvisite( @PathVariable("id_room") Long id_room,Rooms room, Principal principal,@ModelAttribute("visite") Visites visite) {
	
		System.out.println("=============CALL VISITE1===================");
		try {
			System.out.println("=============CALL VISITE2===================");
			String name = principal.getName();
		    
			Abonnees abonnee= service.getAbonnee(name);
			Rooms room1 = (Rooms) service.selectById(room, id_room);
	
			boolean find=service.findByRoomAbonnee(id_room,abonnee.getId_abonnee());
			
			if(find==true){

				Long idv=service.getIdVisite(id_room,abonnee.getId_abonnee());				
				visite=new Visites(idv);
				service.update(visite);
				
			}else {
				
				if(service.datevidebyabonnee(abonnee.getId_abonnee())==true){
					Long idv=service.getIdVisite(id_room,abonnee.getId_abonnee());				
					visite=new Visites(idv);
					service.update(visite);			
				}
				visite=new Visites(abonnee,room1);
				service.insert(visite);
				
			}	
			
		
			
			ModelAndView mv = new ModelAndView("redirect:/hello/callrom/{id_room}");
			return mv;
		} catch (Exception e) {
			
			System.out.println(e.getStackTrace());
			System.out.println(e.getMessage());
			System.out.println("============= not CALL VISITE--------");
			ModelAndView mv2 = new ModelAndView("redirect:/welcome");
			return mv2; 
		}
		
	}	
	
	@SuppressWarnings({ "unchecked" })
	@RequestMapping(value = "/callrom/{id_room}", method = RequestMethod.GET)
	public ModelAndView roomCAll( @PathVariable("id_room") Long id_room,ModelMap pModel,Abonnees abonnee, Rooms room, Echanges echange,Principal principal){
				
		String name = principal.getName();
		
		if (room == null && echange==null && abonnee==null){
			room = new Rooms();
			echange= new Echanges();
			abonnee= new Abonnees();
		}
		
		List<Rooms> listroom = (List<Rooms>) service.selectAll(room);
				
		abonnee= service.getAbonnee(name);
		
		Rooms r= (Rooms) service.selectById(room, id_room);
				
		List<Echanges> listechg = (List<Echanges>) service.selectByRoom(r);
				
		pModel.addAttribute("roomse", listroom);
		
		pModel.addAttribute("echangese", listechg);
	
		pModel.addAttribute("abonne", abonnee);
	
		pModel.addAttribute("rm", r);
		
		ModelAndView mv = new ModelAndView("roomsall");		
		
		return mv;
	}
	
	@RequestMapping(value = "/adddechange/{id_room}")
   public ModelAndView addechange(@ModelAttribute("echanges") Echanges echange ,@PathVariable("id_room") Long id_room,Abonnees abonnee, Rooms room, Principal principal){
		
		 
		ModelAndView mv = new ModelAndView("redirect:/hello/callrom/{id_room}");	
	   
	//   String name = principal.getName();
	  	
	   if (room == null && echange==null && abonnee==null){
		   room = new Rooms();
		   echange= new Echanges();
		   abonnee= new Abonnees();
	   }
//	   abonnee= service.getAbonnee(name);
//	   Rooms roome= (Rooms) service.selectById(room, id_room);
//	   echange= new Echanges(abonnee, roome);
	   service.insert(echange);
	   return mv;
	}
	
	
	

}
