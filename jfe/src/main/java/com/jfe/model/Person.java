/**
 * 
 */
package com.jfe.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

/**
 * @author Venkatesh
 *
 */
@Document(collection = "person")
@Component
public class Person {
	
	@Id
	private long id;
	private String name;
	private String profileName;
	private String available;
	private String accessibleYourself;
	private String email;
	private Address address;
	public enum ENUMIndustries {
		AEROSPACE, DEFENCE, IT, TELECOM, RETAIL, MANUFACTURING, LOGISTICS
	};
	private String keySkills;
	private Education education;
	private String baseLocation;
	private String workLocation;
	private String preferredLocation;
	private Integer noticePeriod;
	public enum ENUMEmployment {
		FULLTIME, CONTRACT, FIXEDTERM, PARTTIME 
	};
	private List<Employment> employments;
	private Double expectedRate;
	private String keyRoles;
	private String ratePerTerm;
	private String profileLink;
	private String otherURLs;
	private String otherDetails;
	private String references;
	
	
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the profileName
	 */
	public String getProfileName() {
		return profileName;
	}
	/**
	 * @param profileName the profileName to set
	 */
	public void setProfileName(String profileName) {
		this.profileName = profileName;
	}
	/**
	 * @return the available
	 */
	public String getAvailable() {
		return available;
	}
	/**
	 * @param available the available to set
	 */
	public void setAvailable(String available) {
		this.available = available;
	}
	/**
	 * @return the accessibleYourself
	 */
	public String getAccessibleYourself() {
		return accessibleYourself;
	}
	/**
	 * @param accessibleYourself the accessibleYourself to set
	 */
	public void setAccessibleYourself(String accessibleYourself) {
		this.accessibleYourself = accessibleYourself;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the address
	 */
	public Address getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(Address address) {
		this.address = address;
	}
	/**
	 * @return the keySkills
	 */
	public String getKeySkills() {
		return keySkills;
	}
	/**
	 * @param keySkills the keySkills to set
	 */
	public void setKeySkills(String keySkills) {
		this.keySkills = keySkills;
	}
	/**
	 * @return the education
	 */
	public Education getEducation() {
		return education;
	}
	/**
	 * @param education the education to set
	 */
	public void setEducation(Education education) {
		this.education = education;
	}
	/**
	 * @return the baseLocation
	 */
	public String getBaseLocation() {
		return baseLocation;
	}
	/**
	 * @param baseLocation the baseLocation to set
	 */
	public void setBaseLocation(String baseLocation) {
		this.baseLocation = baseLocation;
	}
	/**
	 * @return the workLocation
	 */
	public String getWorkLocation() {
		return workLocation;
	}
	/**
	 * @param workLocation the workLocation to set
	 */
	public void setWorkLocation(String workLocation) {
		this.workLocation = workLocation;
	}
	/**
	 * @return the preferredLocation
	 */
	public String getPreferredLocation() {
		return preferredLocation;
	}
	/**
	 * @param preferredLocation the preferredLocation to set
	 */
	public void setPreferredLocation(String preferredLocation) {
		this.preferredLocation = preferredLocation;
	}
	/**
	 * @return the noticePeriod
	 */
	public Integer getNoticePeriod() {
		return noticePeriod;
	}
	/**
	 * @param noticePeriod the noticePeriod to set
	 */
	public void setNoticePeriod(Integer noticePeriod) {
		this.noticePeriod = noticePeriod;
	}
	/**
	 * @return the employments
	 */
	public List<Employment> getEmployments() {
		return employments;
	}
	/**
	 * @param employments the employments to set
	 */
	public void setEmployments(List<Employment> employments) {
		this.employments = employments;
	}
	/**
	 * @return the expectedRate
	 */
	public Double getExpectedRate() {
		return expectedRate;
	}
	/**
	 * @param expectedRate the expectedRate to set
	 */
	public void setExpectedRate(Double expectedRate) {
		this.expectedRate = expectedRate;
	}
	/**
	 * @return the ratePerTerm
	 */
	public String getRatePerTerm() {
		return ratePerTerm;
	}
	/**
	 * @param ratePerTerm the ratePerTerm to set
	 */
	public void setRatePerTerm(String ratePerTerm) {
		this.ratePerTerm = ratePerTerm;
	}
	/**
	 * @return the profileLink
	 */
	public String getProfileLink() {
		return profileLink;
	}
	/**
	 * @param profileLink the profileLink to set
	 */
	public void setProfileLink(String profileLink) {
		this.profileLink = profileLink;
	}
	/**
	 * @return the otherURLs
	 */
	public String getOtherURLs() {
		return otherURLs;
	}
	/**
	 * @param otherURLs the otherURLs to set
	 */
	public void setOtherURLs(String otherURLs) {
		this.otherURLs = otherURLs;
	}
	/**
	 * @return the otherDetails
	 */
	public String getOtherDetails() {
		return otherDetails;
	}
	/**
	 * @param otherDetails the otherDetails to set
	 */
	public void setOtherDetails(String otherDetails) {
		this.otherDetails = otherDetails;
	}
	/**
	 * @return the references
	 */
	public String getReferences() {
		return references;
	}
	/**
	 * @param references the references to set
	 */
	public void setReferences(String references) {
		this.references = references;
	}
	
	/**
	 * @return the keyRoles
	 */
	public String getKeyRoles() {
		return keyRoles;
	}
	/**
	 * @param keyRoles the keyRoles to set
	 */
	public void setKeyRoles(String keyRoles) {
		this.keyRoles = keyRoles;
	}
}
