package Sistema;

import dominio.Productor;

public class SistemaPlantaciones {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Pruebas:
		
				String sep ="";
				for(int i=0; i<140;i++){
					sep+="*";
				}
				
				sep = "\n"+ sep + "\n"+ sep + "\n";
				
				
				
				Sistema s = new Sistema();
				System.out.println(sep);
				System.out.println("Iniciamos Sistema:");
				System.out.println(sep);
				System.out.println("(Cantidad de puntos: -10, se espera ERROR 1): " + 
						s.inicializarSistema(-10).resultado.toString()
						);
				System.out.println("(Cantidad de puntos: 10, se espera OK): " +
						s.inicializarSistema(10).resultado.toString()
						);
				
				System.out.println(sep);
				System.out.println("Destruímos el sistema:");
				System.out.println(sep);
				System.out.println("(Se espera OK): " + 
						s.destruirSistema().resultado.toString()
						);
				
				
				
				System.out.println(sep);
				System.out.println("Registramos Productor:");
				System.out.println(sep);
				System.out.println("Iniciamos Sistema con cant puntos = 9, se espera OK): " +
						s.inicializarSistema(9).resultado.toString()
						);
				System.out.println("");
				System.out.println("1.234.567-1, Productor 1, Dirección Prod 1, prod1@productores.com, 099123456");
				System.out.println("(Datos correctos, se espera OK): " +
						s.registrarProductor("1.234.567-1", "Productor 1", "Dirección Prod 1", "prod1@productores.com", "099123456").resultado.toString()
						);
				System.out.println("");
				System.out.println("2.234.567-1, Productor 2, Dirección Prod 2, prod2@productores.com, 099223456");
				System.out.println("(Datos correctos, se espera OK): " +
						s.registrarProductor("2.234.567-1", "Productor 2", "Dirección Prod 2", "prod2@productores.com", "099223456").resultado.toString()
						);
				System.out.println("");
				System.out.println("3.234.567-1, Productor 3, Dirección Prod 3, prod31@productores.com, 099323456");
				System.out.println("(Datos correctos, se espera OK): " +
						s.registrarProductor("3.234.567-1", "Productor 3", "Dirección Prod 3", "prod3@productores.com", "099323456").resultado.toString()
						);
				System.out.println("");
				System.out.println("0.234.567-1, Productor 0, Dirección Prod 0, prod0@productores.com, 099023456");
				System.out.println("(Datos correctos, se espera OK): " +
						s.registrarProductor("0.234.567-1", "Productor 0", "Dirección Prod 0", "prod0@productores.com", "099023456").resultado.toString()
						);
				
				
				
				System.out.println("");
				System.out.println("1234.567-1, Productor 1, Dirección Prod 1, prod1@productores.com, 099123456");
				System.out.println("(Productor de Cédula inválida, se espera ERROR 1): " +
						s.registrarProductor("1234.567-1", "Productor 1", "Dirección Prod 1", "prod1@productores.com", "099123456").resultado.toString()
						);
				System.out.println("");
				System.out.println("2.234.567-1, Productor 1, Dirección Prod 1, prod1@productores.com, 499123456");
				System.out.println("(Productor de Celular inválido, se espera ERROR 2): " +
						s.registrarProductor("2.234.567-1", "Productor 1", "Dirección Prod 1", "prod1@productores.com", "499123456").resultado.toString()
						);
				System.out.println("");
				System.out.println("2.234.567-1, Productor 1, Dirección Prod 1, prod1productores.com, 099123456");
				System.out.println("(Productor de Email inválido, se espera ERROR 3): " +
						s.registrarProductor("2.234.567-1", "Productor 1", "Dirección Prod 1", "prod1productores.com", "099123456").resultado.toString()
						);
				System.out.println("");
				System.out.println("1.234.567-1, Productor 1, Dirección Prod 1, prod1@productores.com, 099123456");
				System.out.println("(Productor Repetido, se espera ERROR 4): " +
						s.registrarProductor("1.234.567-1", "Productor 1", "Dirección Prod 1", "prod1@productores.com", "099123456").resultado.toString()
						);
				
