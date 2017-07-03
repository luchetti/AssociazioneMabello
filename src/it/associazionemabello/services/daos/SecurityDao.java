package it.associazionemabello.services.daos;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.UserTransaction;

import it.associazionemabello.entities.ArticoloEntity;
import it.associazionemabello.entities.UserEntity;

@Named
@RequestScoped
public class SecurityDao {

	@PersistenceContext(name="mabelloMysql")
	EntityManager em;
	
	@Inject
	UserTransaction ut;
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
			ut.begin();
			em.persist(articolo);
			ut.commit();
			return true;
		}
		catch(Exception ex){
			ex.printStackTrace();
			return false;
		}
	}
	
	public boolean deleteArticicle(int id){
		try{
			ut.begin();
			em.remove(em.find(ArticoloEntity.class, id));
			ut.commit();
			return true;
		}
		catch(Exception ex){
			ex.printStackTrace();
			return false;
		}
	}
	
}
