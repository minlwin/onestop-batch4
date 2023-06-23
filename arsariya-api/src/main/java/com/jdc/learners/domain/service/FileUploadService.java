package com.jdc.learners.domain.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import jakarta.annotation.PostConstruct;

@Service
public class FileUploadService {

	@Value("${app.file.path}")
	private String folder;
	
	private Logger logger;
	
	private Path profileImageFolder;
	private Path courseImageFolder;

	@PostConstruct
	private void postConstruct() {
		
		logger = LoggerFactory.getLogger(FileUploadService.class);
		
		var baseFolder = Path.of(folder);
		var imageFolder = baseFolder.resolve("image");
		
		profileImageFolder = imageFolder.resolve("profile");
		courseImageFolder = imageFolder.resolve("course");
		
		try {
			if (!Files.exists(imageFolder, LinkOption.NOFOLLOW_LINKS)) {
				Files.createDirectories(imageFolder);
			}
			
			if (!Files.exists(profileImageFolder, LinkOption.NOFOLLOW_LINKS)) {
				Files.createDirectories(profileImageFolder);
			}

			if (!Files.exists(courseImageFolder, LinkOption.NOFOLLOW_LINKS)) {
				Files.createDirectories(courseImageFolder);
			}
		} catch (IOException e) {
			logger.error("Image folders can't created.");
		}
	}

	public String uploadProfileImage(MultipartFile file) {
		return saveFile(profileImageFolder, file);
	}

	public String uploadCourseImage(MultipartFile file) {
		return saveFile(courseImageFolder, file);
	}
	
	private String saveFile(Path directory, MultipartFile file) {
		try {
			String fileName = getFileName(file);
			Files.copy(file.getInputStream(), directory.resolve(fileName), StandardCopyOption.REPLACE_EXISTING);
			return fileName;
		} catch (IOException e) {
			logger.error("Image File can't copy to distination.");
		}
		return null;
	}

	private String getFileName(MultipartFile file) {
		var username = SecurityContextHolder.getContext().getAuthentication().getName();
		
		return "%s-%s-%s".formatted(username, 
				LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss")),
				file.getOriginalFilename());
	}

	

}