				System.out.println(sep);
				System.out.println("Registramos Ciudades:");
				System.out.println(sep);
				System.out.println("");
				System.out.println("MONTEVIDEO, -34.901113,-56.164531");
				System.out.println("(Datos correctos, se espera OK): " +
						s.registrarCiudad("MONTEVIDEO", -34.901113,-56.164531).resultado.toString()
						);
				System.out.println("");
				System.out.println("MONTEVIDEO, -34.901113,-56.164531");
				System.out.println("(Ya existe un punto con esas coordenadas, se espera ERROR 2): " +
						s.registrarCiudad("MONTEVIDEO-2", -34.901113,-56.164531).resultado.toString()
						);
				System.out.println("");
				System.out.println("TRINIDAD, -33.520142,-56.904220");
				System.out.println("(Datos correctos, se espera OK): " +
						s.registrarCiudad("TRINIDAD", -33.520142,-56.904220).resultado.toString()
						);
				System.out.println("");
				System.out.println("COLONIA, -34.460719,-57.83391");
				System.out.println("(Datos correctos, se espera OK): " +
						s.registrarCiudad("COLONIA", -34.460719,-57.83391).resultado.toString()
						);
				
			
				
				System.out.println(sep);
				System.out.println("Registramos Plantaciones:");
				System.out.println(sep);
			
				System.out.println("");
				System.out.println("CANELONES, -34.901113,-56.164531,1.234.567-1, -3");
				System.out.println("(capacidad <= 0, se espera ERROR 2): " +
						s.registrarPlantacion("CANELONES", -34.901113,-56.164531,"1.234.567-1", -3).resultado.toString()
						);
				System.out.println("");
				System.out.println("MONTEVIDEO-2, -34.901113,-56.164531,1.234.567-1, 4");
				System.out.println("(Ya existe un punto con esas coordenadas, se espera ERROR 3): " +
						s.registrarPlantacion("MONTEVIDEO-2", -34.901113,-56.164531,"1.234.567-1", 4).resultado.toString()
						);
				System.out.println("");
				System.out.println("MONTEVIDEO-2, -34.901113,-56.164531,1.111.111-1, 4");
				System.out.println("(No existe un productor con esa cédula, se espera ERROR 4): " +
						s.registrarPlantacion("MONTEVIDEO-2", -35.901113,-54.164531,"1.111.111-1", 4).resultado.toString()
						);
				System.out.println("");
				System.out.println("YOUNG, -32.702193,-57.638238,1.234.567-1,150");
				System.out.println("(Datos correctos, se espera OK): " +
						s.registrarPlantacion("YOUNG", -32.702193,-57.638238,"1.234.567-1",150).resultado.toString()
						);
				System.out.println("");
				System.out.println("TOLEDO, -34.7383897,-56.1098602,2.234.567-1,150");
				System.out.println("(Datos correctos, se espera OK): " +
						s.registrarPlantacion("TOLEDO", -34.7383897,-56.1098602,"2.234.567-1",150).resultado.toString()
						);
				System.out.println("");
				System.out.println("VILLA DEL CARMEN, -33.2402962,-56.0255258,3.234.567-1,150");
				System.out.println("(Datos correctos, se espera OK): " +
						s.registrarPlantacion("VILLA DEL CARMEN", -33.2402962,-56.0255258,"3.234.567-1",150).resultado.toString()
						);
				
				System.out.println(sep);
				System.out.println("Registramos Silos:");
				System.out.println(sep);
			
