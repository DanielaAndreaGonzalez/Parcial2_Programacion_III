/**
 * 
 */
package parcial2.model;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

import parcial2.persistence.Persistencia;

/**
 * @author GonzalezHDanielaA
 *
 */
public class Principal implements Serializable{
	
	private static final long serialVersionUID = 1L;
	ArrayList<Persona> listaPersonas = new ArrayList<Persona>();
	
	/**
	 * @return the listaPersonas
	 */
	public ArrayList<Persona> getListaPersonas() {
		return listaPersonas;
	}

	/**
	 * @param listaPersonas the listaPersonas to set
	 */
	public void setListaPersonas(ArrayList<Persona> listaPersonas) {
		this.listaPersonas = listaPersonas;
	}
	
	
	public Persona agregarPersona(String codigo,String nombre,String telefono,String email,String direccion) throws IOException{
		
		String contenido = "";
		
		Persona persona = null;
		
		persona = new Persona();
		persona.setCodigo(codigo);
		persona.setNombre(nombre);
		persona.setTelefono(telefono);
		persona.setEmail(email);
		persona.setDireccion(direccion);
		
		getListaPersonas().add(persona);
		contenido += "codigo :"+codigo+"nombre: "+nombre+"Telefono: "+telefono+
					"Email: "+email+" Direccion: "+direccion;
		
		Persistencia.guardarPersonas(listaPersonas);
		Persistencia.guardarRegistroLog(contenido+"Persona- Principal", 1, "agregarPersona");
		return persona;
	}


	@Override
	public String toString() {
		return "Principal [listaPersonas=" + listaPersonas + "]";
	}


	
	
	
	

}
