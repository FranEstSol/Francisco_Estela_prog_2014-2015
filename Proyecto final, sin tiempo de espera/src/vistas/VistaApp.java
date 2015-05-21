package vistas;
import java.awt.CardLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


public class VistaApp extends JFrame {
	
	//INICIALIZACI�N DE VARIABLES
	JPanel contentPane;
	VistaMain vistaMain;
	VistaLogin vistaLogin;

	public VistaApp() {
		
		//Ventana
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 321, 447);
		setResizable(false);
		
		//Contenedor
		contentPane = new JPanel(new CardLayout()); //Crea un JPanel de tipo CardLayout
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		VistaMain vistaMain = new VistaMain(contentPane); //Inicializa vistaMain pas�ndole el contentPane
		VistaLogin vistaLogin = new VistaLogin();
		contentPane.add(vistaMain, "VISTA_MAIN"); //A�ade VistaMain al cardLayout
		contentPane.add(vistaLogin, "VISTA_LOGIN"); //A�ade VistaLogin al cardLayout
		
	}

}
