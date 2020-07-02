package main;
import java.util.ArrayList;

import java.util.Collections;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONException;

import Usuarios.Usuario;
import cartas.Carta;
import cartas.Carta_basica;
import cartas.Carta_epica;
import cartas.Carta_legendaria;
import colecciones.Coleccion;
import colecciones.ColeccionGenerica;
import colecciones.ListaCarta;
import colecciones.ListaCarta;
import colecciones.Mano;
import colecciones.Mazo;
import utils.JsonUtiles;


public class Main {

	public static void main(String[] args) {

		//ListaCarta nueva = new ListaCarta();
		//System.out.println(nueva.listar());
		//nueva.GuardarLista();
		//nueva.leerArchivo();

	Carta_basica charmander1 = new Carta_basica(0001, "charmander");
	Carta_basica charmander2 = new Carta_basica(0001, "charmander");
	Carta_basica charmander3 = new Carta_basica(0001, "charmander");
	Carta_basica charmander4 = new Carta_basica(0001, "charmander");
	Carta_basica charmander5 = new Carta_basica(0001, "charmander");
	Carta_basica charmander6 = new Carta_basica(0001, "charmander");
	
	Carta_epica nuevaCarta2 = new Carta_epica(0002, "charmeleon");
	Carta_legendaria nuevaCarta3 = new Carta_legendaria(0003, "charizard");	
	Carta_basica nuevaCarta4 = new Carta_basica(0004, "pikachu");	
	Carta_epica nuevaCarta5 = new Carta_epica(0005, "tauros");	
	Carta_legendaria nuevaCarta6 = new Carta_legendaria(0006, "mewtwo");
	
	// Ejemplo de como funcionaria el stock de cartas
	
	ListaCarta lista = new ListaCarta();
	
	lista.cargarLista(lista);	// carga la lista con los datos del archivo
	
	//esto seria como se carga en el archivo , como ya esta cargado no es necesario
	  
	lista.agregarCarta(nuevaCarta2);
	lista.agregarCarta(nuevaCarta3);
	lista.agregarCarta(nuevaCarta4);
	lista.agregarCarta(nuevaCarta5);
	lista.agregarCarta(nuevaCarta6);
	
	//System.out.println(lista.listar());
	
	//lista.GuardarLista();	// guarda la lista en el archivo
	//lista.leerArchivo();	// ve los datos del archivo
	
	//ESTO ERA PARA PROBAR COMO DESORDENAR UN MAZO Y FUNCIONA, ASI QUE LO HICIMOS CANCION... DIGO DIGO FUNCION.
	
	/*
	
	Mazo mazo = new Mazo();
	
	mazo.agregarCartaMazo(nuevaCarta2);
	mazo.agregarCartaMazo(nuevaCarta3);
	mazo.agregarCartaMazo(nuevaCarta4);
	
	System.out.println("ORDENADO: \n");
	
	System.out.println(mazo.listar());
	
	mazo.desordenarMazo(mazo);
	
	System.out.println("DESORDENADO: \n");
	System.out.println(mazo.toString());
	
	*/
	
	Mazo mazo = new Mazo();
	Mano mano = new Mano();
	
	
	mazo.agregarCartaMazo(nuevaCarta4);
	mazo.agregarCartaMazo(nuevaCarta2);
	mazo.agregarCartaMazo(nuevaCarta3);

	
	//System.out.println(mazo.getMazo());
	
	
	//carta = mano.robarUnaCarta(mazo);
	
	//System.out.println(mazo.getMazo());
	//System.out.println("CARTA SOLITA: \n");
	//System.out.println(carta.toString());
	
	/*
	
	mazo.agregarCartaMazo(nuevaCarta2);
	mazo.agregarCartaMazo(nuevaCarta3);
	mazo.agregarCartaMazo(nuevaCarta4);
	mazo.agregarCartaMazo(nuevaCarta5);
	mazo.agregarCartaMazo(nuevaCarta6);
	
	mazo.desordenarMazo(mazo);
	
	System.out.println(mazo.getMazo());

	
	mano.manoInicial(mano, mazo);
	
	System.out.println("\n");
	System.out.println("\n");
	System.out.println("MANO INICIAL: \n");
	
	System.out.println(mano.toString());
	
	System.out.println("\n");
	System.out.println("\n");
	
	System.out.println(mazo.getMazo());
	
	*/
	
	Coleccion<Carta> charmander = new Coleccion<Carta>();
	
	charmander.agregar(charmander1);
	charmander.agregar(charmander2);
	charmander.agregar(charmander3);
	charmander.agregar(charmander4);
	charmander.agregar(charmander5);
	charmander.agregar(charmander6);
	
	ColeccionGenerica<Coleccion<Carta>> prueba = new ColeccionGenerica<Coleccion<Carta>>();
	ColeccionGenerica<Coleccion<Carta>> mazo1 = new ColeccionGenerica<Coleccion<Carta>>();
	
	mazo1.añadir("m0001", mazo.getMazo()); /// hashmap de mazo
	
	
	
	prueba.añadir("0001", charmander); /// hashmap de cartas exactamente iguales
	
	//System.out.println(prueba.listarHashMap(prueba.getHashMap())); // MUESTRA LA COLECCION DE CARTAS QUE TIENE	
	//System.out.println(mazo1.listarHashMap(mazo1.getHashMap()));	// Muestra el mazo que tiene adentro

		
		
		//Menu prueba = new Menu();
		//prueba.menuPrincipal();
		//prueba.menuPrincipal();
		
	/*
	 *  ACA PROBE EL PRIMER GUARDADO DE JSON EN ARCHIVO, CONVINANDO LA HERRAMIENTA DE COLECCION DE GUARDARSE A SI MISMO
	 *  FUNCIONA BIEN, GUARDO 6 CARTAS Y USANDO EL METODO "persistirEnJSONObject" + las JsonUtiles del profe y su metodo "grabar" 
	 *  PODEMOS GENERAR UN ARCHIVO QUE CONTIENE NUESTRA EXPORTACION A JSON !
	 * 
	 * 
	 */	
		
		
		/// TENGO UN NULL POINTER ACA FARI :C
		Mazo deck = new Mazo();
		
		JSONArray jsonArray = new JSONArray();
		
		Coleccion<Carta> otroArray = new Coleccion<Carta>();
		
		deck.getMazo().agregar(nuevaCarta2);
		deck.getMazo().agregar(nuevaCarta3);
		deck.getMazo().agregar(nuevaCarta4);
		deck.getMazo().agregar(nuevaCarta5);
		
		//try {
			//jsonArray = JsonUtiles.decodeJsonObject(deck.getMazo().getColeccion());
			//System.out.println(jsonArray.toString());
			//otroArray = JsonUtiles.fromJSONObject(jsonArray); /// aca hay un bug
			//System.out.println(otroArray.toString());
			
		//} catch (JSONException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		//}
		
		Usuario usuario = new Usuario();
		
		System.out.println(usuario.toString());
		
		Menu menu = new Menu();
		
		System.out.println(usuario.getMilistaCartas().toString());
		
		//menu.menuUsuario();
		
	}
	
}