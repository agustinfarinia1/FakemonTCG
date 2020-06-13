package colecciones;

import java.util.ArrayList;

import cartas.Carta;
import colecciones.Mazo;

public class Mano {
	
	private ArrayList<Carta> mano;
	
	public Mano()
	{
		setMano(new ArrayList <Carta>());
	}

	public ArrayList<Carta> getMano() {
		return mano;
	}

	public void setMano(ArrayList<Carta> mano) {
		this.mano = mano;
	}
	
	public void agregarCartaMano(Carta e) {
		getMano().add(e);
	}

	public void eliminarCartaMano(Carta c) {
		getMano().remove(c);
	}
	
	public int cantidadMano() {
		return getMano().size();
	}
	
	public String listarMano() {
		StringBuilder builder = new StringBuilder();
		builder.append("Lista de Cartas:\n");
		for(Carta c : getMano())
		{
			builder.append(c.toString()+"\n");
			
		}
		return builder.toString();
	}
	
	@Override
	public String toString() {
		return listarMano();
	}
	
	/// FUNCION QUE DEVUELVE LA PRIMERA CARTA DE NUESTRO MAZO. RECIBIMOS UN MAZO CARGADO
	public Carta robarUnaCarta(Mazo mazo) 
		{
			Carta carta = new Carta(); /// CREAMOS UN OBJETO PARA SETEARLE EL VALOR
			int i = 0;
			
			if(i < mazo.getMazo().size()) /// COMPARAMOS EL TAMAÑO PARA NO PASARNOS
			{
				mazo.getMazo().get(i); /// TOMAMOS EL PRIMERO
				carta = mazo.getMazo().get(i); /// LO GUARDAMOS EN UN OBJETO AUXILIAR
				mazo.getMazo().remove(i); /// BORRAMOS LA CARTA QUE ROBAMOS
			}
			return carta; /// DEVOLVEMOS
		}
		
	public Mano cartaEnMano(Mano mano, Mazo mazo)
	/// recibimos nuestra mano, recibimos un mazo, y la cantidad de cartas que tenemos en la mano.
	{
		
		int cantidad = mano.cantidadMano(); /// averiguamos si la mano tiene elementos.			
		
		Carta carta = new Carta(); /// auxiliar de carta donde vamos a guardar lo que recibamos del metodo de mazo "robarUnaCarta"
		
		if((cantidad < 5) && (mazo.cantidad() != 0)) /// preguntamos si nuestra cantidad de cartas es menor a 5 (el total) y si el mazo aun posee cartas
		{
			carta = robarUnaCarta(mazo);
			mazo.eliminarCarta(carta);
			mano.agregarCartaMano(carta);
			cantidad++;
		}
		return mano;
	}
	
	public Mano manoInicial(Mano mano, Mazo mazo) /// igual a cartaEnMano, pero en un bucle para conseguir una mano inicial para el jugador.
	
	{
		
		int cantidad = mano.cantidadMano(); 		
		
		Carta carta = new Carta(); 
		
		while((cantidad < 5) && (mazo.cantidad() != 0)) 
		{
			carta = robarUnaCarta(mazo);
			mazo.eliminarCarta(carta);
			mano.agregarCartaMano(carta);
			cantidad++;
		}
		return mano;
	}

	
}
