package dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import hibernate.utils.HibernateAnnotationUtil;
import models.Client;
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
		Session s=HibernateAnnotationUtil.getSessionFactory().openSession();
		Criteria cr = s.createCriteria(Pack.class);
		List<Pack> results = cr.list();
		return results;
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
		Session s=HibernateAnnotationUtil.getSessionFactory().openSession();

		Criteria cr = s.createCriteria(Pack.class); 
		cr.add(Restrictions.eq("id",new Long(id)));
		Pack pack=(Pack) cr.uniqueResult();
		
		if(pack!=null){
			return pack;
		}else
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
