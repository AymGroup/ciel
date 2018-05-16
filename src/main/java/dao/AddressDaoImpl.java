package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import hibernate.utils.HibernateAnnotationUtil;
import models.Address;

public class AddressDaoImpl implements IDao<Address> {
	
	public boolean save(Address adr) {
		boolean rep=false;
		Session s=HibernateAnnotationUtil.getSessionFactory().openSession();
		Transaction tx=null;
		try {
			tx=s.beginTransaction();
			s.save(adr);
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

	public List<Address> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Address update(Address o) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Address> selectAll(String sortField, String sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Address getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Address findOne(String paramName, Object paramValue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int findCountBy(String paramName, String paramValue) {
		// TODO Auto-generated method stub
		return 0;
	}

}
