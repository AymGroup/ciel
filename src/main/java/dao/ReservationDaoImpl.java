package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import hibernate.utils.HibernateAnnotationUtil;
import models.Reservation;

public class ReservationDaoImpl implements IDao<Reservation> {

	public boolean save(Reservation r) {
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
		
		return rep;
	}

	public List<Reservation> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
