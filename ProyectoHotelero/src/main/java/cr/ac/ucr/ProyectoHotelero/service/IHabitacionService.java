package cr.ac.ucr.ProyectoHotelero.service;

import java.util.List;

import cr.ac.ucr.ProyectoHotelero.model.Habitacion;

public interface IHabitacionService {
	public List<Habitacion> getHabitaciones();
	public Habitacion getHabitacion(int id);
	public void guardar(Habitacion habitacion);
	public void registrar(Habitacion habitacion);
	public void modificar(Habitacion habitacion);
	public void eliminar(Habitacion h);
}
