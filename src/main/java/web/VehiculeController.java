package web;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;

import models.Categorie;
import models.Client;
import models.Proprietaire;
import models.Vehicule;
import service.IService;

@Controller
@RequestMapping(path="/vehicule")
public class VehiculeController {

	@Autowired
	private IService<Vehicule> vehiculeSrv;
	@Autowired
	private IService<Proprietaire> proprietaireSrv;
	@Autowired
	private IService<Categorie> categorieSrv;
	
	private Path path;
	
	public IService<Vehicule> getVehiculeSrv() {
		return vehiculeSrv;
	}
	public void setVehiculeSrv(IService<Vehicule> vehiculeSrv) {
		this.vehiculeSrv = vehiculeSrv;
	}
	public IService<Proprietaire> getProprietaireSrv() {
		return proprietaireSrv;
	}
	public void setProprietaireSrv(IService<Proprietaire> proprietaireSrv) {
		this.proprietaireSrv = proprietaireSrv;
	}
	public IService<Categorie> getCategorieSrv() {
		return categorieSrv;
	}
	public void setCategorieSrv(IService<Categorie> categorieSrv) {
		this.categorieSrv = categorieSrv;
	}
	
	@RequestMapping(path="/nouveau",method=RequestMethod.GET)
	public ModelAndView showForm(){
		
		List<Proprietaire> proprietaires=proprietaireSrv.selectAll();
		List<Categorie> categories=categorieSrv.selectAll();
		
		ModelAndView mv=new ModelAndView("espace-commercial/nouveau_vehicule");
		mv.addObject("vehicule", new Vehicule());
		mv.addObject("proprietaires", proprietaires);
		mv.addObject("categories", categories);
		return mv;
	}
	
	@RequestMapping(path="/getVehicules",method=RequestMethod.GET)
	public String listVehicules(Model model) {
		
		List<Vehicule> vehicules=vehiculeSrv.selectAll();
		List<Proprietaire> proprietaires=proprietaireSrv.selectAll();
		List<Categorie> categories=categorieSrv.selectAll();
		
		model.addAttribute("categories",categories);
		model.addAttribute("proprietaire", new Proprietaire());
		model.addAttribute("vehicule",new Vehicule());
		model.addAttribute("proprietaires", proprietaires);
		model.addAttribute("vehicules",vehicules);
		return "espace-commercial/list_vehicule";
	}
	
	@RequestMapping(path="/get")
	@ResponseBody 
	public String getCategorie(@RequestParam(name="id")String id,Model model){
		
		Vehicule vehicule=vehiculeSrv.getById(Long.parseLong(id));
		ObjectMapper mapper = new ObjectMapper();
		String json = "";
		try {
			json = mapper.writeValueAsString(vehicule);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return json;
		
	}
	
	@RequestMapping(path="/chercherParProprietaire")
	public String chercherParProprietaire(Model model,@RequestParam(name="proprietaire.id") String id) {
		String proprietaire=null;
		List<Vehicule> vehicules=vehiculeSrv.selectAll(null,id);
		List<Proprietaire> proprietaires=proprietaireSrv.selectAll();
		
		List<String>proprietairesMapped=vehicules.stream().map(p->p.getProprietaire().getNom().toUpperCase()+ " " +p.getProprietaire().getPrenom()).collect(Collectors.toList());
		
		if(!proprietairesMapped.isEmpty()){
			proprietaire = proprietairesMapped.get(0);
		}
		
		if(!vehicules.isEmpty()) {
			
			List<Categorie> categories=categorieSrv.selectAll();
			model.addAttribute("categories",categories);
			model.addAttribute("prop",proprietaire);
			model.addAttribute("proprietaire", new Proprietaire());
			model.addAttribute("vehicule",new Vehicule());
			model.addAttribute("proprietaires", proprietaires);
			model.addAttribute("vehicules",vehicules);
			return "espace-commercial/list_vehicule";
		}
		
		return "redirect:vehicule/getVehicules";

	}
	
	@RequestMapping(path="/enregistrer",method=RequestMethod.POST)
	public String saveVehicule(Model model,Vehicule vehicule,HttpServletRequest request){
		String response="";
		
		// get the provided image from the form
		MultipartFile vehiculeImage = vehicule.getVehiculeImage();
		
		Categorie categorie=categorieSrv.getById(vehicule.getCategorie().getId());
		Proprietaire proprietaire=proprietaireSrv.getById(vehicule.getProprietaire().getId());
		vehicule.setCategorie(categorie);
		vehicule.setProprietaire(proprietaire);
		
		Vehicule vehiculeSaved=vehiculeSrv.save(vehicule);
				
		// get root directory to store the image
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");	
		System.out.println("Root Directory :"+rootDirectory);	
		
		if(vehiculeSaved!=null){
			path = Paths.get(rootDirectory + "/resources/uploaded/vehicule/" +vehicule.getId() + ".png");

			if (vehiculeImage != null && !vehiculeImage.isEmpty()) {
				try {
					vehiculeImage.transferTo(new File(path.toString()));
				} catch (IllegalStateException | IOException e) {
					response="error";
					model.addAttribute("response",response);
					e.printStackTrace();
					throw new RuntimeException("Saving Vehicule image was not successful", e);
				}
			}
			response="success";
		}
		
		model.addAttribute("response",response);
		return "redirect:/vehicule/nouveau";
		
	}
	
	@RequestMapping(path="/edit")
	public String editVehicule(Vehicule vehicule,Model model,HttpServletRequest request){
		
		String response="";
		
		Categorie categorie=categorieSrv.getById(vehicule.getCategorie().getId());
		Proprietaire proprietaire=proprietaireSrv.getById(vehicule.getProprietaire().getId());
		vehicule.setProprietaire(proprietaire);
		vehicule.setCategorie(categorie);
		
		if(vehicule.getId()!=null){
			MultipartFile vehiculeImage = vehicule.getVehiculeImage();
			String rootDirectory = request.getSession().getServletContext().getRealPath("/");
			
			System.out.println("Root Directory :"+rootDirectory);
			
			path = Paths.get(rootDirectory + "/resources/uploaded/vehicule/" +vehicule.getId() + ".png");
			
			// check whether image exists or not
			if (vehiculeImage != null && !vehiculeImage.isEmpty()) {
				try {
					// convert the image type to png
					vehiculeImage.transferTo(new File(path.toString()));
				} catch (IllegalStateException | IOException e) {
					// oops! something did not work as expected
					e.printStackTrace();
					throw new RuntimeException("Saving Vehicule image was not successful", e);
				}
			}
	        Vehicule vehiculeUpdated=vehiculeSrv.update(vehicule);
	        response="success";
	        model.addAttribute("response_update", response);
		}
        
		return "redirect:/vehicule/getVehicules";
	}
}
