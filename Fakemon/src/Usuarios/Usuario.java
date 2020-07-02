package Usuarios;

import cartas.Carta;
import colecciones.Coleccion;
import colecciones.Mazo;

public class Usuario {
	
	private String idUsuario;
	private String nombreUsuario;
	private String contrasenya;
	private Mazo mazo;
	private Coleccion<Carta> milistaCartas;
	
	public Usuario()
	{
		setListaCartas();
	}
	
	public Usuario (String nombreUsuario , String contrasenya)
	{
		this.nombreUsuario = nombreUsuario;
		this.contrasenya = contrasenya;
	}
	
	public Usuario(String idUsuario, String nombreUsuario, String contrasenya, Mazo mazo) {
		super();
		this.idUsuario = idUsuario;
		this.nombreUsuario = nombreUsuario;
		this.contrasenya = contrasenya;
		this.mazo = mazo;
	}
	
	private void setListaCartas() {
		this.milistaCartas = new Coleccion<Carta>();
	}
	
	public Coleccion<Carta> getMilistaCartas() {
		return milistaCartas;
	}
	
	public String getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
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
	public void setMazo(Mazo mazo) {
		this.mazo = mazo;
	}

	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", nombreUsuario=" + nombreUsuario + ", contrasenya=" + contrasenya
				+ ", mazo=" + mazo + "]";
	}
}


