/**
 * 
 */
package pgn.examenMarzo.concesionarioCoches;

import java.io.File;
import java.io.IOException;

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
 * @version 1.1
 */
public class TestConcesionario {
	
	/**
	 * Men� general del programa
	 */
	static Menu menu = new Menu("Concesionario de coches", new String[] {
			"Alta Coche", "Baja Coche", "Mostrar Coche",
			"Mostrar concesionario", "Contar coches del concesionario",
			"Mostrar coches de un color", "Ficheros", "Salir" });
	
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
	 * Men� para gestionar los ficheros
	 */
	private static Menu menuFicheros = new Menu("Gestionar ficheros",
			new String[] { "Nuevo", "Abrir", "Guardar", "Guardar como...", "Salir" });
	
	/**
	 * Men� para guardar los cambios
	 */
	private static Menu menuGuardarCambios = new Menu(
			"El concesionario ha sido modificado. �Desea guardar los cambios?",
			new String[] { "Si", "No" });

	/**
	 * Concesionario de coches
	 */
	static Concesionario concesionario = new Concesionario();
	
	private static File file;
	private static boolean modificado;

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
			case 7: // Ficheros
				gestionarFicheros();
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
		Coche coche;
		try {
			coche = concesionario.get(Teclado.leerCadena("Introduce la matr�cula: "));
			System.out.println(coche);
		} catch (MatriculaNoValidaException | CocheNoExisteException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Comunicaci�n con el usuario para eliminar un coche de la lista
	 */
	private static void eliminarCoche() {
		try {
			concesionario.eliminar(Teclado.leerCadena("Introduce la matr�cula: "));
			setModificado(true);
			System.out.println("Coche eliminado.");
		} catch (MatriculaNoValidaException | CocheNoExisteException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Comunicaci�n con el usuario para a�adir un coche a la lista
	 */
	private static void annadirCoche() {
		try {
			concesionario.annadir(Teclado.leerCadena("Introduce la matr�cula: "),
					pedirColor(), pedirModelo());
			setModificado(true);
			System.out.println("Coche a�adido con �xito.");
		} catch (MatriculaNoValidaException | ColorNoValidoException
				| ModeloNoValidoException | CocheYaExisteException e) {
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * M�todo para realizar la gesti�n de los ficheros
	 */
	private static void gestionarFicheros() {
		do {
			switch (menuFicheros.gestionar()) {
			case 1: // Nuevo
				nuevo();
				break;
			case 2: // Abrir
				abrir();
				break;
			case 3: // Guardar
				guardar();
				break;
			case 4: // Guardar como...
				guardarComo();
				break;
			default: // Salir
				return;
			}
		} while (true);
	}

	private static void nuevo() {
		comprobarCambios();
		inicializar();
		setFile(null);
	}

	private static void inicializar() {
		setModificado(false);
		concesionario = new Concesionario();
	}
	
	private static void abrir() {
		comprobarCambios();
		try {
			File file = new File(Teclado.leerCadena("Introduce el nombre del fichero: "));
			concesionario = Fichero.abrir(file);
			setFile(file);
		} catch (ClassNotFoundException e) {
			System.out.println("Fichero con informaci�n distinta a la esperada.");
		} catch (IOException e) {
			System.out.println("El sistema no puede abrir el fichero.");
		}
	}
	
	private static void guardar() {
		if (getFile() == null)
			guardarComo();
		else {
			try {
				Fichero.guardar(getFile(), concesionario);
				setModificado(false);
				System.out.println("Fichero guardado con �xito.");
			} catch (IOException e) {
				System.out.println("El sistema no puede guardar el fichero.");
			}
		}
	}
	
	private static void guardarComo() {
		try {
			File file = new File(Teclado.leerCadena("Introduce el nombre del fichero: "));
			if (Fichero.isExists(file)) {
				char c = Teclado
						.leerCaracter("El fichero ya existe. �Desea sobreescribirlo? (s/n)");
				switch (c) {
				case 'n':
				case 'N':
					return;
				}
			}
			Fichero.guardar(file, concesionario);
			setModificado(false);
			setFile(file);
		} catch (IOException e) {
			System.out.println("El sistema no puede guardar el fichero.");
		}
	}

	private static boolean comprobarCambios() {
		if (isModificado()) {
			switch (menuGuardarCambios.gestionar()) {
			case 1: // Si
				guardar();
				return true;
			}
		}
		return false;
	}

	private static File getFile() {
		return file;
	}

	private static void setFile(File file) {
		TestConcesionario.file = file;
	}

	private static boolean isModificado() {
		return modificado;
	}

	private static void setModificado(boolean modificado) {
		TestConcesionario.modificado = modificado;
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