/**
 * 
 */
package pgn.examenMarzo.gui;

import pgn.examenMarzo.concesionarioCoches.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JOptionPane;

/**
 * @author Elisa Navarro Zuara
 * @version 2.0
 */
public class MostrarPorColor extends ConcesionarioGui {

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
	public MostrarPorColor(ArrayList<Coche> concesionario) {
		super();
		setTitle("Mostrar por color");
		
		this.concesionario = generarConcesionario(concesionario);
		
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
	
	/**
	 * Genera un concesionario con los coches de un determinado color
	 * 
	 * @param concesionario
	 *            Representa la lista con los coches de un determinado color
	 * @return Concesionario generado
	 */
	private Concesionario generarConcesionario(ArrayList<Coche> concesionario) {
		Concesionario concesionarioPorColor = new Concesionario();
		for (Coche coche : concesionario) {
			try {
				concesionarioPorColor.annadir(coche.getMatricula(),
						coche.getColor(), coche.getModelo());
			} catch (MatriculaNoValidaException | ColorNoValidoException
					| ModeloNoValidoException | CocheYaExisteException e) {
				JOptionPane.showMessageDialog(contentPanel, e.getMessage(),
						"Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		return concesionarioPorColor;
	}
	
}