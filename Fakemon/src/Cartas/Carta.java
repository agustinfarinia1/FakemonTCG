package Cartas;

import java.lang.String;
import java.lang.Math;


public  class Carta {

	private int id_Carta;
	private String nombre_Carta;
	private String rareza;
	private int vida;
	private int ataqueBase;
	

	public Carta (int id_Carta, String nombre_Carta, String rareza) 
	{
		this.id_Carta = id_Carta;
		this.nombre_Carta = nombre_Carta;
		this.rareza = rareza;
		this.vida = set_PV(rareza);
		this.ataqueBase = set_AtaqueBasico(rareza);
		
		
	}

	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}

	public int getAtaqueBase() {
		return ataqueBase;
	}

	public void setAtaqueBase(int ataqueBase) {
		this.ataqueBase = ataqueBase;
	}
	
	public int getId_Carta() {
		return id_Carta;
	}
	public void setId_Carta(int id_Carta) {
		this.id_Carta = id_Carta;
	}
	public String getNombre_Carta() {
		return nombre_Carta;
	}
	public void setNombre_Carta(String nombre_Carta) {
		this.nombre_Carta = nombre_Carta;
	}
	
	public String getRareza() {
		return rareza;
	}
	public void setRareza(String rareza) {
		this.rareza = rareza;
	}
	
	
	
	public int set_PV (String rareza) {
		
		String basico = "basico";
		String epico = "epico";
		String legendario = "legendario";
		int pv = 0 ;
		
		if (rareza.equals(basico))
		{
			pv = getRandomInt(10, 8);
		}
		if (rareza.equals(epico))
		{
			pv = getRandomInt(15, 10);
		}
		if (rareza.equals(legendario))
		{
			pv = getRandomInt(20, 15);
		}
		
		return pv;
	}
	
	
	public int set_PV()
	{
		return vida;
	}
	
	
	
		public int set_AtaqueBasico (String rareza) { /// recibimos una carta, averiguamos de que tipo es usando equals para poder asignarle un valor al ataque
		
		int atk = 0 ;
		String cartaBasica = "basico";
		String cartaEpica = "epico";
		String cartaLegendaria = "legendario";
		
		if (cartaBasica.equals(rareza))
		{
			atk = getRandomInt(2, 1);
		}
		if (cartaEpica.equals(rareza))
		{
			atk = getRandomInt(3, 1);
		}
		if (cartaLegendaria.equals(rareza))
		{
			atk = getRandomInt(4, 1);
		}
		
		return atk;
	}
		
	////			METODOS AUXILIARES		////
	public int getRandomInt(int max, int min) /// METODOS QUE DEVUELVE MULTIPLOS DE 10 (PASAR VALORES ENTRE 1 Y 20) 
	{
		int aux = (int)(Math.random() * (max - min + 1) + min);
		int pv = (aux * 10);
		return pv;
	}


	@Override
	public String toString() {
		return "\n"+"id_Carta = " + id_Carta + "\nnombre_Carta = " + nombre_Carta + "\nvida = "+ vida + "\nataqueBase = " + ataqueBase+ "\n";
	}

}
