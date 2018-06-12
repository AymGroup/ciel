package dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import hibernate.utils.HibernateAnnotationUtil;
import models.Categorie;
import models.Reservation;

public class ReservationDaoImpl implements IDao<Reservation> {

	public Reservation save(Reservation r) {
		boolean rep=false;
		Session s=HibernateAnnotationUtil.getSessionFactory().openSession();
		Transaction tx=null;
		try {
			tx=s.beginTransaction();
			s.save(r);
			tx.commit();
			rep=true;
		}catch(Exception e) {
			if (tx!=null) tx.rollback();
			   e.printStackTrace(); 
			rep= false;
		}finally {
			s.close();
		}
		
		if(rep)return r;
		else return null;
	}

	public List<Reservation> selectAll() {
		Session s=HibernateAnnotationUtil.getSessionFactory().openSession();
		Criteria cr = s.createCriteria(Reservation.class);
		List<Reservation> results = cr.list();
		
		return results;
	}

	@Override
	public Reservation update(Reservation r) {
		Boolean rep=false;
		
		Session s=HibernateAnnotationUtil.getSessionFactory().openSession();
		Transaction tx=null;
		try {
			tx=s.beginTransaction();
			s.saveOrUpdate(r);
			tx.commit();
			rep=true;
		}catch(Exception e) {
			if (tx!=null) tx.rollback();
			   e.printStackTrace(); 
			rep=false;
		}finally {
			s.close();
		}
		
		if(rep)return r;
			else return null;
	}

	@Override
	public List<Reservation> selectAll(String sortField, String sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reservation getById(Long id) {
		Session s=HibernateAnnotationUtil.getSessionFactory().openSession();

		Criteria cr = s.createCriteria(Reservation.class); 
		cr.add(Restrictions.eq("id",new Long(id)));
		Reservation reservation=(Reservation) cr.uniqueResult();
		
		if(reservation!=null){
			return reservation;
		}else
			return null;
	}

	@Override
	public void remove(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Reservation findOne(String paramName, Object paramValue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int findCountBy(String paramName, String paramValue) {
		// TODO Auto-generated method stub
		return 0;
	}

}
