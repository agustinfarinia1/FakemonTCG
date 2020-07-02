package colecciones;
import java.util.Collections;

import cartas.Carta;

public class Mazo{
	
	private Coleccion <Carta> mazo;

	public Mazo() {
		setMazo();
	}
	/*
	 * Getters y Setters de Mazo
	 * 
	 */
	public void setMazo()
	{
		this.mazo = new Coleccion<Carta>();
	}
	
	public Coleccion<Carta> getMazo() {
		return mazo;
	}
	
	public void agregarCartaMazo(Carta c) {
		getMazo().agregar(c);
	}
	
	public String listar()
	{
		return getMazo().listar();
	}
	
	/**
	 *  
	 *  RECIBIMOS UN MAZO CARGADO, Y LO MEZCLAMOS. SHUFFLE RECIBE UN "LIST" Y LE PASAMOS EL ATRIBUTO DE MAZO, QUE ES UN ARRAYLIST
	 * @param mazo
	 */
	public void desordenarMazo(Mazo mazo)
	{
	
		Collections.shuffle(getMazo().getColeccion());
	}
	
	
	@Override
	public String toString() {
		return listar();
	}
}
