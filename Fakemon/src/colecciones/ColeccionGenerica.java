package colecciones;

/**@author Axel
*
*	Esta clase pretende recibir distintos tipos de objetos, para generarles un hashMap y guardar dentro de el, por ejemplo un arrayList
*/
import java.util.HashMap;

public class ColeccionGenerica <T>{
	
	private HashMap<String, T> hash;
	
	public ColeccionGenerica()
	{
		hash = new HashMap<String, T>();
	}
	
	public void añadir(String key, T elemento)
	{
		hash.put(key, elemento);
	}
	
	public void remove(String key, T elemento)
	{
		hash.remove(key, elemento);
	}
	
	public <Z> void TipoClase(T obj) 
	{
		System.out.println("El tipo de T es: " + obj.getClass().getName());
	}
}
