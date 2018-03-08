package mvc_controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	
	
	@Autowired
	 
	@RequestMapping("/index.do")
	public String IndexCon ()	{
		
		return "index/index";
		
	}
	
	

}
