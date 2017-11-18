package Utilidades;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;

import dominio.Ciudad;
import dominio.Plantacion;
import dominio.Punto;
import dominio.Silo;

public class GoogleMaps {
	
	public static final String API_KEY = "AIzaSyB2Pdqdsny9XAk0fb2LqAruWcpgF-Enu34";
	
	public static URI generarMapa(String centro, Grafo grafo) {
		try {
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
