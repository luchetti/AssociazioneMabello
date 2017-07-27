package it.associazionemabello.authentication;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.inject.Named;

import org.picketlink.Identity;
import org.picketlink.annotations.PicketLink;
import org.picketlink.authentication.BaseAuthenticator;
import org.picketlink.authentication.event.LoggedInEvent;
import org.picketlink.authentication.event.LoginFailedEvent;
import org.picketlink.credential.DefaultLoginCredentials;
import org.picketlink.idm.IdentityManager;
import org.picketlink.idm.PartitionManager;
import org.picketlink.idm.RelationshipManager;

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
		
		
		UserEntity user = dao.findUser(loginCredentials.getUserId());
		
		
		if(user != null && loginCredentials.getPassword().equals(user.getPassword())){
			setStatus(AuthenticationStatus.SUCCESS);
			setAccount(user);
			
		}
		else{
			setStatus(AuthenticationStatus.FAILURE);
		}
		
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
