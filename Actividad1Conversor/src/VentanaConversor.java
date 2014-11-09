import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class VentanaConversor extends JFrame {
	
	private JPanel contentPane;
	private JTextField CajaEuros;
	private JLabel Label1;
	private JTextField CajaDolares;
	private JLabel Label2;
	private JButton btnConvertir;
	public VentanaConversor(float RatioConversion) {
		
		//VENTANA
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//CAJAS DE TEXTO
		CajaEuros = new JTextField();
		CajaEuros.setBounds(10, 31, 115, 20);
		contentPane.add(CajaEuros);
		CajaEuros.setColumns(10);
		
		CajaDolares = new JTextField();
		CajaDolares.setColumns(10);
		CajaDolares.setBounds(10, 94, 115, 20);
		contentPane.add(CajaDolares);
		
		//ETIQUETAS
		Label1 = new JLabel("Euros");
		Label1.setBounds(10, 11, 77, 14);
		contentPane.add(Label1);
		
		Label2 = new JLabel("Dolares");
		Label2.setBounds(10, 74, 77, 14);
		contentPane.add(Label2);
		
		//BOTON
		btnConvertir = new JButton("Convertir");
		btnConvertir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				float euros;
				euros = Float.parseFloat (CajaEuros.getText());
				CajaDolares.setText(String.valueOf(euros*RatioConversion));
			}
		});
		btnConvertir.setBounds(162, 30, 89, 23);
		contentPane.add(btnConvertir);
	}
}
