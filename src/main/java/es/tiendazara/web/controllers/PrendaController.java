package es.tiendazara.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import es.tiendazara.web.entities.Prenda;
import es.tiendazara.web.services.prenda.PrendaService;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping(value={"/","/prenda"})
public class PrendaController {
	@Autowired	
	PrendaService servicio ; 
	
	@GetMapping
	public String paginaDepartamentos(Model model) throws Exception {
		log.info("[paginaDepartamentos]");
		List<Prenda> prendas  = servicio.listarTodasLasPrendas();
		
		model.addAttribute("prendas", prendas);	
		return "prenda";
	}
	
	@GetMapping("/{id}")
	public String paginaDepartamento(@PathVariable Integer id,Model model) throws Exception {
		log.info("[paginaDepartamento]");
		log.debug("[id:"+id+"]");
		Prenda prenda = servicio.get(id);
		
		model.addAttribute("prenda", prenda);	
		return "prenda";
	}
	


}
