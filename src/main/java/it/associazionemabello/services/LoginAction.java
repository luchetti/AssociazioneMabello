package it.associazionemabello.services;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.picketlink.Identity;
import org.picketlink.Identity.AuthenticationResult;
import org.picketlink.credential.DefaultLoginCredentials;
import org.picketlink.idm.credential.UsernamePasswordCredentials;

import it.associazionemabello.authentication.LoginCredentials;

@Named
@RequestScoped
public class LoginAction {

	@Inject Identity identity;
	
	public void login(){
		AuthenticationResult result = identity.login();
		if (AuthenticationResult.FAILED.equals(result)){
			System.out.println("Errore nell'autenticazione");
		}
	}
	public void logout(){
		identity.logout();
	}
}