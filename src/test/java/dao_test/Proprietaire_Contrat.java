package dao_test;

import java.util.Date;

import dao.ContratDaoImpl;
import dao.IDao;
import models.Contrat;
import models.Proprietaire;

public class Proprietaire_Contrat {

	public static void main(String[] args) {
		
		IDao<Contrat> daoContrat=new ContratDaoImpl();
		
		Proprietaire p=new Proprietaire("Aymen","Mankari","0654781","Monsieurs","aymen@gmail.com","Zenith");
		Contrat c=new Contrat(new Date());
		
		c.setProprietaire(p);
		
		daoContrat.save(c);
		
		
	}
}
