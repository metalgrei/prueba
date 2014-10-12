package com.metalgrei.angular.rest.service;

import com.metalgrei.angular.rest.domain.Person;

// TODO: Auto-generated Javadoc
/**
 * The Interface PersonService.
 */
public interface PersonService {
	
	/**
	 * Gets the random.
	 *
	 * @return the random
	 */
	public Person getRandom();
	
	/**
	 * Gets the by id.
	 *
	 * @param id the id
	 * @return the by id
	 */
	public Person getById(Long id);
	
	/**
	 * Save.
	 *
	 * @param person the person
	 */
	public void save(Person person);
}
