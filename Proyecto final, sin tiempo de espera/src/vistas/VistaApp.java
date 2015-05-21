package vistas;
import java.awt.CardLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


public class VistaApp extends JFrame {
	
	//INICIALIZACIÓN DE VARIABLES
	VistaMain vistaMain = new VistaMain(); //Inicializa vistaMain()
	VistaLogin vistaLogin = new VistaLogin(); //Inicializa VistaLogin()
	private JPanel contentPane;
	CardLayout cl;

	public VistaApp(String vista) {
		
		//Ventana
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 321, 447);
		setResizable(false);
		
		//Contenedor
		contentPane = new JPanel(new CardLayout()); //Crea un JPanel de tipo CardLayout
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.add(vistaMain, "VISTA_MAIN"); //Añade VistaMain() al cardLayout
		contentPane.add(vistaLogin, "VISTA_LOGIN"); //Añade VistaLogin() al cardLayout
		
		cl = (CardLayout)(contentPane.getLayout());
		cl.show(contentPane, vista);
		
	}

}
