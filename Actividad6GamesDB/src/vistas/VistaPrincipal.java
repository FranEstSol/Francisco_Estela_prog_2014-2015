package vistas;


import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import modelo.ConexionDB;
import modelo.UsuariosModel;

public class VistaPrincipal extends JPanel 
{
	private JLabel avatar, lblUsuario, lblContraseña;
	private JComboBox comboBoxUsuario;
	private JPasswordField passwordField;
	private JButton btnLogin, btnRegistrarse, btnJuegos, btnPerfil;
	
	//UsuariosModel usuarios;
	
	public VistaPrincipal() 
	{
		//Ventana
		setLayout (null);
		this.setBounds(0,0, 431, 495);
		Border border = LineBorder.createGrayLineBorder();
				
				
		//Etiquetas
		avatar = new JLabel("");
		avatar.setIcon(new ImageIcon(VistaPrincipal.class.getResource("/images/avatar.png")));
		avatar.setBounds(10, 11, 150, 150);
		add(avatar);
		
		lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(10, 210, 150, 14);
		add(lblUsuario);
		
		lblContraseña = new JLabel("Contrase\u00F1a");
		lblContraseña.setBounds(10, 266, 150, 14);
		add(lblContraseña);
		
		//Combobox
		comboBoxUsuario = new JComboBox();
		comboBoxUsuario.setBounds(10, 235, 150, 20);
		add(comboBoxUsuario);
		//Datos del Combobox
	/*	usuarios = new UsuariosModel();
		System.out.println(usuarios);
		Iterator<String> it = usuarios.UserData().iterator();
		while (it.hasNext())
		{
			comboBoxUsuario.addItem((String)it.next());
		}*/

		//Password Field
		passwordField = new JPasswordField();
		passwordField.setBounds(10, 291, 150, 20);
		add(passwordField);
		
		//Botones
		btnLogin = new JButton("Login");
		btnLogin.setBounds(10, 355, 150, 23);
		add(btnLogin);
		
		btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.setBounds(10, 389, 150, 23);
		add(btnRegistrarse);
		
		btnJuegos = new JButton("Juegos >");
		btnJuegos.setBounds(255, 37, 150, 23);
		add(btnJuegos);
		
		btnPerfil = new JButton("Perfil >");
		btnPerfil.setBounds(255, 71, 150, 23);
		add(btnPerfil);
	}
}
