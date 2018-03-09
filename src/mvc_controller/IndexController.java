package mvc_controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import mvc_service.JoinService;

@Controller
public class IndexController {
	
	
	@Autowired
	JoinService joinService;
	 
	@RequestMapping("/index.do")
	public String IndexCon ()	{
		
		return "index/index";
		
	}
	@RequestMapping(path="/authmail.do",produces="application/json;charset=utf-8")
	@ResponseBody
	public String MailCont (@RequestParam String email)	{
		
		boolean result = joinService.sendAuthEmail(email);
		
		return "{\"result\":"+result+"}";
		
	}
	
	

}
