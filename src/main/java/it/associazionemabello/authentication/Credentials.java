package it.associazionemabello.authentication;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import org.picketlink.idm.credential.AbstractBaseCredentials;
import org.picketlink.idm.credential.Password;

@Named
@RequestScoped
public class Credentials extends AbstractBaseCredentials {

	private String username;
	private Password password;
	
	public Credentials(){
		
	}
	public Credentials (String username, Password password){
		this.username=username;
		this.password=password;
	}
	
	public String getUsername(){
		return username;
	}
	
	public void setUsername(String username){
		this.username=username;
	}
	
	public Password password() {
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
