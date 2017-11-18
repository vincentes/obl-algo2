package dominio;

public class Silo extends Punto{

	private int capacidad;

	public Silo(String nombre, Double coordX, Double coordY, int capacidad) {
		super(nombre, coordX, coordY);
		this.capacidad = capacidad;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}
	
	
	
	
}
