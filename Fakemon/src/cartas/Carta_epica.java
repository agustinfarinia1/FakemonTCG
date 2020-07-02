package cartas;

import interfaces.IAtacar;

public  class Carta_epica extends Carta implements IAtacar{

	private int ataqueEspecial1;
	private int ataqueEspecial2;

	
	public Carta_epica(int id_Carta, String nombre_Carta) 
	{
		super(id_Carta, nombre_Carta, "epico");
		ataqueEspecial1 = ataqueEspecial(3,1);	
		ataqueEspecial2 = ataqueEspecial(5,3);	
	}
	
	public Carta_epica()
	{
		
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
	
	
	
	public int getAtaqueEspecial2() {
		return ataqueEspecial2;
	}

	public void setAtaqueEspecial2(int ataqueEspecial2) {
		this.ataqueEspecial2 = ataqueEspecial2;
	}

	public void setAtaqueEspecial1(int ataqueEspecial1) {
		this.ataqueEspecial1 = ataqueEspecial1;
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
