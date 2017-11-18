package dominio;

public class Plantacion extends Punto{
	private Productor propietario;
	private TipoPlantacion tipo;
	private int produccionMensual;
	
	public Plantacion(String nombre, Double coordX, Double coordY, Productor propietario,  TipoPlantacion tipo, int produccionMensual) {
		super(nombre, coordX, coordY);
		this.propietario = propietario;
		this.tipo = tipo;
		this.produccionMensual = produccionMensual;
	}



}
