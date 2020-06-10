package colecciones;

import java.util.ArrayList;

import cartas.Carta;
import interfaces.IColeccion;

public class Mazo implements IColeccion{
	ArrayList<Carta> mazo;

	public Mazo()
	{
		mazo = new ArrayList <Carta>();
	}

	@Override
	public String listar() {
		StringBuilder builder = new StringBuilder();
		builder.append("Lista de Cartas:\n");
		for(Carta c : mazo)
		{
			builder.append(c.toString()+"\n");
			
		}
		return builder.toString();
	}
	
	public void agregarCarta(Carta e) {
		mazo.add(e);
	}

	public void eliminarCarta(Carta c) {
		mazo.remove(c);
	}
	
	@Override
	public int cantidad() {
		return mazo.size();
	}

	@Override
	public boolean existencia(Object obj) {
		Carta c = (Carta) obj;
		return mazo.contains(c);
	}

	@Override
	public String toString() {
		return listar();
	}
	
	
}
