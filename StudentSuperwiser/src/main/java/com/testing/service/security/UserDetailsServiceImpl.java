package com.testing.service.security;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.testing.dao.security.SecurityDAO;
import com.testing.model.security.UserRole;


@Service("userDetailsService")

public class UserDetailsServiceImpl implements UserDetailsService {
	
	 @Autowired
	    private SecurityDAO securityDAO;
	 
	 public UserDetails loadUserByUsername(String username)
	            throws UsernameNotFoundException, DataAccessException
	            {
	    	com.testing.model.security.User user = securityDAO.getUser(username);
	    	System.out.println("hello" + user.getUserRole());
	    	List<GrantedAuthority> authorities  = 
           buildUserAuthority(user.getUserRole());
	    	return new User(user.getUsername(), user.getPassword(), 
	    			user.isEnabled(), true, true, true, authorities);
	    	
	            }
	    private List<GrantedAuthority> buildUserAuthority(Set<UserRole> userRoles) {
	    	 
			Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();
	 
		
			for (UserRole userRole : userRoles) {
				setAuths.add(new SimpleGrantedAuthority(userRole.getRole()));
			}
	 
			List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>(setAuths);
	 
			return Result;
		}

}
