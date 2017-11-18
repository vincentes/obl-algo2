package Dominio;

public class Punto  implements Comparable<Object>{
	private Double coordX;
	private Double coordY;
	private String nombre;

	public Double getCoordX() {
		return coordX;
	}
	public void setCoordX(Double coordX) {
		this.coordX = coordX;
	}
	public Double getCoordY() {
		return coordY;
	}
	public void setCoordY(Double coordY) {
		this.coordY = coordY;
	}
	
	
	public String getNombre() {
		return nombre;
	}
	
	public Punto(String nombre, Double coordX, Double coordY) {
		//super();
		this.nombre = nombre;
		this.coordX = coordX;
		this.coordY = coordY;
	}
	
	public int compareTo(Object o) {
		if(coordX == ((Punto)o).getCoordX()){
			return coordY.compareTo(((Punto)o).getCoordY());
		}else{
			return -1;
		}
		
	}
	
}
