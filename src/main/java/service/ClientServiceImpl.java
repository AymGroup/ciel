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
	public boolean save(Client c) {
		boolean rep=false;
		System.out.println("Service Client Class !");
		
		try{
			rep=daoClient.save(c);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return rep;
	}
	@Override
	public Client update(Client o) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Client> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Client> selectAll(String sortField, String sort) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Client getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void remove(Long id) {
		// TODO Auto-generated method stub
		
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
