package web;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import models.Contrat;
import service.IService;

@Controller
@RequestMapping(path="/contrat")
public class ContratController {

	@Autowired(required=false)
	public IService<Contrat> contratSrv;
	
	public IService<Contrat> getContratSrv() {
		return contratSrv;
	}
	public void setContratSrv(IService<Contrat> contratSrv) {
		this.contratSrv = contratSrv;
	}

	@RequestMapping(path="/nouveau",method=RequestMethod.GET)
	public String addClient(Model model) {
		/*ModelAndView mv=new ModelAndView("espace-commercial/contrat_proprietaire","contrat",new Contrat());
		return mv;*/
		
		model.addAttribute("contrat", new Contrat());
		return "espace-commercial/contrat_proprietaire";
	}
	
	@RequestMapping(path="/enregistrer",method=RequestMethod.POST)
	public String addContrat(Model model,Contrat contrat,BindingResult result) {
		String response="error";
		
		System.out.println(contrat.toString());
		
		boolean rep=contratSrv.save(contrat);
		
		if(!rep){
			response="error";
			model.addAttribute("response", response);
			model.addAttribute("contrat", new Contrat());
			return "espace-commercial/contrat_proprietaire";
		}else{
			response="success";
			model.addAttribute("response", response);
			model.addAttribute("contrat", new Contrat());
		}
		
		return "espace-commercial/contrat_proprietaire";
		
	}
	
}
