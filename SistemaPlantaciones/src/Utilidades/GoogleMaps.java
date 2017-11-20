package Utilidades;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;

import dominio.Ciudad;
import dominio.Plantacion;
import dominio.Punto;
import dominio.Silo;
import listas.ListaSE;

public class GoogleMaps {
	
	public static final String API_KEY = "AIzaSyB2Pdqdsny9XAk0fb2LqAruWcpgF-Enu34";
	
	public static URI generarMapa(String centro, Grafo grafo) {
		try {
			ListaSE puntosObtenidos = new ListaSE<Punto>();
			String baseURL = "";
			baseURL += "https://maps.googleapis.com/maps/api/staticmap?center=" + URLEncoder.encode(centro, "UTF-8") + 
					"&zoom=" + URLEncoder.encode("7", "UTF-8") + 
					"&size=" + URLEncoder.encode("800x800", "UTF-8") +
					"&maptype=" + URLEncoder.encode("roadmap", "UTF-8");
			for(Punto punto : grafo.getPuntos()) {
				if(punto == null) {
					continue;
				} 
				String color = "";
				if(punto instanceof Ciudad) {
					color = URLEncoder.encode("red", "UTF-8");
				} else if(punto instanceof Plantacion) {
					color = URLEncoder.encode("yellow", "UTF-8");
				} else if(punto instanceof Silo) {
					color = URLEncoder.encode("green", "UTF-8");
				}
				
				
				
				String label = URLEncoder.encode(punto.getNombre(), "UTF-8");
				String latitud = URLEncoder.encode(String.valueOf(punto.getCoordX()), "UTF-8");
				String longitud = URLEncoder.encode(String.valueOf(punto.getCoordY()), "UTF-8");
				baseURL += "&markers=color:" + color + "%7Clabel:" + label + "%7C" + latitud + "," + longitud;	
				
				
				//Agregamos los tramos
				
				
				for(Punto punto2 : grafo.getPuntos()) {
					if(punto2 == null || punto.equals(punto2)) {
						continue;
					} 
					
					if(grafo.getMatriz()[grafo.indice(punto)][grafo.indice(punto2)].getPeso()>0 && !puntosObtenidos.contiene(punto2)){
						color = URLEncoder.encode("red", "UTF-8");
						String latitud2 = URLEncoder.encode(String.valueOf(punto2.getCoordX()), "UTF-8");
						String longitud2 = URLEncoder.encode(String.valueOf(punto2.getCoordY()), "UTF-8");
						String pipe = URLEncoder.encode(String.valueOf("|"), "UTF-8");
						
						baseURL += "&path=color:0xff0000ff"+pipe+"weight:5"+pipe+latitud+","+longitud+pipe+latitud2+","+longitud2;
						if(!puntosObtenidos.contiene(punto)){
							puntosObtenidos.insertar(punto);
						}
						
						//System.out.println("punto " + punto.getNombre() + " - " + "punto2 " + punto2.getNombre());
						
					}
				}
			}
			
			baseURL += "&key=" + URLEncoder.encode(API_KEY, "UTF-8");
			return new URI(baseURL);
		} catch(UnsupportedEncodingException e) {
			// TODO: Que hacemos aca? Revisar esto.
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO: Que hacemos aca? Revisar esto.
			e.printStackTrace();
		}
		return null;
	}
}
//https://maps.googleapis.com/maps/api/staticmap?center=Uruguay&zoom=7&size=800x800&maptype=roadmap&markers=color:red%7Clabel:MONTEVIDEO%7C-34.901113,-56.164531&path=color:0xff0000ff|weight:5|-34.901113,-56.164531|-32.702193,-57.638238&path=color:0xff0000ff|weight:5|-34.901113,-56.164531|-33.9616565,-57.0951748&path=color:0xff0000ff|weight:5|-34.901113,-56.164531|-33.725648,-56.329281&markers=color:red%7Clabel:TRINIDAD%7C-33.520142,-56.90422&markers=color:red%7Clabel:COLONIA%7C-34.460719,-57.83391&markers=color:yellow%7Clabel:YOUNG%7C-32.702193,-57.638238&markers=color:yellow%7Clabel:TOLEDO%7C-34.7383897,-56.1098602&markers=color:yellow%7Clabel:VILLA+DEL+CARMEN%7C-33.2402962,-56.0255258&markers=color:green%7Clabel:ISMAEL+CORTINAS%7C-33.9616565,-57.0951748&path=color:0xff0000ff|weight:5|-33.9616565,-57.0951748|-34.901113,-56.164531&markers=color:green%7Clabel:SARANDI+GRANDE%7C-33.725648,-56.329281&key=AIzaSyB2Pdqdsny9XAk0fb2LqAruWcpgF-Enu34
