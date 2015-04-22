package modelo;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class ConexionDB 
{
	//Datos del controlador de la conexion
	final static String CONTROLADOR_SQL="com.mysql.jdbc.Driver";
	
	//Variables de datos de la DB
	private String host;
	private String bbdd;
	private String user;
	private String pass;
	private String url;
	 
	//Conexion
	private static Connection conexion;
	
	//traemos la informacion desde la clase Main
	public ConexionDB(String HOST, String BBDD, String USER, String PASS) 
	{
		this.host=HOST;
		this.bbdd=BBDD;
		this.user=USER;
		this.pass= PASS;
		//Montamos el principio el host y la base de datos en una sola variable llamada url
		this.url="jdbc:mysql://" + this.host + "/" + this.bbdd;
	}

	public boolean connectDB()
	{
		try
		{
			//Carga del controlador SQL
			Class.forName(CONTROLADOR_SQL);
			//aplicamos la informacion de arriba
			conexion = DriverManager.getConnection(this.url,this.user,this.pass);
		}
		catch (SQLException exceptionSQL)
		{
			exceptionSQL.printStackTrace();
			System.out.println("Error de SQL");
			return false;
		}
		catch(ClassNotFoundException clasePerdida)
		{
			clasePerdida.printStackTrace();
			System.out.println("Error por algo en la conexion(Seguramente algo falta)");
			return false;
		}
		return true;
	}
	
	//metodo getConexion que devuelve conexion
	public static Connection getConexion()
	{
		return conexion;
	}

}
