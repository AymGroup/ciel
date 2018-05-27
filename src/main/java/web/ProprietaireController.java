package web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import models.Proprietaire;
import service.IService;

@Controller
@RequestMapping(path="/proprietaire")
public class ProprietaireController {
	
	@Autowired(required=false)
	public IService<Proprietaire> propSrv;

	public IService<Proprietaire> getPropSrv() {
		return propSrv;
	}
	public void setPropSrv(IService<Proprietaire> propSrv) {
		this.propSrv = propSrv;
	}
	
	@RequestMapping(path="/nouveau",method=RequestMethod.GET)
	public ModelAndView addProprietaire(Model model) {
		ModelAndView mv=new ModelAndView("espace-commercial/nouveau_proprietaire","proprietaire",new Proprietaire());
		return mv;
	}
	
	/*@RequestMapping(path="/enregistrer",method=RequestMethod.POST)
	public ModelAndView addProprietaire(Proprietaire proprietaire,BindingResult result,RedirectAttributes redir) {
		String response="";
		
		if(result.hasErrors()){
			response="error";
			return new ModelAndView("espace-commercial/nouveau_proprietaire", "response", response);
		}
		
		//boolean rep=propSrv.save(proprietaire);
		boolean rep=true;
		if(!rep){
			response="error";
			return new ModelAndView("redirect:/proprietaire/nouveau", "response", response);
		}
		
		response="success";
		return new ModelAndView("espace-commercial/nouveau_proprietaire","response",response);
		
	}*/
	
	@RequestMapping(path="/enregistrer",method=RequestMethod.POST)
	public String addProprietaire(Model model,Proprietaire proprietaire,BindingResult result) {
		String response="error";
		
		Proprietaire proprietaireSaved=propSrv.save(proprietaire);
		
		if(proprietaireSaved==null){
			response="error";
			model.addAttribute("response", response);
			model.addAttribute("proprietaire", new Proprietaire());
			return "espace-commercial/nouveau_proprietaire";
		}else{
			response="success";
			model.addAttribute("response", response);
			model.addAttribute("proprietaire", new Proprietaire());
		}
		
		return "espace-commercial/nouveau_proprietaire";
		
	}
	
	
	

}
