/**
 * 
 */
package parcial2.model;

import java.io.Serializable;

/**
 * @author GonzalezHDanielaA
 *
 */
public class Persona implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	private String codigo;
	private String nombre;
	private String telefono;
	private String email;
	private String direccion;
	
	
	public Persona() {}
	/**
	 * @return the codigo
	 */
	public String getCodigo() {
		return codigo;
	}


	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}


	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}


	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	/**
	 * @return the telefono
	 */
	public String getTelefono() {
		return telefono;
	}


	/**
	 * @param telefono the telefono to set
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}


	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}


	/**
	 * @return the direccion
	 */
	public String getDireccion() {
		return direccion;
	}


	/**
	 * @param direccion the direccion to set
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	@Override
	public String toString() {
		return "Persona [codigo=" + codigo + ", nombre=" + nombre + ", telefono=" + telefono + ", email=" + email
				+ ", direccion=" + direccion + "]";
	}
	
	
	
	
	
	
	
	

}
