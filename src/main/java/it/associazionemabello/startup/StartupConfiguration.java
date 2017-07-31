package it.associazionemabello.startup;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.omnifaces.cdi.Eager;

import it.associazionemabello.entities.AnimaleEntity;
import it.associazionemabello.services.daos.AnimaliDao;

@Named
@Eager
@ApplicationScoped
public class StartupConfiguration {
	
	@Inject
	AnimaliDao dao;
	
	private List <AnimaleEntity> listaAnimali;
	
	public List<AnimaleEntity> getListaAnimali(){
		
		return this.listaAnimali;
	}
	
	private void getList(){
		this.listaAnimali=dao.retrieveAnimaliList("asc");
	}
	
	
	@PostConstruct
	public void init(){
		System.out.println("Applicazione avviata");
		System.out.println("Recupero lista animali");
		getList();
		System.out.println("Recuperati "+listaAnimali.size()+" animali");
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