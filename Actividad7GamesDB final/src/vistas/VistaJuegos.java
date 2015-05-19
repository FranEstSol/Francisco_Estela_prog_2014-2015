package vistas;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;

import controlador.MainController;

import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VistaJuegos extends JPanel 
{
	
	public VistaJuegos() 
	{
		setLayout(null);
		
		JLabel lblPanelDeJuegos = new JLabel("PANEL DE JUEGOS");
		lblPanelDeJuegos.setBounds(178, 67, 89, 14);
		add(lblPanelDeJuegos);
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				//Llama al metodo showJuegos mediante MainController.getInstance
				System.out.println("Boton Atras pulsado");
				MainController.getInstance().showPrincipal();
			}
		});
		btnAtras.setBounds(69, 227, 89, 23);
		add(btnAtras);
	}
}
