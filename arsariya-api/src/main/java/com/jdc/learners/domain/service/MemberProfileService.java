package com.jdc.learners.domain.service;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.jdc.learners.domain.dto.MemberProfileDto;
import com.jdc.learners.domain.repo.MemberRepo;

@Service
public class MemberProfileService {

	private MemberRepo repo;

	private FileUploadService fileUploadService;

	public Optional<MemberProfileDto> getProfile(String email) {
		// TODO implement here
		return null;
	}

	public Optional<MemberProfileDto> uploadProfileImage(MultipartFile file) {
		// TODO implement here
		return null;
	}

	public Optional<MemberProfileDto> saveProfile(MemberProfileDto form) {
		// TODO implement here
		return null;
	}

}