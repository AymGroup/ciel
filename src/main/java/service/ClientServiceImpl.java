package service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.ClientDaoImpl;
import dao.IDao;
import models.Client;

public class ClientServiceImpl implements IService<Client> {

	@Autowired
	public IDao<Client> daoClient;

	public IDao<Client> getDaoClient() {
		return daoClient;
	}
	public void setDaoClient(IDao<Client> daoClient) {
		this.daoClient = daoClient;
	}
	@Override
	public Client save(Client c) {
		Client client=null;
		System.out.println("Service Client Class !");
		
		try{
			client=daoClient.save(c);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return client;
	}
	@Override
	public Client update(Client c) {
		return daoClient.update(c);
	}
	@Override
	public List<Client> selectAll() {
		return daoClient.selectAll();
	}
	@Override
	public List<Client> selectAll(String sortField, String sort) {
		return daoClient.selectAll(sortField,sort);
	}
	@Override
	public Client getById(Long id) {
		return daoClient.getById(id);
	}
	@Override
	public void remove(Long id) {
		daoClient.remove(id);
		
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
