/**
 * 
 */
package pgn.examenMarzo.gui;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;

import pgn.examenMarzo.concesionarioCoches.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;

/**
 * @author Elisa Navarro Zuara
 * @version 2.0
 */
public class ElegirColor extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final JPanel contentPanel = new JPanel();
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JPanel panel;
	private JRadioButton radioButtonPlata;
	private JRadioButton radioButtonRojo;
	private JRadioButton radioButtonAzul;
	private JButton aceptar;
	private JButton salir;
	private MostrarPorColor mostrarPorColor;

	/**
	 * Create the dialog.
	 */
	public ElegirColor() {
		setTitle("Elegir color");
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 298, 109);
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Color", TitledBorder.LEADING, TitledBorder.TOP, null, new java.awt.Color(0, 0, 0)));
		panel.setBounds(37, 0, 210, 45);
		panel.setLayout(null);
		
		radioButtonPlata = new JRadioButton("Plata");
		radioButtonPlata.setBounds(12, 16, 65, 23);
		panel.add(radioButtonPlata);
		buttonGroup.add(radioButtonPlata);
		
		radioButtonRojo = new JRadioButton("Rojo");
		radioButtonRojo.setBounds(76, 16, 65, 23);
		panel.add(radioButtonRojo);
		buttonGroup.add(radioButtonRojo);
		
		radioButtonAzul = new JRadioButton("Azul");
		radioButtonAzul.setBounds(138, 16, 65, 23);
		panel.add(radioButtonAzul);
		buttonGroup.add(radioButtonAzul);
		
		aceptar = new JButton("Aceptar");
		aceptar.setBounds(114, 52, 86, 23);
		aceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Color color = getColor();
				if (color != null) {
					ArrayList<Coche> coches = Gestionar.getConcesionario().getCochesColor(color);
					if (coches.isEmpty()) {
						JOptionPane.showMessageDialog(contentPanel,
								"No existe ningún coche de ese color.",
								"Error", JOptionPane.ERROR_MESSAGE);
						return;
					}
					mostrarPorColor = new MostrarPorColor(coches);
					mostrarPorColor.setVisible(true);
				} else
					JOptionPane.showMessageDialog(contentPanel,
							"Debes seleccionar un color.", "Error",
							JOptionPane.ERROR_MESSAGE);
			}
		});
		
		salir = new JButton("Salir");
		salir.setBounds(210, 52, 65, 23);
		salir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		
		getContentPane().setLayout(null);
		getContentPane().add(panel);
		getContentPane().add(aceptar);
		getContentPane().add(salir);
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
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