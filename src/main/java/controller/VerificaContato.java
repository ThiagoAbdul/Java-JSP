package controller;

import model.Contato;

public class VerificaContato {
	
	public static boolean emailPreenchido(String email) {
		return email != null && email != "";
	}
	
	public static boolean encontrouContato(Contato contato) {
		return contato != null;
	}
	
	public static boolean temId(long id) {
		return id > 0;
	}
}
