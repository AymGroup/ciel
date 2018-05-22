package service;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import dao.IDao;
import models.Contrat;

public class ContratServiceImpl implements IService<Contrat> {

	@Autowired
	public IDao<Contrat> daoContrat;

	public IDao<Contrat> getDaoContrat() {
		return daoContrat;
	}
	public void setDaoContrat(IDao<Contrat> daoContrat) {
		this.daoContrat = daoContrat;
	}
	@Override
	public boolean save(Contrat c) {
		boolean rep=false;
		System.out.println("Service Contrat Class !");
		
		try{
			rep=daoContrat.save(c);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return rep;
	}
	@Override
	public Contrat update(Contrat o) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Contrat> selectAll() {
		return daoContrat.selectAll();
	}
	@Override
	public List<Contrat> selectAll(String sortField, String sort) {
		return daoContrat.selectAll(sortField, sort);
	}
	@Override
	public Contrat getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void remove(Long id) {
		// TODO Auto-generated method stub
		
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
