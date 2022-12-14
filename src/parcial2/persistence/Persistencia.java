/**
 * 
 */
package parcial2.persistence;

import java.io.IOException;
import java.util.ArrayList;

import parcial2.model.Persona;
import parcial2.model.Principal;

/**
 * @author GonzalezHDanielaA
 *
 */
public class Persistencia {
	
	
	public static final String RUTA_ARCHIVO_USUARIOS = "C://td//persistencia//Archivos//";
	
	public static final String RUTA_ARCHIVO_OBJETOS = "src/resources/archivoObjetos.txt";
	public static final String RUTA_ARCHIVO_MODELO_SUBASTA_BINARIO = "C://td//persistencia//usuarioBin.dat";
	public static final String RUTA_ARCHIVO_MODELO_PROGRAMA_XML = "src/application/resource/model.xml";
	public static final String RUTA_ARCHIVO_ESTUDIANTES = "src/application/resource/estudiantes.txt";
	
	
	
	public static final String RUTA_ARCHIVO_PERSONAS_TXT = "C://Carpeta//Archivos//personas.txt";
	
	public static final String RUTA_ARCHIVO_PERSONAS_XML = "C://Carpeta//Archivos//model.xml";
	
	public static final String RUTA_ARCHIVO_PERSONAS_BIN = "C://Carpeta//Archivos//binario.dat";
	
	public static final String SEPARADOR = ";";
	
	public static final String RUTA_ARCHIVO_LOG = "C://Carpeta//Archivos//personasLog.txt";
	
	
	
	public static void guardarPersonas(ArrayList<Persona> personas) throws IOException
	{
		String contenido = "";
		
		for(Persona persona: personas)
		{
			contenido += persona.getCodigo()+SEPARADOR+persona.getNombre()+SEPARADOR+
					SEPARADOR+persona.getTelefono()+SEPARADOR+persona.getEmail()+
					SEPARADOR+persona.getDireccion()+"\n";
		}
		ArchivoUtil.guardarArchivo(RUTA_ARCHIVO_PERSONAS_TXT, contenido, true);
	}
	
	
	public static void guardarRecursoPersonaXML(Principal persona)
	{
		try {
			ArchivoUtil.salvarRecursoSerializadoXML(RUTA_ARCHIVO_PERSONAS_XML, persona);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public static void guardarRecursoPersonaBinario(Principal principal)
	{	
		try {
			ArchivoUtil.salvarRecursoSerializado(RUTA_ARCHIVO_PERSONAS_BIN, principal);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	public static void guardarRegistroLog(String mensajeLog, int nivel, String accion)
	{
		ArchivoUtil.guardarRegistroLog(mensajeLog, nivel, accion, RUTA_ARCHIVO_LOG);
	}
	
	public static ArrayList<Persona> cargarInformacionPersona()
	{
		ArrayList<Persona> personas = new ArrayList<>();
		Principal principal = Persistencia.cargarRecursoPersistenciaXML();
		personas  = principal.getListaPersonas();
		return personas;
	}
	
	public static Principal cargarRecursoPersistenciaXML()
	{
		Principal principal = null;
		try {
			principal = (Principal) ArchivoUtil.cargarRecursoSerializadoXML(RUTA_ARCHIVO_PERSONAS_XML);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return principal;
	}
	
	public static ArrayList<Persona> cargarInformacionPersonaTXT() throws IOException
	{
		ArrayList<Persona> listaPersonas = new ArrayList<>();
		
		ArrayList<String> contenido = ArchivoUtil.leerArchivo(RUTA_ARCHIVO_PERSONAS_TXT);	
		String linea = " ";
		for(int i=0; i<contenido.size(); i++)
		{
			linea = contenido.get(i);
			Persona persona = new Persona();
			
			persona.setCodigo(linea.split(";")[0]);
			persona.setNombre(linea.split(";")[1]);
			persona.setTelefono(linea.split(";")[2]);
			persona.setEmail(linea.split(";")[3]);
			persona.setDireccion(linea.split(";")[4]);
			listaPersonas.add(persona);	
		}
		return listaPersonas;
	}
	
	
	public static Persona buscarPersona(String codigo) throws IOException
	{
		ArrayList<Persona> lista = Persistencia.cargarInformacionPersonaTXT();
		Persona personaEncontrada = new Persona();
		for(int i=0; i<lista.size();i++)
		{
			Persona personaAux = lista.get(i);
			if(personaAux.getCodigo().equalsIgnoreCase(codigo))
			{
				personaEncontrada = personaAux;
			}
		}
		return personaEncontrada;
	}
	
	public static Persona actualizarPersona(String codigo,String nombre,String telefono,String email,String direccion)
	{
		ArrayList<Persona> listaPersonas = Persistencia.cargarInformacionPersona();
		Principal principal = Persistencia.cargarRecursoPersistenciaXML();
		Persona persona = new Persona();
		
		for(int i=0; i<listaPersonas.size();i++)
		{
			if(listaPersonas.get(i).getCodigo().equals(codigo))
			{
				principal.getListaPersonas().get(i).setCodigo(codigo);
				principal.getListaPersonas().get(i).setNombre(nombre);
				principal.getListaPersonas().get(i).setTelefono(telefono);
				principal.getListaPersonas().get(i).setEmail(email);
				principal.getListaPersonas().get(i).setDireccion(direccion);
				persona = listaPersonas.get(i);	
				ArchivoUtil.eliminarArchivo(RUTA_ARCHIVO_PERSONAS_XML);
				Persistencia.guardarRecursoPersonaXML(principal);
			}
		}
		return persona;
	}
	
	
	public static boolean eliminarPersona(String codigo)
	{
		boolean eliminado = false;
		
		Principal principal = Persistencia.cargarRecursoPersistenciaXML();
		for(int i=0; i<principal.getListaPersonas().size();i++)
		{
			if(principal.getListaPersonas().get(i).getCodigo().equals(codigo))
			{
				principal.getListaPersonas().remove(principal.getListaPersonas().get(i));
				eliminado=true;
				ArchivoUtil.eliminarArchivo(RUTA_ARCHIVO_PERSONAS_XML);
				Persistencia.guardarRecursoPersonaXML(principal);
				break;
			}
		}
		return eliminado;
	}
	
	
	
	
	
	

}
