/**
 * 
 */
package pgn.examenMarzo.utiles;

/**
 * Clase utilizada para la gestión de un menú. Se dedica a:
 * <ul>
 * <li>Mostrar las opciones del menú.</li>
 * <li>Recoger y devolver las opciones de un menú.</li>
 * </ul>
 * 
 * @author Elisa Navarro Zuara
 * @version 1.0
 */
public class Menu {
	
	/**
	 * Título del menú
	 */
	String titulo = null;
	
	/**
	 * Opciones del menú 
	 */
	String opciones[] = null;
	
	/**
	 * Número de opciones del menú
	 */
	int numOpciones = 2;

	/**
	 * Construye un nuevo menú de título y opciones especificadas
	 * 
	 * @param titulo
	 *            Representa el título del nuevo menú
	 * @param opciones
	 *            Representa las opciones del nuevo menú
	 */
	public Menu(String titulo, String[] opciones) {
		this.titulo = titulo;
		this.opciones = opciones;
		this.numOpciones = this.opciones.length;
	}

	/**
	 * Gestiona el menú. Consiste en mostrar las opciones y recoger la opción
	 * seleccionada por el usuario.
	 * 
	 * @return Opción válida del menú
	 */
	public int gestionar() {
		mostrar();
		return recogerOpcion();
	}

	/**
	 * Muestra el título y las distintas opciones del menú
	 */
	private void mostrar() {
		int i = 1;
		System.out.println("**" + titulo);
		for (String elemento : opciones)
			System.out.println("(" + (i++) + ") " + elemento);
	}

	/**
	 * Recoge la opción válida del menú
	 * 
	 * @return Opción válida
	 */
	private int recogerOpcion() {
		int opcion;
		do {
			opcion = Teclado.leerEntero();
		} while (opcion < 1 || opcion > numOpciones);
		return opcion;
	}

}