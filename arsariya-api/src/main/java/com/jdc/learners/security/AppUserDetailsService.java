package com.jdc.learners.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.jdc.learners.domain.repo.AccountRepo;

@Service
public class AppUserDetailsService implements UserDetailsService {

	@Autowired
	private AccountRepo repo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		return repo.findOneByEmail(username).map(a -> User.withUsername(username)
				.password(a.getPassword())
				.authorities(a.getRole().name())
				.disabled(!a.isActivated())
				.accountExpired(a.getAudit().isDeleted())
				.build())
				.orElseThrow(() -> new UsernameNotFoundException(username));
	}

}