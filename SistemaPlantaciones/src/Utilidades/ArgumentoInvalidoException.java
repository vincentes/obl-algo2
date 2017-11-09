package Utilidades;

public class ArgumentoInvalidoException extends IllegalArgumentException {
	private String valor;
	
	public ArgumentoInvalidoException(String mensaje, String valor) {
		super(mensaje);
		this.setValor(valor);
	}

	private String getValor() {
		return valor;
	}

	private void setValor(String valor) {
		this.valor = valor;
	}
	
	
}
