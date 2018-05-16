package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import dao.IDao;
import models.Proprietaire;

public class ProprietaireServiceImpl implements IService<Proprietaire> {

	@Autowired
	public IDao<Proprietaire> daoProp;
	
	public IDao<Proprietaire> getDaoProp() {
		return daoProp;
	}
	public void setDaoProp(IDao<Proprietaire> daoProp) {
		this.daoProp = daoProp;
	}

	@Override
	public boolean save(Proprietaire p) {
		boolean rep=false;
		System.out.println("Service Proprietaire Class !");
		
		try{
			rep=daoProp.save(p);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return rep;
	}

	@Override
	public Proprietaire update(Proprietaire o) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Proprietaire> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Proprietaire> selectAll(String sortField, String sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Proprietaire getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Proprietaire findOne(String paramName, Object paramValue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int findCountBy(String paramName, String paramValue) {
		// TODO Auto-generated method stub
		return 0;
	}

	

}
