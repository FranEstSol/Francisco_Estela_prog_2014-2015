import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;

public class Cesar extends JFrame 
{
	//Declaracion de objetos
	private JPanel contentPane;
	private JTextField textFieldIn;
	private JLabel lblIn;
	private JLabel lblOut;
	private JTextField textFieldOut;
	private JButton btnCod;
	private JComboBox comboBox;
	
	//Declaracion e inicializacion de variables
	String fraseIn = "";
	String fraseOut = "";
	int llave = 0;
	
	//Datos importados
	Data data = new Data();
	private JTextField textFieldKey;
	private JLabel lblInfo;
	
	//llamamiento a los metodos usados
	public Cesar() 
	{
		create();
		functions();
	}
	
	// cosas que se crean al iniciar
	public void create ()
	{
		//ventana
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//etiquetas
		lblIn = new JLabel("Entrada de texto");
		lblIn.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblIn.setBounds(10, 11, 284, 15);
		contentPane.add(lblIn);
		
		lblOut = new JLabel("Salida de texto");
		lblOut.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblOut.setBounds(10, 142, 284, 15);
		contentPane.add(lblOut);
		
		lblInfo = new JLabel("");
		lblInfo.setBounds(190, 317, 484, 32);
		contentPane.add(lblInfo);
		
		//cajas de texto
		textFieldIn = new JTextField();
		textFieldIn.setBounds(10, 37, 664, 94);
		contentPane.add(textFieldIn);
		textFieldIn.setColumns(10);
		
		textFieldOut = new JTextField();
		textFieldOut.setEditable(false);
		textFieldOut.setColumns(10);
		textFieldOut.setBounds(10, 168, 664, 94);
		contentPane.add(textFieldOut);
		
		textFieldKey = new JTextField();
		textFieldKey.setText("Llave");
		textFieldKey.setBounds(190, 279, 86, 20);
		contentPane.add(textFieldKey);
		textFieldKey.setColumns(10);
		
		//boton
		btnCod = new JButton("Codificar");		
		btnCod.setBounds(10, 273, 170, 32);
		contentPane.add(btnCod);
		
	}
	
	//funciones
	public void functions () 
	{	
		//Boton de codificar
		btnCod.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0)
			{
				//Intento de borrar todos los campos y de transformar la llave en un numero entero
				try
				{
				String fraseIn = "";
				String fraseOut = "";
				textFieldOut.setText("");
				lblInfo.setText("");
				llave = Integer.parseInt(textFieldKey.getText());
				//Comprobamos los rangos maximos y minimos, ya que valores extremos causan errores.
				if (llave <=10 && llave >= -10)
				{
					//capturamos la frase del text fiel de entrada en la variable fraseIn
					fraseIn = textFieldIn.getText();	
					//Ciclo que va leyendo la frase de entrada hasta que esta termina
					for (int i=0;i<fraseIn.length(); i++)
					{
						//ciclo que lee la informacion de las minusculas hasta que termina
						for (int j=0; j<data.minus.length();j++)
						{
							//condicion de letras minusculas
							if (fraseIn.charAt(i) == data.minus.charAt(j))
							{
								//condicion valores positivos. Si la suma sobrepasa el espacio (tras la Z)
								if (j+llave >= data.minus.length())
								{
									fraseOut += data.minus.charAt((j+llave) % data.minus.length());	
								}
								//condicion valores negativos. Si hay un numero negativo y sobrepasa la A
								else if (j+llave < 0)
								{
									fraseOut += data.minus.charAt((j+llave) + data.minus.length());	
								}
								//condicion valores "normales". No sobrepasa por ningun lado.
								else 
								{
									fraseOut += data.minus.charAt(j+llave);
								}
							}
							//condicion de letras mayusculas
							else if (fraseIn.charAt(i) == data.mayus.charAt(j))
							{
								//condicion valores positivos. Si la suma sobrepasa el espacio (tras la Z)
								if (j+llave >= data.mayus.length())
								{
									fraseOut += data.mayus.charAt((j+llave) % data.mayus.length());	
								}
								//condicion valores negativos. Si hay un numero negativo y sobrepasa la A
								else if (j+llave < 0)
								{
									fraseOut += data.mayus.charAt((j+llave) + data.mayus.length());	
								}
								//condicion valores "normales". No sobrepasa por ningun lado.
								else 
								{
									fraseOut += data.mayus.charAt(j+llave);
								}
							}
						}
					}
					textFieldOut.setText(fraseOut);
				}
				else 
				{
					lblInfo.setText("La llave debe de ser un valor situado entre -10 y 10");
				}
				}
				catch (Exception e)
				{
					lblInfo.setText("Introduce una llave valida. Un numero entero sin espacios");
				}
			}
		}); // Final del boton de codificar
	}
}