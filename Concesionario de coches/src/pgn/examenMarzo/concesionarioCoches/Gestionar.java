/**
 * 
 */
package pgn.examenMarzo.concesionarioCoches;

import java.io.File;

/**
 * Clase que gestiona el concesionario de coches
 * 
 * @author Elisa Navarro Zuara
 * @version 2.0
 */
public class Gestionar {
	
	/**
	 * Concesionario de coches
	 */
	private static Concesionario concesionario = new Concesionario();
	
	/**
	 * Fichero
	 */
	private static File file = new File("Sin título");
	
	/**
	 * Estado del concesionario
	 */
	private static boolean modificado;
	
	/**
	 * Devuelve el concesionario de coches
	 * 
	 * @return Concesionario de coches
	 */
	public static Concesionario getConcesionario() {
		return concesionario;
	}

	/**
	 * Modifica el concesionario de coches
	 * 
	 * @param concesionario
	 *            Representa el nuevo concesionario de coches
	 */
	public static void setConcesionario(Concesionario concesionario) {
		Gestionar.concesionario = concesionario;
	}

	/**
	 * Devuelve el fichero
	 * 
	 * @return Fichero
	 */
	public static File getFile() {
		return file;
	}

	/**
	 * Modifica el fichero
	 * 
	 * @param file
	 *            Representa el nuevo fichero
	 */
	public static void setFile(File file) {
		Gestionar.file = file;
	}

	/**
	 * Devuelve el estado del concesionario
	 * 
	 * @return Estado del concesionario
	 */
	public static boolean isModificado() {
		return modificado;
	}

	/**
	 * Modifica el estado del concesionario
	 * 
	 * @param modificado
	 *            Representa el nuevo estado del concesionario
	 */
	public static void setModificado(boolean modificado) {
		Gestionar.modificado = modificado;
	}

}