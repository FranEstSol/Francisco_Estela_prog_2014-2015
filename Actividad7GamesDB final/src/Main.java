import controlador.MainController;
import vistas.VistaApp;


public class Main 
{		
	public static void main(String[] args) 
	{		
		//Con esto arranca el controlador. Desde aqui el se ocupa de "todo"
		MainController Controller=MainController.getInstance();
		Controller.showMain();	
		
		/*	VistaApp ventana=new VistaApp();
			ventana.setVisible(true);*/
		
	}
}
