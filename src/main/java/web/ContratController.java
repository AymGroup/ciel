package web;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;

import models.Contrat;
import models.Proprietaire;
import service.IService;

@Controller
@RequestMapping(path="/contrat")
public class ContratController {
	
	@Autowired(required=false)
	public IService<Contrat> contratSrv;
	
	@Autowired(required=false)
	public IService<Proprietaire> proprietaireSrv;
	
	public static List<Proprietaire> proprietaires;
	
	public IService<Contrat> getContratSrv() {
		return contratSrv;
	}
	public void setContratSrv(IService<Contrat> contratSrv) {
		this.contratSrv = contratSrv;
	}
	public IService<Proprietaire> getProprietaireSrv() {
		return proprietaireSrv;
	}
	public void setProprietaireSrv(IService<Proprietaire> proprietaireSrv) {
		this.proprietaireSrv = proprietaireSrv;
	}
	
	@RequestMapping(path="/nouveau",method=RequestMethod.GET)
	public String addClient(Model model) {
		
		if(proprietaires==null || proprietaires.isEmpty() ) {
			proprietaires=proprietaireSrv.selectAll();
		}

		model.addAttribute("proprietaires",proprietaires);
		model.addAttribute("contrat", new Contrat());
		return "espace-commercial/contrat_proprietaire";
	}
	
	@RequestMapping(path="/enregistrer",method=RequestMethod.POST)
	public String addContrat(Model model,Contrat contrat,BindingResult result) {
		String response="error";
		
		System.out.println("ID Proprietaire : "+contrat.getProprietaire().getId());
		
		Proprietaire proprietaire=proprietaireSrv.getById(contrat.getProprietaire().getId());
		contrat.setProprietaire(proprietaire);
		
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
	
	/**
	 * Get all contrats.
	 * @param model
	 * @return
	 */
	@RequestMapping(path="/getContrats",method=RequestMethod.GET)
	public String listContrat(Model model) {
		
		if(proprietaires==null || proprietaires.isEmpty() ) {
			proprietaires=proprietaireSrv.selectAll();
		}
		
		List<Contrat> contrats=contratSrv.selectAll();
		
		model.addAttribute("contrat",new Contrat());
		model.addAttribute("proprietaires",proprietaires);
		model.addAttribute("contrats",contrats);
		return "espace-commercial/list_contrat";
	}
	
	/**
	 * Chercher les contrats par propriétaires.
	 * @param model
	 * @param id  : id proprietaire (from dropdown)
	 * @return
	 */
	@RequestMapping(path="/chercher")
	public String searchContrat(Model model,@RequestParam(name="proprietaire.id") String id) {
		
		String proprietaire;
		
		if(id=="" || !id.isEmpty()) {
			if(proprietaires==null || proprietaires.isEmpty() ) {
				proprietaires=proprietaireSrv.selectAll();
			}
			
			List<Contrat> contrats=contratSrv.selectAll(null,id);
			
			proprietaire=contrats.stream().map(p->p.getProprietaire().getNom().toUpperCase()+ " " +p.getProprietaire().getPrenom()).collect(Collectors.joining(", "));
			
			model.addAttribute("prop",proprietaire);
			model.addAttribute("contrat",new Contrat());
			model.addAttribute("proprietaires",proprietaires);
			model.addAttribute("contrats",contrats);
			return "espace-commercial/list_contrat";
		}else
			return "redirect:/contrat/getContrats";
		
	}
	
	/*@RequestMapping(path="/get")
	@ResponseBody 
	public String getContrat(@RequestParam(name="id")String id){
		
		String rep="N° Contrat :"+id;
		System.out.println(rep);
		
		ObjectMapper mapper = new ObjectMapper();
		
		List<String> list = new ArrayList<String>();
		list.add("List A");
		list.add("List B");
		list.add("List C");
		list.add("List D");
		list.add("List E");

		String json = "";
		try {
			json = mapper.writeValueAsString(list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return json;
	}*/
	
	
	@RequestMapping(path="/get")
	@ResponseBody 
	public String getContrat(@RequestParam(name="id")String id,Model model){
		String response="success Response !";
		
		Contrat contrat=contratSrv.getById(Long.parseLong(id));
		ObjectMapper mapper = new ObjectMapper();
		String json = "";
		try {
			json = mapper.writeValueAsString(contrat);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return json;
	}
	
}
