package web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import models.Client;
import service.IService;

@Controller
@RequestMapping(path="/client")
public class ClientController {

	@Autowired(required=false)
	public IService<Client> clientSrv;

	public IService<Client> getClientSrv() {
		return clientSrv;
	}
	public void setClientSrv(IService<Client> clientSrv) {
		this.clientSrv = clientSrv;
	}
	
	@RequestMapping(path="/nouveau",method=RequestMethod.GET)
	public ModelAndView addClient(Model model) {
		//Client client = new Client();
		ModelAndView mv=new ModelAndView("espace-commercial/nouveau_client","client",new Client());
		return mv;
	}
	
	/*@RequestMapping(value = "/enregistrer",method=RequestMethod.POST)
	public ModelAndView enregistrerClient(@Valid Client client,BindingResult result,Model model) {
		String response="";
		if(result.hasErrors()) {
			response="error";
			//return "espace-commercial/nouveau_client";
			return new ModelAndView("espace-commercial/nouveau_client", "response", response);
		}
		
		//ModelAndView mv=new ModelAndView("espace-commercial/nouveau_client","client",client);
		System.out.println(client); 
		boolean rep=clientSrv.save(client);
		
		if(!rep){
			System.out.println("Erreur lors de l'enregistrement du client"); 
			//return "redirect:/client/nouveau";
			return new ModelAndView("redirect:/client/nouveau");
		}
		
		//return "espace-commercial/dashboard";
		return new ModelAndView("espace-commercial/dashboard");
	}*/
	
	@RequestMapping(path="/enregistrer",method=RequestMethod.POST)
	public String addClient(Model model,Client client,BindingResult result) {
		String response="error";
		
		boolean rep=clientSrv.save(client);
		
		if(!rep){
			response="error";
			model.addAttribute("response", response);
			model.addAttribute("client", new Client());
			return "espace-commercial/nouveau_client";
		}else{
			response="success";
			model.addAttribute("response", response);
			model.addAttribute("client", new Client());
		}
		
		return "espace-commercial/nouveau_client";
		
	}
	
	
	
	
}
