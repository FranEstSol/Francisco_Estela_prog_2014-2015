package vistas;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;

import controlador.MainController;

public class VistaUsuario extends JPanel {

	/**
	 * Create the panel.
	 */
	public VistaUsuario() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Vista Usuario");
		lblNewLabel.setBounds(180, 61, 105, 19);
		add(lblNewLabel);
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.setBounds(169, 246, 89, 23);
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
