package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

@Entity
public class Categorie {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_CATEGORIE")
	private Long id;
	@Column(length=50)
	private String libelle;
	@Column(length=150)
	private String description;
	
	@Transient
	private MultipartFile categorieImage;
	
	public Categorie() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public MultipartFile getCategorieImage() {
		return categorieImage;
	}
	public void setCategorieImage(MultipartFile categorieImage) {
		this.categorieImage = categorieImage;
	}

	public Categorie(String libelle, String description) {
		super();
		this.libelle = libelle;
		this.description = description;
	}
	
	
}
