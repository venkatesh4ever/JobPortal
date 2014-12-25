/**
 * HelloController
 */
package com.jfe.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Venkatesh
 *
 */
@Controller
public class HelloController {
	
	private final static Logger logger = LoggerFactory.getLogger(HelloController.class);

	@RequestMapping("/hello")
	public String hello(
			@RequestParam(value = "name", required = false, defaultValue = "World") String name,
			Model model) {
		logger.debug("inside controller...");
		model.addAttribute("name", name);
		return "hello";
	}

}