package colecciones;

import java.util.ArrayList;

import cartas.Carta;

/**@author Axel
*
*	Esta Clase tiene la intencion de trabajar todos los metodos que anteriormente estaban en mazo y mano, para que estos ultimos queden mas limpios
*	Mano y Mazo van a extender de esta, y a su vez van a trabajar con el atributo coleccion, ya que ambas usan arrayList.
*/

public class Coleccion {
	
	private ArrayList<Carta> coleccion;
	
	public Coleccion()
	{
		setColeccion(new ArrayList <Carta>());
	}

	
	public String listarColeccion() {
		StringBuilder builder = new StringBuilder();
		builder.append("Lista de Cartas:\n");
		for(Carta c : getColeccion())
		{
			builder.append(c.toString()+"\n");
			
		}
		return builder.toString();
	}
	//TODO antes de agregar las cartas, tendria que verificar en la lista si esta existe . ya hay un metodo de comprobacion, faltaria implementarlo
	public void agregarCartaColeccion(Carta e) {
		getColeccion().add(e);
	}

	public void eliminarCartaColeccion(Carta c) {
		getColeccion().remove(c);
	}
	
	public int ObtenerCantidadColeccion() {
		return getColeccion().size();
	}
	
	/// lista cartas mejora esto
	public boolean existenciaColeccion(Object obj) {
		Carta c = (Carta) obj;
		return getColeccion().contains(c);
	}

	@Override
	public String toString() {
		return listarColeccion();
	}

	public ArrayList<Carta> getColeccion() {
		return coleccion;
	}

	public void setColeccion(ArrayList<Carta> coleccion) {
		this.coleccion = coleccion;
	}
	
	
}
