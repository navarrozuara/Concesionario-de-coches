/**
 * 
 */
package pgn.examenMarzo.utiles;

/**
 * Clase utilizada para la gesti�n de un men�. Se dedica a:
 * <ul>
 * <li>Mostrar las opciones del men�.</li>
 * <li>Recoger y devolver las opciones de un men�.</li>
 * </ul>
 * 
 * @author Elisa Navarro Zuara
 * @version 1.0
 */
public class Menu {
	
	/**
	 * T�tulo del men�
	 */
	String titulo = null;
	
	/**
	 * Opciones del men� 
	 */
	String opciones[] = null;
	
	/**
	 * N�mero de opciones del men�
	 */
	int numOpciones = 2;

	/**
	 * Construye un nuevo men� de t�tulo y opciones especificadas
	 * 
	 * @param titulo
	 *            Representa el t�tulo del nuevo men�
	 * @param opciones
	 *            Representa las opciones del nuevo men�
	 */
	public Menu(String titulo, String[] opciones) {
		this.titulo = titulo;
		this.opciones = opciones;
		this.numOpciones = this.opciones.length;
	}

	/**
	 * Gestiona el men�. Consiste en mostrar las opciones y recoger la opci�n
	 * seleccionada por el usuario.
	 * 
	 * @return Opci�n v�lida del men�
	 */
	public int gestionar() {
		mostrar();
		return recogerOpcion();
	}

	/**
	 * Muestra el t�tulo y las distintas opciones del men�
	 */
	private void mostrar() {
		int i = 1;
		System.out.println("**" + titulo);
		for (String elemento : opciones)
			System.out.println("(" + (i++) + ") " + elemento);
	}

	/**
	 * Recoge la opci�n v�lida del men�
	 * 
	 * @return Opci�n v�lida
	 */
	private int recogerOpcion() {
		int opcion;
		do {
			opcion = Teclado.leerEntero();
		} while (opcion < 1 || opcion > numOpciones);
		return opcion;
	}

}