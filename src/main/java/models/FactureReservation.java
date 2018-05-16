package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class FactureReservation {

	@Id
	@GeneratedValue
	@Column(name="ID_FACTURE")
	private Long id;
	private double prixTotal;
	
	@OneToOne
	@JoinColumn(name="ID_RESERVATION")
	private Reservation reservation;

	public FactureReservation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getPrixTotal() {
		return prixTotal;
	}

	public void setPrixTotal(double prixTotal) {
		this.prixTotal = prixTotal;
	}

	public Reservation getReservation() {
		return reservation;
	}

	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}

	public FactureReservation(double prixTotal, Reservation reservation) {
		super();
		this.prixTotal = prixTotal;
		this.reservation = reservation;
	}
	
}
