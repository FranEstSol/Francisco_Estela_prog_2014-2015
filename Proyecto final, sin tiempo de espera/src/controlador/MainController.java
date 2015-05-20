package controlador;

import vistas.VistaApp;
import modelo.ConexionDB;
import modelo.UsuariosModel;

public class MainController {
	static ConexionDB horariosDB; 
	//Instancia unica
	private static MainController instance = null;
	//Objeto gameDB desde ConexionDB
	ConexionDB gameDB;
	//Objetos vApp y vJuegos desde las vistas VistaApp y VistaJuegos
	VistaApp vApp;
	//VistaJuegos vJuegos;
	//Objeto usuarios desde UsuariosModel
	UsuariosModel usuarios=null;
	UsuariosModel nombre=null;
	UsuariosModel password=null;

	//Comprobacion del estado de la conexion
	private MainController() 
	{
		//Objeto generado e informacion preparada para "enviar" a la clase ConexionDB/ConexionDB getInstance
		//La informacion es rara porque es generada de forma automatica por tratarse de una base de datos gratuita
		horariosDB = ConexionDB.getInstance("sql5.freemysqlhosting.net", "sql577974", "sql577974", "rS7!zU1*");
		//Comprobacion del estado final de la conexion
		if(horariosDB.conectarDB()==true) {		
			System.out.println("Conexion realizada con exito");	
		}
		else {
			System.out.println("Conexion fallida");
		}
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
/*
	public void showApp() 
	{
		//Carga le objeto vApp desde VistaApp
		vApp = new VistaApp();
		//llama al metodo showPrincipal
		showMain();
		//Vuelve visible la VistaApp a traves del objeto
		vApp.setVisible(true);
	}
	//Metodo showMain
	public void  showMain() 
	{
		//Llama al metodo showPrincipal en VistaApp a traves del objeto vApp y le envia los usuarios del metodo UserData desde en UsuariosModel (ArrayList)
		vApp.showPrincipal();
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
		//showPrincipal();
		//Vuelve visible la VistaApp a traves del objeto
		vApp.setVisible(true);
	}*/

	//Metodo showMain
	/*public void  showMain() 
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
*/
}
