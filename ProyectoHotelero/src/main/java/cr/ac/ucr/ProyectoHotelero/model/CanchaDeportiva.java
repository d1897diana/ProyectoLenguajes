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
@Table(name="tb_cancha_deportiva")
public class CanchaDeportiva {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigo_servicio;
	private String detalle;
	private int precio;
	@OneToOne( fetch = FetchType.EAGER)
	@JoinColumn(name="id_hotel")
	private Hotel id_hotel;

	public CanchaDeportiva() {
	}

	public CanchaDeportiva(String detalle, int precio, Hotel id_hotel) {
		super();
		this.detalle = detalle;
		this.precio = precio;
		this.id_hotel = id_hotel;
	}

	public CanchaDeportiva(int codigo_servicio, String detalle, int precio, Hotel id_hotel) {
		super();
		this.codigo_servicio = codigo_servicio;
		this.detalle = detalle;
		this.precio = precio;
		this.id_hotel = id_hotel;
	}

	public int getCodigo_servicio() {
		return codigo_servicio;
	}

	public void setCodigo_servicio(int codigo_servicio) {
		this.codigo_servicio = codigo_servicio;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
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
