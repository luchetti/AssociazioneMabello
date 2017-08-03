package it.associazionemabello.business;


import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.Part;

import org.apache.commons.io.IOUtils;
import org.omnifaces.util.Servlets;

import it.associazionemabello.model.entities.AnimaleEntity;
import it.associazionemabello.services.ServiceDao;


@Named
@RequestScoped

public class GestoreAnimali {

	@Inject
	ServiceDao dao;
	
	private String name;
	private String content;
	private Part imageAsPart;
	private byte[] imageAsByte;
	
	public void createNewAnimal(){
		if(imageAsPart!=null){
			String fileName = Servlets.getSubmittedFileName(imageAsPart);
			String type = imageAsPart.getContentType();
			long size = imageAsPart.getSize();
			
			try{
				imageAsByte=IOUtils.toByteArray(imageAsPart.getInputStream());
				
				AnimaleEntity animale = new AnimaleEntity();
				animale.setName(name);
				animale.setDescription(content);
				animale.setCoverImage(imageAsByte);
				
				dao.saveAnimal(animale);
			}
			catch(Exception ex){
				ex.printStackTrace();
				System.out.println("Errore nel caricamento dell'immagine");
			}
			System.out.println("Caricata immagine. Nome: "+fileName+", tipo: "+type+", dimensione: "+size);
		}
	}
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Part getImageAsPart() {
		return imageAsPart;
	}
	public void setImageAsPart(Part imageAsPart) {
		this.imageAsPart = imageAsPart;
	}
	public byte[] getImageAsByte() {
		return imageAsByte;
	}
	public void setImageAsByte(byte[] imageAsByte) {
		this.imageAsByte = imageAsByte;
	}	
}
