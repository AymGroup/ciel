package web;


import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;

import models.Client;
import models.Contrat;
import service.IService;

@Controller
@RequestMapping(path="/client")
public class ClientController {

	@Autowired(required=false)
	public IService<Client> clientSrv;
	
	private Path path;
	
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
	
	// # Commented method
	/*@RequestMapping(path="/enregistrer",method=RequestMethod.POST)
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
		
	}*/
	
	@RequestMapping(path="/enregistrer",method=RequestMethod.POST)
	public String saveClient(Model model,Client client,BindingResult result,HttpServletRequest request) {
		
		// get the provided image from the form
		MultipartFile clientImage = client.getUserImage();
		
		Client clientSaved=clientSrv.save(client);
		
		
		// get root directory to store the image
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		
		System.out.println("Root Directory :"+rootDirectory);
		
		path = Paths.get(rootDirectory + "/resources/uploaded/user/" +clientSaved.getId() + ".png");
		
		// check whether image exists or not
		if (clientImage != null && !clientImage.isEmpty()) {
			try {
				// convert the image type to png
				clientImage.transferTo(new File(path.toString()));
			} catch (IllegalStateException | IOException e) {
				// oops! something did not work as expected
				e.printStackTrace();
				throw new RuntimeException("Saving User image was not successful", e);
			}
		}
		
		return "redirect:/client/getClients";
		
	}
	
	/**
	 * Get all clients.
	 * @param model
	 * @return
	 */
	@RequestMapping(path="/getClients",method=RequestMethod.GET)
	public String listClients(Model model) {
		
		List<Client> clients=clientSrv.selectAll();
		
		model.addAttribute("client",new Client());
		model.addAttribute("clients",clients);
		return "espace-commercial/list_client";
	}
	
	/**
	 * Get client by id (Ajax request).
	 * @param id    : id client.
	 * @param model
	 * @return
	 */
	@RequestMapping(path="/get")
	@ResponseBody 
	public String getClient(@RequestParam(name="id")String id,Model model){
		//String response="success Response !";
		
		Client client=clientSrv.getById(Long.parseLong(id));
		ObjectMapper mapper = new ObjectMapper();
		String json = "";
		try {
			json = mapper.writeValueAsString(client);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return json;
	}
	
	/**
	 * Edit client.
	 * @param id    : id client
	 * @param model
	 * @return
	 */
	@RequestMapping(path="/edit")
	public String editClient(@RequestParam(name="id")String id,Client client,Model model){
		String response;
		//System.out.println(contrat.getDescription());
		// # Get contrat before updating
		
		if(!id.isEmpty()){
	        Client clientUpdated=clientSrv.update(client);
	        response="success";
	        model.addAttribute("response_update", response);
		}
        
		return "redirect:/client/getClients";
	}
	
	/**
	 * Delete client by id.
	 * @param id    : id client
	 * @param model
	 * @return
	 */
	@RequestMapping(path="/delete")
	public String deleteClient(@RequestParam(name="id")String id,Model model){
		String response;
		
		try{
			clientSrv.remove(Long.parseLong(id));
			response="success";
			model.addAttribute("response_delete",response);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
		return "redirect:/client/getClients";
	}
	
	/**
	 * Get clients by city.
	 * @param ville : City name
	 * @param model
	 * @return
	 */
	@RequestMapping(path="/chercher")
	public String searchClient(@RequestParam(name="address.city")String ville,Model model){
		
		List<Client> clientsByCity=clientSrv.selectAll(null, ville);
		
		if(!clientsByCity.isEmpty()) {
			model.addAttribute("client",new Client());
			model.addAttribute("clients",clientsByCity);
			return "espace-commercial/list_client";
		}

		return "redirect:/client/getClients";
	}
	
	
	
	
}
