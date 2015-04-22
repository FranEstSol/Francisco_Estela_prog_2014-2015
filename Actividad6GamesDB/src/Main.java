import modelo.ConexionDB;
import modelo.UsuariosModel;
import vistas.VistaApp;


public class Main 
{	
	public static void main(String[] args) 
	{		
		//Variables para conectar con otras clases
		ConexionDB gameDB; 
		UsuariosModel mUsuario;
		
		//Objeto generado e informacion preparada para "enviar" a la clase ConexionDB
		gameDB = new ConexionDB("localhost", "games", "root", "");
		
		if(gameDB.connectDB()==true)
		{		
			System.out.println("Conexion realizada con exito");	
			System.out.println("////Clase MAIN if=true");
		}
		else 
		{
			System.out.println("Conexion fallida");
			System.out.println("////Clase MAIN if=false");
		}
		//Hace visible la clase VistaApp (que contiene la informacion para hacer visible la clase VistaPrincipal)
		VistaApp frame = new VistaApp();
		frame.setVisible(true);
	}
}