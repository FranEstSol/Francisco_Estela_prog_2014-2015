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

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class VistaLogin extends JPanel {
	
	//INICIALIZACIÓN DE VARIABLES
	public static JComboBox comboBoxMedicos;
	JButton btnLogin;
	JLabel lblUsuario;
	JLabel lblPassword;
	public static JLabel lblAlerta;	
	JButton btnAtras;
	JPasswordField passwordField;
	public static String selectedUser ="";
	public static char[] passField=null;
	//JComboBox comboBoxPassword;
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
		
		//Desplegable médicos
		comboBoxMedicos = new JComboBox();
		comboBoxMedicos.setBounds(60, 59, 200, 20);
		add(comboBoxMedicos);
		
		//Botón login
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
		
		/*comboBoxPassword = new JComboBox();
		comboBoxPassword.setBounds(60, 0, 200, 20);
		add(comboBoxPassword);*/
	
		//Funcion del combobox Medicos
		comboBoxMedicos.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				selectedUser=(String) comboBoxMedicos.getSelectedItem();
			}
		});
		
		//Funciones de los botones
		//Boton login
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				//Llama al metodo showMedico mediante MainController.getInstance				
				System.out.println("Boton de Login pulsado");
				System.out.println("Texto recogido del texto al pulsar login:  "+passwordField.getPassword());
				passField=passwordField.getPassword();
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
	//Recibe el ArrayList usuarios desde showMain (En VistaApp) y, mediante el Iterator, lo monta en el combobox.
	public void putUsuarios(ArrayList nombre) {
		//Limpia el combobox para evitar repetir usuarios y volvemos a rellenarlo.
		comboBoxMedicos.removeAllItems();
		//Rellena el combobox
		Iterator<String> it =nombre.iterator();
		while (it.hasNext()) {
			System.out.println("AÑADIDO EL MEDICO AL COMBOBOX ");
			comboBoxMedicos.addItem((String)it.next());
		}		
	}
/*	public void putPassword(ArrayList password) {
		//Limpia el combobox para evitar repetir usuarios y volvemos a rellenarlo.
		comboBoxPassword.removeAllItems();
		//Rellena el combobox
		Iterator<String> it =password.iterator();
		while (it.hasNext()) {
			System.out.println("AÑADIDO PASSWORD AL COMBOBOX ");
			comboBoxPassword.addItem((String)it.next());
		}		
	}*/
}
