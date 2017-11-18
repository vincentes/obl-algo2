package Utilidades;

import java.util.Comparator;

import dominio.Productor;

public class ABB {
	private NodoABB raiz;

	public ABB() {
		//this.raiz = null;
	}
	
	public void insertar(Comparable x)
	{
		if(raiz == null)
			raiz = new NodoABB(x);
		else
			insertarRec(x, raiz);
	}

	private void insertarRec(Comparable x, NodoABB nodo) {
		if(x.compareTo(nodo.getDato()) < 0){
			if(nodo.getIzq() == null)
				nodo.setIzq(new NodoABB(x));
			else
				insertarRec(x,nodo.getIzq());	
		}
		else if(x.compareTo(nodo.getDato()) > 0){
			if(nodo.getDer() == null)
				nodo.setDer(new NodoABB(x));
			else 
				insertarRec(x,nodo.getDer());
		}
	}
	
	//Pre: !EsVacio()
	public Comparable borrarMinimo(){
		Comparable min;
		if(raiz.getIzq()==null){
			min = (Comparable) raiz.getDato();
			raiz = raiz.getDer();
		}else
			min = borrarMinimoRec(raiz);
		return min;
	}

	private Comparable borrarMinimoRec(NodoABB nodo) {
		Comparable min;
		if(nodo.getIzq().getIzq()==null){
			min = (Comparable) nodo.getIzq().getDato();
			nodo.setIzq(nodo.getIzq().getDer());
		}else
			min = borrarMinimoRec(nodo.getIzq());
		return min;
	}
	
	public void listarAscendente()
	{
		listarAscendenteAux(raiz);
	}

	public void listarDescendente()
	{
		listarDescendenteAux(raiz);
	}

	private void listarAscendenteAux(NodoABB nodo) {
		if(nodo != null)
		{
			listarAscendenteAux(nodo.getIzq());
			System.out.println(nodo.getDato());
			listarAscendenteAux(nodo.getDer());
		}
	}

	private void listarDescendenteAux(NodoABB nodo) {
		if(nodo != null)
		{
			listarDescendenteAux(nodo.getDer());
			System.out.println(nodo.getDato());
			listarDescendenteAux(nodo.getIzq());
		}
	}
	
	public boolean pertenece(Comparable dato)
	{
		return perteneceRec(raiz, dato);
	}

	private boolean perteneceRec(NodoABB nodo, Comparable dato) {
		if(nodo == null)
			return false;
		else{
			if(dato.compareTo(nodo.getDato()) == 0)
				return true;
			else if(dato.compareTo(nodo.getDato()) < 0)
				return perteneceRec(nodo.getIzq(), dato);
			else 
				return perteneceRec(nodo.getDer(), dato);
		}
	}
	
	//Pre: pertenece(dato)
	public void borrar(Comparable dato)
 	{
		if(raiz.getDato()==dato)
		{
			if(raiz.getIzq()==null)
				raiz = raiz.getDer();
			else if(raiz.getDer()==null)
				raiz = raiz.getIzq();
			else
			{
				if(raiz.getDer().getIzq()==null)
				{
					raiz.setDato((Comparable) raiz.getDer().getDato());
					raiz.setDer(raiz.getDer().getDer());
				}
				else{
					raiz.setDato(borrarMinimoRec(raiz.getDer()));
				}
			}
		}
		else 
			borrarRec(raiz, dato);
	}

	private void borrarRec(NodoABB nodo, Comparable dato) {
		if(dato.compareTo(nodo.getDato()) < 0)
		{
			if(nodo.getIzq().getDato()==dato)
			{
				if(nodo.getIzq().getIzq()==null)
					nodo.setIzq(nodo.getIzq().getDer());
				else if(nodo.getIzq().getDer()==null)
					nodo.setIzq(nodo.getIzq().getIzq());
				else
				{
					if(nodo.getIzq().getDer().getIzq()==null)
					{
						nodo.getIzq().setDato((Comparable) nodo.getIzq().getDer().getDato());
						nodo.getIzq().setDer(nodo.getIzq().getDer().getDer());
					}
					else{
						nodo.getIzq().setDato(borrarMinimoRec(nodo.getIzq().getDer()));
					}
				}
			}
			else 
				borrarRec(nodo.getIzq(), dato);
		} else if(dato.compareTo(nodo.getDato()) < 0)
		{
			if(nodo.getDer().getDato()==dato)
			{
				if(nodo.getDer().getIzq()==null)
					nodo.setIzq(nodo.getDer().getDer());
				else if(nodo.getDer().getDer()==null)
					nodo.setIzq(nodo.getDer().getIzq());
				else
				{
					if(nodo.getDer().getDer().getIzq()==null)
					{
						nodo.getDer().setDato((Comparable)nodo.getDer().getDer().getDato());
						nodo.getDer().setDer(nodo.getDer().getDer().getDer());
					}
					else{
						nodo.getDer().setDato(borrarMinimoRec(nodo.getDer().getDer()));
					}
				}
			}
			else 
				borrarRec(nodo.getDer(), dato);
		}
	}

	public Productor buscarByCedula(String cedula_productor) {
		NodoABB busqueda = buscarByCedulaRec(raiz, cedula_productor);
		if(busqueda == null) {
			return null;
		}
		return (Productor) busqueda.getDato();
	}
	
	public NodoABB buscarByCedulaRec(NodoABB nodo, String cedula_productor) {
	    if(nodo != null){
	    	Productor productor = (Productor) nodo.getDato();
	        if(productor.getCedula().equals(cedula_productor)) {
	           return nodo;
	        } else {
	            NodoABB foundNode = buscarByCedulaRec(nodo.getIzq(), cedula_productor);
	            if(foundNode == null) {
	                foundNode = buscarByCedulaRec(nodo.getDer(), cedula_productor);
	            }
	            return foundNode;
	         }
	    }
		return null;
	}
	
	
}
