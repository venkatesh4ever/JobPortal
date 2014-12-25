/**
 * 
 */
package com.jfe.dao;

import org.springframework.stereotype.Repository;

import com.jfe.exception.SequenceException;

/**
 * @author Venkatesh
 *
 */
@Repository
public interface SequenceDAO {
	
	long getNextSeekerSequence(String key) throws SequenceException;

}
