package it.associazionemabello.services.daos;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import it.associazionemabello.model.entities.ArticoloEntity;

@Named
@Stateless
public class ArticoliDao {

	@PersistenceContext(name="mabelloMysql")
	EntityManager em;
	
	public List<ArticoloEntity> retrieveArticlesList(String order){
		
		return em.createQuery("select a from ArticoloEntity a ORDER BY a.creationTime "+order, ArticoloEntity.class).getResultList();
	
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