				System.out.println("");
				System.out.println("CANELONES, -33.901113,-54.164531, -3");
				System.out.println("(capacidad < 0, se espera ERROR 2): " +
						s.registrarSilo("CANELONES", -33.901113,-54.164531, -3).resultado.toString()
						);
				System.out.println("");
				System.out.println("MONTEVIDEO-2, -34.901113,-56.164531, 4");
				System.out.println("(Ya existe un punto con esas coordenadas, se espera ERROR 3): " +
						s.registrarSilo("MONTEVIDEO-2", -34.901113,-56.164531, 4).resultado.toString()
						);
				System.out.println("");
				System.out.println("ISMAEL CORTINAS, -33.9616565,-57.0951748,150");
				System.out.println("(Datos correctos, se espera OK): " +
						s.registrarSilo("ISMAEL CORTINAS", -33.9616565,-57.0951748,150).resultado.toString()
						);
				System.out.println("");
				System.out.println("CONCHILLAS, -34.164144,-58.034204,200");
				System.out.println("(Datos correctos, se espera OK): " +
						s.registrarSilo("CONCHILLAS", -34.164144,-58.034204,200).resultado.toString()
						);
				System.out.println("");
				System.out.println("SARANDI GRANDE, -33.725648,-56.329281,250");
				System.out.println("(Datos correctos, se espera OK): " +
						s.registrarSilo("SARANDI GRANDE", -33.725648,-56.329281,250).resultado.toString()
						);
			
				
				
				System.out.println(sep);
				System.out.println("Sobrepasamos cantPuntos en el sistema:");
				System.out.println(sep);
				System.out.println("(CIUDAD: Se sobrepasa cantPuntos en el sistema, se espera ERROR 1): " +
						s.registrarCiudad("SORIANO", -32.460719,-56.83391).resultado.toString()
						);
				System.out.println("(PLANTACION: Se sobrepasa cantPuntos en el sistema, se espera ERROR 1): " +
						s.registrarPlantacion("CANELONES", -34.901113,-56.164531,"1.234.567-1", 3).resultado.toString()
						);
				System.out.println("(SILO: Se sobrepasa cantPuntos en el sistema, se espera ERROR 1): " +
						s.registrarSilo("SARANDI GRANDE", -32.7287648,-52.369281,250).resultado.toString()
						);
				
				System.out.println(sep);
				System.out.println("Registramos Tramos:");
				System.out.println(sep);
				
