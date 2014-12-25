/**
 * 
 */
package com.jfe.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.jfe.model.Person;
import com.jfe.repository.SearchRepository;

/**
 * @author Venkatesh
 *
 */
@Service
public class SearchServiceImpl implements SearchService {
	
	private final static Logger logger = LoggerFactory.getLogger(SearchServiceImpl.class);
	
	@Autowired SearchRepository searchRepository;

	@Override
	public List<Person> findByBaseLocation(String location) {
		return searchRepository.findByBaseLocation(location);
	}
	
	@Override
	public Page<Person> findAll(Pageable pageable) {
		logger.debug("Before Call SearchRepository... ");
		Page<Person> pages = searchRepository.findAll(pageable);
		logger.debug("After Call SearchRepository... ");
		return pages;
	}

	@Override
	public Page<Person> findByBaseLocation(Pageable pageable) {
		logger.debug("Before Call SearchRepository... ");
		Page<Person> pages = searchRepository.findByBaseLocation(pageable);
		logger.debug("After Call SearchRepository... ");
		return pages;
	}

	@Override
	public Page<Person> findByBaseLocation(String location, Pageable pageable) {
		return searchRepository.findByBaseLocation(location, pageable);
	}

}
