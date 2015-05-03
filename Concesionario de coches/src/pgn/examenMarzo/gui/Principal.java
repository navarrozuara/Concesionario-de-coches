/**
 * 
 */
package pgn.examenMarzo.gui;

import java.awt.EventQueue;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.filechooser.FileNameExtensionFilter;

import pgn.examenMarzo.concesionarioCoches.Concesionario;
import pgn.examenMarzo.concesionarioCoches.Fichero;
import pgn.examenMarzo.concesionarioCoches.Gestionar;

import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;

/**
 * @author Elisa Navarro Zuara
 * @version 2.0
 */
public class Principal {

	private JFrame frame;
	private JMenuBar menuBar;
	private JMenu mnFicheros; 
	private JMenu mnCoches; 
	private JMenu mnAyuda;
	
	private JFileChooser fileChooser = new JFileChooser();
	private FileNameExtensionFilter filtro = new FileNameExtensionFilter("*.obj", "obj");
	
	private Alta alta;
	private Baja baja;
	private Mostrar mostrar;
	private ElegirColor elegirColor;
	private MostrarPorMatricula mostrarPorMatricula;
	private Ayuda ayuda;
	private About about;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal window = new Principal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Principal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setTitle(Gestionar.getFile().getPath());
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		fileChooser.setFileFilter(filtro);
		
		menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		mnFicheros = new JMenu("Ficheros");
		mnFicheros.setMnemonic('F');
		menuBar.add(mnFicheros);
		
