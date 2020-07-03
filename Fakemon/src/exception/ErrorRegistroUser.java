package exception;

import Usuarios.Usuario;

/**
 * 
 * @author Fariña
 * Excepcion para que el usuario deba tener un nombre minimo de 8 caracteres.
 */

public class ErrorRegistroUser extends Exception{
	
	private Usuario usuario;
	
	public ErrorRegistroUser(Usuario usuario, String msg)
	{
		super(msg);	
		this.usuario = usuario;
	}
	
	public ErrorRegistroUser(String msg)
	{
		super(msg);
	}
	
	@Override
	public String getMessage() {
		
		return super.getMessage() + " ";
	}
	
	public String getMinimoNombre()
	{
		return "El usuario debe ingresar un minimo de nombre de 8 caracteres";
	}
	
}
