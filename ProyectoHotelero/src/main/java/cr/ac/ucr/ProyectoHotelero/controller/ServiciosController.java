package cr.ac.ucr.ProyectoHotelero.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class ServiciosController {
	@GetMapping("/servicios")
	public String Servicios() {
		return "servicios";
	}
}
