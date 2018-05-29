package web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import models.Vehicule;

@Controller
@RequestMapping(path="/vehicule")
public class VehiculeController {

	@RequestMapping(path="/nouveau",method=RequestMethod.GET)
	public ModelAndView showForm(){
		ModelAndView mv=new ModelAndView("espace-commercial/nouveau_vehicule");
		mv.addObject("vehicule", new Vehicule());
		return mv;
	}
}
