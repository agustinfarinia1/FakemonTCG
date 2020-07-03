package colecciones;

import Usuarios.Usuario;
import exception.ListaMazosException;

public class ListaMazos {
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
		listaMazos.existenciaHashMap(nombreMazo).setActivo(true);	// y se le pone al nuevo
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
}
