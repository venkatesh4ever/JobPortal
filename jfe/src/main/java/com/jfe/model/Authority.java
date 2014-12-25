/**
 * 
 */
package com.jfe.model;

/**
 * @author Venkatesh
 *
 */
public class Authority {
	
	private String id;
	
	private String userId;
	
	private String authority;
	
	/**
	 * 
	 */
	public Authority() {
		super();
	}

	/**
	 * @param id
	 * @param userId
	 * @param authority
	 */
	public Authority(String id, String userId, String authority) {
		this.id = id;
		this.userId = userId;
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
	 * @return the authority
	 */
	public String getAuthority() {
		return authority;
	}

	/**
	 * @param authority the authority to set
	 */
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	
	
	

}
