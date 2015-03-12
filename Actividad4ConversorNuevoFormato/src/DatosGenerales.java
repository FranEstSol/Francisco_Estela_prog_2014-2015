
public class DatosGenerales {
	
	//Lista de monedas
	final static String moneda_DOL= "Dolares";
	final static String moneda_EUR= "Euros";
	final static String moneda_LIB= "Libras";
	final static String moneda_YEN= "Yenes";	
	
	//Lista de valores
	final static float valor_DOL= 1.13f;
	final static float valor_EUR= 1.0f;
	final static float valor_LIB= 0.75f;
	final static float valor_YEN= 132.47f;	
	
	//Otras variables
	private String textoMonedas[]={moneda_DOL, moneda_EUR, moneda_LIB, moneda_YEN};
	private float valoresConversionMonedasAEuro []={valor_DOL, valor_EUR, valor_LIB, valor_YEN};
	
	//Crea una variable publica en formato String (con array) llamada "getMonedas" que coje los valores de "textoMonedas"
	public String [] getMonedas(){
		return textoMonedas;
	}
	//Crea una variable publica en formato float (con array) llamada "getValoresAEuro" que coje los valores de "valoresConversionMonedasAEuro"

	public float [] getValoresAEuro(){
		return valoresConversionMonedasAEuro;
	} 

}
