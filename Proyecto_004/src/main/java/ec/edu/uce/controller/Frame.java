package ec.edu.uce.controller;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * @author Edgar Tipan
 */

public class Frame {

	private static JPanel panel;
	private static JFrame frame;
	private static Font bigFont = new Font("Arial", Font.BOLD, 20);

	public void frameApp() {
		frame = new JFrame("Proyecto DB");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 600);
		frame.setLocationRelativeTo(null);

		panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.setBackground(Color.GRAY.darker());

		frame.getContentPane().add(panel, BorderLayout.CENTER);

		mostrarInterfazPrincipal();
		frame.setVisible(true);
	}

	private static void mostrarInterfazPrincipal() {
		panel.removeAll();
		
		JButton insertarDatosBtn = crearBoton("Insertar Datos");
		JButton buscarDatosBtn = crearBoton("Buscar Datos");
		JButton actualizarDatosBtn = crearBoton("Actualizar Datos");
		JButton borrarDatosBtn = crearBoton("Borrar Datos");

		agregarComponentesAlPanel(insertarDatosBtn, buscarDatosBtn, actualizarDatosBtn, borrarDatosBtn);

		insertarDatosBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mostrarInterfazInsertarDatos();
			}
		});

		panel.revalidate();
		panel.repaint();
	}

	private static void mostrarInterfazInsertarDatos() {
		panel.removeAll();

		JButton regresarBtn = crearBoton("Regresar");
		regresarBtn.setAlignmentX(Component.CENTER_ALIGNMENT);

		JLabel etiqueta = new JLabel("Seleccione una opción");
		etiqueta.setFont(bigFont);
		etiqueta.setForeground(Color.WHITE);
		etiqueta.setAlignmentX(Component.CENTER_ALIGNMENT);

		String[] opciones = { "Opción 1", "Opción 2", "Opción 3", "Opción 4" };
		JComboBox<String> cajaDeSeleccion = new JComboBox<>(opciones);
		cajaDeSeleccion.setMaximumSize(new Dimension(200, 25));
		cajaDeSeleccion.setFont(bigFont);
		cajaDeSeleccion.setAlignmentX(Component.CENTER_ALIGNMENT);

		agregarComponentesAlPanel(regresarBtn, Box.createRigidArea(new Dimension(0, 20)), etiqueta, cajaDeSeleccion);

		regresarBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mostrarInterfazPrincipal();
			}
		});

		cajaDeSeleccion.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					panel.removeAll();

					agregarComponentesAlPanel(regresarBtn, Box.createRigidArea(new Dimension(0, 20)), etiqueta,
							cajaDeSeleccion);

					String[][] nombresDeCamposDeTexto = { { "Campo A1", "Campo A2", "Campo A3", "Campo A4" },
							{ "Campo B1", "Campo B2", "Campo B3", "Campo B4" },
							{ "Campo C1", "Campo C2", "Campo C3", "Campo C4" },
							{ "Campo D1", "Campo D2", "Campo D3", "Campo D4", "Campo D5", "Campo D6" } };
					String[] nombresSeleccionados = nombresDeCamposDeTexto[cajaDeSeleccion.getSelectedIndex()];
					for (String nombre : nombresSeleccionados) {
						JLabel campoEtiqueta = new JLabel(nombre);
						campoEtiqueta.setFont(bigFont);
						campoEtiqueta.setForeground(Color.WHITE);
						campoEtiqueta.setAlignmentX(Component.CENTER_ALIGNMENT);
						panel.add(campoEtiqueta);
						JTextField campoDeTexto = new JTextField();
						campoDeTexto.setMaximumSize(
								new Dimension(Integer.MAX_VALUE, campoDeTexto.getPreferredSize().height));
						panel.add(campoDeTexto);
					}

					panel.revalidate();
					panel.repaint();
				}
			}
		});

		panel.revalidate();
		panel.repaint();
	}

	private static JButton crearBoton(String texto) {
		JButton boton = new JButton(texto);
		boton.setAlignmentX(Component.CENTER_ALIGNMENT);
		boton.setFont(bigFont);
		boton.setBackground(Color.CYAN.darker()); 
		boton.setForeground(Color.WHITE);
		return boton;
	}

	private static void agregarComponentesAlPanel(Component... componentes) {
		panel.add(Box.createVerticalGlue()); 
		for (Component componente : componentes) {
			panel.add(componente);
			panel.add(Box.createRigidArea(new Dimension(0, 20))); 
		}
		panel.add(Box.createVerticalGlue()); 
	}
}
