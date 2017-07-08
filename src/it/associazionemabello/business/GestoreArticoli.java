package it.associazionemabello.business;

import java.util.Calendar;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import it.associazionemabello.services.ArticoloEntity;
import it.associazionemabello.services.ServiceDao;

@Named
@RequestScoped
public class GestoreArticoli {

	@Inject
	ServiceDao dao;
	
	private List<ArticoloEntity> listaArticoli;
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
	public List<ArticoloEntity> getArticoli(){
		if(this.listaArticoli==null){
			this.listaArticoli=dao.getArticoliListDesc();
		}
		return this.listaArticoli;
	}
	public void setArticoli(List <ArticoloEntity> lista){
		this.listaArticoli=lista;
		
	}
	
	
}
