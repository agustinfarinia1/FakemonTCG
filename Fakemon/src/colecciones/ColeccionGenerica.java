package colecciones;

/**@author Axel
*
*	Esta clase pretende recibir distintos tipos de objetos, para generarles un hashMap y guardar dentro de el, por ejemplo un arrayList
*/
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

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
	
	public StringBuilder listarHashMap(HashMap<String, T> hashMap)
	{
		StringBuilder builder = new StringBuilder();
		
		Set<Entry<String, T>> entry = hashMap.entrySet();
		Iterator<Entry<String, T>> itHash = entry.iterator();
		
		while(itHash.hasNext())
		{
			Entry<String, T> aux = itHash.next();
			
			builder.append(aux.getKey());
			builder.append("\n");
			builder.append(aux.getValue().toString());
			builder.append("\n");
		}
		return builder;
	}

	public HashMap<String, T> getHash() {
		return hash;
	}

	public void setHash(HashMap<String, T> hash) {
		this.hash = hash;
	}
}
