package it.associazionemabello.services.daos;

import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import it.associazionemabello.model.entities.ArticoloEntity;
import it.associazionemabello.model.entities.UserEntity;


@Stateless
public class SecurityDao {

	@PersistenceContext(name="mabelloMysql")
	private EntityManager em;

	
	public UserEntity findUser(Long id){
		return em.find(UserEntity.class, id);
	}
	public UserEntity findUser(String username, String password){
		
		List<UserEntity> user = em.createNamedQuery("User.find", UserEntity.class)
				.setParameter("username", username)
				.setParameter("password", password)
				.getResultList();
		
		return user.isEmpty() ? null : user.get(0);

	}
	
	@Produces
	@Named ("userList")
	@RequestScoped
	public List<UserEntity> list(){
		return em.createNamedQuery("User.list", UserEntity.class).getResultList();
	}
	
	public Long newUser(UserEntity user){
		em.persist(user);
		return user.getId();
	}
	
	public void updateUser (UserEntity user){
		em.merge(user);
	}
	
	public void deleteUser(UserEntity user){
		em.remove(em.contains(user) ? user : em.merge(user));
	}
	
	
	
	
	public boolean insertNewArticicle(ArticoloEntity articolo){
		try{
			em.persist(articolo);
			return true;
		}
		catch(Exception ex){
			ex.printStackTrace();
			return false;
		}
	}
	
	public boolean deleteArticicle(int id){
		try{
			em.remove(em.find(ArticoloEntity.class, id));
			return true;
		}
		catch(Exception ex){
			ex.printStackTrace();
			return false;
		}
	}
	
}
