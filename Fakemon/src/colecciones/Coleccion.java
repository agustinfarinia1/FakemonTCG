package colecciones;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import cartas.Carta;

/**@author Axel
*
*	Esta Clase tiene la intencion de trabajar todos los metodos que anteriormente estaban en mazo y mano, para que estos ultimos queden mas limpios
*	Mano y Mazo van a extender de esta, y a su vez van a trabajar con el atributo coleccion, ya que ambas usan arrayList.
*	Le añadi el abstract, para que no se pueda instanciar una coleccion, sino mazo, mano, booster, etc.
*/

public class Coleccion <T>{
	
	private ArrayList<T> coleccion;
	
	public Coleccion()
	{
		setColeccion(new ArrayList <T>());
	}

	public ArrayList<T> getColeccion() {
		return coleccion;
	}

	public void setColeccion() {
		this.coleccion = new ArrayList<T>();
	}
	
	public void setColeccion(ArrayList<T> coleccion) {
		this.coleccion = coleccion;
	}
	
	public String listar() {
		StringBuilder builder = new StringBuilder();
		builder.append("\nLista de Cartas:\n");
		for(T obj : getColeccion())
		{
			
			builder.append(obj.toString()+"\n");
			
		}
		return builder.toString();
	}
	//TODO antes de agregar las cartas, tendria que verificar en la lista si esta existe . ya hay un metodo de comprobacion, faltaria implementarlo
	public void agregar(T e) {
		getColeccion().add(e);
	}

	public void eliminar(Carta c) {
		getColeccion().remove(c);
	}
	
	public int cantidadColeccion() {
		return getColeccion().size();
	}
	
	/// lista cartas mejora esto
	public boolean existencia(Object obj) {
		Carta c = (Carta) obj;
		return getColeccion().contains(c);
	}
	
	@Override
	public String toString() {
		return listar();
	}
}
