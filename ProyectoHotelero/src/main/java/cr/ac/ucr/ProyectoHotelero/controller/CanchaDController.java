package cr.ac.ucr.ProyectoHotelero.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import cr.ac.ucr.ProyectoHotelero.model.CanchaDeportiva;
import cr.ac.ucr.ProyectoHotelero.model.Hotel;
import cr.ac.ucr.ProyectoHotelero.service.ICanchaDeportivaService;
import cr.ac.ucr.ProyectoHotelero.service.IHotelService;

@Controller
@RequestMapping(value = "/canchaDeportiva")
public class CanchaDController {
	
	@Autowired
	private ICanchaDeportivaService serviceCanchaDeport;
	@Autowired
	private IHotelService serviceHotel;
	
	@RequestMapping(value = "guardar", method = RequestMethod.POST)
	public String guardarCancha(@RequestParam("detalle") String detalle, @RequestParam("precio") int precio,
			@RequestParam("hotel") int cod_hotel) {
		Hotel hotel = new Hotel();
		hotel = serviceHotel.getHotel(cod_hotel);
		CanchaDeportiva cancha = new CanchaDeportiva(detalle,precio,hotel);
		serviceCanchaDeport.NuevaCanchaDeportiva(cancha);
		return "redirect:/canchaDeportiva/listaCancha";
	}

	@RequestMapping(value = "listaCancha", method = RequestMethod.GET)
	public String mostrarListaCancha(Model model) {
		List<CanchaDeportiva> lista = serviceCanchaDeport.BuscarTodas();
		model.addAttribute("cancha", lista);		
		List<Hotel> listaH = serviceHotel.getHoteles();
		Map<Integer, String> map = new HashMap<Integer, String>();
		for (Hotel c : listaH) {
			map.put(c.getId_hotel(), c.getProvincia());
		}
		model.addAttribute("hotel", map);
		return "/canchaDeportiva/listaCanchasD";
	}

	@RequestMapping(value = "editarCancha", method = RequestMethod.GET)
	public String mostrarCancha(Model model, @RequestParam("codigo_servicio") int codigo_servicio) {
		CanchaDeportiva cancha = serviceCanchaDeport.BuscarUno(codigo_servicio);
		model.addAttribute("cancha", cancha);
		List<Hotel> listaH = serviceHotel.getHoteles();
		Map<Integer, String> map = new HashMap<Integer, String>();
		for (Hotel c : listaH) {
			map.put(c.getId_hotel(), c.getProvincia());
		}
		model.addAttribute("hotel", map);
		return "canchaDeportiva/editCanchasD";
	}

	@RequestMapping(value = "guardarEdit", method = RequestMethod.POST)
	public String guardarEditCancha(@RequestParam("codigo_servicio") int codigo_servicio,
			@RequestParam("detalle") String detalle, @RequestParam("precio") int precio,
			@RequestParam("hotel") int id_hotel) {
		CanchaDeportiva canchaDeportiva = new CanchaDeportiva(codigo_servicio, detalle, precio, new Hotel(id_hotel,""));
		serviceCanchaDeport.ModificarCanchaDeportiva(canchaDeportiva);
		return "redirect:/canchaDeportiva/listaCancha";
	}

	@RequestMapping(value = "eliminar", method = RequestMethod.GET)
	public String eliminarCancha(@RequestParam("codigo_servicio") int codigo_servicio) {
		serviceCanchaDeport.EliminarCanchaDeportiva(codigo_servicio);
		return "redirect:/canchaDeportiva/listaCancha";
	}
}
