/**
 * 
 */
package parcial2.controller;

import java.util.ArrayList;

import parcial2.model.Persona;
import parcial2.model.Principal;
import parcial2.persistence.Persistencia;

/**
 * @author GonzalezHDanielaA
 *
 */
public class CrudPersonaController {
	
	
	ModelFactoryController modelFactoryController;
	
	public CrudPersonaController(ModelFactoryController modelFactoryController)
	{
		this.modelFactoryController = modelFactoryController;
	}
	
	public Persona agregarPersona(String codigo,String nombre,String telefono,String email,String direccion)
	{
		return modelFactoryController.agregarPersona(codigo, nombre, telefono, email, direccion);
	}
	
	public Persona buscarPersona(String codigo)
	{
		return modelFactoryController.buscarPersona(codigo);	
	}
	
	public Persona actualizarPersona(String codigo,String nombre,String telefono,String email,String direccion)
	{
		return modelFactoryController.actualizarPersona(codigo, nombre, telefono, email, direccion);
	}
	
	public boolean eliminarPersona(String codigo)
	{
		return modelFactoryController.eliminarPersona(codigo);
	}
	
	
}
