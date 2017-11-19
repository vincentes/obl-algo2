package Sistema;

import dominio.Productor;

public class SistemaPlantaciones {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Pruebas:
				Sistema s = new Sistema();
				
				System.out.println("Iniciamos Sistema:");
				System.out.println(
						s.inicializarSistema(10).resultado.toString()
						);
				
				System.out.println("Registramos Productor:");
				System.out.println(
						s.registrarProductor("1.234.567-1", "Productor 1", "Dirección Prod 1", "prod1@productores.com", "099123456").resultado.toString()
						);
				System.out.println(
						s.registrarProductor("2.234.567-1", "Productor 2", "Dirección Prod 2", "prod2@productores.com", "099223456").resultado.toString()
						);
				System.out.println(
						s.registrarProductor("3.234.567-1", "Productor 3", "Dirección Prod 3", "prod3@productores.com", "099323456").resultado.toString()
						);
				System.out.println(
						s.registrarProductor("0.234.567-1", "Productor 0", "Dirección Prod 0", "prod0@productores.com", "099023456").resultado.toString()
						);
				
				
				System.out.println("Registramos Productor Repetido:");
				System.out.println(
						s.registrarProductor("1.234.567-1", "Productor 1", "Dirección Prod 1", "prod1@productores.com", "099123456").resultado.toString()
						);
				
				System.out.println("Registramos Productor Cédula inválida:");
				System.out.println(
						s.registrarProductor("1234.567-1", "Productor 1", "Dirección Prod 1", "prod1@productores.com", "099123456").resultado.toString()
						);
				System.out.println("Registramos Productor Celular inválido:");
				System.out.println(
						s.registrarProductor("2.234.567-1", "Productor 1", "Dirección Prod 1", "prod1@productores.com", "499123456").resultado.toString()
						);
				System.out.println("Registramos Productor Email inválido:");
				System.out.println(
						s.registrarProductor("2.234.567-1", "Productor 1", "Dirección Prod 1", "prod1productores.com", "099123456").resultado.toString()
						);
				
				System.out.println("Listamos los productores de manera ascendente:");
				s.listadoProductores();
				
			}

		}
