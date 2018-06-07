package web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import models.OptionReservation;
import models.Pack;
import service.IService;

@Controller
@RequestMapping(path="/pack")
public class PackController {
	
	@Autowired
	public IService<Pack> packSrv;
	
	public IService<Pack> getPackSrv() {
		return packSrv;
	}
	public void setPackSrv(IService<Pack> packSrv) {
		this.packSrv = packSrv;
	}

	@RequestMapping(path="/nouveau",method=RequestMethod.GET)
	public ModelAndView showPackForm(Model model) {
		ModelAndView mv=new ModelAndView("espace-commercial/nouveau_pack","pack",new Pack());
		return mv;
	}
	
	@RequestMapping(path="/enregistrer",method=RequestMethod.POST)
	public String addPack(Model model,Pack pack) {
		String response;
		Pack packSaved=packSrv.save(pack);
		
		if(packSaved!=null){
			System.out.println("# Pack saved !");
			response="success";
			model.addAttribute("response_insert", response);
			return "redirect:/pack/getPacks";
		}
		response="error";
		return "redirect:/pack/nouveau";
	}

}
