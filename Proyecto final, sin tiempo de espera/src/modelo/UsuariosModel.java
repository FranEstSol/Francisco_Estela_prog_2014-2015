package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import controlador.MainController;

public class UsuariosModel {
	//Consultas SQL preparadas
	private final static String GETALL= "SELECT * FROM usuarios";
	private final static String GETUSERPASSWORD= "SELECT password FROM usuarios WHERE nombre =";
	private final static String GETNOMBRE ="nombre";
	private final static String GETPASSWORD ="password";

	//Variables de conexion
	private Connection conexion = null; //Maneja la conexion
	private Statement instruccion = null;	

	//Variables de consulta
	private ResultSet resultados = null;
	private ArrayList<String> nombre = null;

	public UsuariosModel() {
		//Obtiene la conexi�n desde la clase ConexionDB
		conexion = ConexionDB.getConexion();		
	}

	//Metodo para conseguir los nombres
	public ArrayList<String> ArrNombre() {

		//Inicializa el ArrayList de nombre
		nombre = new ArrayList<String>();
		try {
			//Se crea el statement respecto a la conexion y se combierte en una instruccion
			instruccion = this.conexion.createStatement();
			//la instruccion ejecuta un Query que esta definido arriba (en este caso, GETALL)
			resultados = instruccion.executeQuery(GETALL);
			//Ciclo while que a�ade cada resultado de resultados en la Array "nombre"
			while(resultados.next()) {	
				nombre.add(resultados.getString(GETNOMBRE));
			}
		} 
		catch (SQLException exceptionSQL) {
			System.out.println("Error en Statement");
			exceptionSQL.printStackTrace();
		}
		//Al terminar el ciclo while, devolvemos el nombre
		close();
		return nombre;
	}	

	//Metodo para conseguir las contrase�as. Traemos la String "user" desde
	public String UserPassword(String user) {

		//Inicializa el ArrayList de password
		String password="";
		try {
			//Se crea el statement respecto a la conexion y se combierte en una instruccion
			instruccion = this.conexion.createStatement();
			//la instruccion ejecuta un Query que esta definido arriba (en este caso, GETALL)
			resultados = instruccion.executeQuery(GETUSERPASSWORD+ "'" + user  + "'");
			//Ciclo while que a�ade cada resultado (que solo es 1) en la variable password
			while(resultados.next()) {	
				 password = resultados.getString(GETPASSWORD);
			}
		} 
		catch (SQLException exceptionSQL) {
			System.out.println("Error en Statement");
			exceptionSQL.printStackTrace();
		}
		//Al terminar el ciclo while, devolvemos la password
		close();
		return password;
	}



	public void close(){
		try {
			resultados.close();
			instruccion.close();
		}
		catch (SQLException excepcionSQL) {
			excepcionSQL.printStackTrace();
		}
	}
}