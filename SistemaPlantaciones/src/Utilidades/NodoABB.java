package Utilidades;

import dominio.Punto;

public class NodoABB implements Comparable<Object>{
	private Comparable dato;
	private NodoABB izq;
	private NodoABB der;

	public Object getDato() {
		return dato;
	}

	public void setDato(Comparable dato) {
		this.dato = dato;
	}

	public NodoABB getIzq() {
		return izq;
	}

	public void setIzq(NodoABB izq) {
		this.izq = izq;
	}

	public NodoABB getDer() {
		return der;
	}

	public void setDer(NodoABB der) {
		this.der = der;
	}

	public NodoABB(Comparable dato, NodoABB izq, NodoABB der) {
		this.dato = dato;
		this.izq = izq;
		this.der = der;
	}

	public NodoABB(Comparable dato) {
		this.dato = dato;
	}

	@Override
	public int compareTo(Object nodo) {
		return dato.compareTo(((NodoABB)nodo).getDato());
	}

}
