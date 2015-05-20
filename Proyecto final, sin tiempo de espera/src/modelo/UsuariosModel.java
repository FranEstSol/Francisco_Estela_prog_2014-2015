package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class UsuariosModel {
	//Consultas SQL preparadas
	private final static String GETALL= "SELECT * FROM usuarios";
	private final static String GETNOMBRE ="nombre";
	private final static String GETUSUARIO ="usuario";
	private final static String GETPASSWORD ="password";
	
	//Variables de conexion
	private Connection conexion = null; //Maneja la conexion
	private Statement instruccion = null;	
	
	//Variables de consulta
	private ResultSet resultados = null;
	private ArrayList<String> usuarios = null;
	private ArrayList<String> nombre = null;
	private ArrayList<String> password = null;
	
	public UsuariosModel() {
		//Obtiene la conexión desde la clase ConexionDB
		conexion = ConexionDB.getConexion();		
	}

	public ArrayList<String> ArrUsuario() {
		try {
			//Se crea el statement respecto a la conexion y se combierte en una instruccion
			instruccion = this.conexion.createStatement();
			//la instruccion ejecuta un Query que esta definido arriba (en este caso, GETALL)
			resultados = instruccion.executeQuery(GETALL);
			//Ciclo while que añade cada resultado de resultados en la Array "usuarios"
			while(resultados.next()) {	
				usuarios.add(resultados.getString(GETUSUARIO));
			}
		} 
		catch (SQLException exceptionSQL) {
			System.out.println("Error en Statement");
			exceptionSQL.printStackTrace();
		}
		//Al terminar el ciclo while, devolvemos el usuarios	
		close();
		return usuarios;
	}	
	
	public ArrayList<String> ArrNombre() {
		try {
			//Se crea el statement respecto a la conexion y se combierte en una instruccion
			instruccion = this.conexion.createStatement();
			//la instruccion ejecuta un Query que esta definido arriba (en este caso, GETALL)
			resultados = instruccion.executeQuery(GETALL);
			//Ciclo while que añade cada resultado de resultados en la Array "usuarios"
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
	
	public ArrayList<String> ArrPassword() {
		try {
			//Se crea el statement respecto a la conexion y se combierte en una instruccion
			instruccion = this.conexion.createStatement();
			//la instruccion ejecuta un Query que esta definido arriba (en este caso, GETALL)
			resultados = instruccion.executeQuery(GETALL);
			//Ciclo while que añade cada resultado de resultados en la Array "usuarios"
			while(resultados.next()) {	
				password.add(resultados.getString(GETPASSWORD));
			}
		} 
		catch (SQLException exceptionSQL) {
			System.out.println("Error en Statement");
			exceptionSQL.printStackTrace();
		}
		//Al terminar el ciclo while, devolvemos el nombre
		close();
		return password;
	}	
	public void close(){
		try {
			conexion.close();
			resultados.close();
			instruccion.close();
		}
		catch (SQLException excepcionSQL) {
			excepcionSQL.printStackTrace();
		}
	}
}