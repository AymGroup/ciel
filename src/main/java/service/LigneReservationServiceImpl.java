package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import dao.IDao;
import models.LigneReservation;

public class LigneReservationServiceImpl implements IService<LigneReservation> {

	@Autowired
	private IDao<LigneReservation> daoLigneReservation;
	
	public IDao<LigneReservation> getDaoLigneReservation() {
		return daoLigneReservation;
	}
	public void setDaoLigneReservation(IDao<LigneReservation> daoLigneReservation) {
		this.daoLigneReservation = daoLigneReservation;
	}

	@Override
	public LigneReservation save(LigneReservation l) {
		return daoLigneReservation.save(l);
	}

	@Override
	public LigneReservation update(LigneReservation l) {
		return daoLigneReservation.update(l);
	}

	@Override
	public List<LigneReservation> selectAll() {
		return daoLigneReservation.selectAll();
	}

	@Override
	public List<LigneReservation> selectAll(String sortField, String sort) {
		return daoLigneReservation.selectAll(sortField, sort);
	}

	@Override
	public LigneReservation getById(Long id) {
		return daoLigneReservation.getById(id);
	}

	@Override
	public void remove(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public LigneReservation findOne(String paramName, Object paramValue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int findCountBy(String paramName, String paramValue) {
		// TODO Auto-generated method stub
		return 0;
	}

}
