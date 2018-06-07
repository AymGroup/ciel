package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import hibernate.utils.HibernateAnnotationUtil;
import models.Pack;

public class PackDaoImpl implements IDao<Pack> {

	@Override
	public Pack save(Pack p) {
		boolean rep=false;

		Session s=HibernateAnnotationUtil.getSessionFactory().openSession();
		Transaction tx=null;
		try {
			tx=s.beginTransaction();
			s.save(p);
			tx.commit();
			rep=true;
		}catch(Exception e) {
			if (tx!=null) tx.rollback();
			   e.printStackTrace(); 
			rep= false;
		}finally {
			s.close();
		}
		
		if(rep)return p;
		else return null;
	}

	@Override
	public List<Pack> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pack update(Pack o) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Pack> selectAll(String sortField, String sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pack getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Pack findOne(String paramName, Object paramValue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int findCountBy(String paramName, String paramValue) {
		// TODO Auto-generated method stub
		return 0;
	}

}
