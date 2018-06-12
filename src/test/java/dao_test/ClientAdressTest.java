package dao_test;

import java.util.List;

import dao.AddressDaoImpl;
import dao.ClientDaoImpl;
import dao.IDao;
import models.Address;
import models.Client;

public class ClientAdressTest {

	public static void main(String[] args) {
		
		IDao<Client> daoClt=new ClientDaoImpl();
		IDao<Address> daoAdr=new AddressDaoImpl();
		
		Client c1=new Client("Aymen", "Mankari", "0680127349", "Monsieur", "RFC56452987L","aymen@gmail.com");
		Address adr=new Address("Rue01","Casablanca","Maarif",20600);
		
		//daoClt.save(c1);
		//daoClt.save(c1);
		
		//Client clt=daoClt.getById(new Long(1));
		//daoClt.remove(new Long(1));
		//System.out.println(clt.toString());
		
		/*Address adr=new Address("Rue01","Casablanca","Maarif",20600);
		
		daoAdr.save(adr);
		c1.setAddress(adr);
		daoClt.save(c1);*/
		
		//List<Client> list= daoClt.selectAll();
		//list.forEach(c->System.out.println(c.toString()));
		
		List<Client> cltByCity=daoClt.selectAll("feat","casablanca");
		
		cltByCity.forEach(c->System.out.println(c.getAddress().getCity()));
		
		
		
	}
}
