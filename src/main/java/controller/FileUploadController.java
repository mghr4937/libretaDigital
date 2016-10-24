package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class FileUploadController {

	
	@RequestMapping("/fileUpload")
	public ModelAndView fileUpload() {
					
		ModelAndView mv = new ModelAndView("fileUpload");
		mv.addObject("tituloPagina", "Carga de Datos");
		
//		ClassDayProfessor aux = new ClassDayProfessor();
//		aux.setOid((long) 1);
//		aux.setDate(new Date());
//		mv.addObject("objeto", aux);
		
		return mv;
	}
}
