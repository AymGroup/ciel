package models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class LigneReservation {

	@Id
	@GeneratedValue
	@Column(name="ID_LIGNE_RESERVATION")
	private Long id;
	@Column(nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateDebut;
	@Column(nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateFin;
	
	@ManyToOne
	@JoinColumn(name="ID_VEHICULE")
	private Vehicule vehicule;
	
	public LigneReservation() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Vehicule getVehicule() {
		return vehicule;
	}
	public void setVehicule(Vehicule vehicule) {
		this.vehicule = vehicule;
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
	public Date getDateFin() {
		return dateFin;
	}
	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}
	public LigneReservation(Date dateDebut, Date dateFin) {
		super();
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
	}
	
}
