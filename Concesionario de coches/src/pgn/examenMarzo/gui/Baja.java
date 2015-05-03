/**
 * 
 */
package pgn.examenMarzo.gui;

import javax.swing.JOptionPane;

import pgn.examenMarzo.concesionarioCoches.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * @author Elisa Navarro Zuara
 * @version 2.0
 */
public class Baja extends ConcesionarioGui {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the dialog.
	 */
	public Baja() {
		super();
		setTitle("Baja");
		
		buttonAnterior.setVisible(false);
		buttonSiguiente.setVisible(false);
		
		enviar.setText("Eliminar");
		
		radioButtonPlata.setEnabled(false);
		radioButtonRojo.setEnabled(false);
		radioButtonAzul.setEnabled(false);
		
		comboBoxMarca.setEnabled(false);
		comboBoxModelo.setEnabled(false);
		
		enviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Coche coche = Gestionar.getConcesionario().get(textField.getText());
					mostrarCoche(coche);
					int n = JOptionPane.showOptionDialog(contentPanel,
							"¿Está seguro de que desea eliminarlo?",
							"Confirmar", JOptionPane.YES_NO_CANCEL_OPTION,
							JOptionPane.QUESTION_MESSAGE, null, null, null);
					switch (n) {
					case JOptionPane.YES_OPTION:
						Gestionar.getConcesionario().eliminar(textField.getText());
						Gestionar.setModificado(true);
						clear();
						break;
					}
				} catch (MatriculaNoValidaException | CocheNoExisteException e1) {
					JOptionPane.showMessageDialog(contentPanel,
							e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}
	
	/**
	 * Limpia el contenido del diálogo
	 */
	private void clear() {
		textField.setText("");
		buttonGroup.clearSelection();
		comboBoxMarca.setSelectedItem(null);
		comboBoxModelo.setSelectedItem(null);
	}

	/**
	 * Muestra las características de un coche
	 * 
	 * @param coche
	 *            Representa el coche a mostrar
	 */
	private void mostrarCoche(Coche coche) {
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