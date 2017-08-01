package it.associazionemabello.security.customIdentityModel;

import java.util.Date;

import org.picketlink.idm.model.AbstractAttributedType;
import org.picketlink.idm.model.IdentityType;
import org.picketlink.idm.model.Relationship;
import org.picketlink.idm.model.annotation.AttributeProperty;

public class CustomGrant extends AbstractAttributedType implements Relationship {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/*@AttributeProperty*/
	private IdentityType assignee;
	private CustomRole role;
	
	@AttributeProperty
	private Date grantDate;
	
	public IdentityType getAssignee(){
		return assignee;
	}
	
	public void setAssignee (IdentityType assignee) {
		this.assignee=assignee;
	}
	
	public CustomRole getRole(){
		return role;
	}
	
	public void setRole(CustomRole role){
		this.role=role;
	}

	public Date getGrantDate(){
		return grantDate;
	}
	
	public void setGrantDate(Date grantDate) {
		this.grantDate=grantDate;
	}
	
}
