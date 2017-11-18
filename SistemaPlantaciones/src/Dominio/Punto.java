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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((coordX == null) ? 0 : coordX.hashCode());
		result = prime * result + ((coordY == null) ? 0 : coordY.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Punto other = (Punto) obj;
		if (coordX == null) {
			if (other.coordX != null)
				return false;
		} else if (!coordX.equals(other.coordX))
			return false;
		if (coordY == null) {
			if (other.coordY != null)
				return false;
		} else if (!coordY.equals(other.coordY))
			return false;
		return true;
	}
	
	
	
	
}
