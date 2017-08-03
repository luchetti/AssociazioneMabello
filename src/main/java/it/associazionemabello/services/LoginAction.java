package it.associazionemabello.services;

import java.io.IOException;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.util.SavedRequest;
import org.apache.shiro.web.util.WebUtils;
import org.omnifaces.util.Faces;
import org.picketlink.Identity;
import org.picketlink.Identity.AuthenticationResult;
import org.picketlink.credential.DefaultLoginCredentials;
import org.picketlink.idm.credential.UsernamePasswordCredentials;

import it.associazionemabello.authentication.LoginCredentials;

@Named
@RequestScoped
public class LoginAction {

	public static final String HOME_URL ="/index.xhtml";

	private String username;
	private String password;
	private boolean remember;
	
	public void login() throws IOException {
			
		try{
			SecurityUtils.getSubject().login(new UsernamePasswordToken (username, password, remember));
			SavedRequest savedRequest = WebUtils.getAndClearSavedRequest(Faces.getRequest());
			Subject subject = SecurityUtils.getSubject();
			System.out.println(subject.getPrincipal().toString());
			
			Faces.redirect(savedRequest != null ? savedRequest.getRequestUrl() : HOME_URL);
			
		}
		catch (AuthenticationException ex) {
			System.out.println("Utente sconosciuto");
			ex.printStackTrace();
		}
	}
	public void logout() throws IOException {
		SecurityUtils.getSubject().logout();
		Faces.invalidateSession();
		Faces.redirect(HOME_URL);
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isRemember() {
		return remember;
	}
	public void setRemember(boolean remember) {
		this.remember = remember;
	}
	
	
}