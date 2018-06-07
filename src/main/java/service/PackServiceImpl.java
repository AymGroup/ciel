package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import dao.IDao;
import models.Pack;

public class PackServiceImpl implements IService<Pack> {

	@Autowired
	private IDao<Pack> daoPack;
	
	public IDao<Pack> getDaoPack() {
		return daoPack;
	}
	public void setDaoPack(IDao<Pack> daoPack) {
		this.daoPack = daoPack;
	}

	@Override
	public Pack save(Pack p) {
		return daoPack.save(p);
	}

	@Override
	public Pack update(Pack o) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Pack> selectAll() {
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
		// TODO Auto-generated method stub
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
