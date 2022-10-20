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
	
	
	
	
	
	
	
	
	
	
	
	
	

}