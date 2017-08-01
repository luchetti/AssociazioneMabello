package it.associazionemabello.security.customIdentityModel;

import org.picketlink.idm.model.AbstractIdentityType;
import org.picketlink.idm.model.annotation.AttributeProperty;
import org.picketlink.idm.model.annotation.Unique;

public class CustomGroup extends AbstractIdentityType {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static final String PATH_SEPARATOR = "/";
	
	private String name;
	private CustomGroup parentGroup;
	private String path;
	
	@AttributeProperty
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name=name;
	}

	@Unique
	@AttributeProperty
	public String getPath() {
		this.path=buildPath(this);
		return this.path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
	@AttributeProperty
	public CustomGroup getParentGroup(){
		return this.parentGroup;
	}
	
	public void setParentGroup(CustomGroup group) {
		this.parentGroup=group;
	}
	
	private String buildPath(CustomGroup group) {
		String name = PATH_SEPARATOR + group.getName();
		
		if(group.getParentGroup() != null) {
			name=buildPath(group.getParentGroup()) + name;
		}
		
		return name;
		
	}

}
