package cr.ac.ucr.ProyectoHotelero.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cr.ac.ucr.ProyectoHotelero.model.Clientes;




@Repository
public interface ClienteRepository extends JpaRepository<Clientes, Integer> {

}
