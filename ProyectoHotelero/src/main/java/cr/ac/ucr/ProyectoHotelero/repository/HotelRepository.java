package cr.ac.ucr.ProyectoHotelero.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cr.ac.ucr.ProyectoHotelero.model.Hotel;

@Transactional
@Repository
public interface HotelRepository extends JpaRepository<Hotel, Integer> {
	public List<Hotel> findByDireccionContaining(String b);
	public List<Hotel> findByProvinciaContaining(String b);
	public List<Hotel> findByPaisContaining(String b);
}
