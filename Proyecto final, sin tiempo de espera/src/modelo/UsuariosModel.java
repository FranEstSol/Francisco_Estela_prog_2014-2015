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
	private final static String GETCONSULTA ="consulta";
	
	//Variables de conexion
	private Connection conexion = null; //Maneja la conexion
	private Statement instruccion = null;	
	
	//Variables de consulta
	private ResultSet resultados = null;
	private ArrayList<String> usuario = null;
	private ArrayList<String> nombre = null;
	private ArrayList<String> password = null;
	private ArrayList<String> consulta = null;

	
	public UsuariosModel() {
		//Obtiene la conexión desde la clase ConexionDB
		conexion = ConexionDB.getConexion();		
	}
/*
	public ArrayList<String> ArrUsuario() {
		
		//Inicializa el ArrayList de usuarios
		usuario = new ArrayList<String>();
		try {
			//Se crea el statement respecto a la conexion y se combierte en una instruccion
			instruccion = this.conexion.createStatement();
			//la instruccion ejecuta un Query que esta definido arriba (en este caso, GETALL)
			resultados = instruccion.executeQuery(GETALL);
			//Ciclo while que añade cada resultado de resultados en la Array "usuarios"
			while(resultados.next()) {	
				usuario.add(resultados.getString(GETUSUARIO));
			}
		} 
		catch (SQLException exceptionSQL) {
			System.out.println("Error en Statement");
			exceptionSQL.printStackTrace();
		}
		//Al terminar el ciclo while, devolvemos el usuarios	
		close();
		return usuario;
	}	
	*/
	public ArrayList<String> ArrNombre() {
		
		//Inicializa el ArrayList de nombre
		nombre = new ArrayList<String>();
		try {
			//Se crea el statement respecto a la conexion y se combierte en una instruccion
			instruccion = this.conexion.createStatement();
			//la instruccion ejecuta un Query que esta definido arriba (en este caso, GETALL)
			resultados = instruccion.executeQuery(GETALL);
			//Ciclo while que añade cada resultado de resultados en la Array "nombre"
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
	
/*	public ArrayList<String> ArrPassword() {
		
		//Inicializa el ArrayList de usuarios
		password = new ArrayList<String>();
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
	*/
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