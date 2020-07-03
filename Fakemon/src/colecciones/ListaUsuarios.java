package colecciones;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashSet;

import Usuarios.Usuario;

/**
 *  Tiene todos los usuarios del Programa, esto sirve a la hora de verificar
 *  el logueo y registrar los usuarios nuevos, se hizo con hashMap para mejor proteccion a la hora de registrar
 */

public class ListaUsuarios {
	public static String nombreArchivoListaUsuarios = "listaUsuarios.dat";
	private HashSet <Usuario> lista;
	
	public ListaUsuarios(){
		setListaUsuario();
	}
	
	public void setListaUsuario() {
		this.lista = new HashSet<Usuario>();
	}
	
	public void setListaUsuario(HashSet<Usuario> listaUsuario) {
		this.lista = listaUsuario;
	}

	public HashSet<Usuario> getListaUsuario() {
		return lista;
	}
	
	public void agregarUsuario(Usuario u) {
		getListaUsuario().add(u);
	}
	
	public boolean comprobarExistencia(String nombre) {	// comprueba existencia solo con el nombre
		for(Usuario u : getListaUsuario()) {
			if(nombre.equalsIgnoreCase(u.getNombreUsuario())){
				return true;
			}
		}
		return false;
	}
	
	public void eliminarCarta(String nombre) {	// elimina la carta de la lista
		getListaUsuario().remove(obtenerUsuarioPorNombre(nombre));
	}
	
	//public Carta obtenerCartaPorPosicion(int posicion) {	// obtiene la carta de esa posicion
		//return getListaUsuario().(posicion);
	//}
	
	public Usuario obtenerUsuarioPorNombre(String nombre) {	// obtiene la carta de esa posicion
		Usuario aux = null;
		if(comprobarExistencia(nombre) == true)
		{
			for(Usuario u : getListaUsuario())
			{
				if(u.getNombreUsuario().equals(nombre))
				{
					aux = u;
				}
			}
		}
		return aux;
	}
	
	public Usuario obtenerUsuarioPorNombreYContrasenia(String nombre,String contrasenia) {	// obtiene la carta de esa posicion
		Usuario usuario = null;
		if(obtenerUsuarioPorNombre(nombre) != null)	// Si el usuario existe
		{
			for(Usuario u : getListaUsuario())
			{
				if(u.getNombreUsuario().equals(nombre))
				{
					if(u.getContrasenya().equals(contrasenia))
					{
						return u;
					}
				}
			}
			
		}
		return usuario;
	}
	
	public Usuario obtenerUsuarioPorPosicion(int posicion) {	// obtiene la carta de esa posicion
		Usuario aux = null;
		int i = 0;
		if(posicion < cantidad())
		{
			for(Usuario u : getListaUsuario())
			{
				if(i == posicion)
				{
					return u;
				}
				i++;
			}
		}
		return aux;
	}
	
	public String listar() {
		StringBuilder sb = new StringBuilder();
		for(Usuario u : getListaUsuario())
		{
			sb.append(u.toString()+"\n");
		}
		return sb.toString();
	}
	
	public int cantidad() {
		return getListaUsuario().size();
	}
	
	/**
	 * Carga la lista con los datos del archivo
	 */
	public void cargarLista()	
	{
		try {
			FileInputStream fileInputStream = new FileInputStream(nombreArchivoListaUsuarios);
			ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);
			Usuario aux;
			while ((aux = (Usuario) inputStream.readObject()) != null) {
				agregarUsuario(aux);	
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
			
			FileOutputStream fileOutputStream = new FileOutputStream(nombreArchivoListaUsuarios);
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
			for (int i = 0; i < cantidad(); i++) {
				objectOutputStream.writeObject(obtenerUsuarioPorPosicion(i));
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
			FileInputStream fileInputStream = new FileInputStream(nombreArchivoListaUsuarios);
			ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);
			Usuario aux;
			System.out.println("\narchivo de Usuarios : ");
			while ((aux = (Usuario) inputStream.readObject()) != null) {
					System.out.println(aux.toString());
			}
			inputStream.close();
		} 
		catch (EOFException e) {
				
			//e.printStackTrace();
		} 
		catch (IOException ex) {
			
			//ex.printStackTrace();
		} 
		catch (ClassNotFoundException ex) {
			//ex.printStackTrace();
		}
	}
	
	
	@Override
	public String toString() {
		return listar();
	}
}
