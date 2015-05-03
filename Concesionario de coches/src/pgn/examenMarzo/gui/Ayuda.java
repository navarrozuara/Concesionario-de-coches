/**
 * 
 */
package pgn.examenMarzo.gui;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ScrollPaneConstants;

/**
 * @author Elisa Navarro Zuara
 * @version 2.0
 */
public class Ayuda extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final JPanel contentPanel = new JPanel();

	/**
	 * Create the dialog.
	 */
	public Ayuda() {
		setTitle("Ver ayuda");
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 388, 232);
		
		JTextArea txtrConcesionarioDeCoches = new JTextArea();
		txtrConcesionarioDeCoches.setEditable(false);
		txtrConcesionarioDeCoches.setText("Queremos modelar un concesionario de coches en Java.\r\nNos limitaremos a las  siguientes opciones:\r\n\r\n1. Alta de un coche (se pedir\u00E1 matricula, color y modelo).\r\n2. Baja de  un coche (por matr\u00EDcula).\r\n3. Mostrar un coche (por matr\u00EDcula).\r\n4. Mostrar concesionario (todos los coches del concesionario).\r\n5. Mostrar coches de un color.\r\n\r\nL\u00F3gicamente, no podr\u00E1 a\u00F1adirse un coche inv\u00E1lido o ya contenido\r\n(no pueden existir dos coches con la misma matr\u00EDcula en el concesionario).\r\nPor cada coche que se d\u00E9 de alta, han de conocerse todas sus caracter\u00EDsticas.\r\nNinguna de las caracter\u00EDsticas del coche puede ser por defecto.\r\n\r\nUn coche tendr\u00E1 las siguientes caracter\u00EDsticas:\r\n\r\n1. Color. Se limitar\u00E1n los colores a tres: plata, rojo y azul.\r\n\r\n2. Modelo. Se limitar\u00E1n los modelos de coches a siete:\r\nC\u00F3rdoba (marca Seat), Toledo (marca Seat), Ibiza (marca Seat),\r\nSerie 1 (marca BMW), Serie 2 (marca BMW), Serie 3 (marca BMW)\r\ny Serie 5 (marca BMW).\r\n\r\n3. Matr\u00EDcula (\u00FAnica por coche). El formato de las matr\u00EDculas ser\u00E1 el nuevo:\r\ncombinaci\u00F3n de cuatro n\u00FAmeros (de 0000 a 9999) y tres letras,\r\ncomenzando por BBB y terminando por ZZZ, excluyendo vocales,\r\nla LL, la \u00D1 y la Q.");
		txtrConcesionarioDeCoches.setBounds(0, 0, 382, 153);
		
		JScrollPane scrollPane = new JScrollPane(txtrConcesionarioDeCoches);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(0, 0, 382, 142);
		
		JButton aceptar = new JButton("Aceptar");
		aceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		aceptar.setBounds(233, 162, 91, 23);
		
		getContentPane().setLayout(null);
		getContentPane().add(scrollPane);
		getContentPane().add(aceptar);
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
	}
	
}