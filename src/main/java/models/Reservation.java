package models;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Reservation {

	@Id
	@GeneratedValue
	@Column(name="ID_RESERVATION")
	private Long id;
	@Column(nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateResevation;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn
	private Client client;
	
	@OneToMany
	@JoinColumn(name="ID_OPTION_RESERVATION")
	private Set<OptionReservation> optionReservation;
	
	public Reservation() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Reservation(Date dateResevation) {
		super();
		this.dateResevation = dateResevation;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getDateResevation() {
		return dateResevation;
	}
	public void setDateResevation(Date dateResevation) {
		this.dateResevation = dateResevation;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public Set<OptionReservation> getOptionReservation() {
		return optionReservation;
	}
	public void setOptionReservation(Set<OptionReservation> optionReservation) {
		this.optionReservation = optionReservation;
	}
}
