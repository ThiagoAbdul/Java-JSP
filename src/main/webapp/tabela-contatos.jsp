<%@page import="java.io.IOException"%>
<%@page import="java.util.function.Consumer"%>
<%@page import="org.apache.catalina.connector.Response"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
%>
<%@ page import="java.util.List, java.util.ArrayList" %>
<%@ page import="model.Contato, controller.VerificaContato, model.ContatoDAO" %>

<%!
	public String insereEmail(String email){
		String html;
		if(VerificaContato.emailPreenchido(email)){
			html = "<td>" + email + "</td>";
		}
		else {
			html = "<td style='text-align: center;'> - </td>";
		}
		return html;
	}

	public boolean listaVazia(List<Contato> lista){
		if (lista == null) return true;
		return lista.size() == 0;
	}
%> 

	<%	@SuppressWarnings("unchecked")
		List<Contato> contatos = (ArrayList<Contato>)request.getAttribute("contatos");

		long id;
		String nome;
		String telefone;
		String email;
		

		if(listaVazia(contatos)){
			out.println("<p>Sem contatos por enquanto</p>");
		}
		else {
			%>
			<div id="tabela">
			    <table class="principal">     
					<thead>
						<tr>
							<th scope="col" id="id" onclick="ordenar(0)">Id
							<th scope="col" id="nome" onclick="ordenar(1)">Nome
							<th scope="col" id="telefone" onclick="ordenar(2)">Telefone
							<th scope="col" id="email" onclick="ordenar(3)">E-mail
							<th scope="col" colspan="2">Ações
						</tr>
					</thead>
					<tbody>
						<%
							String linha;
							for (Contato contato : contatos){
								id = contato.getId();
								nome = contato.getNome();
								telefone = contato.getTelefone();
								email = contato.getEmail();
								%>
									<tr>
										<td><%=id%></td>
										<td><%=nome%></td>
										<td><%=telefone%></td>
										<%=insereEmail(email)%>
										<td>
											<a href='select?id=<%=id%>'>
												<img src='imagens/editar.png' alt="Editar">
											</a>
										</td>
										<td>
											<img src='imagens/deletar.png' alt="Deletar" onclick='confirmaExclusao("<%=nome%>", <%=id%>)'>
										</td>
									</tr>
								<%
							}
						%>
					</tbody>
			    </table>
			</div>
		<%
		}
	%>



