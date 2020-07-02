package colecciones;

import cartas.Carta;

public class Mano{
	
	private Coleccion <Carta> mano;
	
	public Mano() {
		setMano();
	}
	
	public void setMano() {
		this.mano = new Coleccion<Carta>();
	}
	
	public Coleccion<Carta> getMano() {
		return mano;
	}

	/**
	 * Metodo que roba una carta del mazo, la elimina del mismo y la devuelve.
	 * @param Mazo
	 * @return Carta
	 */
	public Carta robarUnaCarta(Mazo mazo) 
		{
			Carta carta = new Carta(); /// CREAMOS UN OBJETO PARA SETEARLE EL VALOR
			int i = 0;
			
			if(i < mazo.getMazo().cantidadColeccion()) /// COMPARAMOS EL TAMAÑO PARA NO PASARNOS
			{
				mazo.getMazo().getColeccion().get(i); /// TOMAMOS EL PRIMERO
				carta = mazo.getMazo().getColeccion().get(i); /// LO GUARDAMOS EN UN OBJETO AUXILIAR
				mazo.getMazo().getColeccion().remove(i); /// BORRAMOS LA CARTA QUE ROBAMOS
			}
			return carta; /// DEVOLVEMOS
		}
	
	/**
	 * Este metodo roba 1 sola carta, y la lleva a la mano.
	 * @param mano
	 * @param mazo
	 * @return Mano
	 */
	public Mano cartaEnMano(Mano mano, Mazo mazo)
	/// recibimos nuestra mano, recibimos un mazo, y la cantidad de cartas que tenemos en la mano.
	{
		
		int cantidad = mano.getMano().cantidadColeccion(); /// averiguamos si la mano tiene elementos.			
		
		Carta carta = new Carta(); /// auxiliar de carta donde vamos a guardar lo que recibamos del metodo de mazo "robarUnaCarta"
		
		if((cantidad < 5) && (mazo.getMazo().cantidadColeccion() != 0)) /// preguntamos si nuestra cantidad de cartas es menor a 5 (el total) y si el mazo aun posee cartas
		{
			carta = robarUnaCarta(mazo);
			mano.getMano().agregar(carta);
			cantidad++;
		}
		return mano;
	}
	
	/**
	 * Este metodo genera una mano de cartas inicial para el usuario.
	 * @param mano
	 * @param mazo
	 * @return Mano
	 */
	public Mano manoInicial(Mano mano, Mazo mazo) /// igual a cartaEnMano, pero en un bucle para conseguir una mano inicial para el jugador.
	
	{
		
		int cantidad = mano.getMano().cantidadColeccion(); 		
		
		Carta carta = new Carta(); 
		
		while((cantidad < 5) && (mazo.getMazo().cantidadColeccion() != 0)) 
		{
			carta = robarUnaCarta(mazo);
			mazo.getMazo().eliminar(carta);
			mano.getMano().agregar(carta);
			cantidad++;
		}
		return mano;
	}

	@Override
	public String toString() {
		return getMano().toString();
	}
}
