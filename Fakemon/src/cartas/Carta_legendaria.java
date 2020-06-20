package cartas;

import interfaces.Atacar;

public  class Carta_legendaria extends Carta implements Atacar{

	public int ataqueEspecial1;
	public int ataqueEspecial2;
	public int ataqueEspecial3;
	
	
	public Carta_legendaria(int id_Carta, String nombre_Carta) 
	{
		super(id_Carta, nombre_Carta, "legendario");
		ataqueEspecial1 = ataqueEspecial(3,1);	
		ataqueEspecial2 = ataqueEspecial(5,3);	
		ataqueEspecial3 = ataqueEspecial(10,5);	
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
		return super.toString() + "ataqueEspecial 1= " + ataqueEspecial1 + "\nataqueEspecial 2= " + ataqueEspecial2 + "\nataqueEspecial 3= " + ataqueEspecial3;
	}
	
}
