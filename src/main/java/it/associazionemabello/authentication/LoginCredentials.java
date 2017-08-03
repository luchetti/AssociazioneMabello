package it.associazionemabello.authentication;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import org.picketlink.idm.credential.AbstractBaseCredentials;
import org.picketlink.idm.credential.Credentials;
import org.picketlink.idm.credential.Password;

import java.io.Serializable;

@Named(value ="credentials")
@SessionScoped
public class LoginCredentials extends AbstractBaseCredentials implements Serializable, Credentials {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String username;
	private Password password;
	
	public LoginCredentials(){
		
	}
	public LoginCredentials (String username, Password password){
		this.username=username;
		this.password=password;
	}
	
	public String getUsername(){
		return username;
	}
	
	public void setUsername(String username){
		this.username=username;
	}
	
	public Password getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password=new Password(password);
	}
	
	@Override
	public void invalidate() {
		setStatus(Status.INVALID);
		password.clear();
		
	}

}
