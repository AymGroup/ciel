package web;

import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamSource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;

import models.Categorie;
import models.Message;
import models.User;
import service.IService;

@Controller
@RequestMapping(path="/email")
public class EmailController {

	@Autowired
	private IService<Message> messageSrv;
	
	public IService<Message> getMessageSrv() {
		return messageSrv;
	}
	public void setMessageSrv(IService<Message> messageSrv) {
		this.messageSrv = messageSrv;
	}
	@Autowired
	private JavaMailSender mailSenderObj;
	
	static String emailToRecipient, emailSubject, emailMessage;
	static final String emailFromRecipient = "mankari.aymen1@gmail.com";

	static ModelAndView modelViewObj;
	
	@RequestMapping(path="/show",method=RequestMethod.GET)
	public ModelAndView showEmailForm(){
		modelViewObj=new ModelAndView("espace-commercial/mail","message",new Message());
		return modelViewObj;
	}
	
	@RequestMapping(path="/sendEmail",method=RequestMethod.POST)
	public ModelAndView sendEmail(HttpServletRequest request,Message message, final @RequestParam CommonsMultipartFile attachFileObj,HttpSession session){
		// Logging The Email Form Parameters For Debugging Purpose
		System.out.println("\nReceipient?= " + message.getRecipient() + ", Subject?= " + message.getSubject() + ", Message?= " + message.getBody() + "\n");

				mailSenderObj.send(new MimeMessagePreparator() {
					public void prepare(MimeMessage mimeMessage) throws Exception {

						MimeMessageHelper mimeMsgHelperObj = new MimeMessageHelper(mimeMessage, true, "UTF-8");				
						mimeMsgHelperObj.setTo(message.getRecipient());
						mimeMsgHelperObj.setFrom(emailFromRecipient);				
						mimeMsgHelperObj.setText(message.getBody());
						mimeMsgHelperObj.setSubject(message.getSubject());

						// Determine If There Is An File Upload. If Yes, Attach It To The Client Email				
						if ((attachFileObj != null) && (attachFileObj.getSize() > 0) && (!attachFileObj.equals(""))) {
							System.out.println("\nAttachment Name?= " + attachFileObj.getOriginalFilename() + "\n");
							mimeMsgHelperObj.addAttachment(attachFileObj.getOriginalFilename(), new InputStreamSource() {					
								public InputStream getInputStream() throws IOException {
									return attachFileObj.getInputStream();
								}
							});
						} else {
							System.out.println("\nNo Attachment Is Selected By The User. Sending Text Email!\n");
						}
					}
				});
				System.out.println("\nMessage Send Successfully.... Hurrey!\n");
				
				User u=(User) session.getAttribute("userLoged");
				message.setSender(emailFromRecipient);
				message.setUser(u);
				messageSrv.save(message);
				//List<Message> messages=messageSrv.selectAll();
				//modelViewObj = new ModelAndView("espace-commercial/list_mail","response","OK");
				//modelViewObj.addObject("messages", messages);
				
				modelViewObj = new ModelAndView("redirect:/email/showAll","response","OK");
				return  modelViewObj;	
	}
	
	@RequestMapping(path="/showAll",method=RequestMethod.GET)
	public ModelAndView showListEmails(){
		List<Message> messages=messageSrv.selectAll();
		modelViewObj=new ModelAndView("espace-commercial/list_mail","messages",messages);
		return modelViewObj;
		
	}
	
	@RequestMapping(path="/get")
	@ResponseBody 
	public String getMail(@RequestParam(name="id")String id,Model model){
		Message message=messageSrv.getById(Long.parseLong(id));
		
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		String stringDate = df.format(message.getSendDate());
		
		ObjectMapper mapper = new ObjectMapper();
		String json = "";
		try {
			String d=mapper.writeValueAsString(stringDate);
			json = mapper.writeValueAsString(message);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return json;
	}
}
