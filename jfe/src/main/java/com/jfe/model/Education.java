/**
 * 
 */
package com.jfe.model;

import java.util.List;

/**
 * @author Venkatesh
 *
 */
public class Education {
	
	private List<String> educations;
	private List<String> certifications;
	
	/**
	 * @return the educations
	 */
	public List<String> getEducations() {
		return educations;
	}
	/**
	 * @param educations the educations to set
	 */
	public void setEducations(List<String> educations) {
		this.educations = educations;
	}
	/**
	 * @return the certifications
	 */
	public List<String> getCertifications() {
		return certifications;
	}
	/**
	 * @param certifications the certifications to set
	 */
	public void setCertifications(List<String> certifications) {
		this.certifications = certifications;
	}
}
