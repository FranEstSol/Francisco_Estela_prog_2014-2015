package vistas;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;

import controlador.MainController;

import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Iterator;

public class VistaLogin extends JPanel {
	
	//INICIALIZACIÓN DE VARIABLES
	JComboBox comboBoxMedicos;
	JTextField textFieldPass;
	JButton btnLogin;
	private JButton btnAtras;

	public VistaLogin() {
		setLayout(null);
		
		//Desplegable médicos
		comboBoxMedicos = new JComboBox();
		comboBoxMedicos.setBounds(60, 59, 200, 20);
		add(comboBoxMedicos);
		
		//Caja texto contraseña
		textFieldPass = new JTextField();
		textFieldPass.setBounds(60, 115, 200, 20);
		add(textFieldPass);
		textFieldPass.setColumns(10);
		
		//Botón login
		btnLogin = new JButton("Entrar");		
		btnLogin.setBounds(110, 213, 100, 23);
		add(btnLogin);		
		
		//Boton atras
		btnAtras = new JButton("Atras");		
		btnAtras.setBounds(110, 266, 100, 23);
		add(btnAtras);
		
		
		
		//Funciones de los botones
		//Boton login
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Llama al metodo showMedico mediante MainController.getInstance
				System.out.println("Boton de Login pulsado");
				MainController.getInstance().showMedico();
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
	//Metodo putUsuarios que añade la informacion al combobox
	//Recibe el ArrayList usuarios desde showPrincipal (En VistaApp) y, mediante el Iterator, lo monta en el combobox.
	public void putUsuarios(ArrayList nombre) {
		Iterator<String> it =nombre.iterator();
		while (it.hasNext())
		{
			System.out.println("AÑADIDO EL MEDICO AL COMBOBOX ");
			comboBoxMedicos.addItem((String)it.next());
		}	
	}
}
