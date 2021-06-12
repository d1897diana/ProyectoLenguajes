package cr.ac.ucr.ProyectoHotelero.controller;

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

import cr.ac.ucr.ProyectoHotelero.model.Clientes;
import cr.ac.ucr.ProyectoHotelero.service.ClienteServiceImp;




@Controller
@RequestMapping("/clientes")
public class ClienteController {
	
	@Autowired
	private ClienteServiceImp clienteService;
	
	@GetMapping("/")
	public String mostrar_lista(Model modelo) {
		
		List<Clientes> lista = clienteService.listarClientes();
		modelo.addAttribute("clientes", lista);
		return "/cliente/tabla";
	}
	
	@RequestMapping("/registrar")
	public String registrar(){
		
		
		return "/cliente/insertar";
	}
	
	@PostMapping("/guardarRegistrar")
	public String guardarRegistro(@ModelAttribute Clientes cliente, Model modelo) {
		
		clienteService.registrar(cliente);
		List<Clientes> lista = clienteService.listarClientes();
		modelo.addAttribute("clientes", lista);
		return "/cliente/tabla";
	}
	
	@GetMapping("/modificar/{cedula}")
	public String modificar(@PathVariable("cedula") int cedula, Model modelo) {
		Clientes clientes = clienteService.modificar(cedula);
		
		modelo.addAttribute("clientes", clientes);
		
		return "cliente/editar";
	}
	
	@PostMapping("/guardarEditar")
	public String guardarEditar(@ModelAttribute Clientes cliente,  Model modelo) {
		
		clienteService.guardarModificacion(cliente);
		

		List<Clientes> lista = clienteService.listarClientes();
		modelo.addAttribute("clientes", lista);
		return "/cliente/tabla";
	}
	
	@GetMapping("/eliminar/{cedula}")
	public String eliminar(@PathVariable("cedula") int cedula, Model modelo) {
		clienteService.eliminar(clienteService.getCliente(cedula));
		List<Clientes> lista = clienteService.listarClientes();
		modelo.addAttribute("clientes", lista);
		return "/cliente/tabla";
	}

}
