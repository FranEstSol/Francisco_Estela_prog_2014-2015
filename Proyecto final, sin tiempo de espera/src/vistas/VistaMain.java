package vistas;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.SwingConstants;


public class VistaMain extends JPanel{
	
		//INICIALIZACI�N DE VARIABLES
		JButton btnLoginPaciente;
		JButton btnLoginMedico;
		JLabel labelPaciente;
		JLabel labelMedico;

	public VistaMain() {
		
		//Etiqueta paciente
		labelPaciente = new JLabel("Acceder como Paciente");
		labelPaciente.setHorizontalAlignment(SwingConstants.CENTER);
		labelPaciente.setBounds(10, 89, 301, 14);
		setLayout(null);
		add(labelPaciente);
		
		//Bot�n login paciente
		btnLoginPaciente = new JButton("Acceder");
		btnLoginPaciente.setBounds(107, 114, 107, 23);
		add(btnLoginPaciente);
		
		//Etiqueta m�dico
		labelMedico = new JLabel("Acceder como M�dico");
		labelMedico.setHorizontalAlignment(SwingConstants.CENTER);
		labelMedico.setBounds(10, 271, 301, 14);
		add(labelMedico);
		
		//Bot�n login m�dico
		btnLoginMedico = new JButton("Acceder");
		btnLoginMedico.setBounds(107, 296, 107, 23);
		add(btnLoginMedico);
		
	}

}
