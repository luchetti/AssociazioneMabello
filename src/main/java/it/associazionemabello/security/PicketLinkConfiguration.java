package it.associazionemabello.security;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.picketlink.annotations.PicketLink;
import org.picketlink.idm.PartitionManager;
import org.picketlink.idm.config.IdentityConfigurationBuilder;
import org.picketlink.idm.credential.UsernamePasswordCredentials;
import org.picketlink.idm.credential.handler.PasswordCredentialHandler;
import org.picketlink.idm.internal.DefaultPartitionManager;
import org.picketlink.idm.model.basic.User;
import org.picketlink.internal.EntityManagerContextInitializer;

import it.associazionemabello.model.entities.CredentialEntity;
import it.associazionemabello.model.entities.UserEntity;

@ApplicationScoped
public class PicketLinkConfiguration {

	@PersistenceContext
	private EntityManager entityManager; 
	
	@Inject
	private EntityManagerContextInitializer contextInitializer;
	
	@Produces
	@PicketLink
	public EntityManager getEntityManager(){
		return this.entityManager;
	}
	
	@SuppressWarnings("unchecked")
	@Produces
	@PicketLink
	public PartitionManager producePartitionManager(){
		
		final IdentityConfigurationBuilder builder = new IdentityConfigurationBuilder();
		
		/*builder.named("jpa.config")
			.stores()
			.jpa()
			.addCredentialHandler(PasswordCredentialHandler.class)
			.mappedEntity(
					UserEntity.class,
					CredentialEntity.class)
			.addContextInitializer(this.contextInitializer)
			.supportType(
					User.class)
			.supportCredentials(true);
			*/
		
		builder.named("jpa.config")
		.stores()
		.jpa().supportAllFeatures();
		
		
		return new DefaultPartitionManager(builder.build());
		
	}
}
