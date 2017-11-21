package Sistema;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import Sistema.Retorno.Resultado;
import Utilidades.ABB;
import Utilidades.ArgumentoInvalidoException;
import Utilidades.GoogleMaps;
import Utilidades.Grafo;
import Utilidades.Validar;
import dominio.Ciudad;
import dominio.Plantacion;
import dominio.Productor;
import dominio.Punto;
import dominio.Silo;

public class Sistema implements ISistema {
	
	private ABB productores; 
	private Grafo mapa;

	@Override
	public Retorno inicializarSistema(int cantPuntos) {
		Retorno ret = new Retorno();
		
		if(cantPuntos > 0)
		{
			productores = new ABB();
			mapa = new Grafo(cantPuntos);
			ret.resultado = Resultado.OK;
		}else{
			ret.resultado = Resultado.ERROR_1;
		}
		
		
		return ret;
	}

	@Override
	public Retorno destruirSistema() {
		Retorno ret = new Retorno();
		//Pasamos todas las colecciones a null
		productores = null;
		mapa = null;
		
		ret.resultado = Resultado.OK;
		
		return ret;
	}

	@Override
	public Retorno registrarProductor(String cedula, String nombre, String direccion, String email, String celular) {
		Retorno ret = new Retorno();
		try {
			Productor p = new Productor(cedula, nombre, direccion, email, celular);
			if(!productores.pertenece(p))
			{
				productores.insertar(p);
				ret.resultado = Resultado.OK;
			}else{
				ret.resultado = Resultado.ERROR_4;
			}
			
			
		}
		catch (ArgumentoInvalidoException ex) {
			//System.out.println(ex.getMessage());
			String valor = ex.getValor();
			
			switch (valor) {
				
				case "CEDULA_INVALIDA":
				ret.resultado = Resultado.ERROR_1;
				break;
				case "CELULAR_INVALIDO":
				ret.resultado = Resultado.ERROR_2;
				break;
				case "EMAIL_INVALIDO":
				ret.resultado = Resultado.ERROR_3;
				break;
				default:
				ret.resultado = Resultado.ERROR_4;
				break;
				
			}
			
			
		}
		
		
		return ret;
	}

	@Override
	public Retorno registrarCiudad(String nombre, Double coordX, Double coordY) {
		Retorno ret = new Retorno();
		
		if(!mapa.esLleno())
		{
			Ciudad nueva = new Ciudad(coordX, coordY, nombre);
			if(!mapa.existeVertice(nueva)){
				mapa.agregarVertice(nueva);
				ret.resultado = Resultado.OK;
			}else{
				ret.resultado = Resultado.ERROR_2;
			}
			
			
		}else{
			ret.resultado = Resultado.ERROR_1;
		}
		
		return ret;
	}

	@Override
	public Retorno registrarPlantacion(String nombre, Double coordX, Double coordY, String cedula_productor,
			int capacidad) {
		Retorno ret = new Retorno();
		
		if(mapa.esLleno()) {
			ret.resultado = Resultado.ERROR_1;
		} else if(capacidad < 1) {
			ret.resultado = Resultado.ERROR_2;
		} else if(mapa.existenCoordenadas(coordX, coordY)) {
			ret.resultado = Resultado.ERROR_3;
		} else if(productores.buscarByCedula(cedula_productor) == null) {
			ret.resultado = Resultado.ERROR_4;
		} else {
			Productor productor = productores.buscarByCedula(cedula_productor);
			Plantacion nueva = new Plantacion(nombre, coordX, coordY, productor, null, capacidad);
			mapa.agregarVertice(nueva);
			ret.resultado = Resultado.OK;
		}
		return ret;
	}

	@Override
	public Retorno registrarSilo(String nombre, Double coordX, Double coordY, int capacidad) {
		Retorno ret = new Retorno();
		
		if(mapa.esLleno()) {
			ret.resultado = Resultado.ERROR_1;
		} else if(capacidad < 1) {
			ret.resultado = Resultado.ERROR_2;
		} else if(mapa.existenCoordenadas(coordX, coordY)) {
			ret.resultado = Resultado.ERROR_3;
		} else {
			Silo silo = new Silo(nombre, coordX, coordY, capacidad);
			mapa.agregarVertice(silo);
			ret.resultado = Resultado.OK;
		}
		return ret;
	}

