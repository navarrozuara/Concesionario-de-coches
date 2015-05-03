/**
 * 
 */
package pgn.examenMarzo.concesionarioCoches;

import java.io.Serializable;
import java.util.regex.Pattern;

/**
 * Un coche tendr� las siguientes caracter�sticas:
 * <ul>
 * <li>Color. Se limitar�n los colores a tres: plata, rojo y azul. Para
 * solicitar el color al dar de alta al coche se implementar� un m�todo
 * pedirColor que mediante la gesti�n de un men�, devolver� el color indicado.</li>
 * <li>Modelo. Se limitar�n los modelos de coches a siete: C�rdoba (marca Seat),
 * Toledo (marca Seat), Ibiza (marca Seat), Serie 1 (marca BMW), Serie 2 (marca
 * BMW), Serie 3 (marca BMW) y Serie 5 (marca BMW). Para solicitar el modelo al
 * dar de alta al coche podr� implementarse un m�todo pedirModelo que mediante
 * la gesti�n de un men�, devolver� el modelo indicado.</li>
 * <li>Matr�cula (�nica por coche). El formato de las matr�culas ser� el nuevo:
 * combinaci�n de cuatro n�meros (de 0000 a 9999) y tres letras, comenzando por
 * BBB y terminando por ZZZ, excluyendo vocales, la LL, la � y la Q.</li>
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
	 * Matr�cula del coche
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
	 * Patr�n para una matr�cula v�lida
	 */
	static final private Pattern patternMatricula = Pattern
			.compile("^\\d{4}[ -]?[[B-Z]&&[^QEIOU]]{3}$");

	/**
	 * Construye un nuevo coche de matr�cula, color y modelo especificado
	 * 
	 * @param matricula
	 *            Representa la matr�cula del nuevo coche
	 * @param color
	 *            Representa el color del nuevo coche
	 * @param modelo
	 *            Representa el modelo del nuevo coche
	 *            
	 * @throws MatriculaNoValidaException
	 *             Si la matr�cula no es v�lida
	 * @throws ColorNoValidoException
	 *             Si el color no es v�lido
	 * @throws ModeloNoValidoException
	 *             Si el modelo no es v�lido
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
	 * Construye un nuevo coche de matr�cula especificada
	 * 
	 * @param matricula
	 *            Representa la matr�cula del nuevo coche
	 * @throws MatriculaNoValidaException
	 *             Si la matr�cula no es v�lida
	 */
	Coche(String matricula) throws MatriculaNoValidaException {
		setMatricula(matricula);
	}

	/**
	 * Comprueba si la matr�cula del coche es v�lida o no
	 * 
	 * @param matricula
	 *            Representa la matr�cula a validar
	 * @return true si la matr�cula es v�lida, false si la matr�cula no es
	 *         v�lida
	 */
	public static boolean esValida(String matricula) {
		return patternMatricula.matcher(matricula).matches();
	}

	/**
	 * Modifica la matr�cula del coche
	 * 
	 * @param matricula
	 *            Representa la nueva matr�cula del coche
	 * @throws MatriculaNoValidaException
	 *             Si la matr�cula no es v�lida
	 */
	private void setMatricula(String matricula) throws MatriculaNoValidaException {
		if (!esValida(matricula))
			throw new MatriculaNoValidaException("La matr�cula introducida no es v�lida.");
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
	 * Devuelve la matr�cula del coche
	 * 
	 * @return Matr�cula del coche
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
	 *             Si el color no es v�lido
	 */
	private void setColor(Color color) throws ColorNoValidoException {
		if (color == null)
			throw new ColorNoValidoException("El color introducido no es v�lido.");
		this.color = color;
	}

	/**
	 * Modifica el modelo del coche
	 * 
	 * @param modelo
	 *            Representa el nuevo modelo del coche
	 * @throws ModeloNoValidoException
	 *             Si el modelo no es v�lido
	 */
	private void setModelo(Modelo modelo) throws ModeloNoValidoException {
		if (modelo == null)
			throw new ModeloNoValidoException("El modelo introducido no es v�lido.");
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