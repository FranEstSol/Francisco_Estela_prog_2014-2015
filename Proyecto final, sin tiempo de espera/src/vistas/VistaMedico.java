package vistas;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;

import controlador.MainController;

public class VistaMedico extends JPanel {

	/**
	 * Create the panel.
	 */
	public VistaMedico() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("VISTA MEDICO");
		lblNewLabel.setBounds(174, 78, 120, 29);
		add(lblNewLabel);
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.setBounds(151, 243, 89, 23);
		add(btnAtras);
		
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
