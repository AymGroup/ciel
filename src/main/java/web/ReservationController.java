package web;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;

import models.Categorie;
import models.Client;
import models.LigneReservation;
import models.Pack;
import models.Reservation;
import models.Vehicule;
import service.IService;

@Controller
@RequestMapping(path="/reservation")
public class ReservationController {

	@Autowired
	public IService<Reservation> reservationSrv;
	@Autowired
	public IService<Pack> packSrv;
	@Autowired
	public IService<Categorie> categorieSrv;
	@Autowired
	public IService<Client> clientSrv;
	@Autowired
	public IService<Vehicule> vehiculeSrv;
	@Autowired
	public IService<LigneReservation> ligneReservationSrv;
	
	private Long idReservation;
	private Long idPack;
	private String dateDebut;
	private String dateFin;
	
	public IService<LigneReservation> getLigneReservationSrv() {
		return ligneReservationSrv;
	}
	public void setLigneReservationSrv(IService<LigneReservation> ligneReservationSrv) {
		this.ligneReservationSrv = ligneReservationSrv;
	}
	public IService<Reservation> getReservationSrv() {
		return reservationSrv;
	}
	public void setReservationSrv(IService<Reservation> reservationSrv) {
		this.reservationSrv = reservationSrv;
	}
	public IService<Pack> getPackSrv() {
		return packSrv;
	}
	public void setPackSrv(IService<Pack> packSrv) {
		this.packSrv = packSrv;
	}
	public IService<Categorie> getCategorieSrv() {
		return categorieSrv;
	}
	public void setCategorieSrv(IService<Categorie> categorieSrv) {
		this.categorieSrv = categorieSrv;
	}
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
	
	@RequestMapping(path="/nouveau",method=RequestMethod.GET)
	public ModelAndView addReservation(Model model) {
		ModelAndView mv=new ModelAndView("espace-commercial/nouveau_reservation");	 
		mv.addObject("reservation", new Reservation());
		mv.addObject("packs",packSrv.selectAll());
		mv.addObject("clients", clientSrv.selectAll());
	   return mv;
	}
	
	/**
	 * Saving reservation.
	 * @param model       : model object.
	 * @param reservation : reservation data.
	 * @return
	 */
	@RequestMapping(path="/enregistrer",method=RequestMethod.POST)
	public String saveReservation(Model model,Reservation reservation){
		
		Client client=clientSrv.getById(reservation.getClient().getId());
		Pack pack=packSrv.getById(reservation.getPack().getId());
		reservation.setClient(client);
		reservation.setPack(pack);
		if(client!=null && pack!=null){
			reservation.setTarifTotal(pack.getTarif());
			reservationSrv.save(reservation);
			this.idReservation=reservation.getId();
			this.dateDebut=reservation.getDateResevation();
			this.dateFin=reservation.getDateFinResevation();
			
			model.addAttribute("id_reservation", reservation.getId());
			return "redirect:/reservation/showFormLigneReservation";
		}
		return "redirect:/reservation/nouveau";
	}
	
	/**
	 * Show ligne reservation form.
	 * @return
	 */
	@RequestMapping(path="/showFormLigneReservation",method=RequestMethod.GET)
	public ModelAndView showFormLigneReservation(){
		List<Reservation> reservationDetail=new ArrayList<>();
		reservationDetail.add(reservationSrv.getById(idReservation));
		ModelAndView mv=new ModelAndView("espace-commercial/nouveau_ligne_reservation","ligne_reservation",new LigneReservation());
		mv.addObject("reservationDetail",reservationDetail);
		mv.addObject("vehicules",vehiculeSrv.selectAll("offService",""));
		return mv;
	}
	
	/**
	 * Saving ligneReservation Data.
	 * @param ligneReservation : ligneReservation data.
	 * @return
	 */
	@RequestMapping(path="/enregistrerLigneReservation")
	public ModelAndView saveLigneRes(LigneReservation ligneReservation){
		ModelAndView mv=new ModelAndView();
		String response="";double tarifVehicule=0;
		
		Vehicule v=vehiculeSrv.getById(ligneReservation.getVehicule().getId());
		Reservation r=reservationSrv.getById(idReservation);
		ligneReservation.setVehicule(v);
		ligneReservation.setReservation(r);
		
		// # GETTING THE DIFFERENCE BETWEEN THE TWO DATES
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date dateD = sdf.parse(this.dateDebut);
			Date dateF = sdf.parse(this.dateFin);
			long diffInMillies = Math.abs(dateD.getTime() - dateF.getTime());
			long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
			System.out.println("Difference between two dates : "+diff);
			tarifVehicule=v.getTarifJour()*diff;
			ligneReservation.setTarif(tarifVehicule);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(ligneReservationSrv.save(ligneReservation)!=null){
			
			// # UPDATING DATA - Reservation & Vehicule
			double oldTarifTotal=r.getTarifTotal();
			r.setTarifTotal(oldTarifTotal+tarifVehicule);
			v.setOnService("En Service");
			reservationSrv.update(r);
			vehiculeSrv.update(v);
			
			response="success";
			String ligneRes="ok";
			List<Reservation> reservationDetail=new ArrayList<>();
			reservationDetail.add(reservationSrv.getById(idReservation));
			
			mv.addObject("response",response);
			mv.addObject("ligne_reservation",new LigneReservation());
			mv.addObject("ligneRes", ligneRes);
			mv.addObject("id_reservation",r.getId());
			mv.addObject("ligneReservations",ligneReservationSrv.selectAll(null,String.valueOf(r.getId())));
			mv.addObject("reservationDetail",reservationDetail);
			mv.addObject("vehicules",vehiculeSrv.selectAll("onService",""));
			mv.setViewName("espace-commercial/nouveau_ligne_reservation");
			return mv;
		}
		
		response="error";
		mv.addObject("response",response);
		mv.setViewName("redirect:/reservation/showFormLigneReservation");
		return mv;
	}
	
	@RequestMapping(path="/showVehiculesOnService")
	public ModelAndView showVehiculesOnService(){
		ModelAndView mv=new ModelAndView();
		mv.setViewName("espace-commercial/list_vehicule_en_service");
		mv.addObject("ligneReservation", new LigneReservation());
		mv.addObject("vehiculesReserved", ligneReservationSrv.selectAll());
		return mv;
		
	}
	
	@RequestMapping(path="/showVehiculesHorsService")
	public ModelAndView showVehiculesHorsService(){
		List<Vehicule> vehiculesOffService=vehiculeSrv.selectAll("offService",null);
		ModelAndView mv=new ModelAndView();
		mv.setViewName("espace-commercial/list_vehicule_hors_service");
		mv.addObject("vehiculesOffService",vehiculesOffService);
		return mv;
		
	}
	
	@RequestMapping(path="/getReservations",method=RequestMethod.GET)
	public String getAllReservations(Model model){
		List<Reservation> reservations=reservationSrv.selectAll();
		model.addAttribute("reservations", reservations);
		return "espace-commercial/list_reservations";
	}
	
	@RequestMapping(path="/get")
	@ResponseBody
	public String getDetailsRéservation(@RequestParam(name="id")String id,Model model){
		
		List<LigneReservation> ligneReservations=ligneReservationSrv.selectAll(null,String.valueOf(id));
		
		ObjectMapper mapper = new ObjectMapper();
		String json = "";
		try {
			json = mapper.writeValueAsString(ligneReservations);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return json;
	}
	
}
