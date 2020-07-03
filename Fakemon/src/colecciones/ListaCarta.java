package colecciones;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.lang.String;

import cartas.Carta;
import cartas.Carta_basica;
import cartas.Carta_epica;
import cartas.Carta_legendaria;
import interfaces.IArchivar;
import interfaces.IColeccion;

/**
 * 
 *  Tiene todas las cartas del juego, a futuro se puede cambiar por un hash map para agregar una carta a los mazos
 *  Esta tendria que estar en la lista de cartas
 *	Funciona como stock de cartas
 *	Se podria agregar un atributo disponible en carta para saber si la carta esta en un mazo o no.
 *
 */

public class ListaCarta implements IArchivar{	
	
	public static String nombreArchivoListaCartas = "listaCartas.dat";
	Coleccion <Carta> lista;
	
	public ListaCarta(){
		setListaCarta();
	}
	
	public void setListaCarta() {
		this.lista = new Coleccion<Carta>();
		
	}
	
	public void setListaCarta(Coleccion<Carta> listaCarta) {
		this.lista = listaCarta;
	}

	public Coleccion<Carta> getListaCarta() {
		return lista;
	}
	
	public void devolvemeUnaLista()
	{
		this.lista = generarListaSeteadaAdmin();
	}
	
	public void agregarCarta(Carta e) {
		if(getListaCarta().existencia(e) == false)	// Seria para hacer la comprobacion de que no se pongan cartas iguales
		{
			getListaCarta().agregar(e);
		}
	}
	
	public boolean comprobarExistencia(String nombre) {	// comprueba existencia solo con el nombre
		boolean existencia = false;
		int i = 0;
		while((existencia == false)&&(i < cantidad())) {
			Carta aux = obtenerCartaPorPosicion(i);
			if(nombre.equalsIgnoreCase(aux.getNombre_Carta())){
				existencia = true;
			}
			i++;
		}
		return existencia;
	}
	
	public void eliminarCarta(String nombre) {	// elimina la carta de la lista
		getListaCarta().eliminar(obtenerCartaPorNombre(nombre));
	}
	
	public Carta obtenerCartaPorPosicion(int posicion) {	// obtiene la carta de esa posicion
		return lista.getColeccion().get(posicion);
	}
	
	public Carta obtenerCartaPorNombre(String nombre) {	// obtiene la carta de esa posicion
		Carta aux = null;
		if(comprobarExistencia(nombre) == true)
		{
			for(Carta c : getListaCarta().getColeccion())
			{
				if(c.getNombre_Carta().equals(nombre))
				{
					aux = c;
				}
			}
		}
		return aux;
	}
	
	public String listar() {
		return getListaCarta().listar();
	}
	
	public int cantidad() {
		return getListaCarta().cantidadColeccion();
	}
	
	@Override
	public String toString() {
		return listar();
	}
	
