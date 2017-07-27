package it.associazionemabello.security.customIdentityModel;

import org.picketlink.idm.model.AbstractPartition;
import org.picketlink.idm.model.annotation.AttributeProperty;
import org.picketlink.idm.model.annotation.IdentityPartition;
import org.picketlink.idm.model.basic.*;

@IdentityPartition(supportedTypes = {Application.class, User.class, Role.class, Group.class})

public class Realm extends AbstractPartition{

	private static final long serialVersionUID = 1L;

	@AttributeProperty
	private boolean enforceSSL;
	
	@AttributeProperty
	private int numberFailedLoginAttempts;
	
	@AttributeProperty
	private byte[] publicKey;
	
	@AttributeProperty
	private byte[] privateKey;
	
	private Realm(){
		this(null);
	}
	public Realm(String name){
		super(name);
	}
}
