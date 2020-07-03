package utils;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import cartas.Carta;
import cartas.Carta_basica;
import cartas.Carta_epica;
import cartas.Carta_legendaria;


/**
 * 
 * @author Axel
 * En estas utils, tenemos las herramientas que nos dio el profesor para leer y grabar 
 * y ademas algunos metodos para transformar una carta a JSONObject, y meterlas en un JSONArray
 * Y a su vez, traer un JSONArray y desencriptarlo para generar un ArrayList de Cartas
 */



public class JsonUtiles 
{
	/**
	 * Algunas constantes de ayuda para decodificar
	 */
	public static final String NOMBRECARTA = "Nombre de Carta";
	public static final String IDCARTA = "ID Carta";
	public static final String RAREZA = "Rareza ";
	public static final String VIDA = "Vida";
	public static final String ATAQUEESPECIAL1 = "1er Ataque Especial";
	public static final String ATAQUEESPECIAL2 = "2do Ataque Especial";
	public static final String ATAQUEESPECIAL3 = "3er Ataque Especial";
	public static final String ATAQUEBASE = "Ataque Base";
	
	
	/**
	 * Funcion del profe que nos sirve para escribir un jsonArray a archivo
	 * @param JSONArray array
	 */
	public static void grabar(JSONArray array) {
		try {
			FileWriter file = new FileWriter("test.json");
			file.write(array.toString());
			file.flush();
			file.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Funcion del profe que nos ayuda a leer un archivo de json guardado
	 * @return String 
	 */
	public static String leer() 
	{
		String contenido = "";
		try 
		{
			contenido = new String(Files.readAllBytes(Paths.get("test.json")));
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		return contenido;
	}
	
	/**
	 * Esta funcion nos sirve para decodificar un JSONArray y transformarlo en una coleccion de cartas 
	 * El codigo recorre todo el json, y por cada indice del array, que contiene un jsonObject, lo decodifica
	 * Y lo transforma en una carta; Dicha carta se guarda en una coleccion de cartas.
	 * @param JSONArray jarray
	 * @return ArrayList<Carta> 
	 * @throws JSONException
	 */
	public static ArrayList<Carta> fromJSONObject(JSONArray jarray) throws JSONException
	{
		ArrayList<Carta> aux = new ArrayList<Carta>();
		Carta c;
		JSONObject jobj = new JSONObject();
		
		for(int i=0; i < jarray.length(); i++)
		{
			jobj = jarray.getJSONObject(i);
			c = decodeCartaFromJSONObject(jobj);
			
			aux.add(c);
		}
		
		return aux;
	}
	
	/**
	 * Esta carta trabaja con un jsonObject, lo decodifica y le asigna sus valores a una carta, preguntandose si 
	 * los datos que contiene pertenecen a una carta basica, epica o legandaria.
	 * @param JSONObject jobj
	 * @return Carta carta
	 * @throws JSONException
	 */
	public static Carta decodeCartaFromJSONObject(JSONObject jobj) throws JSONException
	{
		Carta c = new Carta();
		
		if(jobj.getString(RAREZA).equalsIgnoreCase("basico"))
		{
			Carta_basica b = new Carta_basica();
			System.out.println("Sera que entro aca2?");
			
			b.setVida(jobj.getInt(VIDA));
			b.setAtaqueBase(jobj.getInt(ATAQUEBASE));
			b.setId_Carta(jobj.getInt(IDCARTA));
			b.setNombre_Carta(jobj.getString(NOMBRECARTA));
			b.setRareza(jobj.getString(RAREZA));
			
			b.setAtaqueEspecial1(jobj.getInt(ATAQUEESPECIAL1));
			
			return b;
		}
		
		if(jobj.getString(RAREZA).equalsIgnoreCase("epico"))
		{
			Carta_epica e = new Carta_epica();
			System.out.println("Sera que entro aca3?");
			
			
			e.setVida(jobj.getInt(VIDA));
			e.setAtaqueBase(jobj.getInt(ATAQUEBASE));
			e.setId_Carta(jobj.getInt(IDCARTA));
			e.setNombre_Carta(jobj.getString(NOMBRECARTA));
			e.setRareza(jobj.getString(RAREZA));
			
			e.setAtaqueEspecial1(jobj.getInt(ATAQUEESPECIAL1));
			e.setAtaqueEspecial2(jobj.getInt(ATAQUEESPECIAL2));
			
			return e;
		}
		
		if(jobj.getString(RAREZA).equalsIgnoreCase("legendario"))
		{
			Carta_legendaria l = new Carta_legendaria();
			
			l.setVida(jobj.getInt(VIDA));
			l.setAtaqueBase(jobj.getInt(ATAQUEBASE));
			l.setId_Carta(jobj.getInt(IDCARTA));
			l.setNombre_Carta(jobj.getString(NOMBRECARTA));
			l.setRareza(jobj.getString(RAREZA));
			
			l.setAtaqueEspecial1(jobj.getInt(ATAQUEESPECIAL1));
			l.setAtaqueEspecial2(jobj.getInt(ATAQUEESPECIAL2));
			l.setAtaqueEspecial3(jobj.getInt(ATAQUEESPECIAL3));
			
			return l;
		}

		return c;
	}
	
	/**
	 * Este metodo, recibe una coleccion de cartas y la recorre para almacenar cada una de las cartas en un JSONObject 
	 * y cada uno de estos en un JSONArray que vamos a devolver despues.
	 * @param cartasParaPersistencia
	 * @return JSONArray 
	 * @throws JSONException
	 */
	public static JSONArray decodeJsonObject(ArrayList<Carta> cartasParaPersistencia) throws JSONException
	{
		Carta c;
		
		JSONArray jarray = new JSONArray();
		
		for(int i=0; i < cartasParaPersistencia.size(); i++)
		{
			c = (Carta)cartasParaPersistencia.get(i);
			JSONObject jsonObject = new JSONObject(getJsonObjectCarta(c));
			jarray.put(jsonObject);
		}
		
		return jarray;
	}
	
	/**
	 * Este metodo, devuelve un JSONObject por cada carta que le mandemos
	 * @param Carta carta
	 * @return String
	 * @throws JSONException
	 */
	public static String getJsonObjectCarta(Carta c) throws JSONException
	{
		JSONObject jObj = new JSONObject();
		
		jObj = persistirCartaEnJSONObject(c);
		
		return jObj.toString();
	}
	
	/**
	 * Este metodo, recibe una carta y por cada uno de sus campos, agrega una key de una constante y el valor que le corresponde a un JSONObject
	 * @param Carta Carta
	 * @return JSONObject
	 * @throws JSONException
	 */
	public static JSONObject persistirCartaEnJSONObject(Carta c) throws JSONException
	{
		JSONObject jObj = new JSONObject();
		
		jObj.put(IDCARTA, c.getId_Carta());
		jObj.put(NOMBRECARTA, c.getNombre_Carta());
		jObj.put(RAREZA, c.getRareza());
		jObj.put(VIDA, c.getVida());
		jObj.put(ATAQUEBASE, c.getAtaqueBase());
		
		if(c instanceof Carta_basica)
		{
			Carta_basica b = new Carta_basica();
			b = (Carta_basica)c;
			jObj.put(ATAQUEESPECIAL1, b.getAtaqueEspecial1());
		}
		if(c instanceof Carta_epica)
		{
			Carta_epica e = new Carta_epica();
			e = (Carta_epica)c;
			jObj.put(ATAQUEESPECIAL1, e.getAtaqueEspecial1());
			jObj.put(ATAQUEESPECIAL2, e.getAtaqueEspecial2());
		}
		if(c instanceof Carta_legendaria)
		{
			Carta_legendaria l = new Carta_legendaria();
			
			l = (Carta_legendaria)c;
			jObj.put(ATAQUEESPECIAL1, l.getAtaqueEspecial1());
			jObj.put(ATAQUEESPECIAL2, l.getAtaqueEspecial2());
			jObj.put(ATAQUEESPECIAL3, l.getAtaqueEspecial3());
			
		}
		
		return jObj;
	}
	
}
