package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ContatoDAO;

public class DeletaContato extends AtualizaContato implements ProcessaServlet{

	@Override
	public void responder(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
			
		long idContato = Long.parseLong(request.getParameter("id"));
		ContatoDAO.deletar(idContato);
		
		response.sendRedirect("contatos");
		
	}

}
