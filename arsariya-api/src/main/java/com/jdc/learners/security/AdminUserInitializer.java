package com.jdc.learners.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.learners.domain.entity.Account;
import com.jdc.learners.domain.entity.Account.Role;
import com.jdc.learners.domain.repo.AccountRepo;

@Configuration
@Transactional
public class AdminUserInitializer {

	
	@Value("${app.user.admin.name}")
	private String name;
	@Value("${app.user.admin.email}")
	private String email;
	@Value("${app.user.admin.password}")
	private String password;
	
	@Autowired
	private AccountRepo repo;

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@EventListener(value = ContextRefreshedEvent.class)
	void execute() {
		if(repo.count() == 0L) {
			var entity = new Account();
			entity.setName(name);
			entity.setEmail(email);
			entity.setPassword(passwordEncoder.encode(password));
			entity.setRole(Role.Admin);
			entity.setActivated(true);
			
			repo.save(entity);
		}
	}
}
