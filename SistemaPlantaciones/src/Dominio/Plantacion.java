package Dominio;

public class Plantacion extends Punto{
	private Propietario propietario;
	private TipoPlantacion tipo;
	private int produccionMensual;
	
	public Plantacion(Double coordX, Double coordY, String nombre, Propietario propietario,  TipoPlantacion tipo, int produccion) {
		super(nombre, coordX, coordY);
		this.propietario = propietario;
		this.tipo = tipo;
		this.produccionMensual = produccion;
	}

}
