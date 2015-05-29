import controlador.MainController;
import modelo.ConexionDB;
import vistas.VistaApp;


public class Main {
	//Variables para conectar con otras clases
	
	static ConexionDB horariosDB; 
	public static void main(String[] args) {
		MainController Controller=MainController.getInstance();
		Controller.showApp();
	}
}
