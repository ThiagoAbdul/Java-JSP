package controller;

import javax.servlet.http.HttpServletRequest;

import model.Contato;
import util.Formatador;

public class AtualizaContato {
	
	protected Contato getContato(HttpServletRequest request) {
		
		String nome = request.getParameter("nome");
		String nomeFormatado =  Formatador.titulo(nome);
		String telefone = request.getParameter("telefone");
		String email = request.getParameter("email");
		
		if(VerificaContato.emailPreenchido(email)) {
			return new Contato(nomeFormatado, telefone, email);
		}
		
		return new Contato(nomeFormatado, telefone);
		
		
	}

}
