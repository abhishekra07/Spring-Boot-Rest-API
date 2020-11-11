package com.codelabs.request;

import javax.validation.constraints.NotEmpty;

import com.codelabs.utility.ErrorConstants;

public class BasicDetails {
	
	private String id;
	
	@NotEmpty(message = ErrorConstants.INVALID_FIRST_NAME)
	private String firstName;
	
	private String middleName;
	
	@NotEmpty(message = ErrorConstants.INVALID_LAST_NAME)
	private String lastName;
	
	@NotEmpty(message = ErrorConstants.INVALID_EMAIL)
	private String emailAddress;
	
	@NotEmpty(message = ErrorConstants.INVALID_AGE)
	private String age;
	
	@NotEmpty(message = ErrorConstants.INVALID_GENDER)
	private String gender;
	
	@NotEmpty(message = ErrorConstants.INVALID_DOB)
	private String dob;
	
	@NotEmpty(message = ErrorConstants.INVALID_LANGUAGE)
	private String preferedLanguage;
	
	@NotEmpty(message = ErrorConstants.INVALID_HOBBY)
	private String hobbies;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getPreferedLanguage() {
		return preferedLanguage;
	}
	public void setPreferedLanguage(String preferedLanguage) {
		this.preferedLanguage = preferedLanguage;
	}
	public String getHobbies() {
		return hobbies;
	}
	public void setHobbies(String hobbies) {
		this.hobbies = hobbies;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
}
