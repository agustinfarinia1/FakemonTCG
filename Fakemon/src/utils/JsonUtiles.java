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
		Carta p;
		
		for(int i=0; i < jarray.length(); i++)
		{
			p = (Carta) jarray.get(i);
			aux.add(p);
		}
		
		return aux;
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
		
		jObj.put("ID Carta", c.getId_Carta());
		jObj.put("Nombre de Carta ", c.getNombre_Carta());
		jObj.put("Rareza ", c.getRareza());
		jObj.put("Vida ", c.getVida());
		jObj.put("Ataque Base ", c.getAtaqueBase());
		
		if(c instanceof Carta_basica)
		{
			Carta_basica b = new Carta_basica();
			b = (Carta_basica)c;
			jObj.put("1er Ataque Especial", b.getAtaqueEspecial1());
		}
		if(c instanceof Carta_epica)
		{
			Carta_epica e = new Carta_epica();
			e = (Carta_epica)c;
			jObj.put("1er Ataque Especial", e.getAtaqueEspecial1());
			jObj.put("2do Ataque Especial", e.getAtaqueEspecial2());
		}
		if(c instanceof Carta_legendaria)
		{
			Carta_legendaria l = new Carta_legendaria();
			
			l = (Carta_legendaria)c;
			jObj.put("1er Ataque Especial", l.getAtaqueEspecial1());
			jObj.put("2do Ataque Especial", l.getAtaqueEspecial2());
			jObj.put("3er Ataque Espacial", l.getAtaqueEspecial3());
			
		}
		
		return jObj;
	}
	
}
