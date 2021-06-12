package cr.ac.ucr.ProyectoHotelero.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cr.ac.ucr.ProyectoHotelero.model.Habitacion;
import cr.ac.ucr.ProyectoHotelero.repository.HabitacionRepository;

@Service
public class HabitacionServiceImp implements IHabitacionService {

	@Autowired
	private HabitacionRepository repo;

	@Override
	public List<Habitacion> getHabitaciones() {
		return (List<Habitacion>) repo.findAll();
	}

	@Override
	public void guardar(Habitacion habitacion) {
		repo.save(habitacion);
	}

	@Override
	public void eliminar(Habitacion h) {
		repo.delete(h);
	}

	@Override
	public void registrar(Habitacion habitacion) {
		// TODO Auto-generated method stub

	}

	@Override
	public void modificar(Habitacion habitacion) {
		// TODO Auto-generated method stub

	}

	@Override
	public Habitacion getHabitacion(int id) {
		return repo.findById(id).get();
	}

}
