package colecciones;
////////////////////////////////////////////////////////////////////////////
import java.util.Collections;
import cartas.Carta;

public class Booster {
	
	public Booster() {
		super();
	}
	
	/**
	 * Metodo que genera automaticamente un booster con 7 cartas (1 legendaria, 2 epicas, 4 basicas)
	 * las tiene que traer del archivo de cartas
	 * devuelve una coleccion con las cartas aleatorias
	 * @param lista
	 * @return Coleccion<Carta>
	 */
	
	public Coleccion<Carta> booster (ListaCarta lista)
	{
		Coleccion<Carta> booster = new Coleccion<Carta>();
		Coleccion<Carta> arrayB = new Coleccion<Carta>();
		arrayB = listaDeTipos(lista, "basico");
		Coleccion<Carta> arrayE = new Coleccion<Carta>();
		arrayE = listaDeTipos(lista, "epico");
		Coleccion<Carta> arrayL = new Coleccion<Carta>();
		arrayL = listaDeTipos(lista, "legendario");
		Carta aux;
		for (int i=0; i<1; i++)
		{
			Collections.shuffle(arrayB.getColeccion());
			aux = arrayB.getColeccion().get(0);
			booster.agregar(aux);
			
			for (int j=0; j<2; j++)
			{
				Collections.shuffle(arrayE.getColeccion());
				aux = arrayE.getColeccion().get(0);
				booster.agregar(aux);
				
				for (int k=0; k<4; k++)
				{
					Collections.shuffle(arrayL.getColeccion());
					aux = arrayL.getColeccion().get(0);
					booster.agregar(aux);
				}
			}
		}
		return booster;
	}
	
	/**
	 * 
	 * Metodo que devuelve una coleccion con una lista de cartas de un determinado tipo o rareza
	 *
	 * @param ListaCarta lista
	 * @param String rare
	 * @return Coleccion<Carta>
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
		System.out.println("saca esto");
		return listaportipo;
		
	}
}
