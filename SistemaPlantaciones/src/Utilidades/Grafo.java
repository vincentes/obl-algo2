package Utilidades;

import dominio.Punto;
import dominio.Silo;
import listas.Lista;
import listas.ListaSE;

public class Grafo {
	
	private int contador;
	private int tope;
	private Arco[][] matAdy;
	private Punto[] vec;
	
	public Grafo(int tope) {
//		this.contador = 0;
		this.tope = tope;
		this.vec = new Punto[tope];
		this.matAdy = new Arco[tope][tope];
		
		for (int i = 0; i < matAdy.length; i++) {
			for (int j = 0; j < matAdy[0].length; j++) {
				matAdy[i][j] = new Arco();
			}
		}
		
	}
	
	public Arco[][] getMatriz(){
		return matAdy;
	}
	
	public boolean esVacio(){
		return contador == 0;
	}
	
	public boolean esLleno(){
		return contador == tope;
	}

	public boolean existeVertice(Punto v1)
	{
		for (int i = 0; i < vec.length; i++) {
			if(vec[i] != null && vec[i].equals(v1)) {
				return true;
			}				
		}
		return false;
	}
	
	public boolean existenCoordenadas(Double coordX, Double coordY) 
	{
		for(int i = 0; i < vec.length; i++) {
			if(vec[i] != null && vec[i].getCoordX().equals(coordX) && vec[i].getCoordY().equals(coordY)) {
				return true;
			}
		}
		return false;
	}
	
	//Pre: existeVertice(v1) && existeVertice(v2) 
	public boolean existeArista(Punto v1, Punto v2){
		int posV1 = posVertice(v1);
		int posV2 = posVertice(v2);
		return matAdy[posV1][posV2].isExiste();
	}

	//Pre: existeVertice(v1) && existeVertice(v2) && existeArista(v1,v2)
	public int obtenerArista(Punto v1, Punto v2){
		int posV1 = posVertice(v1);
		int posV2 = posVertice(v2);
		return matAdy[posV1][posV2].getPeso();
	}
	
	public Punto[] getPuntos() {
		return vec;
	}
	
	//Pre: existeVertice(v1) && existeVertice(v2) && !existeArista(v1,v2)	
	public void agregarArista(Punto v1, Punto v2, int peso){
		int posV1 = posVertice(v1);
		int posV2 = posVertice(v2);
		matAdy[posV1][posV2].setExiste(true);
		matAdy[posV1][posV2].setPeso(peso);
	}
	
	//Pre: existeVertice(v1) && existeVertice(v2) && existeArista(v1,v2)
	public void borrarArista(Punto v1, Punto v2){
		int posV1 = posVertice(v1);
		int posV2 = posVertice(v2);
		matAdy[posV1][posV2].setExiste(false);
	}
	
	//Pre: !esLleno()
	public void agregarVertice(Punto punto)
	{
		int posNull = 0;
		while(vec[posNull]!=null)
			posNull++;
		
		vec[posNull] = punto;
		
		this.contador++;
	}
	
	//Pre: existeVertice(vertice)
	public void borrarVertice(Punto vertice)
	{
		int posNull = 0;
		while(!vec[posNull].equals(vertice))
			posNull++;
		
		vec[posNull] = null;
		
		for (int i = 0; i < matAdy.length; i++) {
			matAdy[i][posNull].setExiste(false);
			matAdy[posNull][i].setExiste(false);
		}
		
//		for (int i = 0; i < matAdy.length; 
//				matAdy[i][posNull].setExiste(false),
//				matAdy[posNull][i++].setExiste(false)
//		);
		
		this.contador--;
	}
	
