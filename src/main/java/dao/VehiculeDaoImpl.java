package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import hibernate.utils.HibernateAnnotationUtil;
import models.Vehicule;

public class VehiculeDaoImpl implements IDao<Vehicule> {

	public boolean save(Vehicule v) {
		boolean rep=false;
		Session s=HibernateAnnotationUtil.getSessionFactory().openSession();
		Transaction tx=null;
		try {
			tx=s.beginTransaction();
			s.save(v);
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

	public List<Vehicule> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vehicule update(Vehicule o) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Vehicule> selectAll(String sortField, String sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vehicule getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Vehicule findOne(String paramName, Object paramValue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int findCountBy(String paramName, String paramValue) {
		// TODO Auto-generated method stub
		return 0;
	}

}
