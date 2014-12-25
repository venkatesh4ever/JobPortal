/**
 * 
 */
package com.jfe.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jfe.model.Seeker;
import com.jfe.service.SeekerService;

/**
 * @author Venkatesh
 *
 */
@Controller
public class UserController {
	
private final static Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired(required=true)
	private Seeker seeker;
	
	@Autowired(required=true)
	private SeekerService seekerService;

    
    @Qualifier("seekerService")
    public void setSeekerService(SeekerService seekerService){
        this.seekerService = seekerService;
    }

	@RequestMapping("/seeker-action1")
	public String hello(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		logger.debug("SeekerController >>>"+email);
		logger.debug("SeekerController >>>"+password);
		seekerService.saveSeekerInfo(email, password);
		return "hello";
	}
	
	@RequestMapping("/seeker-action")
	public String getMethod(@ModelAttribute Seeker seeker){
	    logger.debug("User Name : " + seeker.getUser());
	    //logger.debug("Email Id : " + seeker.getPassword());
	    seekerService.saveSeeker(seeker);
	    return "hello";
	}

	//This method is invoked before the above method
	@ModelAttribute
	public Seeker getAccount(HttpServletRequest request, HttpServletResponse response){
	    logger.debug("User Value from Request Parameter");
	    seeker.setUser(request.getParameter("email"));
	    //seeker.setPassword(request.getParameter("password"));
	    return seeker;
	}

}
