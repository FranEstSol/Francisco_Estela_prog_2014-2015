import modelo.ConexionDB;
import modelo.UsuariosModel;
import vistas.VistaApp;


public class Main 
{	
	//Variables para conectar con otras clases
	static ConexionDB gameDB; 
	
	public static void main(String[] args) 
	{		
		//Objeto generado e informacion preparada para "enviar" a la clase ConexionDB/ConexionDB getInstance
		gameDB = ConexionDB.getInstance("localhost", "games", "root", "");
		
		//Comprobacion del estado final de la conexion
		if(gameDB.conectarDB()==true)
		{		
			System.out.println("Conexion realizada con exito");	
		}
		else 
		{
			System.out.println("Conexion fallida");
		}
		//Hace visible la clase VistaApp (que contiene la informacion para hacer visible la clase VistaPrincipal)
		VistaApp frame = new VistaApp();
		frame.setVisible(true);
	}
}