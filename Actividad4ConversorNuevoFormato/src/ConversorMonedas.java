import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JComboBox;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class ConversorMonedas extends JFrame 
{
	//Declaracion de objetos.
	private JPanel contentPane;
	private JTextField cajaResultado;
	private JComboBox comboBox;
	private JButton bntConvertir;
	private JLabel labelResultado;
	private JLabel labelInfo;
	private JTextField cajaInsertar;
	
	//Declaracion e inicializacion variables
	private float valorMonedaSelecc=0.0f;
	
	//Datos de monedas importados desde la clase DatosGenerales.
	DatosGenerales d=new DatosGenerales();
		
	
	public ConversorMonedas() 
	{
		//Ventana
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Cajas de texto
		cajaInsertar = new JTextField();
		cajaInsertar.setBounds(10, 75, 122, 20);
		contentPane.add(cajaInsertar);
		cajaInsertar.setColumns(10);
		
		cajaResultado = new JTextField();
		cajaResultado.setEditable(false);
		cajaResultado.setBounds(10, 178, 122, 20);
		contentPane.add(cajaResultado);
		cajaResultado.setColumns(10);
		
		//Etiquetas de ayuda y texto
		labelResultado = new JLabel("Resultado de la conversion:");
		labelResultado.setBounds(10, 153, 154, 14);
		contentPane.add(labelResultado);
		
		labelInfo = new JLabel("");
		labelInfo.setBounds(10, 209, 414, 21);
		contentPane.add(labelInfo);

		//Botones
		bntConvertir = new JButton("Convertir");
		bntConvertir.setBounds(161, 42, 122, 23);
		contentPane.add(bntConvertir);
		
		//ComboBox
		comboBox = new JComboBox();
		comboBox.setBounds(10, 43, 122, 20);
		contentPane.add(comboBox);
		
		//Funcion de botones
		bntConvertir.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				//Variables del boton
				float euros;
				float resultado;
				try
				{
					//Lee el valor de "CajaInsertar", lo transforma en un float y lo mete en la variable "euros"
					euros = Float.parseFloat (cajaInsertar.getText());
				
					if (euros>=0 && euros<=500)
					{
						cajaResultado.setText(String.valueOf(euros*valorMonedaSelecc)); 
						resultado=Float.parseFloat(cajaResultado.getText()); //SE CAPTURA EL CONTENIDO DE "cajaResultado" Y SE APLICA EN LA VARIABLE "resultado"
						labelInfo.setForeground(Color.BLACK);
						labelInfo.setText("La conversion ha dado como resultado: " + resultado );

					}
					else 
					{
						labelInfo.setForeground(Color.RED);
						labelInfo.setText("Introduce un numero valido entre 0 y 500");
						cajaResultado.setText ("");

					}
				}
				catch(Exception z)
				{
					labelInfo.setForeground(Color.RED);
					labelInfo.setText("Has introducido un valor incorrecto. Vuelve a intentarlo" );
					cajaResultado.setText ("");
				}
			}
		});
		
		//Funcion de ComboBox
		comboBox.addItemListener(new ItemListener()
			{
				public void itemStateChanged (ItemEvent arg0)
				{
					labelInfo.setText("La moneda seleccionada es: " +comboBox.getSelectedItem());
					cajaResultado.setText("");
					switch((String)comboBox.getSelectedItem())
					{
						case DatosGenerales.moneda_DOL:
							valorMonedaSelecc=d.getValoresAEuro()[0];
							break;
						case DatosGenerales.moneda_EUR:
							valorMonedaSelecc=d.getValoresAEuro()[1];
							break;
						case DatosGenerales.moneda_LIB:
							valorMonedaSelecc=d.getValoresAEuro()[2];
							break;
						case DatosGenerales.moneda_YEN:
							valorMonedaSelecc=d.getValoresAEuro()[3];
							break;
							//NO ES NECESARIO EL DEFAULT
					}
				}
			});
			
		//Ciclo para cargar contenido al comboBox
		for (int i=0; i<d.getMonedas().length;i++)
			comboBox.addItem((String)d.getMonedas()[i]);
	}
}
