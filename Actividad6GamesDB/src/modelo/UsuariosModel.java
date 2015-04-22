package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class UsuariosModel 
{
	//Consultas SQL preparadas
	private final static String GETALL= "SELECT * FROM userdata";
	private final static String GETUSUARIO ="Usuario";
	
	//Conexion
	private Connection conexion = null; //Maneja la conexion
	private Statement instruccion = null;
	private ResultSet resultados = null;
	
	public ArrayList<String> usuarios = null;
	
	public UsuariosModel(Connection conexion2) 
	{
		this.conexion=conexion2;
		usuarios = new ArrayList<String>();
	}

	public ArrayList<String> UserData()
	{
		try 
		{
			//Se crea el statement respecto a la conexion y se combierte en una instruccion
			instruccion = this.conexion.createStatement();
			//la instruccion ejecuta un Query que esta definido arriba (en este caso, GETALL)
			resultados = instruccion.executeQuery(GETALL);
			//Ciclo while que añade cada resultado de resultados en la Array "usuarios"
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
		//Al terminar el ciclo while, devolvemos el usuarios
		
		return usuarios;
	}
	
}
