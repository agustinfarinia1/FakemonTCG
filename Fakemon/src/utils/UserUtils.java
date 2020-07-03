package utils;

import java.util.Scanner;

import Usuarios.Usuario;
import colecciones.ListaUsuarios;
import exception.UserExistException;
import main.Menu;
import exception.UserException;

public class UserUtils {
	
	public static  Scanner scan = new Scanner(System.in);
	

	
	public void loginUsuario(ListaUsuarios listaUsuario) throws UserException
	{
		String nombre;
		String contrasenia;
		
		System.out.println("Ingrese el nombre de usuario: \n");
		nombre = scan.nextLine();
		
		if(nombre.equalsIgnoreCase(""))
		{
			throw new UserException("El nombre de usuario está vacio ");
		}
		else if (nombre.length() <= 8)
		{
			throw new UserException("El nombre de usuario debe superar como minimo ocho caracteres");
		}
		
		System.out.println("Ingrese una contraseña: \n");
		contrasenia = scan.nextLine();
		
		if(contrasenia.equalsIgnoreCase(""))
		{
			throw new UserException("La contraseña está vacia");
		} 
		else if (contrasenia.length() <= 8)
		{
			throw new UserException("La contraseña debe superar como minimo ocho caracteres");
		}
		
		if((listaUsuario.obtenerUsuarioPorNombreYContrasenia(nombre,contrasenia)) != null)
		{
			Menu menu = new Menu();
			menu.menuUsuario(listaUsuario.obtenerUsuarioPorNombreYContrasenia(nombre,contrasenia));
		}
		else
		{
			throw new UserException("Este usuario no esta registrado.");
		}
		
	}
	
	/**
	 * Metodo que registra un usuario.
	 * @param user
	 * @throws ExceptionUsuario
	 */
	public void registroUser(Usuario user,ListaUsuarios listaUsuario) throws UserException
	{
		System.out.println("Ingrese el nombre de usuario: \n");
		user.setNombreUsuario(scan.nextLine());
		
		if(user.getNombreUsuario().equalsIgnoreCase(""))
		{
			throw new UserException("El nombre de usuario está vacio ");
		}
		else if (user.getNombreUsuario().length() <= 8)
		{
			throw new UserException("El nombre de usuario debe superar como minimo ocho caracteres");
		}
		
		System.out.println("Ingrese una contraseña: \n");
		user.setContrasenya(scan.nextLine());
		
		if(user.getContrasenya().equalsIgnoreCase(""))
		{
			throw new UserException("La contraseña está vacia");
		} 
		else if (user.getContrasenya().length() <= 8)
		{
			throw new UserException("La contraseña debe superar como minimo ocho caracteres");
		}
		
		if(listaUsuario.obtenerUsuarioPorNombre(user.getNombreUsuario()) == null)	// Si no existe un usuario con ese nombre
		{
			listaUsuario.agregarUsuario(user);
			listaUsuario.guardarArchivo();
		}
		else
		{
			throw new UserException("Ya existe un usuario con ese nombre.");
		}
	}
	
	/**
	 * Usamos este metodo, para comparar los campos de nombre y contraseña con el del archivo de usuarios.
	 * @return Usuario
	 * @throws ExceptionUsuario
	 */
	
	
}
