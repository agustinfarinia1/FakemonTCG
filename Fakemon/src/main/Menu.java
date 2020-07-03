package main;

import java.util.Scanner;
import Usuarios.Usuario;
import cartas.Carta;
import colecciones.Coleccion;
import colecciones.ListaMazos;
import colecciones.ListaUsuarios;
import colecciones.Mazo;
import exception.ListaMazosException;
import exception.UserException;
import utils.UserUtils;

public class Menu {

	public static  Scanner scan = new Scanner(System.in);
	private char salir;

	public Menu() {
		salir = 'x';	// por si justo el valor de salir es 's'
	}	
	
	//				METODOS AUXIILIARES				//
	
	public int opcionMenu(int claveTitulo)
	{
		mostrarTitulo(claveTitulo);
		return Character.getNumericValue(scan.nextLine().charAt(0));	// con nextLine porque el buffer se rompe y limitarlo a 1 solo digito
		
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
	
	//				METODOS DE MENUES				//
	
	public void menuPrincipal()
	{
		Usuario user = null;
		try {
			user = new Usuario();
		} catch (ListaMazosException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		ListaUsuarios listaUsuario = new ListaUsuarios();
		listaUsuario.cargarLista();
		UserUtils userUtiles = new UserUtils();
		while(verificarSalir(salir))
		{
			switch(opcionMenu(1))	// devuelve la opcion elegida y muestra el titulo del menu
			{
				case 1:
				try {
					userUtiles.loginUsuario(listaUsuario);
				} catch (UserException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				} // Va al método de logueo
				break;
				
				case 2:	
				try {
					userUtiles.registroUser(user,listaUsuario); // Tendria que Implementar una excepcion en el nombre y contrasenia			
				} catch(UserException e)
				{
					System.out.println(e.getMessage());
				}
				break;
				
				case 3: listaUsuario.leerArchivo(); // "Muestra" los usuarios que están en el archivo
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
	
	public void menuUsuario(Usuario usuario) 
	{
		while (verificarSalir(salir))
		{
			switch (opcionMenu(2))	// devuelve la opcion elegida y muestra el titulo del menu
			{	
				case 1:  	System.out.println("Bienvenido al Modo Campaña");
							System.out.println("PROXIMAMENTE");
							break;
							
				case 2:		System.out.println("Bienvenido al Modo Multijugador Online");
							System.out.println("PROXIMAMENTE");
							break;
							
				case 3:		System.out.println("Menu Editar Mazo");
							Menu editmazo = new Menu();
							editmazo.menuEditarMazo(usuario);
							break;
							
				case 4: 	System.out.println("Menu comprar Cartas");
							Menu comprarcartas = new Menu();
							comprarcartas.menuComprarBooster(usuario);
							break;
							
				case 0:		salir = 's';
							System.out.println("Saliendo Menu Usuario...");
							break;
				default: 	System.out.println("Opcion incorrecta");
							break;
			} 
		}
			
	}
	
	public void menuEditarMazo(Usuario usuario) ///debe recibir tambien el user, y la coleccion
	{
		while (verificarSalir(salir))
		{
			switch (opcionMenu(3)) 
			{	
				
				case 1:  	System.out.println(usuario.getMiListaMazos());
							if(usuario.getMiListaMazos().cantidadMazos() ==  1)
							{
								System.out.println("Usted tiene un mazo solo");
							}
							else
							{
								System.out.println("Ingrese el nombre del mazo que quiera:");
								String nombreMazo = scan.nextLine();
								if(usuario.getMiListaMazos().mazoActivo(nombreMazo, usuario) != null)
								{
									usuario.setMazo(usuario.getMiListaMazos().mazoActivo(nombreMazo, usuario));
									System.out.println(usuario.getMazoActivo());
								}
							}
							break;

				case 2:		System.out.println("Ingrese nombre del mazo a crear:");
							String nombreMazo = scan.nextLine();
							
							Mazo mazoNuevo = new Mazo();
							Coleccion<Carta> coleccion;
							coleccion = ListaMazos.crearMazoNuevo();
							
							mazoNuevo.setMazo(coleccion);
							
							try {
								usuario.getMiListaMazos().agregarMazo(nombreMazo, mazoNuevo);
							} catch (ListaMazosException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							System.out.println(usuario.getMiListaMazos().toString());

							break;
							
				case 3:		System.out.println("Ingrese nombre del mazo a eliminar:");
							nombreMazo = scan.nextLine();
							usuario.getMiListaMazos().eliminarMazo(nombreMazo,usuario.getMiListaMazos().getListaMazos().existenciaHashMap(nombreMazo));
							System.out.println(usuario.getMiListaMazos().toString());
							break;
							
				case 4: 	System.out.println("Edita un mazo agregando o quitando cartas de el");
							break;
				case 0:		salir = 's';
							System.out.println("saliendo Menu Editar Mazo...");
							break;
				default: 	System.out.println("Opcion incorrecta");
							break;
			}  
		}
			
	}
	
	public void menuComprarBooster(Usuario usuario) ///debe recibir tambien el user, y la coleccion de admin
	{
		while (verificarSalir(salir))
		{
			switch (opcionMenu(4)) 
			{	
				
				case 1:  	if(usuario.getMonedas() >= 20)// devuelve un random de cartas que se agregaran a la collecion del usuario
							{
								
								usuario.setMonedas(usuario.getMonedas() - 20);
								System.out.println(usuario.getMonedas());
							}
							else
							{
								System.out.println("no le alcanza para comprar un booster.");
							}
							break;
							
				case 2:		System.out.println("Vende las cartas eliminandolas de la coleccion pero guardando el atributo valorCarta en un aux y a su vez en el usuario");
							break;
							
				case 3:		System.out.println("El saldo es de "+ usuario.getMonedas() + "monedas.");
							break;
				
				case 0:		salir = 's';
							System.out.println("Saliendo Menu Booster...");
							break;
							
				default: 	System.out.println("Opcion incorrecta");
							break;
			}  
		}
			
	}
	
	//				ADMINISTRADOR DE MENUES				//
	
	public void mostrarTitulo(int claveTitulo)	// se recibe una clave y se muestra el titulo
	{
		switch(claveTitulo)	// devuelve la opcion elegida
		{
			case 1:
					tituloMenuPrincipal();
			break;
			
			case 2:	
					tituloMenuUsuario();
			break;
			
			case 3:
					tituloMenuEditarMazo();
			break;
			
			case 4:	
					tituloMenuComprarBooster();
			break;
		}
	}
	
	//				TITULOS DE MENUES				//
	
	public void tituloMenuPrincipal()
	{
		System.out.println("\n1. CONECTARSE");
		System.out.println("2. REGISTRARSE");
		System.out.println("3. TEMP. MOSTRAR USUARIOS REGISTRADOS");
		System.out.println("4. SALIR");
	}
	
	public void tituloMenuUsuario()
	{
		System.out.println("\nBienvenido a Fakemon TCG");
		System.out.println("1.- Jugar modo Campaña (offline)");
		System.out.println("2.- Jugar Online");
		System.out.println("3.- Editar mi Mazo");
		System.out.println("4.- Comprar Cartas");
		System.out.println("0.- Salir");
	}
	
	public void tituloMenuEditarMazo()
	{
		System.out.println("\nEditor de Mazos");
		System.out.println("1.- Elegir Mazo Activo");
		System.out.println("2.- Crear Mazo");
		System.out.println("3.- Eliminar Mazo");
		System.out.println("4.- Editar Mazo");
		System.out.println("0.- Salir");
	}
	
	public void tituloMenuComprarBooster()
	{
		System.out.println("\nVendedor Misterioso");
		System.out.println("1.- Comprar Booster");
		System.out.println("2.- Vender Cartas");
		System.out.println("3.- Ver Saldo actual");
		System.out.println("0.- Salir");
	}
}
	
