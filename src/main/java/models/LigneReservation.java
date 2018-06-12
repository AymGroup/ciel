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

import org.hibernate.annotations.CreationTimestamp;

@Entity
public class LigneReservation {

	@Id
	@GeneratedValue
	@Column(name="ID_LIGNE_RESERVATION")
	private Long id;
	/*@Column(nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateDebut;
	@Column(nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateFin;*/
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastTouched;
	
	public Date getLastTouched() {
		return lastTouched;
	}
	public void setLastTouched(Date lastTouched) {
		this.lastTouched = lastTouched;
	}
	@ManyToOne
	@JoinColumn(name="ID_VEHICULE")
	private Vehicule vehicule;
	
	@ManyToOne
	@JoinColumn(name="ID_RESERVATION")
	private Reservation reservation;
	
	private double tarif;
	
	public double getTarif() {
		return tarif;
	}
	public void setTarif(double tarif) {
		this.tarif = tarif;
	}
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
	public Reservation getReservation() {
		return reservation;
	}
	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}
	
}
