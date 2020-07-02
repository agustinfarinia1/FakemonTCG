package exception;

/**
 * 
 * @author Fariña
 * Excepcion para que el usuario deba tener un nombre minimo de 8 caracteres.
 */
public class ErrorRegistroUser extends Exception{
	

	public ErrorRegistroUser(String msg)
	{
		super(msg);	// SU usuario no cumple las normas del juego
	}
	// minimo de nombre 8 caracteres
	// minimo de 8 caracteres
}
