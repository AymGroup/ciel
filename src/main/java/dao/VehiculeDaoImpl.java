package dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import hibernate.utils.HibernateAnnotationUtil;
import models.Vehicule;

public class VehiculeDaoImpl implements IDao<Vehicule> {

	public Vehicule save(Vehicule v) {
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
		
		if(rep)return v;
		else return null;
	}

	public List<Vehicule> selectAll() {
		Session s=HibernateAnnotationUtil.getSessionFactory().openSession();
		Criteria cr = s.createCriteria(Vehicule.class);
		List<Vehicule> results = cr.list();

		return results;
	}

	@Override
	public Vehicule update(Vehicule o) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Vehicule> selectAll(String sortField, String idProprietaire) {
		Session s=HibernateAnnotationUtil.getSessionFactory().openSession();

		Criteria cr = s.createCriteria(Vehicule.class); 
		cr.add(Restrictions.eq("proprietaire.id",Long.parseLong(idProprietaire)));
		List<Vehicule> results = cr.list();
		
		return results;
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
