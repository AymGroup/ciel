package dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import hibernate.utils.HibernateAnnotationUtil;
import models.Categorie;



public class CategorieDaoImpl implements IDao<Categorie> {

	public Categorie save(Categorie c) {
		boolean rep=false;

		Session s=HibernateAnnotationUtil.getSessionFactory().openSession();
		Transaction tx=null;
		try {
			tx=s.beginTransaction();
			s.save(c);
			tx.commit();
			rep=true;
		}catch(Exception e) {
			if (tx!=null) tx.rollback();
			   e.printStackTrace(); 
			rep= false;
		}finally {
			s.close();
		}
		
		if(rep)return c;
		else return null;
	}

	@Override
	public List<Categorie> selectAll() {
		Session s=HibernateAnnotationUtil.getSessionFactory().openSession();
		Criteria cr = s.createCriteria(Categorie.class);
		List<Categorie> results = cr.list();

		return results;
	}

	@Override
	public Categorie update(Categorie c) {
		Boolean rep=false;
		
		Session s=HibernateAnnotationUtil.getSessionFactory().openSession();
		Transaction tx=null;
		try {
			tx=s.beginTransaction();
			s.saveOrUpdate(c);
			tx.commit();
			rep=true;
		}catch(Exception e) {
			if (tx!=null) tx.rollback();
			   e.printStackTrace(); 
			rep=false;
		}finally {
			s.close();
		}
		
		if(rep)return c;
			else return null;
	}

	@Override
	public List<Categorie> selectAll(String sortField, String sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Categorie getById(Long id) {
		Session s=HibernateAnnotationUtil.getSessionFactory().openSession();

		Criteria cr = s.createCriteria(Categorie.class); 
		cr.add(Restrictions.eq("id",new Long(id)));
		Categorie categorie=(Categorie) cr.uniqueResult();
		
		if(categorie!=null){
			return categorie;
		}else
			return null;
	}

	@Override
	public void remove(Long id) {
		Session s=HibernateAnnotationUtil.getSessionFactory().openSession();
		
		Transaction tx=null;
		try{
			tx=s.beginTransaction();
			Criteria cr = s.createCriteria(Categorie.class); 
			cr.add(Restrictions.eq("id",new Long(id)));
			Categorie categorie=(Categorie) cr.uniqueResult();
			s.delete(categorie);
			tx.commit();
			
		}catch(Exception ex){
			if (tx!=null) tx.rollback();
			ex.printStackTrace();
			
		}finally{
			s.close();
		}
		
	}

	@Override
	public Categorie findOne(String paramName, Object paramValue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int findCountBy(String paramName, String paramValue) {
		// TODO Auto-generated method stub
		return 0;
	}

}
