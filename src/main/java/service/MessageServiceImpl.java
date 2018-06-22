package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import dao.IDao;
import models.Message;

public class MessageServiceImpl implements IService<Message> {

	@Autowired
	private IDao<Message> daoMessage;
	
	public IDao<Message> getDaoMessage() {
		return daoMessage;
	}
	public void setDaoMessage(IDao<Message> daoMessage) {
		this.daoMessage = daoMessage;
	}

	@Override
	public Message save(Message m) {
		return daoMessage.save(m);
	}

	@Override
	public Message update(Message o) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Message> selectAll() {
		return daoMessage.selectAll();
	}

	@Override
	public List<Message> selectAll(String sortField, String sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Message getById(Long id) {
		return daoMessage.getById(id);
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
