package web;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import models.Client;
import models.Reservation;
import models.Vehicule;
import service.IService;

@Controller
@RequestMapping(path="/dashboard")
public class DashboardController {

	@Autowired
	public IService<Client> clientSrv;
	@Autowired
	public IService<Vehicule> vehiculeSrv;
	@Autowired
	public IService<Reservation> reservationSrv;
	
	public IService<Client> getClientSrv() {
		return clientSrv;
	}
	public void setClientSrv(IService<Client> clientSrv) {
		this.clientSrv = clientSrv;
	}
	public IService<Vehicule> getVehiculeSrv() {
		return vehiculeSrv;
	}
	public void setVehiculeSrv(IService<Vehicule> vehiculeSrv) {
		this.vehiculeSrv = vehiculeSrv;
	}
	public IService<Reservation> getReservationSrv() {
		return reservationSrv;
	}
	public void setReservationSrv(IService<Reservation> reservationSrv) {
		this.reservationSrv = reservationSrv;
	}
	
	@RequestMapping(path="/show",method=RequestMethod.GET)
	public String showDashboard(Model model){
		List<Reservation> reservations=new ArrayList<Reservation>();
		reservations=reservationSrv.selectAll().stream().sorted(Comparator.comparing(Reservation::getId).reversed()).collect(Collectors.toList());
		Double sum=reservationSrv.selectAll().stream().mapToDouble(Reservation::getTarifTotal).sum();
		
		model.addAttribute("reservations",reservations);
		model.addAttribute("totalReservation",sum);
		model.addAttribute("sizeClt",clientSrv.selectAll().size());
		model.addAttribute("reservationSize", reservationSrv.selectAll().size());
		model.addAttribute("nbVehicules", vehiculeSrv.selectAll("onService","En Service").size());
		
		return "espace-commercial/dashboard";
	}
}
