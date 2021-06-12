package cr.ac.ucr.ProyectoHotelero.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cr.ac.ucr.ProyectoHotelero.model.Gimnasio;
import cr.ac.ucr.ProyectoHotelero.repository.GimnasioRepository;

@Service
public class GimnasioServiceImp implements IGimnasioService {

	@Autowired
	private GimnasioRepository gimnRepo;
	
	@Override
	public List<Gimnasio> getGimnasios() {
		List<Gimnasio> listGimnasio = gimnRepo.findAll();
		return listGimnasio;
	}

	@Override
	public void guardarGimnasio(Gimnasio gimnasio) {
		gimnRepo.save(gimnasio);
	}
	

	@Override
	public Gimnasio getGimnasio(int codigo_servicio) {
		List<Gimnasio> gimnasios = gimnRepo.findAll();
		Gimnasio gimnasio = new Gimnasio();
		for(Gimnasio gim: gimnasios) {
			if(gim.getCodigo_servicio() == codigo_servicio) {
				gimnasio=gim;
			}
		}
		return gimnasio;
	}

	@Override
	public void ModificarGimnasio(Gimnasio gimnasio) {
		Optional<Gimnasio> opcional = gimnRepo.findById(gimnasio.getCodigo_servicio());
		if (opcional.isPresent()) {
			Gimnasio gim = opcional.get();
			gim.setHotel(gimnasio.getHotel());
			gim.setEquipo(gimnasio.getEquipo());
			gim.setPrecio(gimnasio.getPrecio());
			gimnRepo.save(gim);
		}

	}

	@Override
	public void EliminarGimnasio(int codigo_servicio) {
		gimnRepo.deleteById(codigo_servicio);
	}


}
