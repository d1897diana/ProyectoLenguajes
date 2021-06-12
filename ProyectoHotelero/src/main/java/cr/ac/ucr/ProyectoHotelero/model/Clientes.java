package cr.ac.ucr.ProyectoHotelero.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_cliente")
public class Clientes {
	@Id
	private int cedula;
	private String nombre;
	private int telefono;
	private String correo;
	
	public Clientes() {
		
	}
	
	public Clientes(int cedula, String nombre, int telefono, String correo) {
		this.cedula = cedula;
		this.nombre = nombre;
		this.telefono = telefono;
		this.correo = correo;
		
	}

	public int getCedula() {
		return cedula;
	}

	public void setCedula(int cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

}
