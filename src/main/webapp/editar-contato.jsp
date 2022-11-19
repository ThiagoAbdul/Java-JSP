<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
%>
<%@ page import="model.Contato, controller.VerificaContato" %>
    <!DOCTYPE html>
    <html lang="pt-br">
    <head>
    <meta charset="UTF-8">
    <link rel="shortcut icon" href="imagens/favicon.ico" type="image/x-icon">
    <link rel="stylesheet" href="estilos/style.css">
    <title>Editar contato</title>
    </head>
    <body>
        <header>
            <p><a href="index.html">Home</a></p>
        </header>
        <h1>Editar contato</h1>
        <main class="principal">
        	<%
	    		Contato contato = (Contato) request.getAttribute("contato");
	    		long id= contato.getId();
	    		String nome = contato.getNome();
	    		String telefone = contato.getTelefone();
	    		String email = contato.getEmail();
    		%>
            <form name="formEditar" action="update" method="get">
                <div class="campos">
                    <label for="id">Id: </label>
                    <input type="text" name="id" id="id" readonly value="<%=id%>">
                </div>
                <div class="campos">
                    <label for="nome">Nome: </label>
                    <input type="text" name="nome" id="nome" required value="<%=nome%>">
                </div>
                <div class="campos">
                    <label for="telefone">Telefone: </label>
                    <input type="text" name="telefone" id="telefone" required value="<%=telefone%>">
                </div>
                <div class="campos">
                    <label for="email">E-mail: </label>
                    <input type="text" name="email" id="email" <%
                    	if(VerificaContato.emailPreenchido(email)){
                    		out.print("value='" + email + "'");
                    	}
                    	%>
                    >
                </div>
                <div class="botao">
                    <input type="button" value="Atualizar" onclick='validar("formEditar")'>
                </div>
            </form>
        </main>
        <p><a class="aparecer" href="contatos">Voltar</a></p>
        <footer>
            <p>&copyThiago Abdul</p>
        </footer>
        <script src="scripts/validar.js"></script>
    </body>
    </html>