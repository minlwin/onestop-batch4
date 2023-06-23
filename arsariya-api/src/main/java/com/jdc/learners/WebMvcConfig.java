package com.jdc.learners;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@PropertySource(value = "classpath:/app-setting.properties")
public class WebMvcConfig implements WebMvcConfigurer{

	@Value("${app.file.path}")
	private String baseDirectory;
	@Value("${app.jwt.token.name}")
	private String tokenName;
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		
		var imageLocation = "file:%s/%s/".formatted(baseDirectory, "image");
		LoggerFactory.getLogger(WebMvcConfig.class).info(imageLocation);
		registry.addResourceHandler("/images/**")
			.addResourceLocations(imageLocation);
	}
	
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
			.allowedOriginPatterns("*")
			.allowedHeaders("*")
			.allowedMethods("GET", "POST", "PUT", "DELETE")
			.exposedHeaders(tokenName);
	}
}
