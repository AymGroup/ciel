package dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import hibernate.utils.HibernateAnnotationUtil;
import models.Categorie;
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
	public Vehicule update(Vehicule v) {
		Boolean rep=false;
		
		Session s=HibernateAnnotationUtil.getSessionFactory().openSession();
		Transaction tx=null;
		try {
			tx=s.beginTransaction();
			s.saveOrUpdate(v);
			tx.commit();
			rep=true;
		}catch(Exception e) {
			if (tx!=null) tx.rollback();
			   e.printStackTrace(); 
			rep=false;
		}finally {
			s.close();
		}
		
		if(rep)return v;
			else return null;
	}

	@Override
	public List<Vehicule> selectAll(String sortField, String criterion) {
		Session s=HibernateAnnotationUtil.getSessionFactory().openSession();

		Criteria cr = s.createCriteria(Vehicule.class); 
		if(sortField.equals("categorie")){
			cr.add(Restrictions.eq("categorie.id",Long.parseLong(criterion)));
		}else if(sortField.equals("onService")){
			cr.add(Restrictions.eq("onService", criterion));
		}else if(sortField.equals("offService")){
			cr.add(Restrictions.eq("onService", criterion));
		}else{
			cr.add(Restrictions.eq("proprietaire.id",Long.parseLong(criterion)));
		}
		List<Vehicule> results = cr.list();
		
		return results;
	}

	@Override
	public Vehicule getById(Long id) {
		Session s=HibernateAnnotationUtil.getSessionFactory().openSession();
		Criteria cr=s.createCriteria(Vehicule.class);
		cr.add(Restrictions.eq("id", id));
		Vehicule vehicule=(Vehicule) cr.uniqueResult();
		
		if(vehicule!=null){
			return vehicule;
		}else
			return null;
		
	}

	@Override
	public void remove(Long id) {
		Session s=HibernateAnnotationUtil.getSessionFactory().openSession();
		
		Transaction tx=null;
		try{
			tx=s.beginTransaction();
			Criteria cr = s.createCriteria(Vehicule.class); 
			cr.add(Restrictions.eq("id",new Long(id)));
			Vehicule vehicule=(Vehicule) cr.uniqueResult();
			s.delete(vehicule);
			tx.commit();
			
		}catch(Exception ex){
			if (tx!=null) tx.rollback();
			ex.printStackTrace();
			
		}finally{
			s.close();
		}
		
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
