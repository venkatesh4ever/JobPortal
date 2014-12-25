/**
 * 
 */
package com.jfe.model;
import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

/**
 * @author Venkatesh
 *
 */
@Document(collection = "seeker")
@Component
public class Seeker {
	
	@Id
	private long id;
	private String user;
	private String location;
	private BigDecimal expectedRate;
	private Integer perRate;
	private String tags;
	private String experience;
	private String domain;
	private Byte[] document;
	private String url;
	private byte[] audio;
	private byte [] vedio;
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}
	/**
	 * @return the user
	 */
	public String getUser() {
		return user;
	}
	/**
	 * @param user the user to set
	 */
	public void setUser(String user) {
		this.user = user;
	}
	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}
	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}
	/**
	 * @return the expectedRate
	 */
	public BigDecimal getExpectedRate() {
		return expectedRate;
	}
	/**
	 * @param expectedRate the expectedRate to set
	 */
	public void setExpectedRate(BigDecimal expectedRate) {
		this.expectedRate = expectedRate;
	}
	/**
	 * @return the perRate
	 */
	public Integer getPerRate() {
		return perRate;
	}
	/**
	 * @param perRate the perRate to set
	 */
	public void setPerRate(Integer perRate) {
		this.perRate = perRate;
	}
	/**
	 * @return the tags
	 */
	public String getTags() {
		return tags;
	}
	/**
	 * @param tags the tags to set
	 */
	public void setTags(String tags) {
		this.tags = tags;
	}
	/**
	 * @return the domain
	 */
	public String getDomain() {
		return domain;
	}
	/**
	 * @param domain the domain to set
	 */
	public void setDomain(String domain) {
		this.domain = domain;
	}
	/**
	 * @return the document
	 */
	public Byte[] getDocument() {
		return document;
	}
	/**
	 * @param document the document to set
	 */
	public void setDocument(Byte[] document) {
		this.document = document;
	}
	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	/**
	 * @return the audio
	 */
	public byte[] getAudio() {
		return audio;
	}
	/**
	 * @param audio the audio to set
	 */
	public void setAudio(byte[] audio) {
		this.audio = audio;
	}
	/**
	 * @return the vedio
	 */
	public byte[] getVedio() {
		return vedio;
	}
	/**
	 * @param vedio the vedio to set
	 */
	public void setVedio(byte[] vedio) {
		this.vedio = vedio;
	}
	/**
	 * @return the experience
	 */
	public String getExperience() {
		return experience;
	}
	/**
	 * @param experience the experience to set
	 */
	public void setExperience(String experience) {
		this.experience = experience;
	}
	
}
