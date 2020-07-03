package exception;

import Usuarios.Usuario;

/**
 * 
 * @author Fariña
 * Excepcion para que el usuario deba tener un nombre minimo de 8 caracteres.
 */

public class ErrorRegistroUser extends Exception{
	
	private String msg;
	
	public ErrorRegistroUser(String msg)
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
