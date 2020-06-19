package cartas;

import java.io.EOFException;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**@author Proyecto D
*
*	La clase Usuario controla el sistema , dependiendo el tipo de nivel que tiene.
*/

import colecciones.Mazo;

public class Usuario implements Serializable {
	
	String idUsuario;
	String nombreUsuario;
	String contrasenya;
	private Mazo mazo;
	
	public static String nombreArchivo = "usuario.dat";
	
	//private int misMonedas
	//private Coleccion miCcoleccion
	
	public Usuario() {
		idUsuario = "";
		nombreUsuario = "";
		contrasenya = "";
		setMazo(new Mazo());
	
	}
	public Usuario(String idUsuario,String nombreUsuario,String contrasenya) {
		this.idUsuario = idUsuario;
		this.nombreUsuario = nombreUsuario;
		this.contrasenya = contrasenya;
		setMazo(new Mazo());
	}
	
	public String getNombreUsuario()
	{
		return nombreUsuario;
	}
	
	public void setNombreUsuario(String nombreUsuario)
	{
		this.nombreUsuario = nombreUsuario;
	}
	
	public String getContrasenya() 
	{
		return contrasenya;
	}
	
	public void setContrasenya(String contrasenya)
	{
		this.contrasenya = contrasenya;
	}
	
	public Mazo getMazo() {
		return mazo;
	}
	public void setMazo(Mazo mazo) {
		this.mazo = mazo;
	}
	
	@Override
	public String toString() {
		return "| ID del Usuario = " + idUsuario + "| Nombre de Usuario = " + nombreUsuario + " | Contraseña = " + contrasenya + "| Mazo : " + getMazo().toString();
	}
}	