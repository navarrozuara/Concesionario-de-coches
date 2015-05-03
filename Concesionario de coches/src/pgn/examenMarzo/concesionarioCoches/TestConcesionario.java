/**
 * 
 */
package pgn.examenMarzo.concesionarioCoches;

import pgn.examenMarzo.utiles.Menu;
import pgn.examenMarzo.utiles.Teclado;
import pgn.examenMarzo.concesionarioCoches.Color;
import pgn.examenMarzo.concesionarioCoches.Modelo;

/**
 * Queremos modelar un concesionario de coches en Java. Nos limitaremos a las
 * siguientes opciones:
 * <ol>
 * <li>Alta de un coche (se pedir� matricula, color y modelo).</li>
 * <li>Baja de un coche (por matr�cula).</li>
 * <li>Mostrar un coche (por matr�cula).</li>
 * <li>Mostrar concesionario (todos los coches del concesionario).</li>
 * <li>Contar el n�mero de coches en el concesionario.</li>
 * <li>Mostrar coches de un color.</li>
 * </ol>
 * 
 * @author Elisa Navarro Zuara
 * @version 1.0
 */
public class TestConcesionario {
	
	/**
	 * Men� general del programa
	 */
	static Menu menu = new Menu("Concesionario de coches", new String[] {
			"Alta Coche", "Baja Coche", "Mostrar Coche",
			"Mostrar concesionario", "Contar coches del concesionario",
			"Mostrar coches de un color", "Salir" });
	
	/**
	 * Men� para seleccionar el color
	 */
	private static Menu menuColores = new Menu("Colores de los coches",
			Color.generarOpcionesMenu());
	
	/**
	 * Men� para seleccionar el modelo
	 */
	private static Menu menuModelos = new Menu("Modelos de los coches",
			Modelo.generarOpcionesMenu());
	
	/**
	 * Concesionario de coches
	 */
	static Concesionario concesionario = new Concesionario();

	/**
	 * M�todo principal del programa
	 * 
	 * @param args
	 *            Array de cadenas de argumentos
	 */
	public static void main(String[] args) {
		do {
			switch (menu.gestionar()) {
			case 1: // A�adir coche
				annadirCoche();
				break;
			case 2: // Eliminar coche
				eliminarCoche();
				break;
			case 3: // Obtener coche
				getCoche();
				break;
			case 4: // Mostrar lista
				System.out.println(concesionario);
				break;
			case 5: // Contar coches
				System.out.println("N�mero de coches en el concesionario: "
						+ concesionario.size());
				break;
			case 6: // Mostrar coches de un color
				System.out.println(concesionario.getCochesColor(pedirColor()));
				break;
			default: // Salir
				System.out.println("Aaaaaaaaaaaaaaaaaaaaadios");
				return;
			}
		} while (true);
	}

	/**
	 * Comunicaci�n con el usuario para mostrar un coche seg�n la matr�cula
	 */
	private static void getCoche() {
		Coche coche = concesionario.get(Teclado
				.leerCadena("Introduce la matr�cula"));
		if (coche == null)
			System.out.println("No existe el coche en el concesionario.");
		else
			System.out.println(coche);
	}

	/**
	 * Comunicaci�n con el usuario para eliminar un coche de la lista
	 */
	private static void eliminarCoche() {
		if (concesionario
				.eliminar(Teclado.leerCadena("Introduce la matr�cula")))
			System.out.println("Coche eliminado");
		else
			System.out.println("No se ha podido eliminar");
	}

	/**
	 * Comunicaci�n con el usuario para a�adir un coche a la lista
	 */
	private static void annadirCoche() {
		if (concesionario.annadir(Teclado.leerCadena("Introduce la matr�cula"),
				pedirColor(), pedirModelo()))
			System.out.println("Coche a�adido con �xito");
		else
			System.out.println("No se ha podido a�adir");
	}

	/**
	 * M�todo para pedir al usuario el modelo del coche
	 * 
	 * @return Modelo del coche
	 */
	private static Modelo pedirModelo() {
		int opcion = menuModelos.gestionar();
		Modelo[] arrModelos = Modelo.getValues();
		if (opcion == arrModelos.length + 1)
			return null;
		return arrModelos[opcion - 1];
	}

	/**
	 * M�todo para pedir al usuario el color del coche
	 * 
	 * @return Color del coche
	 */
	private static Color pedirColor() {
		int opcion = menuColores.gestionar();
		Color[] arrColores = Color.getValues();
		if (opcion == arrColores.length + 1)
			return null;
		return arrColores[opcion - 1];
	}

}