				System.out.println("");
				System.out.println("MONTEVIDEO -34.901113,-56.164531 / SARANDI GRANDE -33.725648,-56.329281 / Peso 250");
				System.out.println("(Datos correctos, se espera OK): " +
						s.registrarTramo(-34.901113,-56.164531,-33.725648,-56.329281, 250).resultado.toString()
						);
				System.out.println("");
				System.out.println("MONTEVIDEO -34.901113,-56.164531 / ISMAEL CORTINAS -33.9616565,-57.0951748 / Peso 15");
				System.out.println("(Datos correctos, se espera OK): " +
						s.registrarTramo(-34.901113,-56.164531,-33.9616565,-57.0951748, 15).resultado.toString()
						);
				System.out.println("");
				System.out.println("CONCHILLAS -34.164144,-58.034204 / ISMAEL CORTINAS -33.9616565,-57.0951748 / Peso 250");
				System.out.println("(Datos correctos, se espera OK): " +
						s.registrarTramo(-34.164144,-58.034204,-33.9616565,-57.0951748, 250).resultado.toString()
						);
				System.out.println("");
				System.out.println("CONCHILLAS -34.164144,-58.034204 / VILLA DEL CARMEN -33.2402962,-56.0255258 / Peso 350");
				System.out.println("(Datos correctos, se espera OK): " +
						s.registrarTramo(-34.164144,-58.034204,-33.2402962,-56.0255258, 350).resultado.toString()
						);
				System.out.println("");
				System.out.println("MONTEVIDEO -34.901113,-56.164531 / ISMAEL CORTINAS -33.9616565,-57.0951748 / Peso -10");
				System.out.println("(Peso <= 0, se espera ERROR 1): " +
						s.registrarTramo(-34.901113,-56.164531,-33.9616565,-57.0951748, -10).resultado.toString()
						);
				System.out.println("");
				System.out.println("Test1 -10.0,-20.0 / MONTEVIDEO -34.901113,-56.164531 / Peso 120");
				System.out.println("(No existe coordi, se espera ERROR 2): " +
						s.registrarTramo(-10.0,-20.0,-34.901113,-56.164531,120).resultado.toString()
						);
				System.out.println("");
				System.out.println("MONTEVIDEO -34.901113,-56.164531 / Test2 -15.0,-22.0 / Peso 120");
				System.out.println("(No existe coordf, se espera ERROR 2): " +
						s.registrarTramo(-34.901113,-56.164531,-15.0,-22.0,120).resultado.toString()
						);
				System.out.println("");
				System.out.println("MONTEVIDEO -34.901113,-56.164531 / ISMAEL CORTINAS -33.9616565,-57.0951748 / Peso 250");
				System.out.println("(Ya existe tramo, se espera ERROR 3): " +
						s.registrarTramo(-34.901113,-56.164531,-33.9616565,-57.0951748, 250).resultado.toString()
						);
				System.out.println("");
				System.out.println("ISMAEL CORTINAS -33.9616565,-57.0951748 / MONTEVIDEO -34.901113,-56.164531 / Peso 250");
				System.out.println("(Invertimos el sentido, ya existe tramo, se espera ERROR 3): " +
						s.registrarTramo(-33.9616565,-57.0951748,-34.901113,-56.164531, 250).resultado.toString()
						);
				System.out.println("");
				System.out.println("MONTEVIDEO -34.901113,-56.164531 / Test2 -34.901113,-56.164531 / Peso 120");
				System.out.println("(No existe coordf, se espera ERROR 2): " +
						s.registrarTramo(-34.901113,-56.164531,-15.0,-22.0,120).resultado.toString()
						);
				
				System.out.println("");
				System.out.println("ISMAEL CORTINAS -33.9616565,-57.0951748 / YOUNG -32.702193,-57.638238 / Peso 60");
				System.out.println("(Datos correctos, se espera OK): " +
					s.registrarTramo(-33.9616565,-57.0951748,-32.702193,-57.638238,60).resultado.toString()
					);
				System.out.println("");
				System.out.println("VILLA DEL CARMEN, -33.2402962,-56.0255258 / TOLEDO -34.7383897,-56.1098602 / Peso 100");
				System.out.println("(Datos correctos, se espera OK): " +
					s.registrarTramo(-33.2402962,-56.0255258,-34.7383897,-56.1098602,100).resultado.toString()
					);
				System.out.println("");
				System.out.println("YOUNG -32.702193,-57.638238 / VILLA DEL CARMEN, -33.2402962,-56.0255258 / Peso 60");
				System.out.println("(Datos correctos, se espera OK): " +
					s.registrarTramo(-32.702193,-57.638238,-33.2402962,-56.0255258,60).resultado.toString()
					);
				System.out.println("");
				System.out.println("MONTEVIDEO -34.901113,-56.164531 / TOLEDO -34.7383897,-56.1098602 / Peso 100");
				System.out.println("(Datos correctos, se espera OK): " +
					s.registrarTramo(-34.901113,-56.164531,-34.7383897,-56.1098602,100).resultado.toString()
					);
				
				System.out.println("");
				System.out.println("ISMAEL CORTINAS -33.9616565,-57.0951748 / COLONIA, -34.460719,-57.83391 / Peso 60");
				System.out.println("(Datos correctos, se espera OK): " +
					s.registrarTramo(-33.9616565,-57.0951748,-34.460719,-57.83391,60).resultado.toString()
					);
				
