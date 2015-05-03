/**
 * 
 */
package pgn.examenMarzo.concesionarioCoches;

import java.io.Serializable;
import java.util.regex.Pattern;

/**
 * Un coche tendrá las siguientes características:
 * <ul>
 * <li>Color. Se limitarán los colores a tres: plata, rojo y azul. Para
 * solicitar el color al dar de alta al coche se implementará un método
 * pedirColor que mediante la gestión de un menú, devolverá el color indicado.</li>
 * <li>Modelo. Se limitarán los modelos de coches a siete: Córdoba (marca Seat),
 * Toledo (marca Seat), Ibiza (marca Seat), Serie 1 (marca BMW), Serie 2 (marca
 * BMW), Serie 3 (marca BMW) y Serie 5 (marca BMW). Para solicitar el modelo al
 * dar de alta al coche podrá implementarse un método pedirModelo que mediante
 * la gestión de un menú, devolverá el modelo indicado.</li>
 * <li>Matrícula (única por coche). El formato de las matrículas será el nuevo:
 * combinación de cuatro números (de 0000 a 9999) y tres letras, comenzando por
 * BBB y terminando por ZZZ, excluyendo vocales, la LL, la Ñ y la Q.</li>
 * </ul>
 * 
 * @author Elisa Navarro Zuara
 * @version 2.0
 */
public class Coche implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Matrícula del coche
	 */
	private String matricula;
	
	/**
	 * Color del coche
	 */
	private Color color;
	
	/**
	 * Modelo del coche
	 */
	private Modelo modelo;
	
	/**
	 * Patrón para una matrícula válida
	 */
	static final private Pattern patternMatricula = Pattern
			.compile("^\\d{4}[ -]?[[B-Z]&&[^QEIOU]]{3}$");

	/**
	 * Construye un nuevo coche de matrícula, color y modelo especificado
	 * 
	 * @param matricula
	 *            Representa la matrícula del nuevo coche
	 * @param color
	 *            Representa el color del nuevo coche
	 * @param modelo
	 *            Representa el modelo del nuevo coche
	 *            
	 * @throws MatriculaNoValidaException
	 *             Si la matrícula no es válida
	 * @throws ColorNoValidoException
	 *             Si el color no es válido
	 * @throws ModeloNoValidoException
	 *             Si el modelo no es válido
	 */
	Coche(String matricula, Color color, Modelo modelo)
			throws MatriculaNoValidaException, ColorNoValidoException,
			ModeloNoValidoException {
		super();
		setMatricula(matricula);
		setColor(color);
		setModelo(modelo);
	}

	/**
	 * Construye un nuevo coche de matrícula especificada
	 * 
	 * @param matricula
	 *            Representa la matrícula del nuevo coche
	 * @throws MatriculaNoValidaException
	 *             Si la matrícula no es válida
	 */
	Coche(String matricula) throws MatriculaNoValidaException {
		setMatricula(matricula);
	}

	/**
	 * Comprueba si la matrícula del coche es válida o no
	 * 
	 * @param matricula
	 *            Representa la matrícula a validar
	 * @return true si la matrícula es válida, false si la matrícula no es
	 *         válida
	 */
	public static boolean esValida(String matricula) {
		return patternMatricula.matcher(matricula).matches();
	}

	/**
	 * Modifica la matrícula del coche
	 * 
	 * @param matricula
	 *            Representa la nueva matrícula del coche
	 * @throws MatriculaNoValidaException
	 *             Si la matrícula no es válida
	 */
	private void setMatricula(String matricula) throws MatriculaNoValidaException {
		if (!esValida(matricula))
			throw new MatriculaNoValidaException("La matrícula introducida no es válida.");
		this.matricula = matricula;
	}

	/**
	 * Devuelve el color del coche
	 * 
	 * @return Color del coche
	 */
	public Color getColor() {
		return color;
	}
	
	/**
	 * Devuelve el modelo del coche
	 * 
	 * @return Modelo del coche
	 */
	public Modelo getModelo() {
		return modelo;
	}
	
	/**
	 * Devuelve la matrícula del coche
	 * 
	 * @return Matrícula del coche
	 */
	public String getMatricula() {
		return matricula;
	}

	/**
	 * Modifica el color del coche
	 * 
	 * @param color
	 *            Representa el nuevo color del coche
	 * @throws ColorNoValidoException
	 *             Si el color no es válido
	 */
	private void setColor(Color color) throws ColorNoValidoException {
		if (color == null)
			throw new ColorNoValidoException("El color introducido no es válido.");
		this.color = color;
	}

	/**
	 * Modifica el modelo del coche
	 * 
	 * @param modelo
	 *            Representa el nuevo modelo del coche
	 * @throws ModeloNoValidoException
	 *             Si el modelo no es válido
	 */
	private void setModelo(Modelo modelo) throws ModeloNoValidoException {
		if (modelo == null)
			throw new ModeloNoValidoException("El modelo introducido no es válido.");
		this.modelo = modelo;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((matricula == null) ? 0 : matricula.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coche other = (Coche) obj;
		if (matricula == null) {
			if (other.matricula != null)
				return false;
		} else if (!matricula.equals(other.matricula))
			return false;
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "\nCoche [matricula=" + matricula + ", color=" + color
				+ ", modelo=" + modelo + "]";
	}

}