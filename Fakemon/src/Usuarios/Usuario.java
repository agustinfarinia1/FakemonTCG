package Usuarios;

import colecciones.ListaCarta;
import colecciones.Mazo;

public class Usuario {
	
	public static int idValor = 1;
	private String idUsuario;
	private String nombreUsuario;
	private String contrasenya;
	private Mazo mazo;
	private ListaCarta milistaCartas;
	private int monedas;
	
	public Usuario()
	{
		idUsuario = (String.valueOf(aumentarValorId()));
		setNombreUsuario("");
		setContrasenya("");
		setListaCartas();
		setMonedas(20);
		setMazo();
		milistaCartas = getMilistaCartas().generarListaSeteadaUser();
	}
	
	public Usuario (String nombreUsuario , String contrasenya)
	{
		idUsuario = (String.valueOf(aumentarValorId()));
		setNombreUsuario(nombreUsuario);
		setContrasenya(contrasenya);
		setListaCartas();
		setMonedas(20);
		setMazo();
		milistaCartas = getMilistaCartas().generarListaSeteadaUser();
	}
	
	public Usuario(String nombreUsuario, String contrasenya, Mazo mazo) {
		idUsuario = (String.valueOf(aumentarValorId()));
		setNombreUsuario(nombreUsuario);
		setContrasenya(contrasenya);
		setListaCartas();
		setMonedas(20);
		setMazo(mazo);
		milistaCartas = getMilistaCartas().generarListaSeteadaUser();
	}
	
	
	private void setMazo() {
		this.mazo = new Mazo();
	}
	
	private void setMazo(Mazo mazo) {
		this.mazo = mazo;
	}
	
	private int aumentarValorId() {
		return idValor++;
	}
	
	private void setListaCartas() {
		this.milistaCartas = new ListaCarta();
	}
	
	private void setListaCartas(ListaCarta lista) {
		this.milistaCartas = lista;
	}

	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}
	
	public void setMonedas(int monedas) {
		this.monedas = monedas;
	}
	
	public ListaCarta getMilistaCartas() {
		return milistaCartas;
	}
	
	public String getIdUsuario() {
		return idUsuario;
	}
	
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public String getContrasenya() {
		return contrasenya;
	}
	public void setContrasenya(String contrasenya) {
		this.contrasenya = contrasenya;
	}
	public Mazo getMazo() {
		return mazo;
	}
	
	public int getMonedas() {
		return monedas;
	}
	
	@Override
	public String toString() {
		return "[idUsuario=" + idUsuario + ", nombreUsuario=" + nombreUsuario + ", contrasenya=" + contrasenya + mazo + "]";
	}
}


