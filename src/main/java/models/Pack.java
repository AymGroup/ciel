package models;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Pack {

	@Id
	@GeneratedValue
	@Column(name="ID_PACK")
	private Long id;
	private String libelle;
	private String description;
	private double tarif;
	
	public Pack() {
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
	public double getTarif() {
		return tarif;
	}
	public void setTarif(double tarif) {
		this.tarif = tarif;
	}
	public Pack(String libelle, String description,double tarif) {
		super();
		this.libelle = libelle;
		this.description = description;
		this.tarif=tarif;
	}
	
	
	
}
