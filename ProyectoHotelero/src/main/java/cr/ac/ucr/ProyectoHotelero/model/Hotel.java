package cr.ac.ucr.ProyectoHotelero.model;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_hotel")
public class Hotel implements Serializable{
	
	@Id
    private int id_hotel;
    private String imagen_hotel;
    private String direccion;
    private String pais;
    private String provincia;
    private String correo;
    private String telefono;
    
    @OneToMany(mappedBy = "hotel")
	List<Habitacion> habitacion = new LinkedList<Habitacion>();
    
    public Hotel() {}
    
    //proximamente eliminar
    public Hotel(int id_hotel, String imagen_hotel, String direccion, String correo, String telefono ) {
        this.id_hotel = id_hotel;
        this.imagen_hotel = imagen_hotel;
        this.direccion = direccion;
        this.correo = correo;
        this.telefono  = telefono ;
    }
    
    //jojo y wily
    public Hotel(int id_hotel, String provincia) {
		this.id_hotel = id_hotel;
		this.provincia = provincia;
	}

	public Hotel(int id_hotel, String imagen_hotel, String direccion, String pais, String provincia, String correo, String telefono) {
		this.id_hotel = id_hotel;
		this.imagen_hotel = imagen_hotel;
		this.direccion = direccion;
		this.pais = pais;
		this.provincia = provincia;
		this.correo = correo;
		this.telefono = telefono;
	}

	public int getId_hotel() {
        return id_hotel;
    }

    public void setId_hotel(int id_hotel) {
        this.id_hotel = id_hotel;
    }

    public String getImagen_hotel() {
        return imagen_hotel;
    }

    public void setImagen_hotel(String imagen_hotel) {
        this.imagen_hotel = imagen_hotel;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono ) {
        this.telefono  = telefono ;
    }

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	@Override
	public String toString() {
		return "Hotel [id_hotel=" + id_hotel + ", imagen_hotel=" + imagen_hotel + ", direccion=" + direccion + ", pais="
				+ pais + ", provincia=" + provincia + ", correo=" + correo + ", telefono=" + telefono + "]";
	}
	
}
