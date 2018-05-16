package models;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;


@Entity
public class Proprietaire extends Person {

	@Column(length=25,nullable=false)
	private String assuranceAdherer;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="ID_ADDRESS")
	private Address address;

	public Proprietaire() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getAssuranceAdherer() {
		return assuranceAdherer;
	}

	public void setAssuranceAdherer(String assuranceAdherer) {
		this.assuranceAdherer = assuranceAdherer;
	}
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	public Proprietaire(String nom, String prenom, String telephone, String civilite,String email) {
		super(nom, prenom, telephone, civilite,email);
	}
	
}
