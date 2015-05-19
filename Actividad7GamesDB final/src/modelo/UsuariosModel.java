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
	
	private ArrayList<String> usuarios = null;
	
	public UsuariosModel() {
		//Obtiene la conexión desde la clase ConexionDB
		conexion = ConexionDB.getConexion();	
	}

	public ArrayList<String> UserData()
	{
		//Inicializa el ArrayList de usuarios
		usuarios = new ArrayList<String>();
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
		finally 
		{
			try 
			{
				//conexion.close();
				resultados.close();
				instruccion.close();
			}
			catch (SQLException excepcionSQL) 
			{
				excepcionSQL.printStackTrace();
			}
		}
		return usuarios;
	}
	
}