	@Override
	public Retorno registrarTramo(Double coordXi, Double coordYi, Double coordXf, Double coordYf, int peso) {
		Retorno ret = new Retorno();
		
		Punto i = mapa.obtenerVertice(coordXi, coordYi);
		//Estabas generando dos puntos con las mismas coordenadas?
		//Punto y = mapa.obtenerVertice(coordXi, coordYi);
		Punto y = mapa.obtenerVertice(coordXf, coordYf);
		
		if(peso <= 0) {
			ret.resultado = Resultado.ERROR_1;
		} else if(!mapa.existenCoordenadas(coordXi, coordYi) || !mapa.existenCoordenadas(coordXf, coordYf)) {
			ret.resultado = Resultado.ERROR_2;
		} else if(mapa.existeArista(i, y)) {
			ret.resultado = Resultado.ERROR_3;
		} else {
			mapa.agregarArista(i, y, peso);
			ret.resultado = Resultado.OK;
		}
		return ret;
	}

	@Override
	public Retorno eliminarTramo(Double coordXi, Double coordYi, Double coordXf, Double coordYf) {
		Retorno ret = new Retorno();
		
		Punto i = mapa.obtenerVertice(coordXi, coordYi);
		//Estabas generando dos puntos con las mismas coordenadas?
		//Punto y = mapa.obtenerVertice(coordXi, coordYi);
		Punto y = mapa.obtenerVertice(coordXf, coordYf);
		
		if(!mapa.existenCoordenadas(coordXi, coordYi) || !mapa.existenCoordenadas(coordXf, coordYf)) {
			ret.resultado = Resultado.ERROR_1;
		} else if(!mapa.existeArista(i, y)) {
			ret.resultado = Resultado.ERROR_2;
		} else {
			mapa.borrarArista(i , y);
			ret.resultado = Resultado.OK;
		}
		
		return ret;
	}

	@Override
	public Retorno eliminarPunto(Double coordX, Double coordY) {
		Retorno ret = new Retorno();
		
		Punto punto = mapa.obtenerVertice(coordX, coordY);
		
		if(punto == null) {
			ret.resultado = Resultado.ERROR_1;
		} else {
			mapa.borrarVertice(punto);
			ret.resultado = Resultado.OK;
		}
		
		return ret;
	}

	@Override
	public Retorno mapaEstado() {
		Retorno ret = new Retorno();
		
		try {
			Desktop.getDesktop().browse(GoogleMaps.generarMapa("Uruguay", mapa));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ret.resultado = Resultado.OK;
		return ret;
	}

	@Override
	public Retorno rutaASiloMasCercano(Double coordX, Double coordY) {
		Retorno ret = new Retorno();
		
		if(!mapa.existenCoordenadas(coordX, coordY)) {
			ret.resultado = Resultado.ERROR_1;
		} else {
			String ruta = mapa.siloMasCercano(coordX, coordY);
			ret.resultado = Resultado.OK;
			ret.valorString = ruta;
		}
		
		return ret;
	}

	@Override
	public Retorno listadoDePlantacionesEnCiudad(Double coordX, Double coordY) {
		Retorno ret = new Retorno();
		
		ret.resultado = Resultado.NO_IMPLEMENTADA;
		
		return ret;
	}

	@Override
	public Retorno listadoDeSilos() {
		Retorno ret = new Retorno();
		
		String msg ="";
		for(int i=0; i<mapa.getPuntos().length;i++)
		{
			
			Punto aux = mapa.getPuntos()[i];
			if(aux != null && aux instanceof Silo) msg+= ((Silo) aux).getDatos();
			
		}
		
		if(msg.length() > 0) msg = Validar.cortarUltimo(msg);
		
		ret.resultado = Resultado.OK;
		ret.valorString = msg;
		
		return ret;
	}

	@Override
	public Retorno listadoProductores() {
		Retorno ret = new Retorno();
		
		//System.out.println("Test:" + productores.listarAscendenteString());
		
		ret.resultado = Resultado.OK;
		ret.valorString = productores.listarAscendenteString();
		
		return ret;
	}

}
