import Cartas.Carta;
import Cartas.Carta_basica;
import Cartas.Carta_epica;
import Cartas.Carta_legendaria;

public class Main {

	public static void main(String[] args) {
		
	
	Carta_basica nuevaCarta1 = new Carta_basica(0001, "charmander");
	System.out.println(nuevaCarta1.toString());
	
	Carta_epica nuevaCarta2 = new Carta_epica(0002, "charmeleon");
	System.out.println(nuevaCarta2.toString());
	
	Carta_legendaria nuevaCarta3 = new Carta_legendaria(0003, "charizard");
	System.out.println(nuevaCarta3.toString());
	
	
	Carta_basica nuevaCarta4 = new Carta_basica(0004, "pikachu");
	System.out.println(nuevaCarta4.toString());
	
	Carta_epica nuevaCarta5 = new Carta_epica(0005, "tauros");
	System.out.println(nuevaCarta5.toString());
	
	Carta_legendaria nuevaCarta6 = new Carta_legendaria(0006, "mewtwo");
	System.out.println(nuevaCarta6.toString());

	
	}



	
}