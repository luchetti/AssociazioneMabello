package it.associazionemabello.services.daos;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import it.associazionemabello.entities.ArticoloEntity;
import it.associazionemabello.entities.UserEntity;

@Named
@RequestScoped
public class SecurityDao {

	@PersistenceContext(name="mabelloMysql")
	EntityManager em;

	public UserEntity findUser(String username){
		try{
			TypedQuery<UserEntity> query = em.createQuery("select u from UserEntity u WHERE u.username = :username", UserEntity.class);
			return query.setParameter("username", username).getSingleResult();
		}catch(NoResultException ex){
			return null;
		}
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
