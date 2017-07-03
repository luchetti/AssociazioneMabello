package it.associazionemabello.services;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.picketlink.Identity;
import org.picketlink.Identity.AuthenticationResult;
import org.picketlink.idm.IdentityManager;
import org.picketlink.idm.PartitionManager;
import org.picketlink.idm.RelationshipManager;
import org.picketlink.idm.model.basic.BasicModel;
import org.picketlink.idm.model.basic.Group;
import org.picketlink.idm.model.basic.Role;
import org.picketlink.idm.model.basic.User;
import org.picketlink.idm.query.IdentityQueryBuilder;

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