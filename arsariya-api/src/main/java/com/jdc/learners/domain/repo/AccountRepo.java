package com.jdc.learners.domain.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.jdc.learners.domain.entity.Account;

public interface AccountRepo extends JpaRepositoryImplementation<Account, Integer> {

	public Optional<Account> findOneByEmail(String email);

}