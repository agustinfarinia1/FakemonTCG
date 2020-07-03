package Usuarios;

import java.io.Serializable;
import java.util.HashMap;

import exception.UserException;

public class ListaUsuarios implements Serializable{

	HashMap<String, Usuario> listaUser;

	public HashMap<String, Usuario> getListaUser() {
		return listaUser;
	}

	public void setListaUser(HashMap<Integer, Usuario> listaUser) {
		//this.listaUser = listaUser;
	}
	
	public void AgregarUsuario (Usuario nuevo) throws UserException
	{
		if (!listaUser.containsKey(nuevo.getIdUsuario()))
		{
			listaUser.put(nuevo.getIdUsuario(), nuevo);
		}
		else
		{
			throw new UserException("El ingresado");
		}
		
	}
	
	
}
