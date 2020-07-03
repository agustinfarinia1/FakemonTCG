package utils;

import java.util.Scanner;

import Usuarios.Usuario;
import exception.ErrorRegistroUser;
import exception.UserExistException;

public class UserUtils {
	
	public static  Scanner scan = new Scanner(System.in);
	

	
	/**
	 * Este metodo se encarga de comprobar que el usuario que se acaba de crear no este en el archivo de usuarios
	 * @return
	 */
	public Usuario ComprobarLogin() throws UserExistException
	{
		Usuario usuario = new Usuario();
		
		try {
	
			usuario = loginUsuario();
			
			if(comprobarExistencia())
			{
				guardarUnUsuarioEnArchivo
			}
			else
			{
				throw new UserExistException(usuario);
			}
			
			
		} catch (ErrorRegistroUser e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return usuario;
	}
	
	
	/**
	 * Metodo que registra un usuario.
	 * @param user
	 * @throws ErrorRegistroUser
	 */
	public void registroUser(Usuario user) throws ErrorRegistroUser
	{
		System.out.println("Ingrese el nombre de usuario: \n");
		user.setNombreUsuario(scan.nextLine());
		
		if(user.getNombreUsuario().equalsIgnoreCase(""))
		{
			throw new ErrorRegistroUser("El nombre de usuario está vacio ");
		}
		else if (user.getNombreUsuario().length() <= 8)
		{
			throw new ErrorRegistroUser("El nombre de usuario debe superar como minimo ocho caracteres");
		}
		
		System.out.println("Ingrese una contraseña: \n");
		user.setContrasenya(scan.nextLine());
		
		if(user.getContrasenya().equalsIgnoreCase(""))
		{
			throw new ErrorRegistroUser("La contraseña está vacia");
		} 
		else if (user.getContrasenya().length() <= 8)
		{
			throw new ErrorRegistroUser("La contraseña debe superar como minimo ocho caracteres");
		}
		
	}
	
	/**
	 * Login de usuario que usamos para subir un usuario al archivo, y tambien para comprobar mas adelante si no existe el usuario que queremos crear
	 * @return Usuario
	 * @throws ErrorRegistroUser
	 */
	
	public Usuario loginUsuario() throws ErrorRegistroUser
	{
		Usuario user = new Usuario();
		
		System.out.println("Ingrese el nombre de usuario: \n");
		user.setNombreUsuario(scan.nextLine());
		
		if(user.getNombreUsuario().equalsIgnoreCase(""))
		{
			throw new ErrorRegistroUser("El nombre de usuario está vacio ");
		}
		else if (user.getNombreUsuario().length() <= 8)
		{
			throw new ErrorRegistroUser("El nombre de usuario debe superar como minimo ocho caracteres");
		}
		
		System.out.println("Ingrese una contraseña: \n");
		user.setContrasenya(scan.nextLine());
		
		if(user.getContrasenya().equalsIgnoreCase(""))
		{
			throw new ErrorRegistroUser("La contraseña está vacia");
		} 
		else if (user.getContrasenya().length() <= 8)
		{
			throw new ErrorRegistroUser("La contraseña debe superar como minimo ocho caracteres");
		}
		
		return user;
		
	}
	
}
