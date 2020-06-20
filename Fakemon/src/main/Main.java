package main;
import java.util.ArrayList;

import java.util.Collections;
import java.util.Scanner;

import cartas.Carta;
import cartas.Carta_basica;
import cartas.Carta_epica;
import cartas.Carta_legendaria;

import colecciones.ColeccionGenerica;
import colecciones.ListaCarta;
import colecciones.ListaCarta;
import colecciones.Mano;
import colecciones.Mazo;


public class Main {

	public static void main(String[] args) {

		ListaCarta nueva = new ListaCarta();
		//System.out.println(nueva.listar());
		//nueva.GuardarLista();
		nueva.leerArchivo();
	
	
	/*
	Carta_basica charmander1 = new Carta_basica(0001, "charmander");
	Carta_basica charmander2 = new Carta_basica(0001, "charmander");
	Carta_basica charmander3 = new Carta_basica(0001, "charmander");
	Carta_basica charmander4 = new Carta_basica(0001, "charmander");
	Carta_basica charmander5 = new Carta_basica(0001, "charmander");
	Carta_basica charmander6 = new Carta_basica(0001, "charmander");
	
	
	//System.out.println(nuevaCarta1.toString());
	
	Carta_epica nuevaCarta2 = new Carta_epica(0002, "charmeleon");
	//System.out.println(nuevaCarta2.toString());
	
	Carta_legendaria nuevaCarta3 = new Carta_legendaria(0003, "charizard");
	//System.out.println(nuevaCarta3.toString());
	
	
	Carta_basica nuevaCarta4 = new Carta_basica(0004, "pikachu");
	//System.out.println(nuevaCarta4.toString());
	
	Carta_epica nuevaCarta5 = new Carta_epica(0005, "tauros");
	//System.out.println(nuevaCarta5.toString());
	
	Carta_legendaria nuevaCarta6 = new Carta_legendaria(0006, "mewtwo");
	//System.out.println(nuevaCarta6.toString());
	
	
	
	// Ejemplo de como funcionaria el stock de cartas
	
	ListaCarta lista = new ListaCarta();
	
	lista.cargarLista(lista);	// carga la lista con los datos del archivo
	
	//esto seria como se carga en el archivo , como ya esta cargado no es necesario
	  
	
	lista.agregarCarta(nuevaCarta1);
	lista.agregarCarta(nuevaCarta2);
	lista.agregarCarta(nuevaCarta3);
	lista.agregarCarta(nuevaCarta4);
	lista.agregarCarta(nuevaCarta5);
	lista.agregarCarta(nuevaCarta6);
	*/
	
//	System.out.println(lista.listar());
	
	//lista.GuardarLista();	// guarda la lista en el archivo
	//
	//lista.leerArchivo();	// ve los datos del archivo
	
	
	
	/* ESTO ERA PARA PROBAR COMO DESORDENAR UN MAZO Y FUNCIONA, ASI QUE LO HICIMOS CANCION... DIGO DIGO FUNCION.
	//ArrayList array = new ArrayList();
	Mazo mazo = new Mazo();
	
	mazo.agregarCarta(nuevaCarta1);
	mazo.agregarCarta(nuevaCarta2);
	mazo.agregarCarta(nuevaCarta3);
	//mazo.agregarCarta(nuevaCarta4);
	
	System.out.println("ORDENADO: \n");
	
	System.out.println(mazo.listar());
	
	Collections.shuffle(mazo.getMazo());
	
	System.out.println("DESORDENADO: \n");
	System.out.println(mazo.listar());
	
	*/
	
	/*
	Mazo mazo = new Mazo();
	Mano mano = new Mano();
	
	Carta carta = new Carta();
	
	
	mazo.agregarCartaColeccion(nuevaCarta4);
	mazo.agregarCartaColeccion(nuevaCarta2);
	mazo.agregarCartaColeccion(nuevaCarta3);
	
	*/
	//System.out.println(mazo.getMazo());
	
	
	//carta = mano.robarUnaCarta(mazo);
	
	//System.out.println(mazo.getMazo());
	//System.out.println("CARTA SOLITA: \n");
	//System.out.println(carta.toString());
	
	
	/*
	mazo.agregarCarta(nuevaCarta1);
	mazo.agregarCarta(nuevaCarta2);
	mazo.agregarCarta(nuevaCarta3);
	mazo.agregarCarta(nuevaCarta4);
	mazo.agregarCarta(nuevaCarta5);
	mazo.agregarCarta(nuevaCarta6);
	
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
	
	/*
	ArrayList<Carta> charmander = new ArrayList<Carta>();
	
	charmander.add(charmander1);
	charmander.add(charmander2);
	charmander.add(charmander3);
	charmander.add(charmander4);
	charmander.add(charmander5);
	charmander.add(charmander6);
	
	ColeccionGenerica<ArrayList<Carta>> prueba = new ColeccionGenerica<ArrayList<Carta>>();
	ColeccionGenerica<ArrayList<Carta>> mazo1 = new ColeccionGenerica<ArrayList<Carta>>();
	
	mazo1.añadir("m0001", mazo.getColeccion()); /// hashmap de mazo
	
	
	
	prueba.añadir("0001", charmander); /// hashmap de cartas exactamente iguales
	
	StringBuilder b = new StringBuilder();
	
	//b = prueba.listarHashMap(prueba.getHash());
	b = mazo1.listarHashMap(mazo1.getHash());
	
	System.out.println(b);
	
		
		
		Menu prueba = new Menu();
		prueba.menuPrincipal();
	
	 */
	}
	
}