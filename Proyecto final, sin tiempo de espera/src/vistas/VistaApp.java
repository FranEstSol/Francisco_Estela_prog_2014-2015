package vistas;
import java.awt.CardLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


public class VistaApp extends JFrame {

	//INICIALIZACIÓN DE VARIABLES
	JPanel contentPane;
/*	VistaMain vistaMain;
	VistaLogin vistaLogin;
	VistaMedico vistaMedico;
	VistaUsuario vistaUsuario;
	*/
	VistaMain vistaMain = new VistaMain(); //Inicializa vistaMain pasándole el contentPane
	VistaLogin vistaLogin = new VistaLogin();
	VistaMedico vistaMedico = new VistaMedico();
	VistaUsuario vistaUsuario = new VistaUsuario();
	
	public VistaApp() {

		//Ventana
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 321, 447);
		setResizable(false);

		//Contenedor
		contentPane = new JPanel(new CardLayout()); //Crea un JPanel de tipo CardLayout
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		
		contentPane.add(vistaMain, "VISTA_MAIN"); //Añade VistaMain al cardLayout
		contentPane.add(vistaLogin, "VISTA_LOGIN"); //Añade VistaLogin al cardLayout
		contentPane.add(vistaMedico, "VISTA_MEDICO");
		contentPane.add(vistaUsuario, "VISTA_USUARIO");		
	}

	//Metodos de llamamiento de las vistas
	//Metodo que hace visible VISTA_MAIN (que corresponde a VistaMain)
	public void showMain() {
		CardLayout c = (CardLayout) this.contentPane.getLayout();
		c.show(contentPane, "VISTA_MAIN");		
	}

	//Metodo que hace visible VISTA_MAIN (que corresponde a VistaMain)
	public void showLogin(ArrayList nombre) {
		vistaLogin.putUsuarios(nombre);
		CardLayout c = (CardLayout) this.contentPane.getLayout();
		c.show(contentPane, "VISTA_LOGIN");		
	}

	//Metodo que hace visible VISTA_MEDICO (que corresponde a VistaMedico)
	public void showMedico() {		
		CardLayout c = (CardLayout) this.contentPane.getLayout();
		c.show(contentPane, "VISTA_MEDICO");		
	}

	//Metodo que hace visible VISTA_USUARIO (que corresponde a VistaUsuario)
	public void showUsuario() {		
		CardLayout c = (CardLayout) this.contentPane.getLayout();
		c.show(contentPane, "VISTA_USUARIO");		
	}

}
