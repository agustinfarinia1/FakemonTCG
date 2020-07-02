package exception;

import Usuarios.Usuario;

/**
 * 
 * @author Fariña
 * Excepcion para que el usuario deba tener un nombre minimo de 8 caracteres.
 */

public class ErrorRegistroUser extends Exception{
	
	private Usuario usuario;
	
	public ErrorRegistroUser(String msg, Usuario usuario)
	{
		super(msg);	// SU usuario no cumple las normas del juego
		this.usuario = usuario;
	}
	// minimo de nombre 8 caracteres
	// minimo de 8 caracteres
	
	@Override
	public String getMessage() {
		
		return super.getMessage() + " " + usuario;
	}
}
