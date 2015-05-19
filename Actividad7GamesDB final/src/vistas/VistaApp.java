package vistas;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.border.EmptyBorder;

import controlador.MainController;
import vistas.VistaPrincipal;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VistaApp extends JFrame {
	private JMenuBar menuBar;
	private JMenu menuPrincipal, menuJuegos, menuPerfil;
	private JMenuItem menuItemPrincipal, menuItemJuegos, menuItemPerfil;
	private JPanel contentPane;
	//private JPanel panelPrincipal;
	private JPanel contenedorCartas;
	
	//Creamos los objetos panelPrincipal y panelJuegos proveniente desde la clase VistaPrincipal y VistaJuegos
	VistaPrincipal panelPrincipal = new VistaPrincipal();
	VistaJuegos panelJuegos = new VistaJuegos();
	
	public VistaApp() 
	{
		//Contenedor de paneles general
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 431, 495);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));
		
		//Panel contenedor de las cartas
		contenedorCartas = new JPanel();
		contentPane.add(contenedorCartas);
		contenedorCartas.setLayout(new CardLayout(0, 0));
		
		//Paneles de carta
		contenedorCartas.add(panelPrincipal, "CARTA_PRINCIPAL");
		contenedorCartas.add(panelJuegos, "CARTA_JUEGOS");
		
		//Menu superior
		menuBar = new JMenuBar();
		//Esto manda el menu directamente arriba. Funcion de java
		setJMenuBar(menuBar);

		//items del menu superior
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
		
		//Metodos de accion del menu superior
		//Boton Principal
		menuItemPrincipal.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				//Llama al metodo showJuegos mediante MainController.getInstance
				System.out.println("Menu superior Principal pulsado");
				MainController.getInstance().showPrincipal();
			}
		});
		
		//Boton Juegos
		menuItemJuegos.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				System.out.println("menu superior Juegos pulsado");
				MainController.getInstance().showJuegos();
			}
		});
		
	}

	//Metodo showPrincipal
	public void showPrincipal(ArrayList usuarios) 
	{
		//Recibe un ArrayList usuarios desde MainController y lo envia al metodo "putUsuarios" en VistaPrincipal 
		panelPrincipal.putUsuarios(usuarios);
		System.out.println("He llegado");
		//Hacemos visible la CARTA_PRINCIPAL (que corresponde a VistaPrincipal)
		CardLayout c = (CardLayout) this.contenedorCartas.getLayout();
		c.show(contenedorCartas, "CARTA_PRINCIPAL");
	}
	
	public void showJuegos()
	{
		//Hacemos visible la CARTA_JUEGOS (que corresponde a VistaJuegos)
		System.out.println("Boton juegos ejecutado");
		CardLayout c = (CardLayout) this.contenedorCartas.getLayout();
		c.show(contenedorCartas, "CARTA_JUEGOS");
	}
}
