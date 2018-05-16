package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import hibernate.utils.HibernateAnnotationUtil;
import models.AddressVehicule;

public class AddressVehiculeDaoImpl implements IDao<AddressVehicule> {

	public boolean save(AddressVehicule adrV) {
		boolean rep=false;
		Session s=HibernateAnnotationUtil.getSessionFactory().openSession();
		Transaction tx=null;
		try {
			tx=s.beginTransaction();
			s.save(adrV);
			tx.commit();
			rep=true;
		}catch(Exception e) {
			if (tx!=null) tx.rollback();
			   e.printStackTrace(); 
			rep= false;
		}finally {
			s.close();
		}
		
		return rep;
	}

	public List<AddressVehicule> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AddressVehicule update(AddressVehicule o) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AddressVehicule> selectAll(String sortField, String sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AddressVehicule getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public AddressVehicule findOne(String paramName, Object paramValue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int findCountBy(String paramName, String paramValue) {
		// TODO Auto-generated method stub
		return 0;
	}

}
