package dao_test;


import java.util.Date;

import dao.IDao;
import dao.VehiculeDaoImpl;
import models.Proprietaire;
import models.Vehicule;

public class Vehicule_Categorie_Test {

	public static void main(String[] args) {
		IDao<Vehicule> daoV=new VehiculeDaoImpl();
		Date now = new Date();
		Proprietaire p1=new Proprietaire("Aly","Aymen","06453212","Mr");
		p1.setAssuranceAdherer("ECA");
		Vehicule v =new Vehicule("Porshe",30,now,"FDFSQ23","description",34,true,"manuelle","essence");
		v.setProprietaire(p1);
		daoV.save(v);
		
	}

}
