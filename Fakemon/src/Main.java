import java.util.ArrayList;
import java.util.Collections;

import cartas.Carta;
import cartas.Carta_basica;
import cartas.Carta_epica;
import cartas.Carta_legendaria;
import colecciones.Mazo;

public class Main {

	public static void main(String[] args) {
		
	
	Carta_basica nuevaCarta1 = new Carta_basica(0001, "charmander");
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
	
	mazo.agregarCarta(nuevaCarta1);
	mazo.agregarCarta(nuevaCarta2);
	mazo.agregarCarta(nuevaCarta3);
	
	System.out.println(mazo.getMazo());
	
	
	int i = 0;
	
	
	Carta carta = new Carta();
	carta = mazo.robarUnaCarta(mazo, i);
	
	System.out.println(mazo.getMazo());
	System.out.println("CARTA SOLITA: \n");
	System.out.println(carta.toString());
	*/
	
		
}

	
/// probando 123
/// prbando 12123123
	
	/// last one
	
}