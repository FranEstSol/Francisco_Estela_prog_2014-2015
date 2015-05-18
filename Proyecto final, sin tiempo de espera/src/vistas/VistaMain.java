package vistas;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.SwingConstants;


public class VistaMain extends JPanel{
	
		//INICIALIZACIÓN DE VARIABLES
		JButton btnLoginPaciente;
		JButton btnLoginMedico;
		JLabel labelPaciente;
		JLabel labelMedico;

	public VistaMain() {
		
		//Etiqueta paciente
		labelPaciente = new JLabel("Acceder como Paciente");
		labelPaciente.setHorizontalAlignment(SwingConstants.CENTER);
		labelPaciente.setBounds(10, 11, 289, 14);
		setLayout(null);
		add(labelPaciente);
		
		//Botón login paciente
		btnLoginPaciente = new JButton("Acceder");
		btnLoginPaciente.setBounds(97, 36, 115, 23);
		add(btnLoginPaciente);
		
		//Etiqueta médico
		labelMedico = new JLabel("Acceder como Médico");
		labelMedico.setHorizontalAlignment(SwingConstants.CENTER);
		labelMedico.setBounds(10, 114, 289, 14);
		add(labelMedico);
		
		//Botón login médico
		btnLoginMedico = new JButton("Acceder");
		btnLoginMedico.setBounds(97, 139, 115, 23);
		add(btnLoginMedico);
		
	}

}
