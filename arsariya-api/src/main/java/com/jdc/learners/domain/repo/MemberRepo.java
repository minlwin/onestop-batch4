package com.jdc.learners.domain.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.jdc.learners.domain.entity.Member;

public interface MemberRepo extends JpaRepositoryImplementation<Member, Integer> {

	public Optional<Member> findOneByEmail(String email);

}