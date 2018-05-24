package dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import hibernate.utils.HibernateAnnotationUtil;
import models.Contrat;
import models.Proprietaire;

public class ContratDaoImpl implements IDao<Contrat> {

	@Override
	public boolean save(Contrat contrat) {
		boolean rep=false;
		Session s=HibernateAnnotationUtil.getSessionFactory().openSession();
		Transaction tx=null;
		try {
			tx=s.beginTransaction();
			s.saveOrUpdate(contrat);
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
	public List<Contrat> selectAll() {
		Session s=HibernateAnnotationUtil.getSessionFactory().openSession();
		Criteria cr = s.createCriteria(Contrat.class);
		List<Contrat> results = cr.list();
		
		return results;
	}

	@Override
	public Contrat update(Contrat c) {
		Boolean rep=false;
		
		Session s=HibernateAnnotationUtil.getSessionFactory().openSession();
		Transaction tx=null;
		try {
			tx=s.beginTransaction();
			s.saveOrUpdate(c);
			//s.update(c);
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
	public List<Contrat> selectAll(String sortField, String idProprietaire) {
		Session s=HibernateAnnotationUtil.getSessionFactory().openSession();

		Criteria cr = s.createCriteria(Contrat.class); 
		cr.add(Restrictions.eq("proprietaire.id",Long.parseLong(idProprietaire)));
		List<Contrat> results = cr.list();
		
		return results;
	}

	@Override
	public Contrat getById(Long id) {
		Session s=HibernateAnnotationUtil.getSessionFactory().openSession();

		Criteria cr = s.createCriteria(Contrat.class); 
		cr.add(Restrictions.eq("id",new Long(id)));
		Contrat contrat=(Contrat) cr.uniqueResult();
		
		if(contrat!=null){
			return contrat;
		}else
			return null;
	}

	@Override
	public void remove(Long id) {
		Session s=HibernateAnnotationUtil.getSessionFactory().openSession();
		
		Transaction tx=null;
		try{
			tx=s.beginTransaction();
			Criteria cr = s.createCriteria(Contrat.class); 
			cr.add(Restrictions.eq("id",new Long(id)));
			Contrat contrat=(Contrat) cr.uniqueResult();
			s.delete(contrat);
			tx.commit();
			
		}catch(Exception ex){
			if (tx!=null) tx.rollback();
			ex.printStackTrace();
			
		}finally{
			s.close();
		}
		
	}

	@Override
	public Contrat findOne(String paramName, Object paramValue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int findCountBy(String paramName, String paramValue) {
		// TODO Auto-generated method stub
		return 0;
	}

}
