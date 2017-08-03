package it.associazionemabello.entities;

import java.io.Serializable;
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

@IdentityManaged(User.class)
@Entity
@Table(name ="mabello_authentication_usersNEW")
public class UserEntity extends User implements Serializable{

	private static final long serialVersionUID = 1L;

	public static final QueryParameter LOGIN_NAME = QUERY_ATTRIBUTE.byName("loginName");
	
	@Id
	@Identifier
	@Column (name ="users_id")
	private String id;
	
	@IdentityClass
	@Column (name ="users_typeName")
	private String typeName;
	
	@AttributeValue
	@Column(name ="users_loginName")
	private String loginName;
	
	@AttributeValue
	@Column(name ="users_createdTime")
	private Date createdTime;
	
	@AttributeValue
	@Column(name ="users_expirationDate")
	private Date expirationDate;

	@AttributeValue
	private boolean enabled;
	
	
	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getTypeName() {
		return typeName;
	}


	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}


	public String getLoginName() {
		return loginName;
	}


	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}


	public Date getCreatedTime() {
		return createdTime;
	}


	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}


	public boolean isEnabled() {
		return enabled;
	}


	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
}
