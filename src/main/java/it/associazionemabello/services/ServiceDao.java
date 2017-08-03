package it.associazionemabello.services;

import javax.ejb.Stateless;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import it.associazionemabello.model.entities.AnimaleEntity;
import it.associazionemabello.model.entities.ArticoloEntity;
import it.associazionemabello.services.daos.AnimaliDao;
import it.associazionemabello.services.daos.ArticoliDao;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

@Stateless
@Named
public class ServiceDao implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	ArticoliDao articoli;
	
	@Inject
	AnimaliDao animali;
	
	@Inject
	CurrentUser login;
	
	public void doLogin(){
		login.login();
	}
	public List<ArticoloEntity> getArticoliListDesc(){
		return articoli.retrieveArticlesList("desc");
	}
	public void saveArticle(ArticoloEntity articolo){
		if(articoli.insertNewArticicle(articolo)){
			try {
				FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml?faces-redirect=true");
				System.out.println("Salvataggio articolo corretto");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		else{
			System.out.println("Errore nel salvataggio articolo");
		}
	}
	public void deleteArticle(int id){
		if(articoli.deleteArticicle(id)){
			try {
				FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml?faces-redirect=true");
				System.out.println("Eliminazione articolo corretto");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		else{
			System.out.println("Errore nell'eliminazione articolo");
		}
	}
	public List<AnimaleEntity> getAnimaliListAsc(){
		return animali.retrieveAnimaliList("asc");
		
	}
	
	public void saveAnimal(AnimaleEntity animale){
		if(animali.insertNewAnimal(animale)){
			try {
				FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml?faces-redirect=true");
				System.out.println("Salvataggio animale corretto");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		else{
			System.out.println("Errore nel salvataggio animale");
		}
	}
}
