package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import dao.IDao;
import models.Categorie;
import models.Client;

public class CategorieServiceImpl implements IService<Categorie> {

	@Autowired
	public IDao<Categorie> daoCategorie;
	
	public IDao<Categorie> getDaoCategorie() {
		return daoCategorie;
	}
	public void setDaoCategorie(IDao<Categorie> daoCategorie) {
		this.daoCategorie = daoCategorie;
	}

	@Override
	public Categorie save(Categorie categorie) {
		return daoCategorie.save(categorie);
	}

	@Override
	public Categorie update(Categorie c) {
		return daoCategorie.update(c);
	}

	@Override
	public List<Categorie> selectAll() {
		return daoCategorie.selectAll();
	}

	@Override
	public List<Categorie> selectAll(String sortField, String sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Categorie getById(Long id) {
		return daoCategorie.getById(id);
	}

	@Override
	public void remove(Long id) {
		daoCategorie.remove(id);
		
	}

	@Override
	public Categorie findOne(String paramName, Object paramValue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int findCountBy(String paramName, String paramValue) {
		// TODO Auto-generated method stub
		return 0;
	}

}
