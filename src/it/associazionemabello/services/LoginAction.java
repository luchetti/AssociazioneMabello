package it.associazionemabello.services;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.picketlink.Identity;
import org.picketlink.Identity.AuthenticationResult;

@Named
@RequestScoped
public class LoginAction {

	@Inject
	Identity identity;
	
	String time;
	
	public void login(){
		AuthenticationResult result = identity.login();
		
		if(AuthenticationResult.FAILED.equals(result)){
			System.out.println("Errore nell'autenticazione, si prega di riprovare");
		}
		else{
			System.out.println("Autenticazione avvenuta correttamente");
		}
	}
}
