package main;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

import Usuarios.Usuario;
import cartas.Carta;

public class Menu {

	public static  Scanner scan = new Scanner(System.in);
	private char salir;
	private int opcion;

	
	public Menu() {
		salir = 'x';	// por si justo el valor de salir es 's'
	}
	
	public boolean verificarSalir(char salir)	// Verifica si el salir es correcto , no importa si es mayuscula
	{
		boolean verificacion = true;
		if((String.valueOf(salir)).equalsIgnoreCase("s"))
		{
			verificacion = false;
		}
		return verificacion;
	}
	
	
	
	public int tituloPrincipal()
	{
		System.out.println("\n1. CONECTARSE");
		System.out.println("2. REGISTRARSE");
		System.out.println("3. TEMP. MOSTRAR USUARIOS REGISTRADOS");
		System.out.println("4. SALIR");
		return Integer.parseInt(scan.nextLine());
		
	}
	
	public void menuPrincipal()
	{
		Usuario user = new Usuario();
		while(verificarSalir(salir))
		{
			switch(tituloPrincipal())	// devuelve la opcion elegida
			{
				case 1:
				loginUser(user); // Va al método de logueo
				break;
				
				case 2:	
				registroUser(user); // Va al método de registro
				break;
				
				case 3:
				//lista.leerArchivoUsuario(); // "Muestra" los usuarios que están en el archivo
				break;
				
				case 4:	
					salir = 's';
					System.out.println("Saliendo...");
				break;
				
				default:
				System.out.println("Opcion incorrecta.");
                break;
			}
		}
	}
	
	public void loginUser (Usuario user)
	{
		
		System.out.println("TODO"); // Hacer logueo de usuario
	}
	
	public void registroUser(Usuario user)
	{
		
		System.out.println("Ingrese el nombre de usuario: \n");

		user.setNombreUsuario(scan.nextLine());
		
		System.out.println("Ingrese una contraseña: \n");
		user.setContrasenya(scan.nextLine());
		
		System.out.println(user.toString());
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
	
