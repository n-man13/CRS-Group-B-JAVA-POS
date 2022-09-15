/**
 * 
 */
package com.lti.bean;

import java.util.Collection;

/**
 * @author user101
 *
 */
public class Catalog {
	private Collection<Course> allCourses;

	/**
	 * @return the allCourses
	 */
	public Collection<Course> getAllCourses() {
		return allCourses;
	}

	/**
	 * @param allCourses the allCourses to set
	 */
	public void setAllCourses(Collection<Course> allCourses) {
		this.allCourses = allCourses;
	}
	
}