	//Pre: existeVertice(vertice)
	public Lista<Punto> adyacentes(Punto vertice)
	{
		int posV = posVertice(vertice);
		Lista<Punto> ret = new ListaSE<Punto>();
		for (int i = 0; i < matAdy.length; i++)
			if(matAdy[posV][i].isExiste())
				ret.insertar(vec[i]);
		return ret;
	}		
	//Pre: existeVertice(vertice)
	public Lista<Punto> incidentes(Punto vertice)
	{
		int posV = posVertice(vertice);
		Lista<Punto> ret = new ListaSE<Punto>();
		for (int i = 0; i < matAdy.length; i++)
			if(matAdy[i][posV].isExiste())
				ret.insertar(vec[i]);
		return ret;
	}
	
	
	public Lista<Punto> caminoMasCorto(int origen, int destino) {
		int[] dist = new int[tope];
	    boolean[] vis = new boolean[tope];
	    int[] ant = new int[tope];
	    for(int i = 0; i < tope; i++) {
	    	dist[i] = Integer.MAX_VALUE;
	    	ant[i] = -1;
	    }
	    
	    dist[origen] = 0;
	    vis[origen] = true;
	    for(int i = 0; i < tope; i++) {
	    	if(matAdy[origen][i].isExiste()) {
	    		dist[i] = matAdy[origen][i].getPeso();
	    		ant[i] = origen;
	    	}
	    }
	    
	    for(int k = 1; k < tope; k++) {
	    	int min = Integer.MAX_VALUE;
	    	int cand = -1;
	    	for(int i = 0; i < tope; i++) {
	    		if(dist[i] < min && !vis[i]) {
	    			min = dist[i];
	    			cand = i;
	    		}
	    	}
	    
	    	if(cand == -1) {
	    		break;
	    	}
	    	
	    	vis[cand] = true;
	    	for(int i = 0; i < tope; i++) {
	    		int pasoFinal = matAdy[cand][i].getPeso();
	    		if(matAdy[cand][i].isExiste() && !vis[i] && dist[cand] + pasoFinal < dist[i]) {
	    			dist[i] = dist[cand] + pasoFinal;
	    			ant[i] = cand;
	    		}
	    	}
	    }
	    
	    Lista<Punto> recorrido = new ListaSE<Punto>();
	    for(int i = 0; i < vis.length; i++) {
	    	recorrido.insertar(vec[i]);
	    }
	    
	    return recorrido;
	    
	}
	
	public int distanciaMasCorta(int origen, int destino) {
		int[] dist = new int[tope];
	    boolean[] vis = new boolean[tope];
	    int[] ant = new int[tope];
	    for(int i = 0; i < tope; i++) {
	    	dist[i] = Integer.MAX_VALUE;
	    	ant[i] = -1;
	    }
	    
	    dist[origen] = 0;
	    vis[origen] = true;
	    for(int i = 0; i < tope; i++) {
	    	if(matAdy[origen][i].isExiste()) {
	    		dist[i] = matAdy[origen][i].getPeso();
	    		ant[i] = origen;
	    	}
	    }
	    
	    for(int k = 1; k < tope; k++) {
	    	int min = Integer.MAX_VALUE;
	    	int cand = -1;
	    	for(int i = 0; i < tope; i++) {
	    		if(dist[i] < min && !vis[i]) {
	    			min = dist[i];
	    			cand = i;
	    		}
	    	}
	    
	    	if(cand == -1) {
	    		break;
	    	}
	    	
	    	vis[cand] = true;
	    	for(int i = 0; i < tope; i++) {
	    		int pasoFinal = matAdy[cand][i].getPeso();
	    		if(matAdy[cand][i].isExiste() && !vis[i] && dist[cand] + pasoFinal < dist[i]) {
	    			dist[i] = dist[cand] + pasoFinal;
	    			ant[i] = cand;
	    		}
	    	}
	    }
	    
	    // No se encontro camino
	    if(dist[destino] == Integer.MAX_VALUE) {
	    	return -1;
	    }
	    
	    return dist[destino];
	}
	
	
	//Pre: !existeArista
	private int posVertice(Punto vertice)
	{

		for (int i = 0; i < vec.length; i++)
			if(vec[i].equals(vertice))
				return i;
		return -1;
	}

	public Punto obtenerVertice(Double coordXi, Double coordYi) {
		for(int i = 0; i < vec.length; i++) {
			if(vec[i] != null && vec[i].getCoordX().equals(coordXi) && vec[i].getCoordY().equals(coordYi)) {
				return vec[i];
			}
		}
		return null;
	}

	public Lista<Silo> silos() {
		Lista<Silo> silos = new ListaSE<Silo>();
		for(int i = 0; i < vec.length; i++) {
			if(vec[i] instanceof Silo) {
				silos.insertar((Silo) vec[i]);
			}
		}
		return silos;
	}
	
	public int indice(Punto punto) {
		for(int i = 0; i < vec.length; i++) {
			if(vec[i] != null && vec[i].equals(punto)) {
				return i;
			}
		}
		return -1;
	}
	
	public Silo siloMasCercano(Double coordX, Double coordY) {
		int distanciaMasCorta = Integer.MAX_VALUE;
		Silo siloMasCerca = null;
		Punto origen = obtenerVertice(coordX, coordY);
		for(Silo silo : silos()) {
			int distanciaSilo = distanciaMasCorta(indice(origen), indice(silo));
			if(distanciaSilo == -1) {
				continue;
			}
			
			if(distanciaSilo < distanciaMasCorta) {
				distanciaMasCorta = distanciaSilo;
				siloMasCerca = silo;
			}
		}
		return siloMasCerca;
	}
}
