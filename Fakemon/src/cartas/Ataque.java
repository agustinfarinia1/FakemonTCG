package cartas;

public class Ataque {
	private String nombre_ataque;
	private int poder_ataque;
	private int costo;
	
	public Ataque()
	{
		nombre_ataque = "";
		poder_ataque = 0;
		costo = 0;
	}
	public Ataque(String _nombre_ataque,int _poder_ataque) {	// para el ataque especial
		nombre_ataque = _nombre_ataque;
		poder_ataque = _poder_ataque;
	}
	public Ataque(String _nombre_ataque,int _poder_ataque,int _costo) {
		nombre_ataque = _nombre_ataque;
		poder_ataque = _poder_ataque;
		costo = _costo;
	}
	
	/*
	 * 	Getters y Setters de Ataque
	 */
	
	public String getNombre_ataque() {
		return nombre_ataque;
	}
	public void setNombre_ataque(String nombre_ataque) {
		this.nombre_ataque = nombre_ataque;
	}
	public int getPoder_ataque() {
		return poder_ataque;
	}
	public void setPoder_ataque(int poder_ataque) {
		this.poder_ataque = poder_ataque;
	}
	public int getCosto() {
		return costo;
	}
	public void setCosto(int costo) {
		this.costo = costo;
	}
	
	@Override
	public String toString() {
		return "[ nombre_ataque = " + nombre_ataque + "| poder_ataque = " + poder_ataque + "| costo = " + costo + " ]";
	}
	
}
