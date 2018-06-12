package dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import hibernate.utils.HibernateAnnotationUtil;
import models.LigneReservation;

public class LigneReservationDaoImpl implements IDao<LigneReservation> {

	
	@Override
	public LigneReservation save(LigneReservation l) {
		boolean rep=false;

		Session s=HibernateAnnotationUtil.getSessionFactory().openSession();
		Transaction tx=null;
		try {
			tx=s.beginTransaction();
			s.save(l);
			tx.commit();
			rep=true;
		}catch(Exception e) {
			if (tx!=null) tx.rollback();
			   e.printStackTrace(); 
			rep= false;
		}finally {
			s.close();
		}
		
		if(rep)return l;
		else return null;
	}

	@Override
	public List<LigneReservation> selectAll() {
		Session s=HibernateAnnotationUtil.getSessionFactory().openSession();
		Criteria cr = s.createCriteria(LigneReservation.class);
		List<LigneReservation> results = cr.list();

		return results;
	}

	@Override
	public LigneReservation update(LigneReservation l) {
		Boolean rep=false;
		
		Session s=HibernateAnnotationUtil.getSessionFactory().openSession();
		Transaction tx=null;
		try {
			tx=s.beginTransaction();
			s.saveOrUpdate(l);
			tx.commit();
			rep=true;
		}catch(Exception e) {
			if (tx!=null) tx.rollback();
			   e.printStackTrace(); 
			rep=false;
		}finally {
			s.close();
		}
		
		if(rep)return l;
			else return null;
	}

	@Override
	public List<LigneReservation> selectAll(String sortField, String sort) {
		Session s=HibernateAnnotationUtil.getSessionFactory().openSession();

		Criteria cr = s.createCriteria(LigneReservation.class); 
		cr.add(Restrictions.eq("reservation.id",Long.parseLong(sort)));
		List<LigneReservation> results = cr.list();
		
		return results;
	}

	@Override
	public LigneReservation getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public LigneReservation findOne(String paramName, Object paramValue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int findCountBy(String paramName, String paramValue) {
		// TODO Auto-generated method stub
		return 0;
	}

}
