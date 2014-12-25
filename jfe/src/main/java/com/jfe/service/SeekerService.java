/**
 * 
 */
package com.jfe.service;

import com.jfe.model.Person;
import com.jfe.model.Seeker;

/**
 * @author Venkatesh
 *
 */

public interface SeekerService {
	
	String saveSeekerInfo(String email, String password);
	
	String saveSeeker(Seeker seeker);
	
	String savePersonDetails(Person person);

}