				System.out.println("");
				System.out.println("ISMAEL CORTINAS -33.9616565,-57.0951748 / TRINIDAD -33.520142,-56.904220 / Peso 60");
				System.out.println("(Datos correctos, se espera OK): " +
					s.registrarTramo(-33.9616565,-57.0951748,-33.520142,-56.904220,60).resultado.toString()
					);
				System.out.println("");
				System.out.println("VILLA DEL CARMEN, -33.2402962,-56.0255258 / SARANDI GRANDE -33.725648,-56.329281 / Peso 100");
				System.out.println("(Datos correctos, se espera OK): " +
					s.registrarTramo(-33.2402962,-56.0255258,-33.725648,-56.329281,100).resultado.toString()
					);
				System.out.println("");
				System.out.println("SARANDI GRANDE -33.725648,-56.329281 / YOUNG -32.702193,-57.638238 / Peso 60");
				System.out.println("(Datos correctos, se espera OK): " +
					s.registrarTramo(-33.725648,-56.329281,-32.702193,-57.638238,60).resultado.toString()
					);
				System.out.println("");
				System.out.println("SARANDI GRANDE -33.725648,-56.329281 / VILLA DEL CARMEN, -33.2402962,-56.0255258 / Peso 60");
				System.out.println("(Datos correctos, se espera OK): " +
					s.registrarTramo(-33.725648,-56.329281,-33.2402962,-56.0255258,60).resultado.toString()
					);
				System.out.println("");
				System.out.println("SARANDI GRANDE -33.725648,-56.329281 / TRINIDAD -33.520142,-56.904220 / Peso 60");
				System.out.println("(Datos correctos, se espera OK): " +
					s.registrarTramo(-33.725648,-56.329281,-33.520142,-56.904220,60).resultado.toString()
					);
				
				System.out.println(sep);
				System.out.println("Borramos Tramos:");
				System.out.println(sep);
				
				System.out.println("MONTEVIDEO -34.901113,-56.164531 / YOUNG -32.702193,-57.638238");
				System.out.println("(Datos correctos, se espera OK): " +
						s.eliminarTramo(-34.901113,-56.164531,-32.702193,-57.638238).resultado.toString()
						);
				System.out.println("");
				System.out.println("Test1 -10.0,-20.0 / YOUNG -32.702193,-57.638238");
				System.out.println("(Coord i incorrectas, se espera ERROR 1): " +
						s.eliminarTramo(-10.0,-20.0, -32.702193,-57.638238).resultado.toString()
						);
				System.out.println("");
				System.out.println("MONTEVIDEO -34.901113,-56.164531 / Test2 -15.0,-22.0");
				System.out.println("(Coord f incorrectas, se espera ERROR 1): " +
						s.eliminarTramo(-34.901113,-56.164531,-15.0,-22.0).resultado.toString()
						);
				System.out.println("");
				System.out.println("MONTEVIDEO -34.901113,-56.164531 / YOUNG -32.702193,-57.638238");
				System.out.println("(No existe el tramo, se espera ERROR 2): " +
						s.eliminarTramo(-34.901113,-56.164531,-32.702193,-57.638238).resultado.toString()
						);
				
				System.out.println(sep);
				System.out.println("Borramos Puntos:");
				System.out.println(sep);
				System.out.println("CONCHILLAS -34.164144,-58.034204");
				System.out.println("(Datos correctos, se espera OK): " +
						s.eliminarPunto(-34.164144,-58.034204).resultado.toString()
						);
				System.out.println("");
				System.out.println("CONCHILLAS poseía dos tramos registrados");
				System.out.println("-34.164144,-58.034204,-33.9616565,-57.0951748");
				
