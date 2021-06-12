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

import cr.ac.ucr.ProyectoHotelero.model.Gimnasio;
import cr.ac.ucr.ProyectoHotelero.model.Hotel;
import cr.ac.ucr.ProyectoHotelero.service.IGimnasioService;
import cr.ac.ucr.ProyectoHotelero.service.IHotelService;

@Controller
@RequestMapping(value = "/gimnasio")
public class GimnasioController {

	@Autowired
	private IGimnasioService serviceGimn;
	@Autowired
	private IHotelService serviceHotel;

	@RequestMapping(value = "guardar", method = RequestMethod.POST)
	public String guardarGimnasio(@RequestParam("equipo") String equipo, @RequestParam("precio") int precio,
			@RequestParam("hotel") int cod_hotel) {
		Hotel hotel = new Hotel();
		hotel = serviceHotel.getHotel(cod_hotel);
		Gimnasio gimnasio = new Gimnasio(equipo, precio, hotel);
		serviceGimn.guardarGimnasio(gimnasio);
		return "redirect:/gimnasio/listaGimnasio";
	}

	@RequestMapping(value = "listaGimnasio", method = RequestMethod.GET)
	public String mostrarTabla(Model model) {
		List<Gimnasio> lista = serviceGimn.getGimnasios();
		model.addAttribute("gimnasio", lista);
		List<Hotel> listaH = serviceHotel.getHoteles();
		Map<Integer, String> map = new HashMap<Integer, String>();
		for (Hotel c : listaH) {
			map.put(c.getId_hotel(), c.getProvincia());
		}
		model.addAttribute("hotel", map);
		return "gimnasio/listaGimnasios";
	}

	@RequestMapping(value = "editarGimnasio", method = RequestMethod.GET)
	public String mostrarGimnasio(Model model, @RequestParam("codigo_servicio") int codigo_servicio) {
		Gimnasio gimnasio = serviceGimn.getGimnasio(codigo_servicio);
		model.addAttribute("gimnasio", gimnasio);
		List<Hotel> lista = serviceHotel.getHoteles();
		Map<Integer, String> map = new HashMap<Integer, String>();
		for (Hotel c : lista) {
			map.put(c.getId_hotel(), c.getProvincia());
		}
		model.addAttribute("hotel", map);
		return "gimnasio/editGimnasio";
	}

	@RequestMapping(value = "guardarEdit", method = RequestMethod.POST)
	public String guardarEditGimnasio(@RequestParam("codigo_servicio") int codigo_servicio,
			@RequestParam("equipo") String equipo, @RequestParam("precio") int precio,
			@RequestParam("hotel") int id_hotel) {
		Gimnasio gimnasio = new Gimnasio(codigo_servicio,equipo,precio,new Hotel(id_hotel,""));
		serviceGimn.ModificarGimnasio(gimnasio);
		return "redirect:/gimnasio/listaGimnasio";
	}

	@RequestMapping(value = "eliminar", method = RequestMethod.GET)
	public String eliminarGimnasio(@RequestParam("codigo_servicio") int codigo_servicio) {
		serviceGimn.EliminarGimnasio(codigo_servicio);
		return "redirect:/gimnasio/listaGimnasio";
	}

}
