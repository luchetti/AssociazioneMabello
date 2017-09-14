package it.associazionemabello.authentication;

import org.picketlink.idm.model.AbstractIdentityType;
import org.picketlink.idm.model.Account;
import org.picketlink.idm.model.annotation.AttributeProperty;
import org.picketlink.idm.model.annotation.IdentityStereotype;
import org.picketlink.idm.model.annotation.IdentityStereotype.Stereotype;
import org.picketlink.idm.model.annotation.StereotypeProperty;
import org.picketlink.idm.model.annotation.StereotypeProperty.Property;
import org.picketlink.idm.model.annotation.Unique;
import org.picketlink.idm.query.QueryParameter;

@IdentityStereotype (Stereotype.USER)
public class User extends AbstractIdentityType implements Account{

	private static final long serialVersionUID = 1L;
	
	public static final QueryParameter USER_NAME = QUERY_ATTRIBUTE.byName("username");
	
	
	@StereotypeProperty(Property.IDENTITY_USER_NAME)
	@AttributeProperty
	@Unique
	private String username;
	
	public User (){
		this(null);
	}
	
	public User (String username) {
		this.username=username;
	}
	
	public String getUsername(){
		return username;
	}
	public void setUsername(String username) {
		this.username=username;
	}
}