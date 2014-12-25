/**
 * 
 */
package com.jfe.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * @author Venkatesh
 *
 */
@Controller
public class RedirectController {
	
	private final static Logger logger = LoggerFactory.getLogger(RedirectController.class);
	
	@RequestMapping("/seeker")
	public String seeker(Model model) {
		logger.debug("inside RedirectController - seeker...");
		//model.addAttribute("name", name);
		return "seeker";
	}
	
	@RequestMapping("/seeker-test")
	public String seekerTest(Model model) {
		logger.debug("inside RedirectController - seeker...");
		//model.addAttribute("name", name);
		return "seeker-test";
	}
	
	@RequestMapping("/provider")
	public String provider(Model model) {
		logger.debug("inside RedirectController - provider...");
		//model.addAttribute("name", name);
		return "provider";
	}
	
	@RequestMapping("/search")
	public String hello(Model model) {
		logger.debug("inside RedirectController - search...");
		//model.addAttribute("name", name);
		return "seeker-search";
	}
	
}
