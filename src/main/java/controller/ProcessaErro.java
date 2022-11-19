package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProcessaErro implements ProcessaServlet {

	@Override
	public void responder(HttpServletRequest request, HttpServletResponse response) 
			throws IOException, ServletException {
		response.sendRedirect("pagenotfound.html");

	}

}
