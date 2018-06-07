package web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import models.Reservation;
import service.IService;

@Controller
@RequestMapping(path="/reservation")
public class ReservationController {

	@Autowired
	public IService<Reservation> reservationSrv;
	
	public IService<Reservation> getReservationSrv() {
		return reservationSrv;
	}
	public void setReservationSrv(IService<Reservation> reservationSrv) {
		this.reservationSrv = reservationSrv;
	}

	@RequestMapping(path="/nouveau",method=RequestMethod.GET)
	public ModelAndView addReservation(Model model) {
		ModelAndView mv=new ModelAndView("espace-commercial/nouveau_reservation","reservation",new Reservation());	 
		mv.addObject("reservation", new Reservation());
	   return mv;
	}
	
	@RequestMapping(path="/enregistrer",method=RequestMethod.POST)
	public String saveReservation(Model model,Reservation reservation){
		
		return null;
	}
}
