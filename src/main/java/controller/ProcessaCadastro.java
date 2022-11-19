package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Contato;
import model.ContatoDAO;

public class ProcessaCadastro extends AtualizaContato implements ProcessaServlet {

	@Override
	public void responder(HttpServletRequest request, HttpServletResponse response) 
			throws IOException, ServletException {
		
		Contato contato = getContato(request);
		
		ContatoDAO.cadastrar(contato);
		response.sendRedirect("contatos");
	}
	
	
	
	

}
