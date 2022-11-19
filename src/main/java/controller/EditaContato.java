package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Contato;
import model.ContatoDAO;

public class EditaContato extends AtualizaContato implements ProcessaServlet{

	@Override
	public void responder(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		Contato contato = getContato(request);
		ContatoDAO.editar(contato);
		response.sendRedirect("contatos");
	}
	
	@Override
	protected Contato getContato(HttpServletRequest request) {
		long id = Long.parseLong(request.getParameter("id"));
		Contato contato = super.getContato(request);
		
		contato.setId(id);
		
		return contato;
	}

}
