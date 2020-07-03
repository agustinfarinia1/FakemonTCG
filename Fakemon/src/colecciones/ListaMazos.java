package colecciones;

<<<<<<< HEAD
import java.util.Scanner;
=======
import java.io.Serializable;
>>>>>>> c0bd29616e08c7164eb16cd669cf0030c3e78a81

import Usuarios.Usuario;
import cartas.Carta;
import exception.ListaMazosException;

public class ListaMazos implements Serializable{
	private ColeccionGenerica<Mazo> listaMazos;
	private int cantidadMazos;
	
	public ListaMazos()
	{
		setListaMazos();
		setCantidadMazos(5);	// Limite de mazos por usuario
	}
	
	public void setListaMazos() {
		this.listaMazos = new ColeccionGenerica<Mazo>();
	}
	
	public void setCantidadMazos(int cantidadMazos) {
		this.cantidadMazos = cantidadMazos;
	}
	
	public int getCantidadMazos() {
		return cantidadMazos;
	}
	
	public ColeccionGenerica<Mazo> getListaMazos() {
		return listaMazos;
	}
	
	public void agregarMazo(String nombreMazo,Mazo mazo) throws ListaMazosException
	{
		if(cantidadMazos() < getCantidadMazos())
		{
			getListaMazos().añadir(nombreMazo, mazo);
		}
		else
		{
			throw new ListaMazosException("Llego a su limite de mazos");
		}
	}
	
	public void eliminarMazo(String nombreMazo,Mazo mazo)
	{
		getListaMazos().remove(nombreMazo, mazo);
	}
	
	public Mazo mazoActivo(String nombreMazo,Usuario usuario) {
		eliminarMazo(usuario.getMazoActivo().getNombre(),usuario.getMazoActivo());
		//listaMazos.añadir(usuario.getMazoActivo().getNombre(),usuario.getMazoActivo()// Se le saca el activo al otro
<<<<<<< HEAD
	//	listaMazos.existenciaHashMap(nombreMazo).setActivo(true);	// y se le pone al nuevo
=======
		listaMazos.existenciaHashMap(nombreMazo);	// y se le pone al nuevo
>>>>>>> c0bd29616e08c7164eb16cd669cf0030c3e78a81
		System.out.println(getListaMazos().toString());
		return 	getListaMazos().existenciaHashMap(nombreMazo);	// retorna para que lo guarde el usuario
	}
	
	public int cantidadMazos()
	{
		return getListaMazos().getHashMap().size();
	}
	
	public String listar()
	{
		return getListaMazos().listarHashMap(getListaMazos().getHashMap());
	}
	
	@Override
	public String toString() {
		return listar().toString();
	}
	
	/*
	 * Este metodo deberia devolver mazo, pero despues se me complicaba para trabajarlo. Fariña si tenes ganas cambialo despues, funciona bien
	 */
	public static Coleccion<Carta> crearMazoNuevo()
	{
		Scanner scan = new Scanner(System.in);
		
		Coleccion<Carta> mazoNuevo = new Coleccion<Carta>();
		
		ListaCarta listaTotal = new ListaCarta();
		listaTotal.cargarLista(listaTotal);
		
		int i = 0;
		
		listaTotal.leerArchivo();
		
		while(i < 40)
		{
			System.out.println("Ingrese cartas por nombre a su nuevo mazo hasta un maximo de 50 \n");
			String carta = scan.nextLine();
			mazoNuevo.agregar(listaTotal.obtenerCartaPorNombre(carta));
			i++;
		}
		return mazoNuevo;
	}
}
