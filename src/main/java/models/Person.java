package models;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@MappedSuperclass
public class Person {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private Long id;
	@Column(nullable=false,length=25)
	//@Size(min=4,message="Un nom doit contenir au moins 6 charachtères")
	//@NotEmpty(message="Ce champ ne peut pas être null")
	private String nom;
	@Column(nullable=false,length=25)
	//@NotNull
	//@Pattern(regexp = "^[A-Za-z]+$",message="Votre prénom doit comporter que des caractères alphabétiques!")
	private String prenom;
	@Column(nullable=false,length=25)
	private String telephone;
	@Column(nullable=false,length=10)
	private String civilite;
	@Column(nullable=true)
	//@Email(message="Please provide a valid email address")
	private String email;
	
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getCivilite() {
		return civilite;
	}
	public void setCivilite(String civilite) {
		this.civilite = civilite;
	}
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public Person(Long id, String nom, String prenom, String telephone, String civilite) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.telephone = telephone;
		this.civilite = civilite;
	}
	public Person(String nom, String prenom, String telephone, String civilite,String email) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.telephone = telephone;
		this.civilite = civilite;
		this.email=email;
	}
	
	
}
