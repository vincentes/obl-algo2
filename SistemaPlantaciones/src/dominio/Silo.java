package dominio;

public class Silo extends Punto{

	private int capacidad;
	private int remanente;

	public Silo(String nombre, Double coordX, Double coordY, int capacidad) {
		super(nombre, coordX, coordY);
		this.capacidad = capacidad;
		this.remanente = capacidad;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	public int getRemanente() {
		return remanente;
	}

	public void setRemanente(int remanente) {
		this.remanente = remanente;
	}
	
	public String getDatos(){
		return super.getStringCoord() + ";" + capacidad + ";" + remanente + "|";
	}
	
	
}
