package com.example.FinalProjectLogbook.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.FinalProjectLogbook.model.User;
import com.example.FinalProjectLogbook.model.UserRepository;

/**
 * This class is used by spring security to authenticate and authorize user
 **/
@Service
public class UserDetailsServiceImpl implements UserDetailsService  {
	private final UserRepository urepository;

	@Autowired
	public UserDetailsServiceImpl(UserRepository urepository) {
		this.urepository = urepository;
	}

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {   
User currentUser = urepository.findByUsername(username);
		
		UserDetails user = new org.springframework.security.core.userdetails.User(username, currentUser.getPasswordHash(),
				true, true, true, true, AuthorityUtils.createAuthorityList(currentUser.getRole()));
		
		System.out.println("Role: " + currentUser.getRole());
        return user;
    }   
} 