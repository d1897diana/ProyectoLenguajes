package cr.ac.ucr.ProyectoHotelero.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cr.ac.ucr.ProyectoHotelero.model.Clientes;
import cr.ac.ucr.ProyectoHotelero.repository.ClienteRepository;




@Service
public class ClienteServiceImp implements IClienteService {
	
	@Autowired
	private ClienteRepository repo;
	
	
	@Override
	public List<Clientes> listarClientes() {
		return (List<Clientes>) repo.findAll();
	}
	
	@Override
	public void registrar(Clientes cliente) {
		repo.save(cliente);

	}

	

	@Override
	public void eliminar(Clientes cliente) {
		repo.delete(cliente);
	}



	@Override
	public void guardarModificacion(Clientes cliente) {
		repo.save(cliente);

	}

	@Override
	public Clientes modificar(int cedula) {
		return repo.findById(cedula).get();
	}
	
	@Override
	public Clientes getCliente(int cedula) {
		return repo.findById(cedula).get();
	}

	

}
