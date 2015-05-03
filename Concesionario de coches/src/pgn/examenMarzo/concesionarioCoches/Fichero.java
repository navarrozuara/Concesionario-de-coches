/**
 * 
 */
package pgn.examenMarzo.concesionarioCoches;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.regex.Pattern;

/**
 * Clase Fichero que contiene todos los m�todos necesarios para operar con ficheros
 * 
 * @author Elisa Navarro Zuara
 * @version 1.0
 */
public class Fichero {
	
	/**
	 * Patr�n para un nombre de archivo v�lido
	 */
	private static Pattern pattern = Pattern.compile("^((\\w)+(\\.obj))$");
	
	/**
	 * M�todo para abrir un concesionario existente
	 * 
	 * @param file
	 *            Representa el fichero a abrir
	 * @return Concesionario existente
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	public static Concesionario abrir(File file) throws ClassNotFoundException, IOException {
		file = comprobarExtension(file);
		try (ObjectInputStream in = new ObjectInputStream(
				new BufferedInputStream(new FileInputStream(file)))) {
			return (Concesionario) in.readObject();
		}
	}
	
	/**
	 * M�todo para guardar un concesionario
	 * 
	 * @param file
	 *            Representa el fichero a guardar
	 * @param concesionario
	 *            Representa el concesionario a guardar
	 * @throws IOException
	 */
	public static void guardar(File file, Concesionario concesionario) throws IOException {
		file = comprobarExtension(file);
		try (ObjectOutputStream out = new ObjectOutputStream(
				new BufferedOutputStream(new FileOutputStream(file, false)))) {
			out.writeObject(concesionario);
		}
	}
	
	public static boolean isExists(File file) {
		file = comprobarExtension(file);
		return file.exists();
	}
	
	/**
	 * Comprueba si la extensi�n del fichero es v�lida o no
	 * 
	 * @param file
	 *            Representa el fichero a comprobar
	 * @return Fichero con la extensi�n v�lida
	 */
	static File comprobarExtension(File file) {
		if (pattern.matcher(file.getPath()).matches())
			return file;
		return new File (file.getPath() + ".obj");
	}

}