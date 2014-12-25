package com.jfe.resources;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.web.PageableArgumentResolver;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.ServletWebArgumentResolverAdapter;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.jfe")
public class WebConfig extends WebMvcConfigurerAdapter {

	@Autowired
	private DateFormatter dateFormatter;
	@Resource
	private ConversionService conversionService;

	@Bean(name = "servletContextTemplateResolver")
	public ServletContextTemplateResolver getServletContextTemplateResolver() {
		ServletContextTemplateResolver resolver = new ServletContextTemplateResolver();
		resolver.setPrefix("/WEB-INF/pages/");
		resolver.setSuffix(".html");
		resolver.setTemplateMode("HTML5");
		// Template cache is true by default. Set to false if you want
		// templates to be automatically updated when modified.
		resolver.setCacheable(true);
		return resolver;
	}

	@Bean(name = "springTemplateEngine")
	public SpringTemplateEngine getSpringTemplageEngine() {
		SpringTemplateEngine engine = new SpringTemplateEngine();
		engine.setTemplateResolver(getServletContextTemplateResolver());
		return engine;
	}

	@Bean(name = "thymeleafViewResolver")
	public ThymeleafViewResolver getThymeleafViewResolver() {
		ThymeleafViewResolver resolver = new ThymeleafViewResolver();
		resolver.setTemplateEngine(getSpringTemplageEngine());
		return resolver;
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/utils/**").addResourceLocations(
				"/utils/resources/");
	}

	@Override
	public void addArgumentResolvers(
			List<HandlerMethodArgumentResolver> argumentResolvers) {
		PageableArgumentResolver resolver = new PageableArgumentResolver();
		resolver.setFallbackPagable(new PageRequest(1, 2));
		argumentResolvers.add(new ServletWebArgumentResolverAdapter(resolver));
	}

	@Override
	public void configureDefaultServletHandling(
			DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
	
	@Bean
	public ResourceBundleMessageSource getResourceBundleMessageSource() {
		ResourceBundleMessageSource source = new ResourceBundleMessageSource();
		// source.setBasename("i18n/messages");
		// source.setUseCodeAsDefaultMessage(true);
		source.setBasename("messages");
		return source;
	}

	@Override
	public void addFormatters(FormatterRegistry formatterRegistry) {
		formatterRegistry.addFormatter(getDateFormatter());
	}
	
	@Bean
	public DateFormatter getDateFormatter() {
		return new DateFormatter();
	}

}
