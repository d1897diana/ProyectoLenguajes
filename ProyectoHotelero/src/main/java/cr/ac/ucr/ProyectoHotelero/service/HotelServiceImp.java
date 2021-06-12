package cr.ac.ucr.ProyectoHotelero.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cr.ac.ucr.ProyectoHotelero.model.Hotel;
import cr.ac.ucr.ProyectoHotelero.repository.HotelRepository;

@Service
public class HotelServiceImp implements IHotelService {

	@Autowired
	private HotelRepository repo;
	
	@Override
	public List<Hotel> getHoteles() {
		return (List<Hotel>) repo.findAll();
	}

	@Override
	public Hotel getHotel(int id) {
		return (Hotel) repo.findById(id).get();
	}
	
	@Override
	public void registrar(Hotel hotel) {
		repo.save(hotel);
	}

	@Override
	public void eliminar(int id_hotel) {
		repo.deleteById(id_hotel);
	}

	@Override
	public void modificar(Hotel hotel) {
		Optional<Hotel> optional = repo.findById(hotel.getId_hotel());
		if(optional.isPresent()) {
			Hotel hotelTmp = optional.get();
			hotelTmp.setImagen_hotel(hotel.getImagen_hotel());
			hotelTmp.setDireccion(hotel.getDireccion());
			hotelTmp.setPais(hotel.getPais());
			hotelTmp.setProvincia(hotel.getProvincia());
			hotelTmp.setCorreo(hotel.getCorreo());
			hotelTmp.setTelefono(hotel.getTelefono());
			repo.save(hotelTmp);
		}
	}

	@Override
	public Optional<Hotel> buscarId(int id_hotel) {
		Optional<Hotel> hotel = repo.findById(id_hotel);
		return hotel;
	}

	@Override
	public List<Hotel> buscarDireccion(String direccion) {
		List<Hotel> lista_direccion = (List<Hotel>) repo.findByDireccionContaining(direccion);
		//LinkedList<Hotel> lista_provincia = (LinkedList<Hotel>) repo.findByProvinciaContaining(direccion);
		//LinkedList<Hotel> lista_pais = (LinkedList<Hotel>) repo.findByPaisContaining(direccion);
		//LinkedList<Hotel> lista_hotel = null;
		return lista_direccion;
	}

	@Override
	public List<Hotel> buscarTodos() {
		return (List<Hotel>) repo.findAll();
	}
}
