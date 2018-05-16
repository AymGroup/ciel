package dao_test;

import java.util.HashSet;
import java.util.Set;

import dao.ProprietaireDaoImpl;
import dao.IDao;
import models.Address;
import models.Proprietaire;

public class Proprietaire_Adress_Test {

	public static void main(String[] args) {
		
		IDao<Proprietaire> daoPro=new ProprietaireDaoImpl();
		
		Set<Address> address=new HashSet<Address>();
		
		address.add(new Address("Rue 01", "Manassas", "Virginia", 34521));
		
		/*Proprietaire p1=new Proprietaire("Aly","Aymen","06453212","Mr",address);
		
		daoPro.save(p1);*/
	}
}
