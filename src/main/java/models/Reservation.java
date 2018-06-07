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
	
	@ManyToOne
	@JoinColumn(name="ID")
	private Client client;
	
	//@OneToMany
	//@JoinColumn(name="ID_OPTION_RESERVATION")
	//private Set<OptionReservation> optionReservation;
	
	//@OneToMany
	//@JoinColumn(name="ID_LIGNE_RESERVATION")
	//private Set<LigneReservation> ligneReservation;
	
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
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	/*public Set<OptionReservation> getOptionReservation() {
		return optionReservation;
	}
	public void setOptionReservation(Set<OptionReservation> optionReservation) {
		this.optionReservation = optionReservation;
	}*/
	/*public Set<LigneReservation> getLigneReservation() {
		return ligneReservation;
	}
	public void setLigneReservation(Set<LigneReservation> ligneReservation) {
		this.ligneReservation = ligneReservation;
	}*/
	public Pack getPack() {
		return pack;
	}
	public void setPack(Pack pack) {
		this.pack = pack;
	}
}
