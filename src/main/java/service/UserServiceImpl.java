package service;

import java.util.List;

import dao.UserDaoImpl;
import models.User;

public class UserServiceImpl implements IService<User> {

	private UserDaoImpl daoUser;
	
	@Override
	public User save(User o) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public User CheckUser(User u){
		return daoUser.CheckUser(u);
	}

	@Override
	public User update(User o) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> selectAll() {
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
		// TODO Auto-generated method stub
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
