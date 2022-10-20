/**
 * 
 */
package parcial2.controller;

import parcial2.model.Persona;

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
	
	
	
	
}
