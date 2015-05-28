package controlador;

import vistas.VistaApp;
import vistas.VistaLogin;
import modelo.ConexionDB;
import modelo.UsuariosModel;

public class MainController {
	  
	//Instancia unica
	private static MainController instance = null;
	//Objeto horariosDB desde ConexionDB
	ConexionDB horariosDB;
	//Objetos de las vistas
	VistaApp vApp;
	//Autenticar auth;
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
	public void showMedico() {	
		if (logintest()==true){
			System.out.println("ventana Medico llamada. ShowMedico ha dado TRUE");
			System.out.println("en showMedico se ha recogido el valor de contraseña: "+VistaLogin.passField);
			//vApp.showMedico();
		}
		else {
			System.out.println("showMedico ha dado FALSE");
			System.out.println("en showMedico se ha recogido el valor de contraseña: "+VistaLogin.passField);
		}
	}

	//Metodo showUsuario
	public void showUsuario() {
		vApp.showUsuario();
	}
	public boolean logintest() {
		String pass="";
		pass=VistaLogin.passField;
		
		if (pass.equals("")){
			System.out.println("Devuelto FALSE desde logintest");
		return false;
		}
		else {
			System.out.println("Devuelto TRUE desde logintest");
			return true;
		}
	}
}
