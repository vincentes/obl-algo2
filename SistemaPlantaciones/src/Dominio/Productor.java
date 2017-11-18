package Dominio;

import java.util.Comparator;

import Utilidades.ArgumentoInvalidoException;
import Utilidades.Validar;

public class Productor implements Comparable<Object>{
	private String cedula;
	private String nombre;
	private String direccion;
	private String email;
	private String celular;
	
	
	public Productor(String cedula, String nombre, String direccion, String email, String celular) {
		//super();
		if(!Validar.email(email)) {
			throw new ArgumentoInvalidoException("El email es inv�lido.", "EMAIL_INVALIDO");
		} else if(!Validar.cedula(cedula)) {
			throw new ArgumentoInvalidoException("La c�dula es inv�lida.", "CEDULA_INVALIDA");
		} else if(!Validar.celular(celular)) {
			throw new ArgumentoInvalidoException("El celular es inv�lido.", "CELULAR_INVALIDO");
		}
		
		this.setCedula(cedula);
		this.nombre = nombre;
		this.direccion = direccion;
		this.email = email;
		this.celular = celular;
	}


	public String getCedula() {
		return cedula;
	}


	public void setCedula(String cedula) {
		this.cedula = cedula;
	}


	public int compareTo(Object o) {
		return cedula.compareTo(((Productor) o).getCedula());
	}	
	

}
