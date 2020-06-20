package cartas;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


public class ListaUsuario 
{
	
    public static String nombreArchivo = "usuario.dat";
    ArrayList <Usuario> lista;	
	
	public ListaUsuario() 
	{
		lista = new ArrayList<Usuario>();
	}
	
	public void agregarUsuario(Usuario user) 
	{
		lista.add(user);
	}
	
	public int cantidadUsuarios() //Cuantos usuarios hay en la lista
	{
		return lista.size();
	}
	
	public Usuario escribirLista(int posicion) //Posicion del "cursor" en la lista
	{
		return lista.get(posicion);
	}
	
	/*
	public void eliminarUsuario(Usuario user)	// encuentra persona y cambia el valor de eliminado
	{
		int i = 0;
		boolean encontrado = false;
		
		while((encontrado == false) && ( i < cantidadUsuarios()))
		{
			if(user.equals(escribirLista(i)))
			{
				encontrado = true;
			}
		}
	}
	*/
	
    public void archivoToListaUsuario(ListaUsuario lista)	// Filtro para evitar cargar usuarios eliminados ¿Si/No?
    {
	    try
	    {
	        FileInputStream fileInputStream = new FileInputStream(nombreArchivo);
	        ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);
	        Usuario aux ;
	        
	        while ((aux = (Usuario)inputStream.readObject()) != null)
	        {
	            lista.agregarUsuario(aux);
	        }
	        inputStream.close();
	    }
	    
	    catch (EOFException e)
	    {
	        // TODO: handle exception
	    }
	    
	    catch (IOException ex)
	    {
	       
	    }
	    
	    catch (ClassNotFoundException ex)
	    {
	        ex.printStackTrace();
	    }
    }
	
    public void listaToArchivoUsuario(int cantidad) 
    {
	    
    	try
    	{
	    	
	    	FileOutputStream fileOutputStream = new FileOutputStream(nombreArchivo);
		    ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
		    
		    for(int i = 0 ; i < cantidad ; i++) 
		    {   
		        objectOutputStream.writeObject(escribirLista(i));	// Escribe una persona en el archivo   
		    }
		    
		    objectOutputStream.close();
		}
    	
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
   
    public void leerArchivoUsuario() //Muestra los usuarios en el archivo
    {
	    try
	    {
	        FileInputStream fileInputStream = new FileInputStream(nombreArchivo);
	        ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);
	        Usuario aux ;
	        while ((aux = (Usuario)inputStream.readObject())!=null)
	        {
	            System.out.println(aux.toString());
	        }
	        inputStream.close();
	    }
	    catch (EOFException e)
	    {
	        // TODO: handle exception
	    }
	    catch (IOException ex)
	    {
	       
	    }
	    catch (ClassNotFoundException ex)
	    {
	        ex.printStackTrace();
	    }
    }
    
}
