package colecciones;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

import cartas.Carta;

public class Mazo implements Serializable{
	public static String nombreArchivoListaCartas = "listaCartas.dat";
	
	private String nombre;
	private Coleccion <Carta> mazo;
	private boolean activo;


	public Mazo()	// Constructor para el inicial
	{
		setNombre("Mazo Inicial");
		setMazo();
		setMazoInicial();
		setActivo(true);
	}
	public Mazo(String nombre)
	{
		setNombre(nombre);
		setMazo();
		setActivo(false);
	}
	/*
	 * Getters y Setters de Mazo
	 * 
	 */
	public void setMazo()
	{
		this.mazo = new Coleccion<Carta>();
	}
	
	public void setMazoInicial()
	{
		this.mazo = getMazoInicial();
	}
	
	public Coleccion<Carta> getMazoInicial()
	{
		Coleccion<Carta> mazoInicial = new Coleccion<Carta>();
		mazoInicial.setColeccion(mazoinicial().getColeccion());
		setActivo(true);
		return mazoInicial;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public boolean getActivo() {
		return activo;
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
	

	public int tamañoMazo()
	{
		return getMazo().cantidadColeccion();
	}
	
	/**
	 * Metodo que recibe un mazo y lo desordena
	 * necesario para el comportamiento mezclar mazo dentro del juego
=======
	/**
	 *  
	 *  RECIBIMOS UN MAZO CARGADO, Y LO MEZCLAMOS. SHUFFLE RECIBE UN "LIST" Y LE PASAMOS EL ATRIBUTO DE MAZO, QUE ES UN ARRAYLIST
>>>>>>> 5d5497cb509ced7ced6e168660f3acd6b177dd6c
	 * @param mazo
	 */
	public void desordenarMazo(Mazo mazo)
	{

		Collections.shuffle(getMazo().getColeccion());
	}

	@Override
	public String toString() {
		return "[ Nombre Mazo:"+ nombre + ", Estado-Activo:" + activo +","+ listar() +"]";
	}
	
	/**
	 * Metodo que trabaja con un archivo de cartas, el resultado del mazo incial va a ser producto de la cantodad de cartas que hay dentro del archivo
	 * @author erick
	 * 
	 * @return un mazo con 25 cartas basicas + 10 epicas y 5 legendarias
	 */
	public Coleccion<Carta> mazoinicial()
	{
		ArrayList<Carta> lista = leerArchivo();				///mi cartas del archivo
		Coleccion<Carta> mazo = new Coleccion<Carta>();		///va a ser el contenedor de mi mazo inicial
		ArrayList<Carta> arrayB = new ArrayList<Carta>();	///array con todos los basicos del archivo
		arrayB = listaDeTipos(lista, "basico");
		ArrayList<Carta> arrayE = new ArrayList<Carta>();
		arrayE = listaDeTipos(lista, "epico");
		ArrayList<Carta> arrayL = new ArrayList<Carta>();
		arrayL = listaDeTipos(lista, "legendario");
		Carta aux;
		for (int i=0; i<25; i++)
		{
			Collections.shuffle(arrayB);
			aux = arrayB.get(0);
			mazo.agregar(aux);
			
		}	
			for (int j=0; j<10; j++)
			{
				Collections.shuffle(arrayE);
				aux = arrayE.get(0);
				mazo.agregar(aux);
			}	
				for (int k=0; k<5; k++)
				{
					Collections.shuffle(arrayL);
					aux = arrayL.get(0);
					mazo.agregar(aux);
				}


		return mazo;
	}
	
	/**
	 * Metodo que setea el mazo inicial
	 */
	public void devolvemeUnMazoInicial()
	{
		this.mazo = mazoinicial();
	}
	
	/**
	 * metodo que devuelve una coleccion con una lista de cartas de un determinado tipo o rareza
	 * @param nececita drecibir un atributo raareza de la carta y la lista con la qeu va a trabajar
	 */
	public ArrayList<Carta> listaDeTipos (ArrayList<Carta> lista, String rare)
	{
		ArrayList<Carta> listaportipo = new ArrayList<Carta>();
		for (Carta aux : lista) 
		{
			if (aux.getRareza().equalsIgnoreCase(rare))
			{
				listaportipo.add(aux);
			}
		}
		return listaportipo;
	}
	
	/**
	 * Metodo que lee el archivo de cartas del administrador
	 * @return una coleccion de cartas
	 */
	public ArrayList<Carta> leerArchivo() // lee la informacion que esta en el archivo
	{
		ArrayList<Carta> misCartas = new ArrayList<Carta>();
		try {
			FileInputStream fileInputStream = new FileInputStream(nombreArchivoListaCartas);
			ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);
			Carta aux;
			while ((aux = (Carta) inputStream.readObject()) != null) {
				misCartas.add(aux);
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
		return misCartas;
	}
	
	
}
