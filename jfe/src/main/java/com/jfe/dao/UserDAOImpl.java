/**
 * 
 */
package com.jfe.dao;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.jfe.model.Authority;
import com.jfe.model.User;
import com.jfe.model.UserConnection;
import com.jfe.model.UserProfile;

/**
 * @author Venkatesh
 *
 */
@Service
public class UserDAOImpl implements UserDAO {
	
	private final static Logger logger = LoggerFactory.getLogger(UserDAOImpl.class);
	
	@Autowired
	private MongoOperations mongoOperation;
	
	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public UserProfile getUserProfile(String userId) {
		Query query = new Query();
		query.addCriteria(Criteria.where("userId").is(userId));
		UserProfile userProfile = mongoOperation.findOne(query, UserProfile.class);
		logger.debug("getUserProfile debug query >> "+query.toString());
		
		return userProfile;
	}

	@Override
	public UserConnection getUserConnection(String userId) {
		Query query = new Query();
		query.addCriteria(Criteria.where("userId").is(userId));
		UserConnection userConnection = mongoOperation.findOne(query, UserConnection.class);
		logger.debug("getUserProfile debug query >> "+query.toString());
		
		return userConnection;
	}
	
	@Override
	public UserConnection saveUserConnection(UserConnection userConnection) {
		if(userConnection != null)
			mongoOperation.save(userConnection);
		return userConnection;
	}

	@Override
	public void createUser(String userId, UserProfile profile) {
		logger.debug("SQL INSERT ON users, authorities and userProfile: " + userId + " with profile: " +
                profile.getEmail() + ", " +
                profile.getFirstName() + ", " +
                profile.getLastName() + ", " +
                profile.getName() + ", " +
                profile.getUsername());
        
        String id = UUID.randomUUID().toString();
        
        logger.debug("Save User");
        User user = new User();
        user.setId(id);
        user.setUserId(userId);
        user.setPassword("********");
        user.setAuthority(new Authority(id, userId, "VALID_USER"));
		mongoOperation.save(user);
        
        logger.debug("Sve User Profile");
        if (profile != null)
        	mongoOperation.save(profile);
	}

}
