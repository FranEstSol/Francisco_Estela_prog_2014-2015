package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class UsuariosModel 
{
	//Devolucion de usuarios
	private static String IDcol = "ID";
	private static String NOMBREcol = "Usuario";
	private static String PASScol = "Password";
	private static String JUEGOcol = "Juego";
	
	//Creacion de la array para organizar los datos
	private static String COLUMNAS[]={IDcol,NOMBREcol,PASScol,JUEGOcol};
	
	//Consultas SQL preparadas
	private final static String GETALL= "SELECT * FROM userdata";
	private final static String GETUSUARIO ="Usuario";
	
	//Conexion
	private Connection conexion = null; //Maneja la conexion
	private Statement instruccion = null;
	private ResultSet resultados = null;
	
	public ArrayList<String> usuarios = null;
	
	
	public UsuariosModel(Connection conexion) 
	{
		this.conexion=conexion;
		usuarios = new ArrayList<String>();
	}


	public ArrayList UserData()
	{
		try 
		{
			instruccion = this.conexion.createStatement();
			resultados = instruccion.executeQuery(GETALL);
			//Ciclo que obtiene e imprime la informacion
			
			while(resultados.next())
			{	
				usuarios.add(resultados.getString(GETUSUARIO));	
			}
		} 
		catch (SQLException exceptionSQL) 
		{
			System.out.println("Error en Statement");
			exceptionSQL.printStackTrace();
		}
		finally
		{
			try
			{
				resultados.close();
				instruccion.close();
				conexion.close();
			}
			catch (SQLException exceptionSQL) 
			{
				System.out.println("Error al cerrar");
				exceptionSQL.printStackTrace();
			}
		}	
		System.out.println("Los usuarios devueltos desde la clase UsuariosModel son: "+usuarios);
		return usuarios;
		
	}
	
}
