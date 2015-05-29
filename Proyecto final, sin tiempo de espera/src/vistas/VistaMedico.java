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

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class VistaMedico extends JPanel {

	JButton btnAtras;
	JButton btnAceptar;
	JLabel lblHoraDeLlamada;
	JLabel lblMinutos;
	JComboBox comboBoxHoras;
	JComboBox comboBoxMinutos;
	
	int minutos=0;
	int horas=0;
	
	
	
	public VistaMedico() {
		setLayout(null);
		
		//Label Hora de llamada
		lblHoraDeLlamada = new JLabel("Hora de llamada:");
		lblHoraDeLlamada.setBounds(30, 11, 115, 14);
		add(lblHoraDeLlamada);

		//Label Hora de minutos
		lblMinutos = new JLabel("Minutos de llamada:");
		lblMinutos.setBounds(30, 77, 110, 14);
		add(lblMinutos);
		//Botón atrás
		btnAtras = new JButton("Atras");
		btnAtras.setBounds(42, 227, 89, 23);
		add(btnAtras);

		//Botón aceptar
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(30, 177, 115, 23);
		add(btnAceptar);

		//Combo Box horas de llamada
		comboBoxHoras = new JComboBox();
		comboBoxHoras.setBounds(30, 36, 115, 20);
		add(comboBoxHoras);
		for (int i=00; i<24;i++){
			comboBoxHoras.addItem(i);
			System.out.println();
		}

		//Combo Box minutos de llamada
		comboBoxMinutos = new JComboBox();
		comboBoxMinutos.setBounds(30, 102, 115, 20);
		add(comboBoxMinutos);
		for (int i=0; i<60;i++){
			comboBoxMinutos.addItem(i);
			System.out.println();
			i=i+14;
		}

		//Funciones de los comboBox
		//comboBox Horas
		comboBoxHoras.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				horas=(int) comboBoxHoras.getSelectedItem();						
			}
		});
		//comboBox Minutos
		comboBoxMinutos.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {				
				minutos=(int) comboBoxMinutos.getSelectedItem();				
			}
		});

		//Funciones de los botones
		//Boton aceptar
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Boton de Aceptar pulsado");
				String horario = new String (horas+":"+minutos);
				//Unimos horas y minutos y los juntamos en la variable "horario"
				//horario=horas+":"+minutos;
				MainController.getInstance().setHorario(horario);
				System.out.println("montaje: "+horario);
				
			}
		});
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
