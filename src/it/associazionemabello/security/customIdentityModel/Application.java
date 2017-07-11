package it.associazionemabello.security.customIdentityModel;

import org.picketlink.idm.model.AbstractIdentityType;
import org.picketlink.idm.model.Partition;
import org.picketlink.idm.model.annotation.IdentityPartition;
import org.picketlink.idm.model.basic.Group;
import org.picketlink.idm.model.basic.Role;

@IdentityPartition(supportedTypes = {Role.class, Group.class})
public class Application extends AbstractIdentityType implements Partition{

}
