package es.tiendazara.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PrendaController {

	@RequestMapping("/prenda")
	public String miMetodo() {
		return "prenda";
	}
	
	// Login form with error
	  @RequestMapping("/prendaError")
	  public String loginError(Model model) {
	    model.addAttribute("loginError", true);
	    return "prenda";
	  }
	  
	  @RequestMapping("/accesoDenegado")
		public String accessDenied() {
			return "accesoDenegado";
	  }
	  

}
