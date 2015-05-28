package vistas;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;

//import controlador.Autenticar;
import controlador.MainController;

import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JPasswordField;
import javax.swing.JLabel;

public class VistaLogin extends JPanel {
	
	//INICIALIZACI�N DE VARIABLES
	JComboBox comboBoxMedicos;
	JButton btnLogin;
	JLabel lblUsuario;
	JLabel lblPassword;
	JLabel lblAlerta;	
	JButton btnAtras;
	JPasswordField passwordField;
	
	public static String passField=null;
	
	public VistaLogin() {
		setLayout(null);
		
		//Etiquetas
		lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(60, 34, 75, 14);
		add(lblUsuario);
		
		lblPassword = new JLabel("Contrase\u00F1a");
		lblPassword.setBounds(60, 103, 90, 14);
		add(lblPassword);
		
		lblAlerta = new JLabel("");
		lblAlerta.setBounds(60, 173, 200, 14);
		add(lblAlerta);
		
		//Desplegable m�dicos
		comboBoxMedicos = new JComboBox();
		comboBoxMedicos.setBounds(60, 59, 200, 20);
		add(comboBoxMedicos);
		
		//Bot�n login
		btnLogin = new JButton("Entrar");		
		btnLogin.setBounds(110, 232, 100, 23);
		add(btnLogin);		
		
		//Boton atras
		btnAtras = new JButton("Atras");		
		btnAtras.setBounds(110, 266, 100, 23);
		add(btnAtras);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(60, 142, 200, 20);
		add(passwordField);
	
		//Funciones de los botones
		//Boton login
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				//Llama al metodo showMedico mediante MainController.getInstance				
				System.out.println("Boton de Login pulsado");
				System.out.println("Texto recogido del texto al pulsar login:  "+passwordField.getText());
				passField=passwordField.getText();
				MainController.getInstance().logintest();
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
	//Metodo putUsuarios que a�ade la informacion al combobox
	//Recibe el ArrayList usuarios desde showPrincipal (En VistaApp) y, mediante el Iterator, lo monta en el combobox.
	public void putUsuarios(ArrayList nombre) {
		//Limpia el combobox para evitar repetir usuarios y volvemos a rellenarlo.
		comboBoxMedicos.removeAllItems();
		//Rellena el combobox
		Iterator<String> it =nombre.iterator();
		while (it.hasNext()) {
			System.out.println("A�ADIDO EL MEDICO AL COMBOBOX ");
			comboBoxMedicos.addItem((String)it.next());
		}	
	}
	
	//ESTO ME CABREA
/*	public static boolean getPass() {
		if(passField == ""){
			System.out.println("falso");
			System.out.println("bool "+passField);
			return false;
		}else {
		System.out.println("verdadero");
		System.out.println("bool "+passField);
		return true;}					
	}		*/	
	
}
