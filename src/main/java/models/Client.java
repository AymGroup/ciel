package models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Client extends Person {

	@Column(nullable=false,unique=true)
	private String numPermis;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="ID_ADDRESS")
	private Address address;
	
	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public String getNumPermis() {
		return numPermis;
	}

	public void setNumPermis(String numPermis) {
		this.numPermis = numPermis;
	}

	public Client(String nom, String prenom, String telephone, String civilite, String numPermis,String email) {
		super(nom, prenom, telephone, civilite,email);
		this.numPermis = numPermis;
	}

	@Override
	public String toString() {
		return "Client [numPermis=" + numPermis + ", address=" + address + ", getId()=" + getId() + ", getNom()="
				+ getNom() + ", getPrenom()=" + getPrenom() + ", getTelephone()=" + getTelephone() + ", getCivilite()="
				+ getCivilite() +"]";
	}

	

	 
}
