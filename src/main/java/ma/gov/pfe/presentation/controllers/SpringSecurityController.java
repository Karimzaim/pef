package ma.gov.pfe.presentation.controllers;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import ma.gov.pfe.modeles.Abonnees;
import ma.gov.pfe.modeles.Echanges;
import ma.gov.pfe.modeles.Rooms;
import ma.gov.pfe.services.Iservices;




@Controller
public class SpringSecurityController {

	
	@Autowired
	Iservices service;
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
			}
		System.out.println("LOGOUT");
		return "redirect:/login";
		}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(ModelMap model) {
		model.addAttribute("abonnee", new Abonnees());
		System.out.println("LOGIN");
		return "login";
	}
	
	
	@SuppressWarnings({ "unchecked" })
	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView welcomeToApp( ModelMap pModel,Abonnees abonnee, Rooms room, Echanges echange,Principal principal){
		ModelAndView mv = new ModelAndView("welcome");
		try {
			
			String name = principal.getName();
						 System.out.println("name="+name);
			 if(abonnee==null || room==null || echange==null){
				 abonnee=new Abonnees();
				 room= new Rooms();
				 echange=new Echanges();
			 }
		
			abonnee= service.getAbonnee(name);
			List<Echanges> listechg = (List<Echanges>) service.selectByIDAbonnee(abonnee.getId_abonnee());
			List<Rooms> listroom = (List<Rooms>) service.selectAll(room);
						System.out.println("-------------listeroom"+listroom );
			pModel.addAttribute("echangese", listechg);
			pModel.addAttribute("roomse", listroom);
			pModel.addAttribute("abonne", abonnee);
			
		} catch (Exception e) {
			System.out.println(e.getMessage().toString());
			System.out.println(e.getMessage());
			System.out.println("no welcom");
		}
		
		return mv;
	}


	

	@RequestMapping(value = "/access_denied", method = RequestMethod.GET)
	public String accessDeniedPage(ModelMap model) {
		model.addAttribute("abonnee", getPrincipal());
		return "accessDenied";
	}

	private String getPrincipal() {
		String userName = null;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			userName = ((UserDetails) principal).getUsername();
		} else {
			userName = principal.toString();
		}
		return userName;
	}

}
