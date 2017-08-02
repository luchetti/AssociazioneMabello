package it.associazionemabello.security;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.picketlink.annotations.PicketLink;
import org.picketlink.idm.PartitionManager;
import org.picketlink.idm.config.IdentityConfigurationBuilder;
import org.picketlink.idm.internal.DefaultPartitionManager;
import org.picketlink.idm.model.basic.User;
import org.picketlink.internal.EntityManagerContextInitializer;

import it.associazionemabello.entities.UserEntity;

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
		
		builder.named("jpa.config")
			.stores()
			.jpa()
			.mappedEntity(
					UserEntity.class)
			.addContextInitializer(this.contextInitializer)
			.supportType(
					User.class)
			.supportGlobalRelationship()
			.supportCredentials(true);
		
		return new DefaultPartitionManager(builder.build());
		
	}
}
