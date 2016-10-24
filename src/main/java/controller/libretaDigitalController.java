package controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import entities.ClassDayProfessor;
import entities.ClassDayStudent;

/*
 * author: 
 * 
 */

@Controller
public class LibretaDigitalController {
	
	@RequestMapping("/")
	public ModelAndView index() { 
		
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("tituloPagina", "INDEX");
		
		return mv;
	}
	
	@RequestMapping("/welcome")
	public ModelAndView helloWorld() {
					
		String message = "<br><div style='text-align:center;'>"
				+ "<h3>********** Hello World, Spring MVC Tutorial</h3>This message is coming from HelloWorld.java **********</div><br><br>";
		ModelAndView mv = new ModelAndView("welcome", "message", message);
		mv.addObject("tituloPagina", "WELCOME");
		
		ClassDayProfessor aux = new ClassDayProfessor();
		aux.setOid((long) 1);
		aux.setDate(new Date());
		mv.addObject("objeto", aux);
		
		return mv;
	}
	

}
