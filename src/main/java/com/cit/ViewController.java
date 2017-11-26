package com.cit;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {
	
	@RequestMapping("/")
	public String index() {
		
		
		return "index";
	}
	
	@RequestMapping("/about")
	public String about() {
		
		
		return "about";
	}

}
