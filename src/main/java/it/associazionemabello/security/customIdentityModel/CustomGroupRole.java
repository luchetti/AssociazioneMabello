package it.associazionemabello.security.customIdentityModel;

import org.picketlink.idm.model.Relationship;

public class CustomGroupRole extends CustomGrant implements Relationship {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private CustomGroup group;

	public CustomGroup getGroup() {
		return group;
	}

	public void setGroup(CustomGroup group) {
		this.group = group;
	}
	
}
