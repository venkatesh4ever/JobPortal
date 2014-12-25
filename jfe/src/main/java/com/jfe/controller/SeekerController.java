/**
 * HelloController
 */
package com.jfe.controller;

import java.math.BigDecimal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jfe.model.Seeker;
import com.jfe.service.SeekerService;

/**
 * @author Venkatesh
 *
 */
@Controller
public class SeekerController {
	
	private final static Logger logger = LoggerFactory.getLogger(SeekerController.class);
	
	@Autowired
	private Seeker seeker;
	
	@Autowired(required=true)
	private SeekerService seekerService;

    
    @Qualifier("seekerService")
    public void setSeekerService(SeekerService seekerService){
        this.seekerService = seekerService;
    }
	
	@RequestMapping("/seekerAction")
	public String processSeekerInfo(HttpServletRequest request, HttpServletResponse response, Model model) {
	    logger.debug("Person name >> "+request.getParameter("personName"));
	    Seeker seeker = getRequestSeeker(request, response);
	    String saveSeeker = seekerService.saveSeeker(seeker);
	    logger.debug("Server response for Person dave detail >> "+saveSeeker);
	    
	    return "saveSeeker";
	}

	public Seeker getRequestSeeker(HttpServletRequest request, HttpServletResponse response) {
	    logger.debug("Inside getRequestPerson");
	    
	    logger.debug("Person name >> "+request.getParameter("personName"));
	    Seeker seeker = new Seeker();
	    
	    seeker.setLocation(request.getParameter("location"));
	    seeker.setExpectedRate((request.getParameter("expectedRate") == null) ? null : new BigDecimal(request.getParameter("expectedRate")));
	    seeker.setPerRate((request.getParameter("ratePer") == null) ? null : new Integer(request.getParameter("ratePer")));
	    seeker.setTags(request.getParameter("tag"));
	    seeker.setExperience(request.getParameter("experience"));
	    seeker.setDomain(request.getParameter("domain"));
	    seeker.setDocument(null);
	    seeker.setUrl(request.getParameter("reference"));
	    seeker.setAudio(null);
	    seeker.setVedio(null);
	    
	    return seeker;
	}

}