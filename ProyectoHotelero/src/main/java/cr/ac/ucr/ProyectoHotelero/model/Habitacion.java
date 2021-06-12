package cr.ac.ucr.ProyectoHotelero.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_habitacion")
public class Habitacion {
	@Id
	private int numero;
	
    @ManyToOne()
    @JoinColumn(name = "id_hotel", nullable = false)
	private Hotel hotel;
	
	private int precio;
	private String tipo;
	private String detalle;
	
	public Hotel getHotel() {
		return hotel;
	}
	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
	
	public int getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getDetalle() {
		return detalle;
	}
	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	@Override
	public String toString() {
		return "Habitacion [numero=" + numero + ", precio=" + precio + ", tipo=" + tipo + ", detalle=" + detalle + "]";
	}
	
}
