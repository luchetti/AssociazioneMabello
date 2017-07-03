package it.associazionemabello.services.daos;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

import it.associazionemabello.entities.ArticoloEntity;

@Named
@RequestScoped
public class ArticoliDao {

	@PersistenceContext(name="mabelloMysql")
	EntityManager em;
	
	@Inject
	UserTransaction ut;
	public List<ArticoloEntity> retrieveArticlesList(String order){
		
		return em.createQuery("select a from ArticoloEntity a ORDER BY a.creationTime "+order, ArticoloEntity.class).getResultList();
	
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
