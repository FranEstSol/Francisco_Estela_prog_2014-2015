import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;


public class VentanaConversor extends JFrame {
	
	private JPanel contentPane;
	private JTextField CajaEuros;
	private JLabel Label1;
	private JTextField CajaDolares;
	private JLabel Label2;
	private JButton btnConvertir;
	private JTextField SystemMsg;
	public VentanaConversor(float RatioConversion) {
		
		//VENTANA
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//ETIQUETAS
		Label1 = new JLabel("Euros");
		Label1.setBounds(10, 78, 77, 14);
		contentPane.add(Label1);
		
		Label2 = new JLabel("Dolares");
		Label2.setBounds(10, 141, 77, 14);
		contentPane.add(Label2);
		
		JLabel LabelLimite = new JLabel("Introduce un valor entre 0 y 500.");
		LabelLimite.setFont(new Font("Tahoma", Font.PLAIN, 14));
		LabelLimite.setForeground(Color.BLUE);
		LabelLimite.setBounds(10, 23, 414, 20);
		contentPane.add(LabelLimite);
		
		//CAJAS DE TEXTO
		CajaEuros = new JTextField();
		CajaEuros.setBounds(10, 98, 115, 20);
		contentPane.add(CajaEuros);
		CajaEuros.setColumns(10);
		
		CajaDolares = new JTextField();
		CajaDolares.setBackground(Color.WHITE);
		CajaDolares.setEditable(false);
		CajaDolares.setColumns(10);
		CajaDolares.setBounds(10, 161, 115, 20);
		contentPane.add(CajaDolares);
		
		SystemMsg = new JTextField();
		SystemMsg.setFont(new Font("Tahoma", Font.PLAIN, 13));
		SystemMsg.setEditable(false);
		SystemMsg.setBounds(10, 208, 414, 23);
		contentPane.add(SystemMsg);
		SystemMsg.setColumns(10);
				
		//BOTON
		btnConvertir = new JButton("Convertir");
		btnConvertir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				//VARIABLES
				float euros;
				float resultado;
				try{
					//SE CAPTURA EL CONTENIDO DE "CajaEuros" Y SE APLICA EN LA VARIABLE "euros"
					euros = Float.parseFloat (CajaEuros.getText());
				
					if (euros>=0 && euros<=500){
						CajaDolares.setText(String.valueOf(euros*RatioConversion)); 
						resultado=Float.parseFloat(CajaDolares.getText()); //SE CAPTURA EL CONTENIDO DE "CajaDolares" Y SE APLICA EN LA VARIABLE "resultado"
						SystemMsg.setForeground(Color.BLACK);
						SystemMsg.setText("La conversion ha dado como resultado: " + resultado );

					}else {
						SystemMsg.setForeground(Color.RED);
						SystemMsg.setText("Introduce un numero valido entre 0 y 500");
						CajaDolares.setText ("");

					}
				}catch(Exception z){
					SystemMsg.setForeground(Color.RED);
					SystemMsg.setText("Has introducido un valor incorrecto. Vuelve a intentarlo" );
					CajaDolares.setText ("");
				}
			}
		});
		btnConvertir.setBounds(162, 97, 89, 23);
		contentPane.add(btnConvertir);
		

		

	}
}