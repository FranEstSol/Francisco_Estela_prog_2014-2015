package vistas;
import java.awt.CardLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


public class VistaApp extends JFrame {
	
	//INICIALIZACIÓN DE VARIABLES
	VistaMain vistaMain = new VistaMain(); //Inicializa vistaMain()
	private JPanel contentPane;

	public VistaApp() {
		
		//Ventana
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 321, 447);
		setResizable(false);
		
		//Contenedor
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0)); //Crea un cardLayout
		contentPane.add(vistaMain, "VISTA_MAIN"); //Añade VistaMain() al cardLayout
	}

}
