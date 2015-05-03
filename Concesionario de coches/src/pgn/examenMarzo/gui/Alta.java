/**
 * 
 */
package pgn.examenMarzo.gui;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

import pgn.examenMarzo.concesionarioCoches.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

/**
 * @author Elisa Navarro Zuara
 * @version 2.0
 */
public class Alta extends ConcesionarioGui {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the dialog.
	 */
	public Alta() {
		super();
		setTitle("Alta");
		
		buttonAnterior.setVisible(false);
		buttonSiguiente.setVisible(false);
		
		enviar.setText("Añadir");
		
		textField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				if (!Coche.esValida(textField.getText()))
					textField.setForeground(java.awt.Color.RED);
			}
			@Override
			public void focusGained(FocusEvent e) {
				textField.setForeground(java.awt.Color.BLACK);
			}
		});
		
		comboBoxMarca.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				comboBoxModelo.setModel(new DefaultComboBoxModel(getModelo()));
			}
		});
		comboBoxMarca.setModel(new DefaultComboBoxModel(Marca.values()));
		comboBoxModelo.setModel(new DefaultComboBoxModel(getModelo()));
		
		enviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Gestionar.getConcesionario().annadir(textField.getText(), getColor(),
							(Modelo) comboBoxModelo.getSelectedItem());
					Gestionar.setModificado(true);
					JOptionPane.showMessageDialog(contentPanel, "Coche añadido con éxito.");
				} catch (MatriculaNoValidaException | ColorNoValidoException
						| ModeloNoValidoException | CocheYaExisteException e1) {
					JOptionPane.showMessageDialog(contentPanel,
							e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}
	
	/**
	 * Devuelve un array con los modelos de una marca
	 * 
	 * @return Array de modelos
	 */
	private Object[] getModelo() {
		Marca marca = (Marca) comboBoxMarca.getSelectedItem();
		ArrayList<Modelo> modelos = new ArrayList<Modelo>();
		for (Modelo m : Modelo.values()) {
			if (m.getMarca() == marca)
				modelos.add(m);
		}
		return modelos.toArray();
	}
	
	/**
	 * Devuelve el color seleccionado
	 * 
	 * @return Color seleccionado
	 */
	private Color getColor() {
		if (radioButtonPlata.isSelected())
			return Color.PLATA;
		else if (radioButtonRojo.isSelected())
			return Color.ROJO;
		else if (radioButtonAzul.isSelected())
			return Color.AZUL;
		else
			return null;
	}

}