package it.associazionemabello.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.picketlink.idm.credential.storage.EncodedPasswordStorage;
import org.picketlink.idm.jpa.annotations.CredentialClass;
import org.picketlink.idm.jpa.annotations.CredentialProperty;
import org.picketlink.idm.jpa.annotations.EffectiveDate;
import org.picketlink.idm.jpa.annotations.ExpiryDate;
import org.picketlink.idm.jpa.annotations.OwnerReference;
import org.picketlink.idm.jpa.annotations.entity.ManagedCredential;

@ManagedCredential (EncodedPasswordStorage.class)
@Entity

public class CredentialEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column (name ="credentials_id")
	private Long id;
	
	@OwnerReference
	@ManyToOne
	private UserEntity owner;
	
	@CredentialClass
	@Column (name = "credentials_typeName")
	private String typeName;
	
	@EffectiveDate
	@Column (name ="credentials_effectiveDate")
	private Date effectiveDate;
	
	@ExpiryDate
	@Column (name = "credentials_expiryDate")
	private Date expiryDate;
	
	@CredentialProperty
	@Column (name ="credentials_passwordEncodedHash")
	private String passwordEncodedHash;
	
	@CredentialProperty
	@Column (name ="credentials_passwordSalt")
	private  String passwordSalt;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public UserEntity getOwner() {
		return owner;
	}

	public void setOwner(UserEntity owner) {
		this.owner = owner;
	}

	public Date getEffectiveDate() {
		return effectiveDate;
	}

	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getPasswordEncodedHash() {
		return passwordEncodedHash;
	}

	public void setPasswordEncodedHash(String passwordEncodedHash) {
		this.passwordEncodedHash = passwordEncodedHash;
	}

	public String getPasswordSalt() {
		return passwordSalt;
	}

	public void setPasswordSalt(String passwordSalt) {
		this.passwordSalt = passwordSalt;
	}
	
	
	
	
}
