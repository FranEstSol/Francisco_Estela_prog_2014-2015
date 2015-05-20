package modelo;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class ConexionDB {
	//VARIABLES
	//Datos del controlador de la conexion
	final static String CONTROLADOR_SQL="com.mysql.jdbc.Driver";

	//Variables de datos de la DB
	private String host;
	private String bbdd;
	private String user;
	private String pass;
	private String url;

	//OBJETOS
	//Conexion
	private static Connection conexion = null; //Maneja la conexion

	//Instancia unica
	private static ConexionDB instance =null;

	//METODOS
	//Recibe los datos desde la clase ConexionDB/ConexionDB get instance
	//Envia el montaje de informacion a ConexionDB/connectDB
	private ConexionDB(String HOST, String BBDD, String USER, String PASS) {
		this.host=HOST;
		this.bbdd=BBDD;
		this.user=USER;
		this.pass= PASS;
		//Montamos el principio el host y la base de datos en una sola variable llamada url
		this.url="jdbc:mysql://" + this.host + "/" + this.bbdd;
	}

	//Recibe desde Main la informacion para montar la instance, comprobando si es null o no.
	//En caso de ser null, la montara. Si no es null, devolvera la informacion que ya tiene.
	public static ConexionDB getInstance (String HOST, String BBDD, String USER, String PASS){
		if (instance == null) {
			instance = new ConexionDB(HOST, BBDD, USER, PASS);
		}			
		return instance;
	}
	//Conexion a la base de datos. 
	//Recibe el montaje de informacion desde ConexionDB/ConexionDB (Arriba)
	//Devuelve True o False a Main/horariosDB.connectDB()
	public boolean conectarDB() {
		try {
			//Carga del controlador SQL
			Class.forName(CONTROLADOR_SQL);
			//aplicamos la informacion de arriba
			conexion = DriverManager.getConnection(this.url,this.user,this.pass);
		}
		catch (SQLException exceptionSQL) {
			exceptionSQL.printStackTrace();
			System.out.println("Error de SQL");
			return false;
		}
		catch(ClassNotFoundException clasePerdida) {
			clasePerdida.printStackTrace();
			System.out.println("Error por algo en la conexion(Seguramente algo falta)");
			return false;
		}
		return true;
	}

	//metodo getConexion que devuelve conexion
	public static Connection getConexion() {
		return conexion;
	}
}
