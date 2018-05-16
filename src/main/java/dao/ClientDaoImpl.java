package dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import hibernate.utils.HibernateAnnotationUtil;
import models.Client;


public class ClientDaoImpl implements IDao<Client> {

	public boolean save(Client c) {
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
		
		return rep;
	}

	@Override
	public List<Client> selectAll() {
		Session s=HibernateAnnotationUtil.getSessionFactory().openSession();
		Criteria cr = s.createCriteria(Client.class);
		List<Client> results = cr.list();
		
		return results;
	}

	@Override
	public Client update(Client c) {
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
		
		if(!rep)return c;
			else return null;
	}

	@Override
	public List<Client> selectAll(String sortField, String sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Client getById(Long id) {
		Session s=HibernateAnnotationUtil.getSessionFactory().openSession();

		Criteria cr = s.createCriteria(Client.class); 
		cr.add(Restrictions.eq("id",new Long(id)));
		Client client=(Client) cr.uniqueResult();
		
		if(client!=null){
			return client;
		}else
			return null;
	}

	@Override
	public void remove(Long id) {
		Session s=HibernateAnnotationUtil.getSessionFactory().openSession();
		
		Transaction tx=null;
		try{
			tx=s.beginTransaction();
			Criteria cr = s.createCriteria(Client.class); 
			cr.add(Restrictions.eq("id",new Long(id)));
			Client client=(Client) cr.uniqueResult();
			s.delete(client);
			tx.commit();
			
		}catch(Exception ex){
			if (tx!=null) tx.rollback();
			ex.printStackTrace();
			
		}finally{
			s.close();
		}
		
		
	}

	@Override
	public Client findOne(String paramName, Object paramValue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int findCountBy(String paramName, String paramValue) {
		// TODO Auto-generated method stub
		return 0;
	}

	
}
