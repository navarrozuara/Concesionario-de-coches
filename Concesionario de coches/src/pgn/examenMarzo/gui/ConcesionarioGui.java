/**
 * 
 */
package pgn.examenMarzo.gui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import pgn.examenMarzo.concesionarioCoches.*;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;

/**
 * @author Elisa Navarro Zuara
 * @version 2.0
 */
public class ConcesionarioGui extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected final JPanel contentPanel = new JPanel();
	protected JTextField textField;
	protected JLabel lblMatricula;
	protected JLabel lblMarca;
	protected JLabel lblModelo;
	private JPanel panel;
	protected final ButtonGroup buttonGroup = new ButtonGroup();
	protected JRadioButton radioButtonPlata;
	protected JRadioButton radioButtonRojo;
	protected JRadioButton radioButtonAzul;
	protected JComboBox<Marca> comboBoxMarca;
	protected JComboBox<Modelo> comboBoxModelo;
	protected JButton enviar;
	protected JButton buttonAnterior;
	protected JButton buttonSiguiente;
	protected JButton salir;

	/**
	 * Create the dialog.
	 */
	public ConcesionarioGui() {
		super();
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 388, 232);
		
		lblMatricula = new JLabel("Matr\u00EDcula");
		lblMatricula.setBounds(26, 11, 76, 30);
		
		textField = new JTextField();
		textField.setBounds(106, 16, 177, 20);
		textField.setColumns(10);
		
		lblMarca = new JLabel("Marca");
		lblMarca.setBounds(26, 103, 49, 14);
		
		comboBoxMarca = new JComboBox<Marca>();
		comboBoxMarca.setBounds(106, 99, 65, 22);
		
		lblModelo = new JLabel("Modelo");
		lblModelo.setBounds(26, 142, 49, 14);
		
		comboBoxModelo = new JComboBox<Modelo>();
		comboBoxModelo.setBounds(106, 138, 92, 22);
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Color", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(26, 43, 257, 45);
		panel.setLayout(null);
		
		radioButtonPlata = new JRadioButton("Plata");
		radioButtonPlata.setBounds(16, 16, 65, 23);
		panel.add(radioButtonPlata);
		buttonGroup.add(radioButtonPlata);
		
		radioButtonRojo = new JRadioButton("Rojo");
		radioButtonRojo.setBounds(96, 16, 65, 23);
		panel.add(radioButtonRojo);
		buttonGroup.add(radioButtonRojo);
		
		radioButtonAzul = new JRadioButton("Azul");
		radioButtonAzul.setBounds(176, 16, 65, 23);
		panel.add(radioButtonAzul);
		buttonGroup.add(radioButtonAzul);
		
		enviar = new JButton();
		enviar.setBounds(205, 164, 86, 23);
		
		buttonAnterior = new JButton("<");
		buttonAnterior.setBounds(205, 164, 43, 23);
		
		buttonSiguiente = new JButton(">");
		buttonSiguiente.setBounds(248, 164, 43, 23);
		
		salir = new JButton("Salir");
		salir.setBounds(300, 164, 65, 23);
		salir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		
		getContentPane().setLayout(null);
		getContentPane().add(textField);
		getContentPane().add(lblMarca);
		getContentPane().add(lblModelo);
		getContentPane().add(lblMatricula);
		getContentPane().add(panel);
		getContentPane().add(comboBoxMarca);
		getContentPane().add(comboBoxModelo);
		getContentPane().add(enviar);
		getContentPane().add(buttonAnterior);
		getContentPane().add(buttonSiguiente);
		getContentPane().add(salir);
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
	}

}