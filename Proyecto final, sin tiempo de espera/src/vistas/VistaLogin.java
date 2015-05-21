package vistas;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;

public class VistaLogin extends JPanel {
	
	//INICIALIZACIÓN DE VARIABLES
	JComboBox comboBoxMedicos;
	JTextField textFieldPass;
	JButton btnLogin;

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
		
	}
}
