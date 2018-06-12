package models;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;


@Entity
public class Reservation {

	@Id
	@GeneratedValue
	@Column(name="ID_RESERVATION")
	private Long id;
	@Column(nullable=false)
	//@Temporal(TemporalType.TIMESTAMP)
	private String dateResevation;
	
	@Column(nullable=false)
	private String dateFinResevation;
	
	private double tarifTotal;
	
	@ManyToOne
	@JoinColumn(name="ID")
	private Client client;
	
	@ManyToOne
	@JoinColumn(name="ID_PACK")
	private Pack pack;
	
	public Reservation() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Reservation(String dateResevation) {
		super();
		this.dateResevation = dateResevation;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDateResevation() {
		return dateResevation;
	}
	public void setDateResevation(String dateResevation) {
		this.dateResevation = dateResevation;
	}
	public String getDateFinResevation() {
		return dateFinResevation;
	}
	public void setDateFinResevation(String dateFinResevation) {
		this.dateFinResevation = dateFinResevation;
	}
	public double getTarifTotal() {
		return tarifTotal;
	}
	public void setTarifTotal(double tarifTotal) {
		this.tarifTotal = tarifTotal;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public Pack getPack() {
		return pack;
	}
	public void setPack(Pack pack) {
		this.pack = pack;
	}
}
