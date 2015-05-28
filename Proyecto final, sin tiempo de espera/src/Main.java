import controlador.MainController;
import modelo.ConexionDB;
import vistas.VistaApp;


public class Main {
	//Variables para conectar con otras clases
	
	static ConexionDB horariosDB; 
	public static void main(String[] args) {
	/*	//Objeto generado e informacion preparada para "enviar" a la clase ConexionDB/ConexionDB getInstance
		//La informacion es rara porque es generada de forma automatica por tratarse de una base de datos gratuita
		horariosDB = ConexionDB.getInstance("sql5.freemysqlhosting.net", "sql577974", "sql577974", "rS7!zU1*");
		//Comprobacion del estado final de la conexion
		if(horariosDB.conectarDB()==true) {		
			System.out.println("Conexion realizada con exito");	
		}
		else {
			System.out.println("Conexion fallida");
		}
		//Hace visible la clase VistaApp (que contiene la informacion para hacer visible la clase VistaPrincipal)
		VistaApp vistaApp = new VistaApp(); //Inicializamos VistaApp
		vistaApp.setVisible(true); //Hacemos visible VistaApp
		//Con esto arranca el controlador. Desde aqui el se ocupa de "todo"
		
		*/MainController Controller=MainController.getInstance();
		Controller.showApp();
	}
}
