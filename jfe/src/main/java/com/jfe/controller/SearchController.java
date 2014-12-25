package com.jfe.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jfe.model.Person;
import com.jfe.service.SearchService;
import com.jfe.service.SeekerService;
import com.jfe.util.PageWrapper;

@Controller
public class SearchController {
	
private final static Logger logger = LoggerFactory.getLogger(SearchController.class);
	
	@Autowired
	private Person person;
	
	@Autowired(required=true)
	private SeekerService seekerService;
	
	@Autowired(required=true)
	private SearchService searchService;
	
	@Qualifier("searchService")
    public void setSearchService(SearchService searchService){
        this.searchService = searchService;
    }
    
    @Qualifier("seekerService")
    public void setSeekerService(SeekerService seekerService){
        this.seekerService = seekerService;
    }
    
    @RequestMapping("/search-action1")
	public String processSeekerInfo(HttpServletRequest request, HttpServletResponse response) {
    	
	    logger.debug("Search by location >> "+request.getParameter("location"));
	    logger.debug("Search by location >> "+request.getParameter("rate"));
	    int page = 1;
        int pageSize = 2;
        
        Pageable pageable = new PageRequest(page, pageSize);
        Page<Person> persons = searchService.findAll(pageable);
        
        logger.debug("Pageable details >>> "+persons.isFirstPage());
        logger.debug("Pageable details >>> "+persons.getTotalPages());
	    
	    return "hello";
	}
    
    @RequestMapping(value = "/search-action")
	public String searchResults(Model uiModel, Pageable pageable, HttpServletRequest request) {
    	
	    logger.debug("Search by location >> "+request.getParameter("location"));
	    logger.debug("Search by location >> "+request.getParameter("rate"));
	    //int page = 1;
        //int pageSize = 2;
        
        //Pageable pageable = new PageRequest(page, pageSize);
    	logger.debug("inside search results...");
    	logger.debug("Pageable parameter >> "+pageable.getPageNumber());
    	logger.debug("Pageable parameter >> "+pageable.getPageSize());
    	
        Page<Person> persons = searchService.findAll(pageable);
        PageWrapper<Person> page = new PageWrapper<Person>
                    (persons, "/search-action");
        uiModel.addAttribute("page", page);
        
        uiModel.addAttribute("location", request.getParameter("location"));
        uiModel.addAttribute("rate", request.getParameter("rate"));
        logger.debug("Pageable details >>> "+persons.isFirstPage());
        logger.debug("Pageable details >>> "+persons.getTotalPages());
	    
	    return "search-results";
	}
    
    @RequestMapping(value = "/search-action123")
	public String searchResults123(Model uiModel, Pageable pageable) {

    	logger.debug("inside search results...");
    	logger.debug("Pageable parameter >> "+pageable.getPageNumber());
    	logger.debug("Pageable parameter >> "+pageable.getPageSize());
    	
        Page<Person> persons = searchService.findAll(pageable);
        PageWrapper<Person> page = new PageWrapper<Person>
                    (searchService.findAll(pageable), "/search-action");
        uiModel.addAttribute("page", page);

        logger.debug("Pageable details >>> "+persons.isFirstPage());
        logger.debug("Pageable details >>> "+persons.getTotalPages());
	    
	    return "search-results";
	}

}
