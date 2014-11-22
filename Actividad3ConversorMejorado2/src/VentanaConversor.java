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

import javax.swing.JComboBox;

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;


public class VentanaConversor extends JFrame {
	
	private JPanel contentPane;
	private JTextField CajaEuros;
	private JLabel Label1;
	private JTextField CajaResultado;
	private JLabel Label2;
	private JButton btnConvertir;
	private JTextField SystemMsg;{
		
		//VENTANA
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//ETIQUETAS
		Label1 = new JLabel("Euros");
		Label1.setBounds(10, 54, 77, 14);
		contentPane.add(Label1);
		
		Label2 = new JLabel("Resultado");
		Label2.setBounds(10, 159, 77, 14);
		contentPane.add(Label2);
		
		JLabel LabelLimite = new JLabel("Introduce un valor entre 0 y 500.");
		LabelLimite.setFont(new Font("Tahoma", Font.PLAIN, 14));
		LabelLimite.setForeground(Color.BLUE);
		LabelLimite.setBounds(10, 23, 414, 20);
		contentPane.add(LabelLimite);
		
		//CAJAS DE TEXTO
		CajaEuros = new JTextField();
		CajaEuros.setBounds(10, 74, 115, 20);
		contentPane.add(CajaEuros);
		CajaEuros.setColumns(10);
		
		CajaResultado = new JTextField();
		CajaResultado.setBackground(Color.WHITE);
		CajaResultado.setEditable(false);
		CajaResultado.setColumns(10);
		CajaResultado.setBounds(10, 179, 115, 20);
		contentPane.add(CajaResultado);
		
		SystemMsg = new JTextField();
		SystemMsg.setFont(new Font("Tahoma", Font.PLAIN, 13));
		SystemMsg.setEditable(false);
		SystemMsg.setBounds(10, 226, 414, 23);
		contentPane.add(SystemMsg);
		SystemMsg.setColumns(10);
				
		//COMBOBOX
		JComboBox comboBox = new JComboBox();
		
		//AÑADIMOS LOS ELEMENTOS DEL COMBOBOX MEDIANTE ARRAYS
				//Creacion de 4 nuevas Strings en "formado" array.
				String monedas []=new String[4];
				
				//Definicion de los 4 items
				monedas[0]="Libras";
				monedas[1]="Dolares";
				monedas[2]="Yen";
				monedas[3]="Pesos";
				//Creacion de 4 nuevos items dentro de combobox
				comboBox.addItem(monedas[0]);
				comboBox.addItem(monedas[1]);
				comboBox.addItem(monedas[2]);
				comboBox.addItem(monedas[3]);
				
				//ACCION DE CAMBIAR DE ITEM SELECCIONADO
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {

				//CONDICION PARA EL SWITCH -> SELECCION DE ITEM EN COMBOBOX
				switch((String)comboBox.getSelectedItem())
				{
				case"Libras":
					SystemMsg.setText("Hemos seleccionado la moneda de UK");
					CajaResultado.setText("");
					break;
				case"Dolares":
					SystemMsg.setText("Hemos seleccionado la moneda de EEUU");
					CajaResultado.setText("");
					break;
				case"Yen":
					SystemMsg.setText("Hemos seleccionado la moneda de Japon");
					CajaResultado.setText("");
					break;
				case"Pesos":
					SystemMsg.setText("Hemos seleccionado la moneda de Mexico");
					CajaResultado.setText("");
					break;
					//NO ES NECESARIO EL DEFAULT
				}
			}
				
		});
		comboBox.setBounds(10, 116, 115, 20);
		contentPane.add(comboBox);

		
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
						//creamos la variable "Valor" y la inicializamos.
						float Valor = 0;
						//CONDICION PARA EL SWITCH -> SELECCION DE ITEM EN COMBOBOX
						//Cada "case" cambiara el valor de la variable "Valor" por el valor de la moneda seleccionada
						switch((String)comboBox.getSelectedItem())
						{
						case"Libras":
							 Valor = 0.8f;
							break;
						case"Dolares":
							 Valor = 1.24f;
							break;
						case"Yen":
							Valor = 147.81f;
							break;
						case"Pesos":
							Valor = 18.1f;
							break;
						//NO ES NECESARIO EL DEFAULT
						}
						
						CajaResultado.setText(String.valueOf(euros*Valor)); 
						resultado=Float.parseFloat(CajaResultado.getText()); //SE CAPTURA EL CONTENIDO DE "CajaDolares" Y SE APLICA EN LA VARIABLE "resultado"
						SystemMsg.setForeground(Color.BLACK);
						SystemMsg.setText("La conversion ha dado como resultado: " + resultado +" " + (String)comboBox.getSelectedItem());

					}else {
						SystemMsg.setForeground(Color.RED);
						SystemMsg.setText("Introduce un numero valido entre 0 y 500");
						CajaResultado.setText ("");

					}
				}catch(Exception z){
					SystemMsg.setForeground(Color.RED);
					SystemMsg.setText("Has introducido un valor incorrecto. Vuelve a intentarlo" );
					CajaResultado.setText ("");
				}
			}
		});
		
		btnConvertir.setBounds(162, 73, 89, 23);
		contentPane.add(btnConvertir);
		
		

		

	}
}