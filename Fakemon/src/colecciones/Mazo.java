package colecciones;
import java.util.Collections;

import cartas.Carta;

public class Mazo{
	
	private Coleccion <Carta> mazo;

	/// METODO QUE DESORDENA UN MAZO Y SE SIRVE DE COLLECTION.shuffle
	public Mazo() {
		setMazo();
		// TODO Auto-generated constructor stub
	}
	
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
	
	public void desordenarMazo(Mazo mazo)
	{
		/// RECIBIMOS UN MAZO CARGADO, Y LO MEZCLAMOS. SHUFFLE RECIBE UN "LIST" Y LE PASAMOS EL ATRIBUTO DE MAZO, QUE ES UN ARRAYLIST
		Collections.shuffle(getMazo().getColeccion());
	}
	
	/// ACA HABIA UN METODO DE ROBAR UNA CARTA, PERO LO PASE A LA CLASE MANO
	
	@Override
	public String toString() {
		return listar();
	}
}
