package com.metalgrei.angular.rest.service;

import java.util.Random;

import org.springframework.stereotype.Service;

import com.metalgrei.angular.rest.domain.Person;

// TODO: Auto-generated Javadoc
/**
 * The Class PersonServiceImpl.
 */
@Service
public class PersonServiceImpl implements PersonService {

	/** The names. */
	String[] names = {"Nikolaus Otto", "Robert Ford", "Gottlieb Daimler", "Lt. General Masaharu Homma"};

	/* (non-Javadoc)
	 * @see com.metalgrei.angular.rest.service.PersonService#getRandom()
	 */
	public Person getRandom() {
		Person person = new Person();
		person.setName(randomName());
		person.setAge(randomAge());
		return person;
	}

	/* (non-Javadoc)
	 * @see com.metalgrei.angular.rest.service.PersonService#getById(java.lang.Long)
	 */
	public Person getById(Long id) {
		Person person = new Person();
		person.setName(names[id.intValue()]);
		person.setAge(50);
		return person;
	}

	/* (non-Javadoc)
	 * @see com.metalgrei.angular.rest.service.PersonService#save(com.metalgrei.angular.rest.domain.Person)
	 */
	public void save(Person person) {
		// Save person to database ...
	}
	
	/**
	 * Random age.
	 *
	 * @return the integer
	 */
	private Integer randomAge() {
		Random random = new Random();
		return 10 + random.nextInt(100);
	}

	/**
	 * Random name.
	 *
	 * @return the string
	 */
	private String randomName() {
		Random random = new Random();
		return names[random.nextInt(names.length)];
	}

}
