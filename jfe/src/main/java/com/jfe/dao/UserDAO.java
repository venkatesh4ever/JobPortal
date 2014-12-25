/**
 * 
 */
package com.jfe.dao;

import org.springframework.stereotype.Repository;

import com.jfe.model.UserConnection;
import com.jfe.model.UserProfile;

/**
 * @author Venkatesh
 *
 */
@Repository
public interface UserDAO {
	
	public UserProfile getUserProfile(final String userId);
	
	public UserConnection getUserConnection(final String userId);
	
	public void createUser(String userId, UserProfile profile);
	
	public UserConnection saveUserConnection(UserConnection userConnection);

}
