package it.associazionemabello.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table (name="mabello_animali")
public class AnimaleEntity {

	@Id
	@Column(name="animali_id")
	int id;
	
	@NotNull
	@Column(name="animali_name")
	String name;
	
	@NotNull
	@Column(name="animali_description")
	String description;
	
	@NotNull
	@Lob
	@Column(name="animali_cover")
	byte[] coverImage;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public byte[] getCoverImage() {
		return coverImage;
	}

	public void setCoverImage(byte[] coverImage) {
		this.coverImage = coverImage;
	}
	
	
}
