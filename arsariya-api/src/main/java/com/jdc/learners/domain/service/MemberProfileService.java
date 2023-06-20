package com.jdc.learners.domain.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.jdc.learners.domain.dto.MemberProfileDto;
import com.jdc.learners.domain.repo.MemberRepo;

@Service
@Transactional
public class MemberProfileService {

	@Autowired
	private MemberRepo repo;

	@Autowired
	private FileUploadService fileUploadService;

	@Transactional(readOnly = true)
	public Optional<MemberProfileDto> getProfile(String email) {
		return repo.findOneByEmail(email).map(MemberProfileDto::from);
	}

	@PreAuthorize("hasAnyAuthority('Teacher', 'Student')")
	public Optional<MemberProfileDto> uploadProfileImage(MultipartFile file) {
		var image = fileUploadService.uploadProfileImage(file);
		
		var member = repo.findOneByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
		member.ifPresent(a -> a.setProfileImage(image));
		
		return member.map(MemberProfileDto::from);
	}

	@PreAuthorize("hasAnyAuthority('Teacher', 'Student')")
	public Optional<MemberProfileDto> saveProfile(MemberProfileDto form) {
		var member = repo.findOneByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
		
		// Email Should not change as it had been used as login id
		// Profile Image can only be update with uploadProfileImage 
		member.ifPresent(a -> {
			a.setName(form.getName());
			a.setPhone(form.getPhone());
		});
		return member.map(MemberProfileDto::from);
	}

}