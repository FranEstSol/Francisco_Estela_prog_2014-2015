package controlador;

import vistas.VistaApp;
import modelo.ConexionDB;
import modelo.UsuariosModel;

public class MainController {
	  
	//Instancia unica
	private static MainController instance = null;
	//Objeto horariosDB desde ConexionDB
	ConexionDB horariosDB;
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
	
	//PUNTO DE ROTURA
	
	//Implementacion SingleTon
	public static MainController getInstance() {
		if (instance == null)
		{
			instance = new MainController();
		}
		return instance;
	}

	public void showApp() {
		//Carga le objeto vApp desde VistaApp
		vApp = new VistaApp();
		//llama al metodo showMain
		showMain();
		//Vuelve visible la VistaApp a traves del objeto
		vApp.setVisible(true);
	}

	//Metodos de llamamiento a los metodos que hacen visibles las vistas
	//Metodo showMain
	public void showMain() {
		System.out.println("ventana Main llamada");
		vApp.showMain();
	}

	//Metodo showLogin
	public void showLogin() {
		System.out.println("ventana Login llamada");
		//Si usuarios es null, se crea el objetos usuarios desde UsuariosModel (relacionado con el objeto de arriba)
		if (nombre==null) {
			nombre=new UsuariosModel();
		}
		vApp.showLogin(nombre.ArrNombre());
	}

	//Metodo showMedico
	public void showMedico() 
	{
		vApp.showMedico();
	}

	//Metodo showUsuario
	public void showUsuario() 
	{
		vApp.showUsuario();
	}
}
