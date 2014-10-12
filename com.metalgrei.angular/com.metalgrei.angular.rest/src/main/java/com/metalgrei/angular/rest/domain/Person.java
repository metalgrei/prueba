package com.metalgrei.angular.rest.domain;


// TODO: Auto-generated Javadoc
/**
 * The Class Person.
 */
public class Person {

	/** The name. */
	private String name;
	
	/** The age. */
	private Integer age;
	
	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		if( name == null){
			name = "";
		}
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Gets the age.
	 *
	 * @return the age
	 */
	public Integer getAge() {
		if( age == null ){
			age = 0;
		}
		return age;
	}

	/**
	 * Sets the age.
	 *
	 * @param age the new age
	 */
	public void setAge(Integer age) {
		this.age = age;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	
	
}
