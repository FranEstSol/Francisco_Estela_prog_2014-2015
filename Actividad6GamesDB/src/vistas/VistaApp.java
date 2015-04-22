package vistas;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.CardLayout;

import vistas.VistaPrincipal;


public class VistaApp extends JFrame {

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu menuPrincipal, menuJuegos, menuPerfil;
	private JMenuItem menuItemPrincipal, menuItemJuegos, menuItemPerfil;
	private JPanel ventanas;
	private JPanel vPrincipal;
	//Creamos el objeto vistaPrincipal desde la clase VistaPrincipal
	VistaPrincipal vistaPrincipal = new VistaPrincipal();
	
	public VistaApp() 
	{
		//Contenedor de paneles
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 431, 495);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new CardLayout(0, 0));
		setContentPane(contentPane);
		
		//panel ventana
		ventanas = new JPanel();
		contentPane.add(ventanas, BorderLayout.NORTH);
		ventanas.setLayout(new CardLayout(0, 0));
		//Implantamos vistaPrincipal
		ventanas.add(vistaPrincipal, "VPCard");		
        
		//Menu superior e items
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		menuPrincipal = new JMenu("Principal");
		menuBar.add(menuPrincipal);		
		menuItemPrincipal = new JMenuItem("Principal");
		menuPrincipal.add(menuItemPrincipal);
		
		menuJuegos = new JMenu("Juegos");
		menuBar.add(menuJuegos);		
		menuItemJuegos = new JMenuItem("Juegos");
		menuJuegos.add(menuItemJuegos);
		
		menuPerfil = new JMenu("Perfil");
		menuBar.add(menuPerfil);		
		menuItemPerfil = new JMenuItem("Perfil");
		menuPerfil.add(menuItemPerfil);
	}

}
