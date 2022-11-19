package controller;

public class ProcessaServletFactory {
	
	public static ProcessaServlet getProcessaServlet(String path) {
		switch(path) {
			case "/contatos":
				return new ProcessaContato();
			case "/insert":
				return new ProcessaCadastro();
			case "/select":
				return new BuscaContato();
			case "/update":
				return new EditaContato();
			case "/delete":
				return new DeletaContato();
			default:
				return new ProcessaErro();
		}
	}

}
