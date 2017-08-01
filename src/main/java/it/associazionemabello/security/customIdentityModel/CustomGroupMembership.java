package it.associazionemabello.security.customIdentityModel;

import org.picketlink.idm.model.AbstractAttributedType;
import org.picketlink.idm.model.Account;
import org.picketlink.idm.model.Relationship;

public class CustomGroupMembership extends AbstractAttributedType implements Relationship{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Account member;
	private CustomGroup group;
	
	public Account getMember() {
		return member;
	}
	public void setMember(Account member) {
		this.member = member;
	}
	public CustomGroup getGroup() {
		return group;
	}
	public void setGroup(CustomGroup group) {
		this.group = group;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
