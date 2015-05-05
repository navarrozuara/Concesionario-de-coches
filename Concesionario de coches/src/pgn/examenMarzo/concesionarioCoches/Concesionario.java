/**
 * 
 */
package pgn.examenMarzo.concesionarioCoches;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Queremos modelar un concesionario de coches en Java. Nos limitaremos a las
 * siguientes opciones:
 * <ol>
 * <li>Alta de un coche (se pedirá matricula, color y modelo).</li>
 * <li>Baja de un coche (por matrícula).</li>
 * <li>Mostrar un coche (por matrícula).</li>
 * <li>Mostrar concesionario (todos los coches del concesionario).</li>
 * <li>Contar el número de coches en el concesionario.</li>
 * <li>Mostrar coches de un color.</li>
 * </ol>
 * Lógicamente, no podrá añadirse un coche inválido o ya contenido (no pueden
 * existir dos coches con la misma matrícula en el concesionario). Por cada
 * coche que se dé de alta, han de conocerse todas sus características. Ninguna
 * de las características del coche puede ser por defecto.
 * 
 * @author Elisa Navarro Zuara
 * @version 2.0
 */
public class Concesionario implements Serializable {
	// Comentario de Victor
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Colección de coches. No puede tener null.
	 */
	private ArrayList<Coche> almacen = new ArrayList<Coche>();
	
	/**
	 * Nombre del concesionario
	 */
	private final String nombre = "IES Gran Capitán";

	/**
	 * Añade un coche al almacen
	 * 
	 * @param matricula
	 *            Representa la matrícula del coche a añadir
	 * @param color
	 *            Representa el color del coche a añadir
	 * @param modelo
	 *            Representa el modelo del coche a añadir
	 * @return true si el coche se añade, false en otro caso (el coche es null o
	 *         el coche ya está contenido en el almacen)
	 * 
	 * @throws MatriculaNoValidaException
	 *             Si la matrícula no es válida
	 * @throws ColorNoValidoException
	 *             Si el color no es válido
	 * @throws ModeloNoValidoException
	 *             Si el modelo no es válido
	 * @throws CocheYaExisteException
	 *             Si el coche ya existe en el concesionario
	 */
	public boolean annadir(String matricula, Color color, Modelo modelo)
			throws MatriculaNoValidaException, ColorNoValidoException,
			ModeloNoValidoException, CocheYaExisteException {
		Coche coche = new Coche(matricula, color, modelo);
		if (almacen.contains(coche))
			throw new CocheYaExisteException("El coche ya existe.");
		return almacen.add(coche);
	}

	/**
	 * Elimina un coche del almacen
	 * 
	 * @param matricula
	 *            Representa la matrícula del coche a eliminar
	 * @return true si el coche se elimina, false en otro caso (el coche no está
	 *         en el almacen)
	 * @throws MatriculaNoValidaException
	 *             Si la matrícula no es válida
	 * @throws CocheNoExisteException
	 *             Si el coche no existe en el concesionario
	 */
	public boolean eliminar(String matricula)
			throws MatriculaNoValidaException, CocheNoExisteException {
		Coche coche = new Coche(matricula);
		if (!almacen.contains(coche))
			throw new CocheNoExisteException("El coche no existe.");
		return almacen.remove(coche);
	}

	/**
	 * Devuelve el número de coches del almacen
	 * 
	 * @return Número de coches del almacen
	 */
	public int size() {
		return almacen.size();
	}

	/**
	 * Devuelve el coche indicado por la matrícula
	 * 
	 * @param matricula
	 *            Representa la matrícula a buscar
	 * @return Coche contenido en el almacen. null si no existe
	 * @throws MatriculaNoValidaException
	 *             Si la matrícula no es válida
	 * @throws CocheNoExisteException
	 *             Si el coche no existe en el concesionario
	 */
	public Coche get(String matricula) throws MatriculaNoValidaException,
			CocheNoExisteException {
		Coche coche = new Coche(matricula);
		int index = almacen.indexOf(coche);
		if (index != -1) {
			return almacen.get(index);
		} else {
			throw new CocheNoExisteException("El coche no existe.");
		}
	}
	
	/**
	 * Devuelve el coche indicado por el índice
	 * 
	 * @param index
	 *            Representa el índice a buscar
	 * @return Coche contenido en el almacen. null si no existe
	 */
	public Coche get(int index) {
		if(almacen.isEmpty())
			return null;
		if(index < 0 | index > almacen.size()-1)
			return null;
		return almacen.get(index);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Concesionario " + nombre + "[almacen=" + almacen + "]";
	}

	/**
	 * Genera una lista de coches de un determinado color
	 * 
	 * @param color
	 *            Representa el color a buscar
	 * @return Lista de coches de un determinado color
	 */
	public ArrayList<Coche> getCochesColor(Color color) {
		ArrayList<Coche> arrCochesColor = new ArrayList<Coche>();
		for (Coche coche : almacen) {
			if (coche.getColor() == color)
				arrCochesColor.add(coche);
		}
		return arrCochesColor;
	}

}