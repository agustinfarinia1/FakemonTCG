package cartas;

/**@author Proyecto D
*
*	La clase Usuario controla el sistema , dependiendo el tipo de nivel que tiene.
*/

import colecciones.Mazo;

public class Usuario {
	String id_usuario;
	String nombre;
	String contraseņa;
	private Mazo mazo;
	//private int misMonedas
	//private Coleccion miCcoleccion
	
	public Usuario() {
		id_usuario = "";
		nombre = "";
		contraseņa = "";
		setMazo(new Mazo());
	}
	public Usuario(String id_usuario,String nombre,String contraseņa) {
		this.id_usuario = id_usuario;
		this.nombre = nombre;
		this.contraseņa = contraseņa;
		setMazo(new Mazo());
	}
	public Mazo getMazo() {
		return mazo;
	}
	public void setMazo(Mazo mazo) {
		this.mazo = mazo;
	}
	
	@Override
	public String toString() {
		return "| id_usuario = " + id_usuario + "| nombre = " + nombre + " | contraseņa = " + contraseņa + "| Mazo : " + getMazo().toString();
	}
}
