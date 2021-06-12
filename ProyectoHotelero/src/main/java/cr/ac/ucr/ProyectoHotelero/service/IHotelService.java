package cr.ac.ucr.ProyectoHotelero.service;

import java.util.List;
import java.util.Optional;

import cr.ac.ucr.ProyectoHotelero.model.Hotel;

public interface IHotelService {
	public List<Hotel> getHoteles();
	public Hotel getHotel(int id);
	public void registrar(Hotel hotel);
	public void eliminar(int id_hotel);
	public void modificar(Hotel hotel);
	public Optional<Hotel> buscarId(int id_hotel);
	public List<Hotel> buscarDireccion(String direccion);
	public List<Hotel> buscarTodos();
}
 