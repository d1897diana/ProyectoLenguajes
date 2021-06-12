package cr.ac.ucr.ProyectoHotelero.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import cr.ac.ucr.ProyectoHotelero.model.Hotel;
import cr.ac.ucr.ProyectoHotelero.service.IHotelService;

@Controller
@RequestMapping("/hotel")
public class HotelController {
	
	@Autowired
	private IHotelService service;
	
	@GetMapping("/agregar_hotel")
	public String agregar() {
		return "/hotel/agregar_hotel";
	}
	
	@GetMapping("/sin_datos")
	public String noHayDatos() {
		return "/hotel/no_hay_hoteles";
	}
	
	@GetMapping("/guardar")
	public String form(Model model) {
		model.addAttribute("hotel",new Hotel());
		return "/hotel/agregar_hotel";
	}
	
	@PostMapping("/guardar")
	public String guardar(@RequestParam(name = "file", required = false)MultipartFile foto, Hotel hotel) {
		if(!foto.isEmpty()){
			try {
				String ruta = "C://Users//charlylen//Documents//workspace-spring-tool-suite-4-4.10.0.RELEASE//ProyectoHotelero//src//main//resources//static//imagenes";
				byte[] bytes = foto.getBytes();
				Path rutaAbsoluta = Paths.get(ruta + "//" + foto.getOriginalFilename());
				Files.write(rutaAbsoluta, bytes);
				hotel.setImagen_hotel(foto.getOriginalFilename());
				
				System.out.println(hotel.getProvincia());
				
				service.registrar(hotel);
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
		return "redirect:/hotel/guardar";
	}
	
	@GetMapping("/buscar/{busqueda}")
	public String buscar(@PathVariable String busqueda, Model modelo) {
		List<Hotel> lista_hoteles = new LinkedList();
		lista_hoteles = service.buscarDireccion(busqueda);
		modelo.addAttribute("hoteles", lista_hoteles);
		return "/hotel/busqueda_hotel";
	}
	
	@GetMapping("/buscarT")
	public String buscarTodos(Model modelo) {
		List<Hotel> lista_hoteles = new LinkedList();
		lista_hoteles = service.buscarTodos();
		modelo.addAttribute("hoteles", lista_hoteles);
		return "/hotel/busqueda_hotel";
	}
	
	@GetMapping("/listar_hoteles")
	public String listar(Model modelo) {
		List<Hotel> lista_hoteles = new LinkedList();
		lista_hoteles = service.buscarTodos();		
		if(lista_hoteles.isEmpty()) {
			return "redirect:/hotel/sin_datos";
		}else {
			modelo.addAttribute("hoteles", lista_hoteles);
			return "/hotel/ver_hoteles";	
		}
	}
	
	@GetMapping("/editar/{id}")
	public String editar(@PathVariable int id, Model modelo) {
		Optional<Hotel> hotel = service.buscarId(id);
		modelo.addAttribute("hotel", hotel);
		return "/hotel/modificar_hotel";
	}
	
	@PostMapping("/modificar")
	public String modificar(@RequestParam(name = "file", required = false)MultipartFile foto, Hotel hotel) {
		if(!foto.isEmpty()){
			try {
				String ruta = "C://Users//charlylen//Documents//workspace-spring-tool-suite-4-4.10.0.RELEASE//ProyectoHotelero//src//main//resources//static//imagenes";
				byte[] bytes = foto.getBytes();
				Path rutaAbsoluta = Paths.get(ruta + "//" + foto.getOriginalFilename());
				Files.write(rutaAbsoluta, bytes);
				hotel.setImagen_hotel(foto.getOriginalFilename());	
				System.out.println(hotel.getProvincia());
				//service.modificar(hotel);
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
		return "redirect:/hotel/listar_hoteles";
	}
	
	@GetMapping("/eliminar/{id}")
	public String delete(@PathVariable int id) {
		service.eliminar(id);
		return "redirect:/hotel/listar_hoteles";
	}
}
