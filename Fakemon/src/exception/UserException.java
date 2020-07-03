package exception;

import Usuarios.Usuario;

/**
 * 
 * @author Fariña
 * Excepcion para que el usuario deba tener un nombre minimo de 8 caracteres.
 */

public class UserException extends Exception{
	
	private String msg;
	
	public UserException(String msg)
	{
		super(msg);	
		this.msg = msg;
	}
	
	
	
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public String getMsg() {
		return msg;
	}
	
	@Override
	public String getMessage() {
		
		return getMsg();
	}
}
