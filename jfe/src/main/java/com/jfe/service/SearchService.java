/**
 * 
 */
package com.jfe.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.jfe.model.Person;

/**
 * @author Venkatesh
 *
 */
public interface SearchService {
	
	public List<Person> findByBaseLocation(String location);
	
	public Page<Person> findAll(Pageable pageable);

    public Page<Person> findByBaseLocation(Pageable pageable);
    
    public Page<Person> findByBaseLocation(String location, Pageable pageable);

}
