import modelo.ConexionDB;
import modelo.UsuariosModel;
import vistas.VistaApp;


public class Main 
{	
	public static void main(String[] args) 
	{		
		ConexionDB gameDB; 
		UsuariosModel mUsuario;
		
		//Objeto generado e informacion preparada para "enviar" a la clase ConexionDB
		gameDB = new ConexionDB("localhost", "games", "root", "");
		
		if(gameDB.connectDB()==true)
		{		
			System.out.println("Conexion realizada con exito");
			//Objeto mUsuario en relacion con UsuariosModel
			mUsuario = new UsuariosModel (gameDB.getConexion());
			mUsuario.UserData();
			System.out.println("Datos de usuario obtenidos con exito");
		}
		else 
		{
			System.out.println("Conexion fallida");
		}
		
		VistaApp frame = new VistaApp();
		frame.setVisible(true);
	}
}