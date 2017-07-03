package it.associazionemabello.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "mabello_articoli")
public class ArticoloEntity {

	@Id
	@Column(name="articoli_id")
	int id;
	
	@NotNull
	@Column(name="articoli_titolo")
	String title;
	
	@NotNull
	@Column(name="articoli_contenuto")
	String content;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="articoli_creationTime")
	Date creationTime;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="articoli_lastEditTime")
	Date lastEditTime;
	
	@Override
	public String toString(){
		return "[Id, "+this.id+"; Titolo, "+this.title+"; Contenuto, "+this.content+"; Data Creazione, "+this.creationTime+"; "+this.lastEditTime+"]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}

	public Date getLastEditTime() {
		return lastEditTime;
	}

	public void setLastEditTime(Date lastEditTime) {
		this.lastEditTime = lastEditTime;
	}
}
