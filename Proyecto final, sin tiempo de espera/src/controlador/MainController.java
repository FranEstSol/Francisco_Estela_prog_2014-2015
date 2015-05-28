package controlador;

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
			vApp.showMedico();
		}
		else {
			VistaLogin.lblAlerta.setText("Contraseña incorrecta");
		}
	}

	//Metodo showUsuario
	public void showUsuario() {
		vApp.showUsuario();
	}

	public boolean logintest() {
		char[] pass;
		pass=VistaLogin.passField;

		if(pass.length == 0){			
			return false;
		}
		else {
			System.out.println("Devuelto TRUE desde logintest");
			return true;
			}					
		}
		
	}
	



	/* EXPERIMENTO RARO PARA LA CONTRASEÑA. IGNORAR DE MOMENTO
	  for (int i=0; i<=VistaLogin.comboBoxMedicos.getItemCount();i++){
				if (VistaLogin.comboBoxMedicos.getSelectedItem()==VistaLogin.selectedUser){
					for (int u=0; u==i;u++)
						Iterator<String> it =password.iterator();
					while (it.hasNext()) {
						System.out.println("AÑADIDO EL MEDICO AL COMBOBOX ");
						comboBoxMedicos.addItem((String)it.next());
					}	
				}
				System.out.println();
				i=i+14;*/
