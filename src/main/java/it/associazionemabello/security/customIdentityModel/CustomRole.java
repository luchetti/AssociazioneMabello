package it.associazionemabello.security.customIdentityModel;

import org.picketlink.idm.model.AbstractIdentityType;
import org.picketlink.idm.model.annotation.AttributeProperty;
import org.picketlink.idm.model.annotation.Unique;

public class CustomRole extends AbstractIdentityType {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String name;
	
	@AttributeProperty
	@Unique
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name=name;
	}

}
