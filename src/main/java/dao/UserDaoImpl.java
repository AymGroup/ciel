package dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import hibernate.utils.HibernateAnnotationUtil;
import models.User;

public class UserDaoImpl implements IDao<User> {

	@Override
	public User save(User o) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public User CheckUser(User u){
		Session s=HibernateAnnotationUtil.getSessionFactory().openSession();

		Criteria cr = s.createCriteria(User.class); 
		cr.add(Restrictions.eq("login",u.getLogin()))
		.add(Restrictions.eq("password", u.getPassword()));
		User user=(User) cr.uniqueResult();
		
		if(user!=null){
			return user;
		}else
			return null;
	}

	@Override
	public List<User> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User update(User o) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> selectAll(String sortField, String sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getById(Long id) {
		Session s=HibernateAnnotationUtil.getSessionFactory().openSession();

		Criteria cr = s.createCriteria(User.class); 
		cr.add(Restrictions.eq("id",new Long(id)));
		User user=(User) cr.uniqueResult();
		
		if(user!=null){
			return user;
		}else
			return null;
	}

	@Override
	public void remove(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User findOne(String paramName, Object paramValue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int findCountBy(String paramName, String paramValue) {
		// TODO Auto-generated method stub
		return 0;
	}


}
