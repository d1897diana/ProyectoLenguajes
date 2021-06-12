package cr.ac.ucr.ProyectoHotelero.controller;

import java.util.LinkedList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import cr.ac.ucr.ProyectoHotelero.model.Habitacion;
import cr.ac.ucr.ProyectoHotelero.negocio.Logica;
import cr.ac.ucr.ProyectoHotelero.service.HabitacionServiceImp;
import cr.ac.ucr.ProyectoHotelero.service.HotelServiceImp;

@Controller
@RequestMapping("/habitaciones")
public class HabitacionController {
	
	@Autowired
	private HotelServiceImp hotelI;
	@Autowired
	private HabitacionServiceImp habita;
	
	private List<String> tipos = new LinkedList<String>();
	
	
	@RequestMapping("/")
	public String mostrar(Model modelo) {
		List<Habitacion> habitaciones = habita.getHabitaciones();
		modelo.addAttribute("habitaciones", habitaciones);
		
		return "/habitacion/mostrar";
	}
	@RequestMapping("/reg")
	public String registrar(Model modelo){
		
		guardarTipos();
		modelo.addAttribute("hoteles", hotelI.getHoteles());
		modelo.addAttribute("tipos", tipos);
		return "/habitacion/registrar";
	}

	@PostMapping("/guardarRegistrar")
	public String guardar(@ModelAttribute Habitacion habitacion, @RequestParam int hotel, Model modelo) {
		Logica log = new Logica();
		List<Habitacion> habitaciones = habita.getHabitaciones();
		boolean agrega = log.sortHabitaciones(habitaciones, hotel, habitacion.getNumero());
		
		if(agrega) {
			int id_habitacion = log.getCantHabitaciones(habitaciones, hotel);
			habitacion.setHotel(hotelI.getHotel(hotel));
			habitacion.setNumero(id_habitacion);
			habita.guardar(habitacion);
				
			modelo.addAttribute("hoteles", hotelI.getHoteles());
			modelo.addAttribute("tipos", tipos);
			modelo.addAttribute("valor", "Se ha guardado correctamente");
			
		}else {
			System.out.println("no agrega");
		}
		return "/habitacion/registrar";
	}
	
	@PostMapping("/guardarEditar")
	public String guardarE(@ModelAttribute Habitacion habitacion1,int hotel,int id_hab,  Model modelo) {
		habitacion1.setNumero(id_hab);
		Habitacion h = habita.getHabitacion(id_hab);
		h.setDetalle(habitacion1.getDetalle());
		h.setPrecio(habitacion1.getPrecio());
		h.setTipo(habitacion1.getTipo());
		
		habita.guardar(h);
		modelo.addAttribute("habitaciones", habita.getHabitaciones());
		return "habitacion/mostrar";
	}
	
	
	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable("id") int id, Model modelo) {
		habita.eliminar(habita.getHabitacion(id));
		modelo.addAttribute("habitaciones", habita.getHabitaciones());
		return "/habitacion/mostrar";
	}
	
	@GetMapping("/modificar/{id}")
	public String modificar(@PathVariable("id") int id, Model modelo) {
		Habitacion h = habita.getHabitacion(id);
		System.out.println(h.getDetalle());
		guardarTipos();
		modelo.addAttribute("hab", h);
		modelo.addAttribute("tipos", tipos);
		modelo.addAttribute("hotel", hotelI.getHotel(h.getHotel().getId_hotel()));
		return "habitacion/modificar";
	}
	
	private void guardarTipos() {
		if(tipos.isEmpty()) {
			tipos.add("Normal");
			tipos.add("Doble");
			tipos.add("Suit");
			tipos.add("Presidencial");
		}
	}
}
