package vistas;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;

import controlador.MainController;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;

public class VistaMedico extends JPanel {
	
	JButton btnAtras;
	JButton btnAceptar;
	JLabel lblHoraDeLlamada;
	JComboBox comboBoxHoras;
	

	/**
	 * Create the panel.
	 */
	public VistaMedico() {
		setLayout(null);
		
		//Label Hora de llamada
		lblHoraDeLlamada = new JLabel("Hora de llamada:");
		lblHoraDeLlamada.setBounds(30, 152, 115, 14);
		add(lblHoraDeLlamada);
		
		//Botón atrás
		btnAtras = new JButton("Atras");
		btnAtras.setBounds(30, 53, 89, 23);
		add(btnAtras);
		
		//Botón aceptar
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(91, 251, 115, 23);
		add(btnAceptar);
		
		//Combo Box horas de llamada
		comboBoxHoras = new JComboBox();
		comboBoxHoras.setBounds(155, 149, 115, 20);
		add(comboBoxHoras);
		
		//Funciones de los botones
		//Boton atras
				btnAtras.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						//Llama al metodo showMain mediante MainController.getInstance
						System.out.println("Boton de Atras pulsado");
						MainController.getInstance().showMain();
					}
				});

	}
}
