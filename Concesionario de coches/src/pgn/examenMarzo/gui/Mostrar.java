/**
 * 
 */
package pgn.examenMarzo.gui;

import pgn.examenMarzo.concesionarioCoches.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * @author Elisa Navarro Zuara
 * @version 2.0
 */
public class Mostrar extends ConcesionarioGui {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Concesionario de coches
	 */
	private Concesionario concesionario;
	
	/**
	 * Índice del coche
	 */
	private int indiceCoche = -1;

	/**
	 * Create the dialog.
	 */
	public Mostrar() {
		super();
		setTitle("Mostrar concesionario");
		
		this.concesionario = Gestionar.getConcesionario();
		
		enviar.setVisible(false);
		
		textField.setEnabled(false);
		
		radioButtonPlata.setEnabled(false);
		radioButtonRojo.setEnabled(false);
		radioButtonAzul.setEnabled(false);

		comboBoxMarca.setEnabled(false);
		comboBoxModelo.setEnabled(false);
		
		buttonAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarAnterior();
			}
		});
		
		buttonSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarSiguiente();
			}
		});
		actualizar();
	}
	
	/**
	 * Actualiza el contenido del diálogo
	 */
	private void actualizar() {
		if (concesionario.size() == 0) {
			return;
		}
		indiceCoche = 0;
		mostrarCoche(concesionario.get(indiceCoche));
		comprobarBotones();		
	}
	
	/**
	 * Muestra el siguiente coche del concesionario
	 */
	private void mostrarSiguiente() {
		mostrarCoche(concesionario.get(++indiceCoche));
		comprobarBotones();
	}

	/**
	 * Muestra el coche anterior del concesionario
	 */
	private void mostrarAnterior() {
		mostrarCoche(concesionario.get(--indiceCoche));
		comprobarBotones();
	}
	
	/**
	 * Comprueba si existe otro coche en el concesionario, tanto en el botón
	 * siguiente como en el botón anterior
	 */
	private void comprobarBotones() {
		if (concesionario.get(indiceCoche + 1) == null)
			buttonSiguiente.setEnabled(false);
		else
			buttonSiguiente.setEnabled(true);

		if (concesionario.get(indiceCoche - 1) == null)
			buttonAnterior.setEnabled(false);
		else
			buttonAnterior.setEnabled(true);
	}
	
	/**
	 * Muestra las características de un coche
	 * 
	 * @param coche
	 *            Representa el coche a mostrar
	 */
	private void mostrarCoche(Coche coche) {
		textField.setText(coche.getMatricula());
		switch (coche.getColor()) {
		case PLATA:
			radioButtonPlata.setSelected(true);
			break;
		case ROJO:
			radioButtonRojo.setSelected(true);
			break;
		case AZUL:
			radioButtonAzul.setSelected(true);
		}
		comboBoxMarca.addItem(coche.getModelo().getMarca());
		comboBoxMarca.setSelectedItem(coche.getModelo().getMarca());
		comboBoxModelo.addItem(coche.getModelo());
		comboBoxModelo.setSelectedItem(coche.getModelo());
	}
	
}