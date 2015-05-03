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
public class About extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final JPanel contentPanel = new JPanel();

	/**
	 * Create the dialog.
	 */
	public About() {
		setTitle("Acerca de...");
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 388, 232);
		
		JTextArea txtrConcesionarioDeCoches = new JTextArea();
		txtrConcesionarioDeCoches.setEditable(false);
		txtrConcesionarioDeCoches.setText("Concesionario de coches\r\n\r\nVersion: 2.0\r\n(c) Copyright 2015.  All rights reserved.\r\n\r\nRealizado por:\r\n\tElisa Navarro Zuara");
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