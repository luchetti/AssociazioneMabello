package it.associazionemabello.security.customIdentityModel;

import org.picketlink.idm.model.AbstractIdentityType;
import org.picketlink.idm.model.Account;
import org.picketlink.idm.model.annotation.AttributeProperty;
import org.picketlink.idm.model.annotation.Unique;

public class CustomAgent extends AbstractIdentityType implements Account {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String loginName;
	
	@AttributeProperty
	@Unique
	public String getLoginName(){
		return loginName;
	}
	
	public void setLoginName(String loginName){
		this.loginName=loginName;
	}
}
