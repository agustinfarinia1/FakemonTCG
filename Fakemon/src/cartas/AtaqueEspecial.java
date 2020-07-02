package cartas;

public class AtaqueEspecial extends Ataque{
	private int valor_dado;
	
	public AtaqueEspecial(){
		super();
		valor_dado = 0;
	}
	
	public AtaqueEspecial(String _nombre_ataque,int _poder_ataque,int _costo,int _valor_dado){
		super(_nombre_ataque,_poder_ataque);
		valor_dado = _valor_dado;
		setPoder_ataque(_poder_ataque);
		setCosto(_costo);
	}

	public int getValor_dado() {
		return valor_dado;
	}
	public void setValor_dado(int valor_dado) {
		this.valor_dado = valor_dado;
	}

	@Override
	public String toString() {
		return super.toString() + "| valor_dado = " + valor_dado + " ]" ;
	}
	
	
}
