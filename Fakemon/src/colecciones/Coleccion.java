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

public abstract class Coleccion {
	
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
	
	/// INTENTAMOS HACER PERSISTENCIA DE COLLECION, PARA QUE PUEDAN EXPORTARSE
	
	/// NOTA: Si tuvieramos un array de arrays de coleccion, preguntamos
	/// preguntamos si nos puede devovler el JSONObject y eso lo podriamos meter en un JSONArray, para luego exportarlo o guardarlo en un archivo.
	public JSONObject persistirColeccionEnJSONObject() throws JSONException
	{
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("Coleccion", getColeccion()); /// Esta key se me hace rara, porque si le ponemos un mazo va a tirar "coleccion", evaluar luego si conviene poner un atributo de nombre o algo así!
		return jsonObject;
	}
	
	public JSONArray persistirColeccionEnJSONArray(JSONArray jsonArray, JSONObject jsonObject) throws JSONException
		{
			jsonArray.put(jsonObject);
			return jsonArray;
		}
	public void fromJSONObject(JSONObject jsonObject) throws JSONException
	{
		try {
			
		ArrayList <Carta> array;
		setColeccion(array = (ArrayList<Carta>) jsonObject.get("Coleccion"));
		}
		catch(ClassCastException e) { /// le mandamos error de casteo, porque es lo que probablemente pueda suceder.
			
			System.out.println("Intente traer un JSONObject, y convertirlo a un ArrayList del tipo carta (Aunque deberia funcionar, puesto que las demas colecciones que heredan de ella poseen arrayList de Carta, aunque nunca se sabe... Si esto acaba de pasar ERROR 404 ! Enterra tu oro capooo !");
		}
	}
	
}
