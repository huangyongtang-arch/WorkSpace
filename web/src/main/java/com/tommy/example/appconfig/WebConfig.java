package com.tommy.example.appconfig;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
@ComponentScan
public class WebConfig extends WebMvcConfigurerAdapter {

	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		registry.jsp("/WEB-INF/admin/", ".jsp");
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/html/**").addResourceLocations("/WEB-INF/html/");
		registry.addResourceHandler("/lib/**").addResourceLocations("/WEB-INF/lib/");
		registry.addResourceHandler("/static/**").addResourceLocations("/WEB-INF/static/");
		registry.addResourceHandler("/util/**").addResourceLocations("/WEB-INF/util/");
		registry.addResourceHandler("/uploads/**").addResourceLocations("/uploads/");
	}

}
