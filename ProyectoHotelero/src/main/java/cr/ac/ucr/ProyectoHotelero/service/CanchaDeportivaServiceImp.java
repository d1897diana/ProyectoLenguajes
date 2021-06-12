package cr.ac.ucr.ProyectoHotelero.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cr.ac.ucr.ProyectoHotelero.model.CanchaDeportiva;
import cr.ac.ucr.ProyectoHotelero.repository.CanchaDeportivaRepository;

@Service
public class CanchaDeportivaServiceImp implements ICanchaDeportivaService {

	@Autowired
	private CanchaDeportivaRepository canchaDeportRepository;
	
	@Override
	public List<CanchaDeportiva> BuscarTodas() {
		List<CanchaDeportiva> list = canchaDeportRepository.findAll();
		return list;
	}

	@Override
	public void NuevaCanchaDeportiva(CanchaDeportiva canchaDeport) {
		canchaDeportRepository.save(canchaDeport);

	}
	
	@Override
	public CanchaDeportiva BuscarUno(int codigo_servicio) {
		List<CanchaDeportiva> canchaDepos = canchaDeportRepository.findAll();
		CanchaDeportiva canchaDepo= new CanchaDeportiva();
		for(CanchaDeportiva canD: canchaDepos) {
			if(canD.getCodigo_servicio() == codigo_servicio) {
				canchaDepo=canD;
			}
		}
		return canchaDepo;
	}

	@Override
	public void ModificarCanchaDeportiva(CanchaDeportiva canchaDeport) {
		Optional<CanchaDeportiva> opcional = canchaDeportRepository.findById(canchaDeport.getCodigo_servicio());
		if(opcional.isPresent()) {
			CanchaDeportiva canDepo = opcional.get();
			canDepo.setDetalle(canchaDeport.getDetalle());
			canDepo.setPrecio(canchaDeport.getPrecio());
			canDepo.setHotel(canchaDeport.getHotel());
			canchaDeportRepository.save(canDepo);
		}

	}

	@Override
	public void EliminarCanchaDeportiva(int codigo_servicio) {
		canchaDeportRepository.deleteById(codigo_servicio);

	}

}