		JMenuItem mntmNuevo = new JMenuItem("Nuevo");
		mntmNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				comprobarCambios();
				Gestionar.setConcesionario(new Concesionario());
				Gestionar.setFile(new File("Sin título"));
				Gestionar.setModificado(false);
				frame.setTitle(Gestionar.getFile().getPath());
			}
		});
		mntmNuevo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK));
		mnFicheros.add(mntmNuevo);
		
		JMenuItem mntmAbrir = new JMenuItem("Abrir...");
		mntmAbrir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrir();
			}
		});
		mntmAbrir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK));
		mnFicheros.add(mntmAbrir);
		
		JMenuItem mntmGuardar = new JMenuItem("Guardar");
		mntmGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				guardar();
			}
		});
		mntmGuardar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
		mnFicheros.add(mntmGuardar);
		
		JMenuItem mntmGuardarComo = new JMenuItem("Guardar como...");
		mntmGuardarComo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardarComo();
			}
		});
		mntmGuardarComo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK | InputEvent.ALT_MASK));
		mnFicheros.add(mntmGuardarComo);
		
		mnFicheros.addSeparator();
		
		JMenuItem mntmSalir = new JMenuItem("Salir");
		mntmSalir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, InputEvent.ALT_MASK));
		mntmSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		mnFicheros.add(mntmSalir);
		
		mnCoches = new JMenu("Coches");
		mnCoches.setMnemonic('C');
		menuBar.add(mnCoches);
		
		JMenuItem mntmAlta = new JMenuItem("Alta");
		mntmAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				alta = new Alta();
				alta.setVisible(true);	
			}
		});
		mntmAlta.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_MASK));
		mnCoches.add(mntmAlta);
		
		JMenuItem mntmBaja = new JMenuItem("Baja");
		mntmBaja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				baja = new Baja();
				baja.setVisible(true);
			}
		});
		mntmBaja.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, InputEvent.CTRL_MASK));
		mnCoches.add(mntmBaja);
		
		JMenu mnBuscar = new JMenu("Buscar");
		mnCoches.add(mnBuscar);
		
		JMenuItem mntmPorMatricula = new JMenuItem("Por matr\u00EDcula...");
		mntmPorMatricula.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarPorMatricula();
			}
		});
		mnBuscar.add(mntmPorMatricula);
		
		JMenuItem mntmPorColor = new JMenuItem("Por color...");
		mntmPorColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarPorColor();
			}
		});
		mnBuscar.add(mntmPorColor);
		
		JMenuItem mntmMostrarConcesionario = new JMenuItem("Mostrar concesionario");
		mntmMostrarConcesionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mostrar();
			}
		});
		mnCoches.add(mntmMostrarConcesionario);
		
		mnAyuda = new JMenu("Ayuda");
		mnAyuda.setMnemonic('y');
		menuBar.add(mnAyuda);
		
		JMenuItem mntmAyuda = new JMenuItem("Ver ayuda");
		mntmAyuda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ayuda = new Ayuda();
				ayuda.setVisible(true);
			}
		});
		mntmAyuda.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, InputEvent.SHIFT_MASK));
		mnAyuda.add(mntmAyuda);
		
		JMenuItem mntmAcerca = new JMenuItem("Acerca de...");
		mntmAcerca.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0));
		mntmAcerca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				about = new About();
				about.setVisible(true);
			}
		});
		mnAyuda.add(mntmAcerca);
		
		frame.getContentPane().setLayout(null);
	}

	/**
	 * Comprueba si se ha realizado algún cambio en el concesionario, en caso de
	 * que se haya realizado algún cambio el concesionario se guarda si el
	 * usuario lo desea
	 */
	private void comprobarCambios() {
		if (Gestionar.isModificado()) {
			int n = JOptionPane.showOptionDialog(frame.getContentPane(),
							"El concesionario ha sido modificado. ¿Desea guardar los cambios?",
							"Confirmar", JOptionPane.YES_NO_OPTION,
							JOptionPane.QUESTION_MESSAGE, null, null, null);
			switch (n) {
			case JOptionPane.YES_OPTION:
				guardar();
				break;
			}
		}
	}
	
	/**
	 * Recupera el contenido de un fichero, en caso de que el concesionario se
	 * haya modificado se pregunta al usuario si desea guardarlo
	 */
	private void abrir() {
		comprobarCambios();
		int seleccion = fileChooser.showOpenDialog(frame);
		if (seleccion == JFileChooser.APPROVE_OPTION) {
			try {
				File file = fileChooser.getSelectedFile();
				Gestionar.setConcesionario(Fichero.abrir(file));
				Gestionar.setFile(file);
				frame.setTitle(Gestionar.getFile().getPath());
			} catch (ClassNotFoundException e) {
				JOptionPane.showMessageDialog(frame.getContentPane(),
						"Fichero con información distinta a la esperada.",
						"Warning", JOptionPane.WARNING_MESSAGE);
			} catch (IOException e) {
				JOptionPane.showMessageDialog(frame.getContentPane(),
						"El sistema no puede abrir el fichero.", "Warning",
						JOptionPane.WARNING_MESSAGE);
			}
		}
	}
	
	/**
	 * Guarda el contenido en un fichero, si no hay un fichero previo se
	 * solicita el nombre del mismo
	 */
	private void guardar() {
		if (Gestionar.getFile().getName().equals("Sin título"))
			guardarComo();
		else {
			try {
				File file = fileChooser.getSelectedFile();
				Fichero.guardar(file, Gestionar.getConcesionario());
				Gestionar.setModificado(false);
				Gestionar.setFile(file);
				frame.setTitle(Gestionar.getFile().getPath());
			} catch (IOException e) {
				JOptionPane.showMessageDialog(frame.getContentPane(),
						"El sistema no puede guardar el fichero.", "Warning",
						JOptionPane.WARNING_MESSAGE);
			}
		}
	}
	
	/**
	 * Guarda el contenido en un fichero solicitando el nombre del mismo, en
	 * caso de existir el fichero se pregunta al usuario si desea
	 * sobreescribirlo
	 */
	private void guardarComo() {
		int seleccion = fileChooser.showSaveDialog(frame);
		if (seleccion == JFileChooser.APPROVE_OPTION) {
			try {
				File file = fileChooser.getSelectedFile();
				if (Fichero.isExists(file)) {
					int n = JOptionPane.showOptionDialog(frame.getContentPane(),
							"El fichero ya existe. ¿Desea sobreescribirlo?",
							"Confirmar", JOptionPane.YES_NO_OPTION,
							JOptionPane.QUESTION_MESSAGE, null, null, null);
					switch (n) {
					case JOptionPane.NO_OPTION:
						return;
					}
				}
				Fichero.guardar(file, Gestionar.getConcesionario());
				Gestionar.setModificado(false);
				Gestionar.setFile(file);
				frame.setTitle(Gestionar.getFile().getPath());
			} catch (IOException e) {
				JOptionPane.showMessageDialog(frame.getContentPane(),
						"El sistema no puede guardar el fichero.",
						"Warning", JOptionPane.WARNING_MESSAGE);
			}
		}
	}

	/**
	 * Muestra los coches del concesionario
	 */
	private void mostrar() {
		if (Gestionar.getConcesionario().size() == 0) {
			JOptionPane.showMessageDialog(frame.getContentPane(),
					"No hay coches en el concesionario.", "Error",
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		mostrar = new Mostrar();
		mostrar.setVisible(true);
	}

	/**
	 * Muestra por color los coches del concesionario
	 */
	private void mostrarPorColor() {
		if (Gestionar.getConcesionario().size() == 0) {
			JOptionPane.showMessageDialog(frame.getContentPane(),
					"No hay coches en el concesionario.", "Error",
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		elegirColor = new ElegirColor();
		elegirColor.setVisible(true);
	}
	
	/**
	 * Muestra por matrícula los coches del concesionario
	 */
	private void mostrarPorMatricula() {
		if (Gestionar.getConcesionario().size() == 0) {
			JOptionPane.showMessageDialog(frame.getContentPane(),
					"No hay coches en el concesionario.", "Error",
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		mostrarPorMatricula = new MostrarPorMatricula();
		mostrarPorMatricula.setVisible(true);
	}
	
}