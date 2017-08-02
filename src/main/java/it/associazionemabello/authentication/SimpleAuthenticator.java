package it.associazionemabello.authentication;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.inject.Named;

import java.util.List;

import org.picketlink.Identity;
import org.picketlink.annotations.PicketLink;
import org.picketlink.authentication.BaseAuthenticator;
import org.picketlink.authentication.event.LoggedInEvent;
import org.picketlink.authentication.event.LoginFailedEvent;
import org.picketlink.credential.DefaultLoginCredentials;
import org.picketlink.idm.IdentityManager;
import org.picketlink.idm.PartitionManager;
import org.picketlink.idm.RelationshipManager;
import org.picketlink.idm.credential.Credentials.Status;
import org.picketlink.idm.model.basic.BasicModel;
import org.picketlink.idm.model.basic.User;
import org.picketlink.idm.query.IdentityQueryBuilder;

import it.associazionemabello.entities.UserEntity;
import it.associazionemabello.services.daos.SecurityDao;

@PicketLink
@Named
@RequestScoped
public class SimpleAuthenticator extends BaseAuthenticator {

	@Inject
	PartitionManager partitionManager;
	
	@Inject
	IdentityManager identityManager;
	
	@Inject
	RelationshipManager relationshipManager;
	
	@Inject
	Identity identity;
	
	@Inject
	DefaultLoginCredentials loginCredentials;
	
	@Inject
	SecurityDao dao;
	
	
	@Override
	public void authenticate() {
		System.out.println("CREDENTIAL");
		System.out.println("Username: "+loginCredentials.getUserId());
		System.out.println("Password: "+loginCredentials.getPassword());
		identityManager.validateCredentials(loginCredentials);
	}
	
	@Override
	public void postAuthenticate(){
		
		System.out.println(this.getAccount().toString());
	}
	
	//LISTENER METHODS
		
	public void onSuccessFulLogin(@Observes LoggedInEvent event) {
		System.out.println("Observer login success");
	}

	public void onLoginFailed(@Observes LoginFailedEvent event) {
		System.out.println("Observer login failed");
	}
	
}