package org.iiiedu.eeit131.controller;

import org.iiiedu.eeit131.model.Cat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BaseController {
	
	private static Logger log = LoggerFactory.getLogger(BaseController.class);
	
	@Autowired  // DI: Dependency Injection
	Cat kitty;
	
	@GetMapping({"/", "/index"})
	public  String home(Model model) {
		log.info("home()方法執行中");
		model.addAttribute("myKitty", kitty.toString());
		return "index";         
	}
	
	@GetMapping({"/hello", "/des/sdsd/asa"})
	public  String hello(
			@RequestParam(value="name", required = false) String visitor,
			Model model
			) {
		String message = visitor != null ? visitor + " 您好" : "訪客，您好";
		model.addAttribute("helloMessage", message);
		return "greeting";
	}
	
}
