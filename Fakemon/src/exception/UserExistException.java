package exception;

import Usuarios.Usuario;

public class UserExistException extends Exception {
	
	private Usuario usuario;
	
	public UserExistException(Usuario usuario)
	{
		super();
		this.usuario = usuario;
	}
	
	public UserExistException()
	{
		
	}
	
	@Override
	public String getMessage() {
		
		return super.getMessage() + "El usuario: " + usuario.getNombreUsuario() + "ya existe en nuestro archivo."; 
	}
}
