package cr.ac.ucr.ProyectoHotelero.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import cr.ac.ucr.ProyectoHotelero.model.Habitacion;

@Repository
public interface HabitacionRepository extends CrudRepository<Habitacion, Integer> {

}
