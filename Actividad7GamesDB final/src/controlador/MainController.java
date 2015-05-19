package controlador;

import vistas.VistaApp;
import vistas.VistaJuegos;
import modelo.ConexionDB;
import modelo.UsuariosModel;

public class MainController {
	//Instancia unica
	private static MainController instance = null;
	//Objeto gameDB desde ConexionDB
	ConexionDB gameDB;
	//Objetos vApp y vJuegos desde las vistas VistaApp y VistaJuegos
	VistaApp vApp;
	VistaJuegos vJuegos;
	//Objeto usuarios desde UsuariosModel
	UsuariosModel usuarios=null;

	//Comprobacion del estado de la conexion
	public MainController() 
	{
		gameDB = ConexionDB.getInstance("localhost", "games", "root", "");
		if (gameDB.conectarDB()==true)
		{
			System.out.println("Conexion realizada con exito");
		}	
		else
		{
			System.out.println("Conexion fallida");
		}
		//SI ACTIVO ESTA LINEA, SE EJECUTAN 2 VENTANAS. PREGUNTAR A PACO PORQUE
		//this.showMain();
	}
	
	//Implementacion SingleTon
	public static MainController getInstance() 
	{
		if (instance == null)
		{
			instance = new MainController();
		}
		return instance;
	}

	//Metodo showMain
	public void showMain() 
	{
		//Si usuarios es null, se crea el objetos usuarios desde UsuariosModel (relacionado con el objeto de arriba)
		if (usuarios==null) 
		{
			usuarios=new UsuariosModel();
		}
		//Carga le objeto vApp desde VistaApp
		vApp = new VistaApp();
		//llama al metodo showPrincipal
		showPrincipal();
		//Vuelve visible la VistaApp a traves del objeto
		vApp.setVisible(true);
	}

	//Metodo showPrincipal
	public void  showPrincipal() 
	{
		//Llama al metodo showPrincipal en VistaApp a traves del objeto vApp y le envia los usuarios del metodo UserData desde en UsuariosModel (ArrayList)
		vApp.showPrincipal(usuarios.UserData());
	}
	//Metodo showJuegos
	public void showJuegos() 
	{		
		//Llama al metodo showJuegos en VistaApp a traves del objeto vApp
		vApp.showJuegos();		
	}

}
