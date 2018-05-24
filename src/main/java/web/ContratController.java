package web;

import java.io.BufferedReader;
import java.io.InputStreamReader;
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
	public String addContrat(Model model) {
		
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
			model.addAttribute("proprietaires",proprietaires);
			model.addAttribute("response", response);
			model.addAttribute("contrat", new Contrat());
			return "espace-commercial/contrat_proprietaire";
		}else{
			response="success";
			model.addAttribute("response", response);
			model.addAttribute("contrat", new Contrat());
		}
		
		//return "espace-commercial/contrat_proprietaire";
		return "redirect:/contrat/getContrats";
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
			
			//proprietaire=contrats.stream().distinct().map(p->p.getProprietaire().getNom().toUpperCase()+ " " +p.getProprietaire().getPrenom()).collect(Collectors.joining(", "));
			List<String>proprietairesMapped=contrats.stream().map(p->p.getProprietaire().getNom().toUpperCase()+ " " +p.getProprietaire().getPrenom()).collect(Collectors.toList());
			proprietaire = proprietairesMapped.get(0);
			
			
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
	
	@RequestMapping(path="/edit")
	@ResponseBody 
	public String editContrat(@RequestParam(name="id")String id,HttpServletRequest request){
		
		String response="It's the Edit methode !";
		Contrat contrat=new Contrat();
       
        String json = "";
        try {
        	BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
        	if(br != null){
                json = br.readLine();
                
                // # initiate jackson mapper
                ObjectMapper mapper = new ObjectMapper();
                
                // # Convert received JSON to Contrat
                contrat = mapper.readValue(json, Contrat.class);
                
                // # Set Contrat id for updating
                contrat.setId(Long.parseLong(id));
                
                // # Get contrat before updating
                Contrat oldContrat=contratSrv.getById(Long.parseLong(id));
                
                // # Set Date Debut & Proprietaire for the updating contrat
                contrat.setDateDebut(oldContrat.getDateDebut());
                contrat.setProprietaire(oldContrat.getProprietaire());
                Contrat contratUpdated=contratSrv.update(contrat);
                
                System.out.println(contratUpdated);
                
            }
        	
        	
        }catch(Exception ex) {
        	ex.printStackTrace();
        }
        
        System.out.println(contrat.getDescription());
		return response;
	}
	
}
