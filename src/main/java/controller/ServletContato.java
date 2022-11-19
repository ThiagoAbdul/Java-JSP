package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/ServletContato", "/contatos", "/insert", "/select", "/update", "/delete"})
public class ServletContato extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public ServletContato() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String servletPath = request.getServletPath();

		ProcessaServlet processo = ProcessaServletFactory.getProcessaServlet(servletPath);
		processo.responder(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
