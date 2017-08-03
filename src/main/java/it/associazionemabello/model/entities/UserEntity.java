package it.associazionemabello.model.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import it.associazionemabello.model.Role;

@Entity
@NamedQueries ({
		@NamedQuery(
				name = "User.find",
				query= "SELECT u FROM UserEntity u WHERE u.username= :username AND u.password = :password"),
		@NamedQuery(
				name = "User.list",
				query= "SELECT u FROM UserEntity u")
})
@Table(name ="mabello_authentication_users")
public class UserEntity implements Serializable{

	private static final long serialVersionUID = 1L;

	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name ="users_id")
	private Long  id;
	
	@NotNull
	@Column (name ="users_username", unique = true)
	private String username;
	

	@Column(name ="users_password")
	private String password;
	

	@Column(name ="users_createdTime")
	private Date createdTime;
	

	@Column(name ="users_expirationDate")
	private Date expirationDate;

	@ElementCollection (targetClass =Role.class, fetch = FetchType.EAGER)
	@Enumerated(EnumType.STRING)
	@CollectionTable(name="mabello_authentication_roles", joinColumns= {@JoinColumn ( name ="roles_id")})
	private List <Role> roles;
	
	
	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}



	public Date getCreatedTime() {
		return createdTime;
	}


	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}


	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}
}
