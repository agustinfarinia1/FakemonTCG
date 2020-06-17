package colecciones;

import java.util.ArrayList;

import cartas.Carta;
import colecciones.Mazo;

public class Mano extends Coleccion{
	
	public Mano() {
		super();
		// TODO Auto-generated constructor stub
	}

	/// FUNCION QUE DEVUELVE LA PRIMERA CARTA DE NUESTRO MAZO. RECIBIMOS UN MAZO CARGADO
	public Carta robarUnaCarta(Mazo mazo) 
		{
			Carta carta = new Carta(); /// CREAMOS UN OBJETO PARA SETEARLE EL VALOR
			int i = 0;
			
			if(i < mazo.getColeccion().size()) /// COMPARAMOS EL TAMAÑO PARA NO PASARNOS
			{
				mazo.getColeccion().get(i); /// TOMAMOS EL PRIMERO
				carta = mazo.getColeccion().get(i); /// LO GUARDAMOS EN UN OBJETO AUXILIAR
				mazo.getColeccion().remove(i); /// BORRAMOS LA CARTA QUE ROBAMOS
			}
			return carta; /// DEVOLVEMOS
		}
		
	public Mano cartaEnMano(Mano mano, Mazo mazo)
	/// recibimos nuestra mano, recibimos un mazo, y la cantidad de cartas que tenemos en la mano.
	{
		
		int cantidad = mano.ObtenerCantidadColeccion(); /// averiguamos si la mano tiene elementos.			
		
		Carta carta = new Carta(); /// auxiliar de carta donde vamos a guardar lo que recibamos del metodo de mazo "robarUnaCarta"
		
		if((cantidad < 5) && (mazo.ObtenerCantidadColeccion() != 0)) /// preguntamos si nuestra cantidad de cartas es menor a 5 (el total) y si el mazo aun posee cartas
		{
			carta = robarUnaCarta(mazo);
			mazo.eliminarCartaColeccion(carta);
			mano.agregarCartaColeccion(carta);
			cantidad++;
		}
		return mano;
	}
	
	public Mano manoInicial(Mano mano, Mazo mazo) /// igual a cartaEnMano, pero en un bucle para conseguir una mano inicial para el jugador.
	
	{
		
		int cantidad = mano.ObtenerCantidadColeccion(); 		
		
		Carta carta = new Carta(); 
		
		while((cantidad < 5) && (mazo.ObtenerCantidadColeccion() != 0)) 
		{
			carta = robarUnaCarta(mazo);
			mazo.eliminarCartaColeccion(carta);
			mano.agregarCartaColeccion(carta);
			cantidad++;
		}
		return mano;
	}

	
}
