package models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class CertificatVisite {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ID_CERTIFICAT")
	private Long id;
	@Column(nullable=false,length=15)
	private Date delivreLe;
	@Column(nullable=false,length=15)
	private Date dateExpiration;
	
	@ManyToOne
	@JoinColumn(name="ID_VEHICULE")
	private Vehicule vehicule;
	
	public CertificatVisite() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getDelivreLe() {
		return delivreLe;
	}
	public void setDelivreLe(Date delivreLe) {
		this.delivreLe = delivreLe;
	}
	public Date getDateExpiration() {
		return dateExpiration;
	}
	public void setDateExpiration(Date dateExpiration) {
		this.dateExpiration = dateExpiration;
	}
	public Vehicule getVehicule() {
		return vehicule;
	}
	public void setVehicule(Vehicule vehicule) {
		this.vehicule = vehicule;
	}
	public CertificatVisite(Date delivreLe, Date dateExpiration) {
		super();
		this.delivreLe = delivreLe;
		this.dateExpiration = dateExpiration;
	}
	
	
}
