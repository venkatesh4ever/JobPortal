/**
 * 
 */
package com.jfe.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

/**
 * @author Venkatesh
 *
 */
@Document(collection = "user")
@Component
public class User {
	
	private String id;
	
	private String userId;
	
	private String password;
	
	private Authority authority;
	
	public User() {
		super();
	}
	
	public User(String id, String userId, String password, Authority authority) {
		this.id = id;
		this.userId = userId;
		this.password = password;
		this.authority = authority;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the authority
	 */
	public Authority getAuthority() {
		return authority;
	}

	/**
	 * @param authority the authority to set
	 */
	public void setAuthority(Authority authority) {
		this.authority = authority;
	}
	
	
	

}
