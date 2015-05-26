package vistas;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;

import controlador.MainController;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class VistaUsuario extends JPanel {
	
	private JTable tablaConsultas;
	JLabel lblConsultasActivas;
	JButton btnAtras;
	JScrollPane scrollPaneConsultas;
	
	private JTextField textFieldPrueba;
	
	public VistaUsuario() {
		setLayout(null);
		
		//Label consultas activas
		JLabel lblConsultasActivas = new JLabel("Consultas activas");
		lblConsultasActivas.setBounds(10, 72, 114, 14);
		add(lblConsultasActivas);
		
		//Botón atrás
		btnAtras = new JButton("Atras");
		btnAtras.setBounds(10, 11, 89, 23);
		add(btnAtras);
		
		//Scroll Pane consultas
		scrollPaneConsultas = new JScrollPane();
		scrollPaneConsultas.setBounds(10, 97, 286, 278);
		add(scrollPaneConsultas);
		
		//Tabla consultas
		tablaConsultas = new JTable();
		scrollPaneConsultas.setViewportView(tablaConsultas);
		

		
		//Funciones de los botones
		//Boton atras
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Llama al método showMain mediante MainController.getInstance
				System.out.println("Boton de Atras pulsado");
				MainController.getInstance().showMain();
				
			}
		});
	}
}
