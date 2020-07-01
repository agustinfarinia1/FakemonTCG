package colecciones;
import java.util.Collections;

import cartas.Carta;
import interfaces.IColeccion;

public class Mazo{
	
	Coleccion <Carta> mazo;

	/// METODO QUE DESORDENA UN MAZO Y SE SIRVE DE COLLECTION.shuffle
	public Mazo() {
		super();
		mazo.setColeccion();
		// TODO Auto-generated constructor stub
	}
	
	public Coleccion<Carta> getMazo() {
		return mazo;
	}
	
	public void desordenarMazo(Mazo mazo)
	{
		/// RECIBIMOS UN MAZO CARGADO, Y LO MEZCLAMOS. SHUFFLE RECIBE UN "LIST" Y LE PASAMOS EL ATRIBUTO DE MAZO, QUE ES UN ARRAYLIST
		Collections.shuffle(getMazo().getColeccion());
	}
	
	/// ACA HABIA UN METODO DE ROBAR UNA CARTA, PERO LO PASE A LA CLASE MANO
}