	/**
	 * Carga la lista con los datos del archivo
	 * No se cargan los repetidos porque ya comprueba su existencia antes
	 * @param lista
	 */
	public void cargarLista(ListaCarta lista)	
	{
		try {
			FileInputStream fileInputStream = new FileInputStream(nombreArchivoListaCartas);
			ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);
			Carta aux;
			while ((aux = (Carta) inputStream.readObject()) != null) {
				lista.agregarCarta(aux);	
			}
			inputStream.close();
			
		} catch (EOFException e) {
			
			//e.printStackTrace();
			
		} catch (IOException ex) {
			
			//ex.printStackTrace();

		} catch (ClassNotFoundException ex) {
			//ex.printStackTrace();
		}
	}
	
	/**
	 * Guarda la lista en el archivo
	 */
	public void guardarArchivo() {	
		try {
			
			FileOutputStream fileOutputStream = new FileOutputStream(nombreArchivoListaCartas);
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
			for (int i = 0; i < cantidad(); i++) {
				objectOutputStream.writeObject(obtenerCartaPorPosicion(i));
			}
			objectOutputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Lee la informacion que esta en el archivo
	 */
	public void leerArchivo()
	{
		try {
			FileInputStream fileInputStream = new FileInputStream(nombreArchivoListaCartas);
			ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);
			Carta aux;
			System.out.println("\narchivo de cartas : ");
			while ((aux = (Carta) inputStream.readObject()) != null) {
					System.out.println(aux.toString());
			}
			inputStream.close();
		} 
		catch (EOFException e) {
				
			e.printStackTrace();
		} 
		catch (IOException ex) {
			
			ex.printStackTrace();
		} 
		catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}
	}


	 /** Este metodo genera una lista hardcodeada para llenar el archivo,
	 * lo llena de cartas de diferentes tipos
	 * 
	 * @return
	 */
	public Coleccion<Carta> generarListaSeteadaAdmin() 		/// LISTA HARCODEADA PARA LLENAR EL ARCHIVO

	{
		String basicos[] = { "Bulbasaur", "Squirtle", "Charmander", "Caterpie", "Weedle", "Pidgey", "Rattata",
				"Spearow", "Ekans", "Pikachu", "Sandshrew", "Nidoran", "Vulpix", "Jigglypuff", "Zubat", "Oddish",
				"Paras", "Venonat", "Diglett", "Meowth", "Psyduck", "Mankey", "Growlithe", "Poliwag", "Abra", "Machop",
				"Bellsprout", "Tentacool", "Geodude", "Ponyta" };

		String epicos[] = { "Ivysaur", "Charmeleon", "Wartortle", "Metapod", "Kakuna", "Pidgeotto", "Raticate",
				"Fearow", "Arbok", "Raichu", "Nidorina", "Ninetales", "Kadabra", "Golbat", "Gloom" };

		String legendario[] = { "Charizard", "Blastoise", "Venusaur", "Butterfree", "Beedrill", "Pidgeot", "Nidoqueen",
				"Vileplume", "Alakazam", "Mewtwo" };

		Coleccion<Carta> archivocartas = new Coleccion<Carta>();
		
		for (int i = 0; i < basicos.length; i++) {
			Carta_basica cb = new Carta_basica(i + 1, basicos[i]);
			archivocartas.agregar(cb);

		}

		for (int j = 0; j < epicos.length; j++) {
			int x = archivocartas.cantidadColeccion();
			Carta_epica ce = new Carta_epica(x + 1, epicos[j]);
			archivocartas.agregar(ce);
		}

		for (int k = 0; k < legendario.length; k++) {
			int z = archivocartas.cantidadColeccion();
			Carta_legendaria cl = new Carta_legendaria(z + 1, legendario[k]);
			archivocartas.agregar(cl);
		}

		System.out.println("entre aca" + archivocartas.listar());

		return archivocartas;
	}
	
	public boolean existenciaPorNombre(String nombre){
		for(Carta c : getListaCarta().getColeccion())
		{
			if(c.getNombre_Carta().equalsIgnoreCase(nombre))
			{
				return true;
			}
		}
		return false;
	}
	
	public ListaCarta generarListaSeteadaUser() 		/// LISTA HARCODEADA PARA LLENAR EL ARCHIVO
	{
		ListaCarta admin = new ListaCarta();
		cargarLista(admin);
		String basicos[] = { "Bulbasaur", "Squirtle", "Charmander", "Caterpie", "Weedle", "Pidgey", "Rattata",
				"Spearow", "Ekans", "Pikachu", "Sandshrew", "Nidoran", "Vulpix", "Jigglypuff", "Zubat", "Oddish",
				"Paras", "Venonat", "Diglett", "Meowth", "Psyduck", "Mankey", "Growlithe", "Poliwag", "Abra", "Machop",
				"Bellsprout", "Tentacool", "Geodude", "Ponyta" };

		String epicos[] = { "Ivysaur", "Charmeleon", "Wartortle", "Metapod", "Kakuna", "Pidgeotto", "Raticate"};

		String legendario[] = { "Charizard", "Blastoise", "Venusaur"};

		ListaCarta archivocartas = new ListaCarta();

		for (int i = 0; i < basicos.length; i++) {
			Carta_basica cb = new Carta_basica(i + 1, basicos[i]);

			archivocartas.agregarCarta(cb);

			if(admin.existenciaPorNombre(cb.getNombre_Carta()))	// Si existe en la listaDeCartas del admi, se agrega
			{
				archivocartas.agregarCarta(cb);
			}

			
		}

		for (int j = 0; j < epicos.length; j++) {
			int x = archivocartas.cantidad();
			Carta_epica ce = new Carta_epica(x + 1, epicos[j]);

			archivocartas.agregarCarta(ce);
			

			if(admin.existenciaPorNombre(ce.getNombre_Carta())) // Si existe en la listaDeCartas del admi, se agrega
			{
				archivocartas.agregarCarta(ce);
			}

		}

		for (int k = 0; k < legendario.length; k++) {
			int z = archivocartas.cantidad();
			Carta_legendaria cl = new Carta_legendaria(z + 1, legendario[k]);
			if(admin.existenciaPorNombre(cl.getNombre_Carta())) // Si existe en la listaDeCartas del admi, se agrega
			{
				archivocartas.agregarCarta(cl);
			}
		}
		
		return archivocartas;
	}

	@Override
	public void modificarArchivo() {
		// TODO Auto-generated method stub
		
	}
}