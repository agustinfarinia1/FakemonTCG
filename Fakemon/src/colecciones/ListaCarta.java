package colecciones;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import cartas.Carta;
import interfaces.IColeccion;

// Tiene todas las cartas del juego, a futuro se puede cambiar por un hash map
// para agregar una carta a los mazos , esta tendria que estar en la lista de cartas
// funciona como stock de cartas
// se podria agregar un atributo disponible en carta para saber si la carta esta en un mazo o no.

public class ListaCarta implements IColeccion{	
	
	public static String nombreArchivoListaCartas = "listaCartas.dat";
	ArrayList <Carta> lista;
	
	public ListaCarta(){
		setListaCarta(new ArrayList <Carta>());
	}

	public void agregarCarta(Carta e) {
		if(comprobarExistencia(e) == false)
		{
			getListaCarta().add(e);
		}
	}

	private boolean comprobarExistencia(Carta e) {	// comprueba la existencia con el objeto entero
		boolean existencia = false;
		int i = 0;
		while((existencia == false)&&(i < cantidad())) {
			Carta aux = obtenerCartaPorPosicion(i);
			if(aux.equals(e)){
				existencia = true;
			}
			i++;
		}
		return existencia;
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
		if(comprobarExistencia(nombre) == true)
		{
			for(Carta carta : lista)
			{
				if(nombre.equalsIgnoreCase(carta.getNombre_Carta())){
					lista.remove(carta);
				}
			}
		}
	}
	
	public Carta obtenerCartaPorPosicion(int posicion) {	// obtiene la carta de esa posicion
		return lista.get(posicion);
	}
	
	@Override
	public String listar() {
		StringBuilder builder = new StringBuilder();
		builder.append("Lista de Cartas:\n");
		for(Carta c : getListaCarta())
		{
				builder.append(c.toString()+"\n");			
		}
		return builder.toString();
	}
	
	@Override
	public int cantidad() {
		return getListaCarta().size();
	}

	@Override
	public boolean existencia(Object obj) {	// no use existencia porque hay que implementarle el equals
		//TODO agregarle el equals para que funcione correctamente
		boolean existencia = false;
		Carta aux = (Carta) obj;
		int i = 0;
		Carta carta;
		while((existencia == false)&&(i < cantidad()))
		{
			carta = obtenerCartaPorPosicion(i);
			if(carta.equals(aux) == true)
			{
				existencia = true;
			}
		}
		return existencia;
	}
	
	public ArrayList<Carta> getListaCarta() {
		return lista;
	}

	public void setListaCarta(ArrayList<Carta> lista) {
		this.lista = lista;
	}
	
	@Override
	public String toString() {
		return listar();
	}
	
	public void cargarLista(ListaCarta lista)	// carga la lista con los datos del archivo
	{
		try {
			FileInputStream fileInputStream = new FileInputStream(nombreArchivoListaCartas);
			ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);
			Carta aux;
			while ((aux = (Carta) inputStream.readObject()) != null) {
				lista.agregarCarta(aux);	// no se cargan repetidos porque tiene equals adentro
			}
			inputStream.close();
		} catch (EOFException e) {
			// TODO: handle exception
		} catch (IOException ex) {

		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}
	}

	public void GuardarLista() {	// guarda la lista en el archivo
		try {

			FileOutputStream fileOutputStream = new FileOutputStream(nombreArchivoListaCartas);
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
			for (int i = 0; i < cantidad(); i++) {
				objectOutputStream.writeObject(obtenerCartaPorPosicion(i)); // escribe una carta en el archivo
			}
			objectOutputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void leerArchivo() // lee la informacion que esta en el archivo
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
			// TODO: handle exception
		} 
		catch (IOException ex) {

		} 
		catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}
	}
}