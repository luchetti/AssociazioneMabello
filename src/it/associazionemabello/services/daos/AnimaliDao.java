package it.associazionemabello.services.daos;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

import it.associazionemabello.entities.AnimaleEntity;

@Named
@RequestScoped
public class AnimaliDao {

	@PersistenceContext(name="mabelloMysql")
	EntityManager em;
	
	@Inject
	UserTransaction ut;
	
	public List<AnimaleEntity> retrieveAnimaliList(String order){
		return em.createQuery("Select a from AnimaleEntity a ORDER BY a.name "+order, AnimaleEntity.class).getResultList();
	}
	
	public boolean insertNewAnimal(AnimaleEntity animale){
		try{
			ut.begin();
			em.persist(animale);
			ut.commit();
			return true;
		}
		catch(Exception ex){
			ex.printStackTrace();
			return false;
		}
	}
}
