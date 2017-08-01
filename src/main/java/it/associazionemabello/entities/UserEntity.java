package it.associazionemabello.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.picketlink.idm.jpa.annotations.AttributeValue;
import org.picketlink.idm.jpa.annotations.Identifier;
import org.picketlink.idm.jpa.annotations.IdentityClass;
import org.picketlink.idm.jpa.annotations.entity.IdentityManaged;
import org.picketlink.idm.model.basic.User;


@IdentityManaged(User.class)
@Entity
@Table(name ="mabello_authentication_users")
public class UserEntity extends User {

	private static final long serialVersionUID = 1L;

	@Id
	@Identifier
	@IdentityClass
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
