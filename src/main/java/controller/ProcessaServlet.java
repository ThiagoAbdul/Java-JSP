package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ProcessaServlet {
	

	public abstract void responder(HttpServletRequest request, HttpServletResponse response) 
			throws IOException, ServletException;

}
