/**
 * 
 */
package parcial2.controller;

import java.io.IOException;
import java.util.ArrayList;

import parcial2.model.Persona;
import parcial2.model.Principal;
import parcial2.persistence.Persistencia;

/**
 * @author GonzalezHDanielaA
 *
 */
public class ModelFactoryController {

	
		Principal principal;
	
		//***********************************Singleton***********************************************
		//Clase estatica oculta. Tan solo se instanciara el singleton una vez
		private static class SingletonHolder{
			//El constructor de Singleton puede ser llamado desde aquí al ser protected 
			private final static ModelFactoryController eINSTANCE = new ModelFactoryController();
		}
		
		
		//Metodo para obtener la instancia de nuestra clase
		public static ModelFactoryController getInstance()
		{
			return SingletonHolder.eINSTANCE;
		}
		
		public ModelFactoryController()
		{
			inicializarDatos();
			cargarXMLPersonas();
		}
	
		private void inicializarDatos()
		{
			principal = new Principal();
		}
			/**
		 * @return the principal
		 */
		public Principal getPrincipal() {
			return principal;
		}

		/**
		 * @param principal the principal to set
		 */
		public void setPrincipal(Principal principal) {
			this.principal = principal;
		}

		public Persona agregarPersona(String codigo,String nombre, String telefono,String email,String direccion)
		{
			Persona persona = null;
			try {
				persona = getPrincipal().agregarPersona(codigo, nombre, telefono, email, direccion);
				Persistencia.guardarRecursoPersonaXML(principal);
				Persistencia.guardarRecursoPersonaBinario(principal);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return persona;
		}
		
		
		public void cargarXMLPersonas()
		{
			principal = Persistencia.cargarRecursoPersistenciaXML();
		}
		
		
		public ArrayList<Persona> obtenerListaPersonasXML()
		{
			ArrayList<Persona> lista = new ArrayList<>();
			lista = Persistencia.cargarInformacionPersona();
			return lista;
		}
		
		
		public Persona buscarPersona(String codigo)
		{
			Persona personaEncontrada = new Persona();
			try {
				personaEncontrada = Persistencia.buscarPersona(codigo);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			return personaEncontrada;		
		}
		
		public Persona actualizarPersona(String codigo,String nombre, String telefono,String email,String direccion)
		{
			Persona persona = new Persona();
			persona = Persistencia.actualizarPersona(codigo, nombre, telefono, email, direccion);
			return persona;
		}
	
}
