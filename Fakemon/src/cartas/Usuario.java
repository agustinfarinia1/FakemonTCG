package cartas;

/**@author Proyecto D
*
*	La clase Usuario controla el sistema , dependiendo el tipo de nivel que tiene.
*/

import colecciones.Mazo;

public class Usuario {
	String id_usuario;
	String nombre;
	String contrase�a;
	private Mazo mazo;
	
	public Usuario() {
		id_usuario = "";
		nombre = "";
		contrase�a = "";
		setMazo(new Mazo());
	}
	public Usuario(String _id_usuario,String _nombre,String _contrase�a) {
		id_usuario = _id_usuario;
		nombre = _nombre;
		contrase�a = _contrase�a;
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
		return "| id_usuario = " + id_usuario + "| nombre = " + nombre + " | contrase�a = " + contrase�a + "| Mazo : " + getMazo().toString();
	}
}
