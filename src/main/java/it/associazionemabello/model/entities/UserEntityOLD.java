package it.associazionemabello.model.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.picketlink.idm.config.IdentityStoreConfiguration.IdentityOperation;
import org.picketlink.idm.jpa.annotations.AttributeValue;
import org.picketlink.idm.jpa.annotations.CredentialProperty;
import org.picketlink.idm.jpa.annotations.ExpiryDate;
import org.picketlink.idm.jpa.annotations.Identifier;
import org.picketlink.idm.jpa.annotations.IdentityClass;
import org.picketlink.idm.jpa.annotations.entity.IdentityManaged;
import org.picketlink.idm.jpa.annotations.entity.ManagedCredential;
import org.picketlink.idm.model.AttributedType.QUERY_ATTRIBUTE;
import org.picketlink.idm.model.annotation.AttributeProperty;
import org.picketlink.idm.model.annotation.IdentityStereotype;
import org.picketlink.idm.model.annotation.IdentityStereotype.Stereotype;
import org.picketlink.idm.model.annotation.StereotypeProperty;
import org.picketlink.idm.model.annotation.StereotypeProperty.Property;
import org.picketlink.idm.model.annotation.Unique;
import org.picketlink.idm.model.basic.User;
import org.picketlink.idm.query.QueryParameter;

@IdentityStereotype(Stereotype.USER)
@IdentityManaged(User.class)
@Table(name ="mabello_authentication_users")
public class UserEntityOLD extends User {

	private static final long serialVersionUID = 1L;

	public static final QueryParameter LOGIN_NAME = QUERY_ATTRIBUTE.byName("username");
	
	@Id
	@Identifier
	@IdentityClass
	@AttributeProperty
	@Unique
	@StereotypeProperty(Property.IDENTITY_USER_NAME)
	@Column (name ="users_username")
	private String username;
	
	@AttributeValue
	@Column (name ="users_password")
	private String password;
	
	@AttributeValue
	@Column(name ="users_registerTime")
	private Date registerTime;
	
	@AttributeValue
	@Column(name ="users_lastAccess")
	private Date lastAccess;
	
	@ExpiryDate
	@AttributeValue
	@Column(name ="users_expirationDate")
	private Date expirationDate;

	@Override
	public String toString(){
		return "User [Username: "+this.username+"; Register Time: "+this.registerTime+"; Last Access: "+this.lastAccess+"; Expiration Date: "+this.expirationDate+"]";
		
	}


	public String getUsername() {
		return username;
	}

	public void setPassword(String password){
		this.password=password;
	}
	public String getPassword(){
		return this.password;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	public Date getRegisterTime() {
		return registerTime;
	}

	public void setRegisterTime(Date registerTime) {
		this.registerTime = registerTime;
	}

	public Date getLastAccess() {
		return lastAccess;
	}

	public void setLastAccess(Date lastAccess) {
		this.lastAccess = lastAccess;
	}

	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}
}
