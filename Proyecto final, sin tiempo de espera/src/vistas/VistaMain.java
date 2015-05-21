package vistas;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.SwingConstants;

import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class VistaMain extends JPanel {
	
		//INICIALIZACIÓN DE VARIABLES
		JButton btnLoginPaciente;
		JButton btnLoginMedico;
		JLabel labelPaciente;
		JLabel labelMedico;
		VistaApp vistaApp;

	public VistaMain(JPanel contentPane) {
		
		//Etiqueta paciente
		labelPaciente = new JLabel("Acceder como Paciente");
		labelPaciente.setHorizontalAlignment(SwingConstants.CENTER);
		labelPaciente.setBounds(0, 81, 301, 14);
		setLayout(null);
		add(labelPaciente);
		
		//Botón login paciente
		btnLoginPaciente = new JButton("Acceder");
		btnLoginPaciente.setBounds(98, 106, 107, 23);
		add(btnLoginPaciente);
		
		//Etiqueta médico
		labelMedico = new JLabel("Acceder como Médico");
		labelMedico.setHorizontalAlignment(SwingConstants.CENTER);
		labelMedico.setBounds(0, 243, 301, 14);
		add(labelMedico);
		
		//Botón login médico
		btnLoginMedico = new JButton("Acceder");
		btnLoginMedico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CardLayout cl = (CardLayout) contentPane.getLayout(); //Obtenemos el layout manager de contentPane
				cl.show(contentPane, "VISTA_LOGIN"); //Mostramos vista login en el contentPane
			}
		});
		btnLoginMedico.setBounds(98, 267, 107, 23);
		add(btnLoginMedico);
		
	}

}
