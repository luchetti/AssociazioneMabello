package it.associazionemabello.startup;

import javax.annotation.PostConstruct;
import javax.ejb.Startup;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@Named
@Startup
/*@Eager*/
@ApplicationScoped
public class StartupConfiguration {
	
	
	
	
	@PostConstruct
	public void init(){
		System.out.println("Applicazione avviata");
		
		/*
		
		
		
		IdentityConfigurationBuilder builder = new IdentityConfigurationBuilder();
		
		builder.named("default").stores().jpa().mappedEntity(UserEntity.class);
		*/
/*		User user=new User("luchetti");
		
		user.setFirstName("Luca");
		user.setLastName("Di Natale");
		
		identityManager.add(user);
		
		Group group = new Group("mabelloAuthenticated");
		Group groupTwo = new Group("mabelloUnauthenticated");
		identityManager.add(group);
		identityManager.add(groupTwo);
		
		Role admin = new Role("admin");
		Role basicUser = new Role("BasicUser");
		Role unauthUser = new Role("UnauthUser");
		
		identityManager.add(unauthUser);
		identityManager.add(basicUser);
		identityManager.add(admin);
		
		relationshipManager.add(new Grant(user, admin));
		relationshipManager.add(new GroupMembership(user, group));
		*/
	}
}