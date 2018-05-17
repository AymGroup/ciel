package models;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Vehicule {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_VEHICULE")
	private Long id;
	@Column(nullable=false,length=25)
	private String marque;
	@Column(nullable=false)
	private int puissanceFiscale;
	@Column(nullable=false)
	@Temporal(TemporalType.DATE)
	private Date dateAchat;
	@Column(nullable=false,length=25)
	private String immatriculation;
	@Column(nullable=false)
	private String description;
	private double kilometrage;
	private boolean airConditioner;
	@Column(nullable=false,length=15)
	private String typeTransmission;
	@Column(nullable=false,length=15)
	private String carburant;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="ID_ADDRESS_VEHICULE")
	private AddressVehicule addressVehicule;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="ID")
	private Proprietaire Proprietaire;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="ID_CATEGORIE")
	private Categorie categorie;
	
	
	public Vehicule() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMarque() {
		return marque;
	}
	public void setMarque(String marque) {
		this.marque = marque;
	}
	public int getPuissanceFiscale() {
		return puissanceFiscale;
	}
	public void setPuissanceFiscale(int puissanceFiscale) {
		this.puissanceFiscale = puissanceFiscale;
	}
	public Date getDateAchat() {
		return dateAchat;
	}
	public void setDateAchat(Date dateAchat) {
		this.dateAchat = dateAchat;
	}
	public String getImmatriculation() {
		return immatriculation;
	}
	public void setImmatriculation(String immatriculation) {
		this.immatriculation = immatriculation;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getKilometrage() {
		return kilometrage;
	}
	public void setKilometrage(double kilometrage) {
		this.kilometrage = kilometrage;
	}
	public boolean isAirConditioner() {
		return airConditioner;
	}
	public void setAirConditioner(boolean airConditioner) {
		this.airConditioner = airConditioner;
	}
	public String getCarburant() {
		return carburant;
	}
	public void setCarburant(String carburant) {
		this.carburant = carburant;
	}
	public String getTypeTransmission() {
		return typeTransmission;
	}
	public void setTypeTransmission(String typeTransmission) {
		this.typeTransmission = typeTransmission;
	}
	public AddressVehicule getAddressVehicule() {
		return addressVehicule;
	}
	public void setAddressVehicule(AddressVehicule addressVehicule) {
		this.addressVehicule = addressVehicule;
	}
	public Proprietaire getProprietaire() {
		return Proprietaire;
	}
	public void setProprietaire(Proprietaire proprietaire) {
		Proprietaire = proprietaire;
	}
	public Categorie getCategorie() {
		return categorie;
	}
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	public Vehicule(String marque, int puissanceFiscale, Date dateAchat, String immatriculation, String description,
			double kilometrage, boolean airConditioner, String typeTransmission, String carburant) {
		super();
		this.marque = marque;
		this.puissanceFiscale = puissanceFiscale;
		this.dateAchat = dateAchat;
		this.immatriculation = immatriculation;
		this.description = description;
		this.kilometrage = kilometrage;
		this.airConditioner = airConditioner;
		this.typeTransmission = typeTransmission;
		this.carburant = carburant;
	}
	
	
}
