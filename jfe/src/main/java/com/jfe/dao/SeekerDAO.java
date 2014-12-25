/**
 * 
 */
package com.jfe.dao;

import org.springframework.stereotype.Repository;

import com.jfe.model.Person;
import com.jfe.model.Seeker;

/**
 * @author Venkatesh
 *
 */
@Repository
public interface SeekerDAO {
	
	String mongoSeeekerInfo(String email, String password);
	
	String saveSeeker(Seeker seeker);
	
	String savePersonDetails(Person person);

}
