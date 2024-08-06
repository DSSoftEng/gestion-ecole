package com.coding.service;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.coding.entity.Role;
import com.coding.entity.User;





@Service
public class CustemUserDetailService implements UserDetailsService {
	
	@Autowired
	IuserService userService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user=userService.chercherparUsername(username);
		
		if(user==null)
		{
			throw new UsernameNotFoundException(username);
		}
		
		List<GrantedAuthority> authorities=getGrantedAuthority(user);
		
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),authorities);
		
		

	}
	
	private List<GrantedAuthority> getGrantedAuthority(User u)
	{
		List<GrantedAuthority> liste= new ArrayList<>();
		List<Role> roles=u.getRoles();
		for(Role r:roles)
		{
			liste.add(new SimpleGrantedAuthority(r.getname()));
		}
		
		return liste;
		
	}

}
