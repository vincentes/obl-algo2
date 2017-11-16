package Utilidades;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validar {
	//Prueba
	//Comentario de prueba
	private static Pattern pattern;
	private static Matcher matcher;
	
		
	//Validadores:
	public static boolean email(String dato){
		
		return validar(dato,
				Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
				+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"));
	}
	
public static boolean cedula(String dato){
	
		return validar(dato,
				Pattern.compile("^[0-9]\\.[0-9]{3}\\.[0-9]{3}-[0-9]$"));
	}

public static boolean celular(String dato) {
	
	return validar(dato,
			Pattern.compile("^09[0-9]{7}$"));
}
	
	public static boolean validar(String valor, Pattern patron) {

		matcher = patron.matcher(valor);
		return matcher.matches();

	}

	

}
