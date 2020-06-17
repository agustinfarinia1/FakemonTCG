package colecciones;

import java.util.ArrayList;
import java.util.Collections;

import cartas.Carta;
import interfaces.IColeccion;

public class Mazo extends Coleccion{

	/// METODO QUE DESORDENA UN MAZO Y SE SIRVE DE COLLECTION.shuffle
	public Mazo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void desordenarMazo(Mazo mazo)
	{
		/// RECIBIMOS UN MAZO CARGADO, Y LO MEZCLAMOS. SHUFFLE RECIBE UN "LIST" Y LE PASAMOS EL ATRIBUTO DE MAZO, QUE ES UN ARRAYLIST
		Collections.shuffle(mazo.getColeccion());
	}
	
	/// ACA HABIA UN METODO DE ROBAR UNA CARTA, PERO LO PASE A LA CLASE MANO
}
