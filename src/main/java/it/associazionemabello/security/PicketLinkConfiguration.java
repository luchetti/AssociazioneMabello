package it.associazionemabello.security;

import javax.ejb.Stateless;
import javax.enterprise.event.Observes;

import org.picketlink.event.PartitionManagerCreateEvent;
import org.picketlink.idm.PartitionManager;
import org.picketlink.idm.config.IdentityConfigurationBuilder;
import org.picketlink.idm.internal.DefaultPartitionManager;
import org.picketlink.idm.model.Partition;
import org.picketlink.idm.model.basic.Realm;

@Stateless
public class PicketLinkConfiguration {


	public PartitionManager producePartitionManager(@Observes PartitionManagerCreateEvent event){
		IdentityConfigurationBuilder builder = new IdentityConfigurationBuilder();
		
		builder.named("jpa.config").stores().file().supportAllFeatures();
		
		PartitionManager partitionManager = new DefaultPartitionManager(builder.build());
		Partition defaultPartition = new Realm(Realm.DEFAULT_REALM);
		partitionManager.add(defaultPartition);
		return partitionManager;
	}
}
