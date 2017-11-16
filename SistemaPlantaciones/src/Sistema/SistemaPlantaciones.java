package Sistema;

import Dominio.Productor;

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
				
				
			}

		}
