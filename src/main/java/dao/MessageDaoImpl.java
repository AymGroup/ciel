package dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import hibernate.utils.HibernateAnnotationUtil;
import models.Message;

public class MessageDaoImpl implements IDao<Message> {

	@Override
	public Message save(Message m) {
		boolean rep=false;

		Session s=HibernateAnnotationUtil.getSessionFactory().openSession();
		Transaction tx=null;
		try {
			tx=s.beginTransaction();
			s.save(m);
			tx.commit();
			rep=true;
		}catch(Exception e) {
			if (tx!=null) tx.rollback();
			   e.printStackTrace(); 
			rep= false;
		}finally {
			s.close();
		}
		
		if(rep)return m;
		else return null;
	}

	@Override
	public List<Message> selectAll() {
		Session s=HibernateAnnotationUtil.getSessionFactory().openSession();
		Criteria cr=s.createCriteria(Message.class);
		List<Message> messages=cr.list();
		return messages;
	}

	@Override
	public Message update(Message o) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Message> selectAll(String sortField, String sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Message getById(Long id) {
		Session s=HibernateAnnotationUtil.getSessionFactory().openSession();

		Criteria cr = s.createCriteria(Message.class); 
		cr.add(Restrictions.eq("id",new Long(id)));
		Message message=(Message) cr.uniqueResult();
		
		if(message!=null){
			return message;
		}else
			return null;
	}

	@Override
	public void remove(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Message findOne(String paramName, Object paramValue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int findCountBy(String paramName, String paramValue) {
		// TODO Auto-generated method stub
		return 0;
	}

}
