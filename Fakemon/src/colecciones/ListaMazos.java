package colecciones;

import java.util.ArrayList;

public class ListaMazos extends ColeccionGenerica<Mazo>{
	private ArrayList<Mazo> listaMazos;
	
	public ListaMazos() {
		setListaMazos();
	}
	
	public void setListaMazos() {
		this.listaMazos = new ArrayList<Mazo>();
	}
}
