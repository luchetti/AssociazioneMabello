package it.associazionemabello.services.daos;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import it.associazionemabello.model.entities.AnimaleEntity;

@Stateless
@Named
public class AnimaliDao {

	@PersistenceContext(name="mabelloMysql")
	EntityManager em;
	
	public List<AnimaleEntity> retrieveAnimaliList(String order){
		return em.createQuery("Select a from AnimaleEntity a ORDER BY a.name "+order, AnimaleEntity.class).getResultList();
	}
	
	public boolean insertNewAnimal(AnimaleEntity animale){
		try{
			em.persist(animale);
			return true;
		}
		catch(Exception ex){
			ex.printStackTrace();
			return false;
		}
	}
}
