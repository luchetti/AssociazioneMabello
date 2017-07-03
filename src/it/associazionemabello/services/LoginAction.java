package it.associazionemabello.services;


import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.picketlink.Identity;
import org.picketlink.Identity.AuthenticationResult;
import org.picketlink.idm.IdentityManager;
import org.picketlink.idm.PartitionManager;
import org.picketlink.idm.RelationshipManager;

@Named
@RequestScoped
public class LoginAction {

	@Inject
	PartitionManager partitionManager;
	
	@Inject
	IdentityManager identityManager;
	
	@Inject
	RelationshipManager relationshipManager;
	
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