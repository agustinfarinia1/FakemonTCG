package main;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

import cartas.Carta;
import cartas.Usuario;


public class Menu {

	static Scanner scan;
	private char salir = 's';
	private int opcion;
	
	
	public void loginUser (Usuario user)
	{
		
		
	}
	
	public void menuUsuario(Scanner scan) 
	{
		while ((salir == 's') || (salir == 'S'))
		{
			System.out.println("Bienvenido a Fakemin TCG");
			System.out.println("1.- Jugar modo Campaña (offline)");
			System.out.println("2.- Jugar Online");
			System.out.println("3.- Editar mi Mazo");
			System.out.println("4.- Comprar Cartas");
			System.out.println("0.- Salir");
			opcion = scan.nextInt();
			
			switch (opcion) 
			{	
				
				case 1:  	System.out.println("Bienvenido al Modo Campaña");
							break;
							
				case 2:		System.out.println("Bienvenido al Modo Multijugador Online");
							break;
							
				case 3:		System.out.println("Menu Editar Mazo");
							Menu editmazo = new Menu();
							editmazo.menuEditarMazo(scan);
							break;
							
				case 4: 	System.out.println("Menu comprar Cartas");
							Menu comprarcartas = new Menu();
							comprarcartas.menuComprarBooster(scan);
							break;
							
				default: 	System.out.println("Opcion incorrecta");
			}  
			
			System.out.println("Presione 's' si desea continuar\t");
			scan.nextLine();
			salir = scan.nextLine().charAt(0); 
			
		}
			
	}
	
	public void menuEditarMazo(Scanner scan) ///debe recibir tambien el user, y la coleccion
	{
		while ((salir == 's') || (salir == 'S'))
		{
			System.out.println("Editor de Mazos");
			System.out.println("1.- Elegir Mazo Activo");
			System.out.println("2.- Crear Mazo");
			System.out.println("3.- Eliminar Mazo");
			System.out.println("4.- Editar Mazo");
			System.out.println("0.- Salir");
			opcion = scan.nextInt();
			
			switch (opcion) 
			{	
				
				case 1:  	System.out.println("Modifica el Valor del atributo activo a (true)");
							break;
							
				case 2:		System.out.println("Crear un mazo a partir de la coleccion de cartas propias");
							break;
							
				case 3:		System.out.println("Elimina el mazo Modificando el atributo eliminado a (true)");
							break;
							
				case 4: 	System.out.println("Edita un mazo agregando o quitando cartas de el");
							break;
							
				default: 	System.out.println("Opcion incorrecta");
			}  
			
			System.out.println("Presione 's' si desea continuar\t");
			scan.nextLine();
			salir = scan.nextLine().charAt(0); 
			
		}
			
	}
	
	public void menuComprarBooster(Scanner scan) ///debe recibir tambien el user, y la coleccion de admin
	{
		while ((salir == 's') || (salir == 'S'))
		{
			System.out.println("Vendedor Misterioso");
			System.out.println("1.- Comprar Booster");
			System.out.println("2.- Vender Cartas");
			System.out.println("3.- Ver Saldo actual");
			System.out.println("0.- Salir");
			opcion = scan.nextInt();
			
			switch (opcion) 
			{	
				
				case 1:  	System.out.println("Trae de collection admin un metodo que se llama generar booster"); // devuelve un random de cartas que se agregaran a la collecion del usuario
							break;
							
				case 2:		System.out.println("Vende las cartas eliminandolas de la coleccion pero guardando el atributo valorCarta en un aux y a su vez en el usuario");
							break;
							
				case 3:		System.out.println("Ver el saldo que le va quedando al usuario");
							break;
							
				default: 	System.out.println("Opcion incorrecta");
			}  
			
			System.out.println("Presione 's' si desea continuar\t");
			scan.nextLine();
			salir = scan.nextLine().charAt(0); 
			
		}
			
	}
	
}
	
