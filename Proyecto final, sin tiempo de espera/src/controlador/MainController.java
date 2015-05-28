package controlador;

import java.sql.SQLException;
import java.util.Iterator;

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
	//Objeto usuarios desde UsuariosModel
	UsuariosModel usuarios=null;
	UsuariosModel nombre=null;
	UsuariosModel password=null;

	public static String selectedUser="";

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
	//Recibimos las 2 variables passString y selectedUser desde VistaLogin
	public void showMedico(String password, String user) {	
		//Mediante el if "llamamos" al metodo logintest para comprobar, lo primero, si la contraseña esta vacia o no. De paso le enviamos las 2 variables
		if (logintest(password, user)==true){
			vApp.showMedico();
		}
		else {
			System.out.println(selectedUser);

		}
	}

	//Metodo showUsuario
	public void showUsuario() {
		vApp.showUsuario();
	}

	//Metodo logintest
	//Recibe las 2 variables y se pone en marcha.
	public boolean logintest(String password, String user) {
		//Si esta vacio, error de contraseña vacia devolviendo false
		if(password.length() == 0){	
			VistaLogin.lblAlerta.setText("Campo de contraseña vacio.");
			return false;
		}
		//En caso de que la contraseña no este vacia, llega aqui
		else {

			//Coje el con el objeto "nombre" llama al metodo "userpassword" que esta en usuariosModel, enviandole la variable "user" que llevamos un rato arrastrando.
			//Ese metodo devuelve la contraseña relacionado con ese usuario
			String pass = nombre.UserPassword(user);
			//Comprueba si la contraseña que traiamos arrastrando (la de la caja de la contraseña) es la misma que la de la base de datos, traida desde UsuariosModel.
			//Si son iguales, devuelve true y muestra el panel de los medicos.
			if (password.equals(pass)){
				System.out.println("LAS CONTRASEÑAS SON CORRECTAS!");
				System.out.println("Devuelto TRUE desde logintest");
				return true;
			}
			//En caso de que no sean iguales, da contraseña erronea
			else {
				System.out.println("CONTRASEÑA FAIL!");
				VistaLogin.lblAlerta.setText("Contraseña incorrecta");
				return false;
			}
		}					
	}		
}
	

