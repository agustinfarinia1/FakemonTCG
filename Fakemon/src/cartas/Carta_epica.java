package cartas;

import interfaces.Atacar;

public  class Carta_epica extends Carta implements Atacar{

	public int ataqueEspecial1;
	public int ataqueEspecial2;

	
	public Carta_epica(int id_Carta, String nombre_Carta) 
	{
		super(id_Carta, nombre_Carta, "epico");
		ataqueEspecial1 = ataqueEspecial(3,1);	
		ataqueEspecial2 = ataqueEspecial(5,3);	
	}
	
	
	

	public int getAtaqueEspecial1() 
	{
		return ataqueEspecial1;
	}
	
	public int ataqueEspecial (int max, int min)
	{	
		int value = getRandomInt(max, min);
		return value;
	}
	
	
	@Override
	public int tirarDados() 
	{
		int dado =(int)(Math.random() * (6 - 1 + 1) + 1);
		return dado;
	}

	@Override
	public String toString() {
		return super.toString() + "ataqueEspecial 1= " + ataqueEspecial1 + "\nataqueEspecial 2= " + ataqueEspecial2;
	}

	
}
