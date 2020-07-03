package Usuarios;

import java.io.Serializable;

import colecciones.ListaCarta;
import colecciones.ListaMazos;
import colecciones.Mazo;
import exception.ListaMazosException;

public class Usuario implements Serializable{
	
	public static int idValor = 1;
	private String idUsuario;
	private String nombreUsuario;
	private String contrasenya;
	private Mazo mazo;
	private ListaCarta miListaCartas;
	private ListaMazos miListaMazos;
	private int monedas;
	
	public Usuario() throws ListaMazosException
	{
		idUsuario = (String.valueOf(aumentarValorId()));
		setNombreUsuario("");
		setContrasenya("");
		setListaCartas();
		setMonedas(20);
		setMazoInicial();
		setListaCartas(getMilistaCartas().generarListaSeteadaUser());
		setMiListaMazos();
		getMiListaMazos().agregarMazo(this.mazo.getNombre(),getMazoActivo());
	}
	
	public Usuario (String nombreUsuario , String contrasenya) throws ListaMazosException
	{
		idUsuario = (String.valueOf(aumentarValorId()));
		setNombreUsuario(nombreUsuario);
		setContrasenya(contrasenya);
		setListaCartas();
		setMonedas(20);
		setMazoInicial();	// no comprueba con la lista de cartas o tendria que pasarsela para que la setee con las cartas de ahi
		setListaCartas(getMilistaCartas().generarListaSeteadaUser());
		setMiListaMazos();
		getMiListaMazos().agregarMazo(this.mazo.getNombre(),getMazoActivo());
	}
	
	public void setMazoInicial() {
		this.mazo = new Mazo();
	}
	
	public void setMazo(Mazo mazo) {
		this.mazo = mazo;
	}
	
	public void setMiListaMazos()
	{
		this.miListaMazos = new ListaMazos();
	}
	
	public ListaMazos getMiListaMazos() {
		return miListaMazos;
	}
	
	public int aumentarValorId() {
		return idValor++;
	}
	
	public void setListaCartas() {
		this.miListaCartas = new ListaCarta();
	}
	
	public void setListaCartas(ListaCarta lista) {
		this.miListaCartas = lista;
	}

	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}
	
	public void setMonedas(int monedas) {
		this.monedas = monedas;
	}
	
	public ListaCarta getMilistaCartas() {
		return miListaCartas;
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
	public Mazo getMazoActivo() {
		return mazo;
	}
	
	public int getMonedas() {
		return monedas;
	}
	
	
	@Override
	public boolean equals(Object obj) {
		boolean existencia = false;
		if(obj instanceof Usuario)
		{
			Usuario aux = (Usuario) obj;
			if(aux.getNombreUsuario().equals(this.getNombreUsuario()))
			{
				if(aux.getContrasenya().equals(this.getContrasenya()))
				{
					existencia = true;
				}
			}
		}
		return existencia;
	}
	
	@Override
	public int hashCode() {
		return 0;
	}
	
	@Override
	public String toString() {
		return "[idUsuario=" + idUsuario + ", nombreUsuario=" + nombreUsuario + ", contrasenya=" + contrasenya  + ", Monedas=" + monedas  +"]";
	}
}