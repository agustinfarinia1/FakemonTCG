package colecciones;

import java.util.ArrayList;
import java.util.Collections;
import cartas.Carta;

public class Booster extends Mazo{
	public static String nombreArchivoListaCartas = "listaCartas.dat";
	
	private Coleccion<Carta> booster;
	
	
	public Booster()
	{
		this.booster = new Coleccion<Carta>();
	}
	
	public Coleccion<Carta> getBooster() {
		return booster;
	}

	public void setBooster(Coleccion<Carta> booster) {
		this.booster = booster;
	}

	/*
	 * Metodo que genera automaticamente un booster con 7 cartas (1 legendaria, 2 epicas, 4 basicas)
	 * las tiene que traer del archivo de cartas
	 * devuelve una coleccion con las cartas aleatorias
	 */
	public Coleccion<Carta> booster ()
	{
		ArrayList<Carta> lista = leerArchivo();				
		Coleccion<Carta> booster = new Coleccion<Carta>();		
		ArrayList<Carta> arrayB = new ArrayList<Carta>();	
		arrayB = listaDeTipos(lista, "basico");
		ArrayList<Carta> arrayE = new ArrayList<Carta>();
		arrayE = listaDeTipos(lista, "epico");
		ArrayList<Carta> arrayL = new ArrayList<Carta>();
		arrayL = listaDeTipos(lista, "legendario");
		Carta aux;
		for (int i=0; i<4; i++)
		{
			Collections.shuffle(arrayB);
			aux = arrayB.get(0);
			booster.agregar(aux);
		}	
			for (int j=0; j<2; j++)
			{
				Collections.shuffle(arrayE);
				aux = arrayE.get(0);
				booster.agregar(aux);
			}	
				for (int k=0; k<1; k++)
				{
					Collections.shuffle(arrayL);
					aux = arrayL.get(0);
					booster.agregar(aux);
				}
			
		
		return booster;
	}
	
	public void devolvemeUnBooster()
	{
		this.booster = booster();
	}
	
	
	/*
	 * metodoo que devuelve una coleccion con una lista de cartas de un determinado tipo o rareza
	 */
	public Coleccion<Carta> listaDeTipos (ListaCarta lista, String rare)
	{
		Coleccion<Carta> listaportipo = new Coleccion<Carta>();
		for (Carta aux : lista.getListaCarta().getColeccion()) 
		{
			if (aux.getRareza().equalsIgnoreCase(rare))
			{
				listaportipo.agregar(aux);
			}
		}
		return listaportipo;
	}
	
	@Override
	public ArrayList<Carta> leerArchivo() {
		// TODO Auto-generated method stub
		return super.leerArchivo();
	}
	
	
}
