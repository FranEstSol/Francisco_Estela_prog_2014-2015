package vistas;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;

import controlador.MainController;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableColumnModel;

import modelo.UsuariosModel;

public class VistaUsuario extends JPanel {
	private JTable tablaConsultas;
	JLabel lblConsultasActivas;
	JButton btnAtras;
	JScrollPane scrollPaneConsultas;
	JButton btnActualizar;
	
	public VistaUsuario() {
		setLayout(null);
		
		//Label consultas activas
		JLabel lblConsultasActivas = new JLabel("Consultas activas");
		lblConsultasActivas.setBounds(10, 72, 114, 14);
		add(lblConsultasActivas);
		
		//Botón atrás
		btnAtras = new JButton("Atras");
		btnAtras.setBounds(10, 11, 98, 23);
		add(btnAtras);
		
		//Scroll Pane consultas
		scrollPaneConsultas = new JScrollPane();
		scrollPaneConsultas.setBounds(10, 97, 286, 278);
		add(scrollPaneConsultas);
		
		//Botón actualizar
		btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainController.getInstance().showUsuario();
			}
		});
		btnActualizar.setBounds(198, 11, 98, 23);
		add(btnActualizar);
		
		//tablaConsultas = new JTable();
		//scrollPaneConsultas.setViewportView(tablaConsultas);
		
		//Funciones de los botones
		//Boton atras
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Llama al método showMain mediante MainController.getInstance
				System.out.println("Boton de Atras pulsado");
				MainController.getInstance().showMain();
				
			}
		});
	}
	
	public void buildTableModel() throws SQLException {
		UsuariosModel modelo = new UsuariosModel();
		ResultSet rs = modelo.getInfoConsultas();
	    ResultSetMetaData metaData = rs.getMetaData();

	    // Nombre de las columnas
	    Vector<String> nombresColumnas = new Vector<String>();
	    nombresColumnas.add("Doctor/a");
	    nombresColumnas.add("Consulta");
	    nombresColumnas.add("Hora");
	    int columnCount = 3;

	    //Datos de la tabla
	    Vector<Vector<Object>> data = new Vector<Vector<Object>>();
	    while (rs.next()) {
	        Vector<Object> vector = new Vector<Object>();
	        for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
	            vector.add(rs.getObject(columnIndex));
	        }
	        data.add(vector);
	    }

	    tablaConsultas = new JTable(data, nombresColumnas) {
	    	public boolean isCellEditable(int row, int column) {
	    		return false;
	    	}
	    };
	    TableColumnModel columnModel = tablaConsultas.getColumnModel();
	    columnModel.getColumn(0).setPreferredWidth(250);
	    
		scrollPaneConsultas.setViewportView(tablaConsultas);
		
		//Cierro la conexion desde aquí porque desde UsuariosModel daba problemas
		modelo.close();

	}
}
