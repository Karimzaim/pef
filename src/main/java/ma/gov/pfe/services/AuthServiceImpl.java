package ma.gov.pfe.services;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ma.gov.pfe.dao.IAuthDao;
import ma.gov.pfe.modeles.Abonnees;
import ma.gov.pfe.modeles.Role;


@Service
public class AuthServiceImpl implements UserDetailsService{
	
	@Autowired
	private IAuthDao userDao;
	
	
	@Override
	public UserDetails loadUserByUsername(String pseudo)	throws UsernameNotFoundException {
		System.out.println("Call UserAuthService loadUserByUsername........" +	pseudo);
		
		// load user
		final Abonnees abonnee = userDao.getAbonnee(pseudo);
		if (abonnee== null) {
			throw new UsernameNotFoundException("Invalid User");
			}
		
		Set<GrantedAuthority> auths = new HashSet<GrantedAuthority>();
		
		for (Role r : abonnee.getRole())
			auths.add(new SimpleGrantedAuthority("ROLE_" +r.getName()));
		
		org.springframework.security.core.userdetails.User ud;
		ud= new org.springframework.security.core.userdetails.User(	abonnee.getPseudo(), abonnee.getPassword(), auths);
		
		return ud;
	}

}
