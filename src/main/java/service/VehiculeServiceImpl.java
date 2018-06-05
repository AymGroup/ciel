package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import dao.IDao;
import models.Vehicule;

public class VehiculeServiceImpl implements IService<Vehicule> {

	@Autowired
	private IDao<Vehicule> daoVehicule;
	
	public IDao<Vehicule> getDaoVehicule() {
		return daoVehicule;
	}
	public void setDaoVehicule(IDao<Vehicule> daoVehicule) {
		this.daoVehicule = daoVehicule;
	}

	@Override
	public Vehicule save(Vehicule v) {
		return daoVehicule.save(v);
	}

	@Override
	public Vehicule update(Vehicule o) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Vehicule> selectAll() {
		return daoVehicule.selectAll();
	}

	@Override
	public List<Vehicule> selectAll(String sortField, String sort) {
		return daoVehicule.selectAll(null,sort);
	}

	@Override
	public Vehicule getById(Long id) {
		return daoVehicule.getById(id);
	}

	@Override
	public void remove(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Vehicule findOne(String paramName, Object paramValue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int findCountBy(String paramName, String paramValue) {
		// TODO Auto-generated method stub
		return 0;
	}

}
