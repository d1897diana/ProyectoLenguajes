package cr.ac.ucr.ProyectoHotelero.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_gimnasio")
public class Gimnasio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigo_servicio;
	private String equipo;
	private int precio;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_hotel ")
	private Hotel id_hotel;

	public Gimnasio() {
	}

	public Gimnasio(String equipo, int precio, Hotel id_hotel) {
		super();
		this.equipo = equipo;
		this.precio = precio;
		this.id_hotel = id_hotel;
	}

	public Gimnasio(int codigo_servicio, String equipo, int precio, Hotel id_hotel) {
		super();
		this.codigo_servicio = codigo_servicio;
		this.equipo = equipo;
		this.precio = precio;
		this.id_hotel = id_hotel;
	}

	public int getCodigo_servicio() {
		return codigo_servicio;
	}

	public void setCodigo_servicio(int codigo_servicio) {
		this.codigo_servicio = codigo_servicio;
	}

	public String getEquipo() {
		return equipo;
	}

	public void setEquipo(String equipo) {
		this.equipo = equipo;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public Hotel getHotel() {
		return id_hotel;
	}

	public void setHotel(Hotel id_hotel) {
		this.id_hotel = id_hotel;
	}
}
