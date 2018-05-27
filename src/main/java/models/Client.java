package models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

@Entity
public class Client extends Person {

	@Column(nullable=false,unique=true)
	private String numPermis;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="ID_ADDRESS")
	private Address address;
	
	@Transient
	private MultipartFile userImage;

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
	public MultipartFile getUserImage() {
		return userImage;
	}
	public void setUserImage(MultipartFile userImage) {
		this.userImage = userImage;
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
