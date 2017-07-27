package it.associazionemabello.business;

import java.util.Calendar;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import it.associazionemabello.entities.ArticoloEntity;
import it.associazionemabello.services.ServiceDao;


@Named
@RequestScoped
public class GestoreArticoli {

	@Inject
	ServiceDao dao;
	
	private String titolo;
	private String contenuto;
	
	public void createNewArticle(){
		ArticoloEntity articolo=new ArticoloEntity();
		
		articolo.setTitle(titolo);
		articolo.setContent(contenuto);
		articolo.setCreationTime(Calendar.getInstance().getTime());
		articolo.setLastEditTime(Calendar.getInstance().getTime());
		
		dao.saveArticle(articolo);
		
	}
	
	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	public String getContenuto() {
		return contenuto;
	}
	public void setContenuto(String contenuto) {
		this.contenuto = contenuto;
	}	
}
