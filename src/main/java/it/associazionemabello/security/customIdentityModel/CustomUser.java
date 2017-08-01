package it.associazionemabello.security.customIdentityModel;

import org.picketlink.idm.model.annotation.AttributeProperty;

public class CustomUser extends CustomAgent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@AttributeProperty
	private String firstName;
	
	@AttributeProperty
	private String lastName;
	
	@AttributeProperty
	private String email;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
