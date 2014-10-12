package com.metalgrei.angular.rest.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.metalgrei.angular.rest.domain.Person;
import com.metalgrei.angular.rest.service.PersonService;

@Controller
@RequestMapping("api")
public class PersonController {

	private static final Logger LOG = LoggerFactory
			.getLogger("com.metalgrei.angular.rest.controller.PersonController");

	@Inject
	PersonService personService;

	@RequestMapping("person/random")
	@ResponseBody
	public Person randomPerson() {
		return personService.getRandom();
	}

	@RequestMapping("person/{id}")
	@ResponseBody
	public Person getById(@PathVariable Long id) {
		return personService.getById(id);
	}

	/*
	 * same as above method, but is mapped to /api/person?id= rather than
	 * /api/person/{id}
	 */
	@RequestMapping(value = "person", params = "id")
	@ResponseBody
	public Person getByIdFromParam(@RequestParam("id") Long id) {
		return personService.getById(id);
	}

	/**
	 * Saves new person. Spring automatically binds the name and age parameters
	 * in the request to the person argument
	 * 
	 * @param person
	 * @return String indicating success or failure of save
	 */
	@RequestMapping(value = "person", method = RequestMethod.POST)
	@ResponseBody
	public String savePerson(@RequestBody Person person) {
		LOG.info(new StringBuffer("Se recibe el bean: ").append(person)
				.toString());
		personService.save(person);
		return "Saved person: " + person.toString();
	}
}
