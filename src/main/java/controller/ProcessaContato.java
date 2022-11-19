package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Contato;
import model.ContatoDAO;

public class ProcessaContato implements ProcessaServlet {

	public ProcessaContato() {
		super();
		
	}

	@Override
	public void responder(HttpServletRequest request, HttpServletResponse response) 
			throws IOException, ServletException {
		
		List<Contato> contatos = ContatoDAO.listar();
		request.setAttribute("contatos", contatos);
		RequestDispatcher rd = request.getRequestDispatcher("contatos.jsp");
		rd.forward(request, response);
		
	}
	
	

}
