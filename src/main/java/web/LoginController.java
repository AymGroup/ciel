package web;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionAttributeStore;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.WebRequest;

import models.User;
import service.IService;
import service.UserServiceImpl;

@Controller
@SessionAttributes(names="userLoged")
public class LoginController {
	
	private UserServiceImpl userSrv=new UserServiceImpl();

	@RequestMapping(path="/login",method=RequestMethod.GET)
	public String showLogin(Model model){
		model.addAttribute("user", new User());
		return "espace-commercial/login";
	}
	
	@RequestMapping(path="/authentifier",method=RequestMethod.POST)
	public String authentifier(Model model,User u){
		User userLoged=userSrv.CheckUser(u);
		if(userLoged!=null){
			model.addAttribute("userLoged", userLoged);
			return "redirect:/dashboard/show";
		}
		return "redirect:/login";
	}
	
	@RequestMapping(path="/dashboard",method=RequestMethod.GET)
	public String redirectToHomePage(HttpSession session){
		User u=(User) session.getAttribute("userLoged");
		System.out.println("User loged : "+u.getLogin());
		return "espace-commercial/dashboard";
	}
	
	@RequestMapping(path="/logout")
	public String logOut(WebRequest request, SessionStatus status,HttpSession session){
		status.setComplete();
	    //store.cleanupAttribute(request, "userLoged");
	    return "redirect:/login";
	}
}
