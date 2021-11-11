package fr.istic.m2.taa.subrapays.projectTaa.dto;

import java.io.Serializable;

import javax.validation.constraints.*;


public class UserDto implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@NotBlank(message="firstname cannot be empty")
	private String firstname;	

	@NotBlank(message="lastname cannot be empty")
	private String lastname;
	
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
    @Override
    public String toString() {
    	return "User{firstname = " + firstname + ", lastname = " + lastname;
    }

}
