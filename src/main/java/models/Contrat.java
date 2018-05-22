package models;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

@Entity
public class Contrat {

	@Id
	@GeneratedValue
	@Column(name="ID_CONTRAT")
	private Long id;
	//@Column(insertable = false, updatable = false)
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateDebut; 
	private String dateFin;
	
	private String reglement;
	private String description;
	private double tarif;
	
	@ManyToOne
	@JoinColumn(name="ID")
	private Proprietaire proprietaire;
	
	public Contrat() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Proprietaire getProprietaire() {
		return proprietaire;
	}
	public void setProprietaire(Proprietaire proprietaire) {
		this.proprietaire = proprietaire;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getDateDebut() {
		return dateDebut;
	}
	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}
	public String getDateFin() {
		return dateFin;
	}
	public void setDateFin(String dateFin) {
		this.dateFin = dateFin;
	}
	public String getReglement() {
		return reglement;
	}
	public void setReglement(String reglement) {
		this.reglement = reglement;
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

	public Contrat(String dateFin) {
		super();
		this.dateFin = dateFin;
	}

	
	
	
	
	

}
