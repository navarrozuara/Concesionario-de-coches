/**
 * 
 */
package pgn.examenMarzo.concesionarioCoches;

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
 * @version 1.0
 */
public class Concesionario {
	
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
	 */
	boolean annadir(String matricula, Color color, Modelo modelo) {
		Coche coche = Coche.instanciarCoche(matricula, color, modelo);
		if (coche == null || almacen.contains(coche))
			return false;
		return almacen.add(coche);
	}

	/**
	 * Elimina un coche del almacen
	 * 
	 * @param matricula
	 *            Representa la matrícula del coche a eliminar
	 * @return true si el coche se elimina, false en otro caso (el coche no está
	 *         en el almacen)
	 */
	boolean eliminar(String matricula) {
		return almacen.remove(Coche.instanciarCoche(matricula));
	}

	/**
	 * Devuelve el número de coches del almacen
	 * 
	 * @return Número de coches del almacen
	 */
	int size() {
		return almacen.size();
	}

	/**
	 * Devuelve el coche indicado por la matrícula
	 * 
	 * @param matricula
	 *            Representa la matrícula a buscar
	 * @return Coche contenido en el almacen. null si no existe
	 */
	Coche get(String matricula) {
		Coche coche = Coche.instanciarCoche(matricula);
		int index = almacen.indexOf(coche);
		if (index != -1) {
			return almacen.get(index);
		}
		return null;
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
			if(coche.getColor()== color)
				arrCochesColor.add(coche);
		}
		return arrCochesColor;
	}

}