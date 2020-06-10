package colecciones;

import java.util.ArrayList;
import java.util.Collections;

import cartas.Carta;
import interfaces.IColeccion;

public class Mazo implements IColeccion{
	private ArrayList<Carta> mazo;

	public Mazo()
	{
		setMazo(new ArrayList <Carta>());
	}

	@Override
	public String listar() {
		StringBuilder builder = new StringBuilder();
		builder.append("Lista de Cartas:\n");
		for(Carta c : getMazo())
		{
			builder.append(c.toString()+"\n");
			
		}
		return builder.toString();
	}
	
	public void agregarCarta(Carta e) {
		getMazo().add(e);
	}

	public void eliminarCarta(Carta c) {
		getMazo().remove(c);
	}
	
	@Override
	public int cantidad() {
		return getMazo().size();
	}

	@Override
	public boolean existencia(Object obj) {
		Carta c = (Carta) obj;
		return getMazo().contains(c);
	}

	@Override
	public String toString() {
		return listar();
	}

	public ArrayList<Carta> getMazo() {
		return mazo;
	}

	public void setMazo(ArrayList<Carta> mazo) {
		this.mazo = mazo;
	}
	
	/// METODO QUE DESORDENA UN MAZO Y SE SIRVE DE COLLECTION.shuffle
	public void desordenarMazo(Mazo mazo)
	{
		/// RECIBIMOS UN MAZO CARGADO, Y LO MEZCLAMOS. SHUFFLE RECIBE UN "LIST" Y LE PASAMOS EL ATRIBUTO DE MAZO, QUE ES UN ARRAYLIST
		Collections.shuffle(mazo.getMazo());
	}
	
	/// FUNCION QUE DEVUELVE LA PRIMERA CARTA DE NUESTRO MAZO. RECIBIMOS UN MAZO CARGADO, Y EL INDICE PARA ROBAR
	public Carta robarUnaCarta(Mazo mazo, int i) 
	{
		Carta carta = new Carta(); /// CREAMOS UN OBJETO PARA SETEARLE EL VALOR
		
		if(i < mazo.getMazo().size()) /// COMPARAMOS EL TAMAÑO PARA NO PASARNOS
		{
			mazo.getMazo().get(i); /// TOMAMOS EL PRIMERO
			carta = mazo.getMazo().get(i); /// LO GUARDAMOS EN UN OBJETO AUXILIAR
			mazo.getMazo().remove(i); /// BORRAMOS LA CARTA QUE ROBAMOS
		}
		return carta; /// DEVOLVEMOS
	}
	
}
