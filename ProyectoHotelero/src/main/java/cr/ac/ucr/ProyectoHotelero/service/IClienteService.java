package cr.ac.ucr.ProyectoHotelero.service;

import java.util.List;

import cr.ac.ucr.ProyectoHotelero.model.Clientes;




public interface IClienteService {
	
	List<Clientes> listarClientes();
	void registrar(Clientes cliente);
	Clientes modificar(int cedula);
	void guardarModificacion(Clientes cliente);
	void eliminar(Clientes cliente);
	Clientes getCliente(int cedula);

}
