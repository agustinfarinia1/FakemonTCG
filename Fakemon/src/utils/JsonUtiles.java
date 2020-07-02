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
	 * Algunas constantes de ayuda
	 */
	public static final String NOMBRECARTA = "Nombre de Carta";
	public static final String IDCARTA = "ID Carta";
	public static final String RAREZA = "Rareza ";
	public static final String VIDA = "Vida";
	public static final String ATAQUEESPECIAL1 = "1er Ataque Especial";
	public static final String ATAQUEESPECIAL2 = "2do Ataque Especial";
	public static final String ATAQUEESPECIAL3 = "3er Ataque Especial";
	public static final String ATAQUEBASE = "Ataque Base";
	
	
	
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
	
	/// esta funcion tiene un bug, mañana la miro.
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
	public static Carta decodeCartaFromJSONObject(JSONObject jobj) throws JSONException
	{
		Carta c = new Carta();
		
		c.setVida(jobj.getInt(VIDA));
		c.setAtaqueBase(jobj.getInt(ATAQUEBASE));
		c.setId_Carta(jobj.getInt(IDCARTA));
		c.setNombre_Carta(jobj.getString(NOMBRECARTA));
		c.setRareza(jobj.getString(RAREZA));
		
		if(c.getRareza().equalsIgnoreCase("basico"))
		{
			Carta_basica b = new Carta_basica();
			b = (Carta_basica)c;
			
			b.setAtaqueEspecial1(jobj.getInt(ATAQUEESPECIAL1));
			
			return b;
		}
		
		if(c.getRareza().equalsIgnoreCase("epico"))
		{
			Carta_epica e = new Carta_epica();
			e = (Carta_epica)c;
			
			e.setAtaqueEspecial1(jobj.getInt(ATAQUEESPECIAL1));
			e.setAtaqueEspecial2(jobj.getInt(ATAQUEESPECIAL2));
			
			return e;
		}
		
		if(c.getRareza().equalsIgnoreCase("legendario"))
		{
			Carta_legendaria l = new Carta_legendaria();
			l = (Carta_legendaria)c;
			
			l.setAtaqueEspecial1(jobj.getInt(ATAQUEESPECIAL1));
			l.setAtaqueEspecial2(jobj.getInt(ATAQUEESPECIAL2));
			l.setAtaqueEspecial3(jobj.getInt(ATAQUEESPECIAL3));
			
			return l;
		}

		return c;
	}
	
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
	
	
	public static String getJsonObjectCarta(Carta c) throws JSONException
	{
		JSONObject jObj = new JSONObject();
		
		jObj = persistirCartaEnJSONObject(c);
		
		return jObj.toString();
	}
	
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
