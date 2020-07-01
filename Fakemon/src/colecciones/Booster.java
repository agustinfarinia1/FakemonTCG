package colecciones;

import java.util.ArrayList;
import java.util.Collections;
import cartas.Carta;

public class Booster {
	
	public Booster() {
		super();
	}
	/*
	 * Metodo que genera automaticamente un booster con 7 cartas (1 legendaria, 2 epicas, 4 basicas)
	 * las tiene que traer del archivo de cartas
	 * devuelve un arraylist con las cartas aleatorias
	 */
	public ArrayList<Carta> booster (ListaCarta lista)
	{
		ArrayList<Carta> booster = new ArrayList<Carta>();
		ArrayList<Carta> arrayB = new ArrayList<Carta>();
		arrayB = listaDeTipos(lista, "basico");
		ArrayList<Carta> arrayE = new ArrayList<Carta>();
		arrayE = listaDeTipos(lista, "epico");
		ArrayList<Carta> arrayL = new ArrayList<Carta>();
		arrayL = listaDeTipos(lista, "legendario");
		Carta aux;
		for (int i=0; i<1; i++)
		{
			Collections.shuffle(arrayB);
			aux = arrayB.get(0);
			booster.add(aux);
			
			for (int j=0; j<2; j++)
			{
				Collections.shuffle(arrayE);
				aux = arrayE.get(0);
				booster.add(aux);
				
				for (int k=0; k<4; k++)
				{
					Collections.shuffle(arrayL);
					aux = arrayL.get(0);
					booster.add(aux);
				}
			}
		}
		return booster;
	}
	/*
	 * metodoo que devuelve un arreglo con una lista de cartas de un determinado tipo o rareza
	 */
	public ArrayList<Carta> listaDeTipos (ListaCarta lista, String rare)
	{
		ArrayList<Carta> listaportipo = new ArrayList<Carta>();
		for (Carta aux : lista.getListaCarta()) 
		{
			if (aux.getRareza().equalsIgnoreCase(rare))
			{
				listaportipo.add(aux);
			}
		}
		return listaportipo;
	}
}
