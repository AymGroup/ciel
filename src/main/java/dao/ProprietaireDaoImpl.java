package dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import hibernate.utils.HibernateAnnotationUtil;
import models.Proprietaire;

public class ProprietaireDaoImpl implements IDao<Proprietaire> {
	
	public Proprietaire save(Proprietaire p) {
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

	public List<Proprietaire> selectAll() {
		Session s=HibernateAnnotationUtil.getSessionFactory().openSession();
		Criteria cr = s.createCriteria(Proprietaire.class);
		List<Proprietaire> results = cr.list();

		return results;
	}

	@Override
	public Proprietaire update(Proprietaire p) {
		Boolean rep=false;
		
		Session s=HibernateAnnotationUtil.getSessionFactory().openSession();
		Transaction tx=null;
		try {
			tx=s.beginTransaction();
			s.saveOrUpdate(p);
			tx.commit();
			rep=true;
		}catch(Exception e) {
			if (tx!=null) tx.rollback();
			   e.printStackTrace(); 
			rep=false;
		}finally {
			s.close();
		}
		
		if(rep)return p;
			else return null;
	}

	@Override
	public List<Proprietaire> selectAll(String sortField, String sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Proprietaire getById(Long id) {
		Session s=HibernateAnnotationUtil.getSessionFactory().openSession();

		Criteria cr = s.createCriteria(Proprietaire.class); 
		cr.add(Restrictions.eq("id",new Long(id)));
		Proprietaire proprietaire=(Proprietaire) cr.uniqueResult();
		
		if(proprietaire!=null){
			return proprietaire;
		}else
			return null;
	}

	@Override
	public void remove(Long id) {
		Session s=HibernateAnnotationUtil.getSessionFactory().openSession();
		
		Transaction tx=null;
		try{
			tx=s.beginTransaction();
			Criteria cr = s.createCriteria(Proprietaire.class); 
			cr.add(Restrictions.eq("id",new Long(id)));
			Proprietaire proprietaire=(Proprietaire) cr.uniqueResult();
			s.delete(proprietaire);
			tx.commit();
			
		}catch(Exception ex){
			if (tx!=null) tx.rollback();
			ex.printStackTrace();
			
		}finally{
			s.close();
		}
		
	}

	@Override
	public Proprietaire findOne(String paramName, Object paramValue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int findCountBy(String paramName, String paramValue) {
		// TODO Auto-generated method stub
		return 0;
	}

}
