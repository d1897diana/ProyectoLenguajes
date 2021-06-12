package cr.ac.ucr.ProyectoHotelero.service;

import java.util.List;

import cr.ac.ucr.ProyectoHotelero.model.CanchaDeportiva;

public interface ICanchaDeportivaService {
	List<CanchaDeportiva> BuscarTodas();
	CanchaDeportiva BuscarUno(int codigo_servicio);
	void NuevaCanchaDeportiva(CanchaDeportiva canchaDeport);
	void ModificarCanchaDeportiva(CanchaDeportiva canchaDeport);
	void EliminarCanchaDeportiva(int codigo_servicio);
}
