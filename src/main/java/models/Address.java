package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Address {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ID_ADDRESS")
	private Long id;
	@Column(nullable=false,length=100)
	private String street;
	@Column(nullable=false,length=15)
	private String city;
	@Column(nullable=true,length=15)
	private String state;
	@Column(nullable=true,length=10)
	private int postCode;

	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getPostCode() {
		return postCode;
	}

	public void setPostCode(int postCode) {
		this.postCode = postCode;
	}

	public Address(Long id, String street, String city, String state, int postCode) {
		super();
		this.id = id;
		this.street = street;
		this.city = city;
		this.state = state;
		this.postCode = postCode;
	}

	public Address(String street, String city, String state, int postCode) {
		super();
		this.street = street;
		this.city = city;
		this.state = state;
		this.postCode = postCode;
	}
		
}
