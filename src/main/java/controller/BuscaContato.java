package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Contato;
import model.ContatoDAO;


public class BuscaContato implements ProcessaServlet{

	@Override
	public void responder(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		long id = Long.parseLong(request.getParameter("id"));
		Contato contato = ContatoDAO.buscarContato(id);
		
		if(VerificaContato.encontrouContato(contato)) {
			request.setAttribute("contato", contato);
			RequestDispatcher rd = request.getRequestDispatcher("editar-contato.jsp");
			rd.forward(request, response);
		}
	}

}
