package web;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;

import models.Categorie;
import service.IService;

@Controller
@RequestMapping(path="/categorie")
public class CategorieController {

	@Autowired(required=false)
	public IService<Categorie> categorieSrv;
	
	private Path path;
	
	public IService<Categorie> getCategorieSrv() {
		return categorieSrv;
	}
	public void setCategorieSrv(IService<Categorie> categorieSrv) {
		this.categorieSrv = categorieSrv;
	}

	@RequestMapping(path="/nouveau",method=RequestMethod.GET)
	public ModelAndView addCategorie(Model model) {
		ModelAndView mv=new ModelAndView("espace-commercial/nouveau_categorie","categorie",new Categorie());
		return mv;
	}
	
	@RequestMapping(path="/getCategories",method=RequestMethod.GET)
	public String getCategories(Model model){
		
		List<Categorie> categories=categorieSrv.selectAll();
		
		model.addAttribute("categorie",new Categorie());
		model.addAttribute("categories", categories);
		return "espace-commercial/list_categorie";
		
	}
	
	@RequestMapping(path="/get")
	@ResponseBody 
	public String getCategorie(@RequestParam(name="id")String id,Model model){
		
		Categorie categorie=categorieSrv.getById(Long.parseLong(id));
		ObjectMapper mapper = new ObjectMapper();
		String json = "";
		try {
			json = mapper.writeValueAsString(categorie);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return json;
		
	}
	
	@RequestMapping(path="/edit")
	public String editCategorie(Categorie categorie,Model model,HttpServletRequest request){
		
		String response="";
		if(categorie.getId()!=null){
			MultipartFile categorieImage = categorie.getCategorieImage();
			String rootDirectory = request.getSession().getServletContext().getRealPath("/");
			
			System.out.println("Root Directory :"+rootDirectory);
			
			path = Paths.get(rootDirectory + "/resources/uploaded/categorie/" +categorie.getId() + ".png");
			
			// check whether image exists or not
			if (categorieImage != null && !categorieImage.isEmpty()) {
				try {
					// convert the image type to png
					categorieImage.transferTo(new File(path.toString()));
				} catch (IllegalStateException | IOException e) {
					// oops! something did not work as expected
					e.printStackTrace();
					throw new RuntimeException("Saving Categorie image was not successful", e);
				}
			}
	        Categorie categorieUpdated=categorieSrv.update(categorie);
	        response="success";
	        model.addAttribute("response_update", response);
		}
        
		return "redirect:/categorie/getCategories";
	}
	
	@RequestMapping(path="/delete")
	public String deleteCategorie(@RequestParam(name="id")String id,Model model){
		String response;
		
		try{
			categorieSrv.remove(Long.parseLong(id));
			response="success";
			model.addAttribute("response_delete",response);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
		return "redirect:/categorie/getCategories";
	}
	
	
	@RequestMapping(path="/enregistrer",method=RequestMethod.POST)
	public String saveCategorie(Model model,Categorie categorie,HttpServletRequest request) {
		
		// get the provided image from the form
		MultipartFile categorieImage = categorie.getCategorieImage();
		
		Categorie categorieSaved=categorieSrv.save(categorie);
		
		// get root directory to store the image
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		
		System.out.println("Root Directory :"+rootDirectory);
		
		path = Paths.get(rootDirectory + "/resources/uploaded/categorie/" +categorie.getId() + ".png");
		
		// check whether image exists or not
		if (categorieImage != null && !categorieImage.isEmpty()) {
			try {
				// convert the image type to png
				categorieImage.transferTo(new File(path.toString()));
			} catch (IllegalStateException | IOException e) {
				// oops! something did not work as expected
				e.printStackTrace();
				throw new RuntimeException("Saving Categorie image was not successful", e);
			}
		}
		
		return "redirect:/categorie/nouveau";
		
	}
}
