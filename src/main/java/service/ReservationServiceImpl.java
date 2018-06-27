package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import dao.IDao;
import models.Reservation;

public class ReservationServiceImpl implements IService<Reservation> {

	@Autowired
	private IDao<Reservation> daoReservation;
	
	public IDao<Reservation> getDaoReservation() {
		return daoReservation;
	}
	public void setDaoReservation(IDao<Reservation> daoReservation) {
		this.daoReservation = daoReservation;
	}

	@Override
	public Reservation save(Reservation r) {
		return daoReservation.save(r);
	}

	@Override
	public Reservation update(Reservation r) {
		return daoReservation.update(r);
	}

	@Override
	public List<Reservation> selectAll() {
		return daoReservation.selectAll();
	}

	@Override
	public List<Reservation> selectAll(String sortField, String sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reservation getById(Long id) {
		return daoReservation.getById(id);
	}

	@Override
	public void remove(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Reservation findOne(String paramName, Object paramValue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int findCountBy(String paramName, String paramValue) {
		// TODO Auto-generated method stub
		return 0;
	}

}
