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
@Document(collection = "data")
@Component
public class Data {
	
	private String userId;
	
	private String data;
	
	/**
	 * 
	 */
	public Data() {
		super();
	}

	/**
	 * @param userId
	 * @param data
	 */
	public Data(String userId, String data) {
		this.userId = userId;
		this.data = data;
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
	 * @return the data
	 */
	public String getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(String data) {
		this.data = data;
	}

}
