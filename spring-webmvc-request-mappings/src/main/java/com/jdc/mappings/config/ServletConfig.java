package com.jdc.mappings.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.jdc.mappings.controller")
public class ServletConfig implements WebMvcConfigurer {

	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		registry.jsp().prefix("/views/").suffix(".jsp");
	}
	
	@SuppressWarnings("deprecation")
	@Bean(name="requestMappingHandlerMapping")
	public RequestMappingHandlerMapping mappings() {
		var mapping = new RequestMappingHandlerMapping();
		mapping.setRemoveSemicolonContent(false);
		return mapping;
	}
}