				System.out.println("(Intentamos borrarlo pero no existe el punto, se espera ERROR 1): " +
						s.eliminarTramo(-34.164144,-58.034204,-33.9616565,-57.0951748).resultado.toString()
						);
				System.out.println("-34.164144,-58.034204,-33.2402962,-56.0255258");
				System.out.println("(Intentamos borrarlo pero no existe el punto, se espera ERROR 1): " +
						s.eliminarTramo(-34.164144,-58.034204,-33.2402962,-56.0255258).resultado.toString()
						);
				System.out.println("");
				System.out.println("MONTEVIDEO -2.0,-56.164531");
				System.out.println("(Error en coordX, se espera ERROR 1): " +
						s.eliminarPunto(-2.0,-56.164531).resultado.toString()
						);
				System.out.println("MONTEVIDEO -34.901113,-2.0");
				System.out.println("(Error en coordY, se espera ERROR 1): " +
						s.eliminarPunto(-34.164144,-2.0).resultado.toString()
						);
				
				System.out.println(sep);
				System.out.println("Mapa de Estado:");
				System.out.println(sep);
				System.out.println("Ventana del navegador");
				s.mapaEstado();
				
				System.out.println(sep);
				System.out.println("Mejor ruta a silo:");
				System.out.println(sep);
				System.out.println("TODO\n");
				
				System.out.println(sep);
				System.out.println("Listado de plantaciones en ciudad:");
				System.out.println(sep);
				System.out.println("MONTEVIDEO -34.901113,-56.164531");
				System.out.println("(Coordenadas de MONTEVIDEO, no hay plantaciones a menos de 20KM, se espera OK): " +
						s.listadoDePlantacionesEnCiudad(-34.901113, -56.164531).resultado.toString()
						);
				System.out.println("");
				System.out.println("");
				System.out.println("Registramos Plantación: JARDIN BOTANICO -34.8589873,-56.217556,550");
				System.out.println("(Datos correctos, se espera OK): " +
						s.registrarPlantacion("JARDIN BOTANICO", -34.8589873,-56.217556,"3.234.567-1",550).resultado.toString()
						);
				System.out.println("Registramos tramo: MONTEVIDEO -34.901113,-56.164531 / JARDIN BOTANICO -34.8589873,-56.217556 / Peso 10");
				System.out.println("(Datos correctos, se espera OK): " +
						s.registrarTramo(-34.901113,-56.164531,-34.8589873,-56.217556, 10).resultado.toString()
						);
				System.out.println("MONTEVIDEO -34.901113,-56.164531");
				System.out.println("(Coordenadas de MONTEVIDEO, una plantación disponible, se espera OK): " +
						s.listadoDePlantacionesEnCiudad(-34.901113, -56.164531).resultado.toString()
						);
				System.out.println("Retorno esperado:");
				System.out.println("-34.8589873;-56.217556");
				 
				System.out.println("Retorno obtenido:");
				System.out.println(s.listadoDePlantacionesEnCiudad(-34.901113, -56.164531).valorString);
				
				
				
				System.out.println(sep);
				System.out.println("Listado de silos:");
				System.out.println(sep);
				System.out.println("(No hay error posible, se espera OK): " +
						s.listadoDeSilos().resultado.toString());
				System.out.println("Retorno esperado:");
				System.out.println("-33.9616565;-57.0951748;150;150|-33.725648;-56.329281;250;250");
				 
				System.out.println("Retorno obtenido:");
				System.out.println(s.listadoDeSilos().valorString);
				
				
				
				
				System.out.println(sep);
				System.out.println("Listamos los productores de manera ascendente:");
				System.out.println(sep);
				System.out.println("(No hay error posible, se espera OK): " +
						s.listadoProductores().resultado.toString());
				System.out.println("Retorno esperado:");
				System.out.println("0.234.567-1;Productor 0;099023456|1.234.567-1;Productor 1;099123456|2.234.567-1;Productor 2;099223456|3.234.567-1;Productor 3;099323456");
				System.out.println("Retorno obtenido:");
				System.out.println(s.listadoProductores().valorString);
				System.out.println(sep);
				
			}

		}
