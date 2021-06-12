package cr.ac.ucr.ProyectoHotelero.negocio;

import java.util.List;
import cr.ac.ucr.ProyectoHotelero.model.Habitacion;

public class Logica {
	public boolean sortHabitaciones(List<Habitacion> habitaciones, int id_hotel, int id_habitacion){
		for(Habitacion h : habitaciones) {
			if(h.getHotel().getId_hotel() == id_hotel && h.getNumero() == id_habitacion) {
				return false;
			}
		}
		return true;
	}
	
	public int getCantHabitaciones(List<Habitacion> habitaciones, int id_hotel) {
		int cont = 0;
		for (Habitacion i : habitaciones) {
			if(i.getHotel().getId_hotel() == id_hotel && i.getNumero() > cont) {
				cont = i.getNumero();
			}
		}
		return cont+1;
	}
}
