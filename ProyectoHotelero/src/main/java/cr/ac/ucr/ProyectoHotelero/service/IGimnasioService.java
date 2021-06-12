package cr.ac.ucr.ProyectoHotelero.service;

import java.util.List;

import cr.ac.ucr.ProyectoHotelero.model.Gimnasio;

public interface IGimnasioService {
	List<Gimnasio> getGimnasios();
	Gimnasio getGimnasio(int codigo_servicio);
	void guardarGimnasio(Gimnasio gimnasio);
	void ModificarGimnasio(Gimnasio gimnasio);
	void EliminarGimnasio(int codigo_servicio);

}
