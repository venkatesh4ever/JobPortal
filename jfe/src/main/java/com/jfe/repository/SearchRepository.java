/**
 * 
 */
package com.jfe.repository;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.jfe.model.Person;

/**
 * @author Venkatesh
 *
 */
@Repository
public interface SearchRepository extends MongoRepository<Person, String> {

	@Query(value="{ 'baseLocation' : ?0 }")
    public List<Person> findByBaseLocation(String location);
	
	//public List<Person> findAll();
	
	public Page<Person> findAll(Pageable pageable);

    public Page<Person> findByBaseLocation(Pageable pageable);
    
    public Page<Person> findByBaseLocation(String location, Pageable pageable);
    
}
