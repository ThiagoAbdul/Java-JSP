<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@
	page import="model.Contato, 
	java.util.List, java.util.ArrayList"
 %>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
<meta charset="UTF-8">
<link rel="shortcut icon" href="imagens/favicon.ico" type="image/x-icon">
<link rel="stylesheet" href="estilos/style.css">
<title>Agenda de contatos</title>
</head>
<body>
    <header>
        <p><a href="index.html">Home</a></p>
    </header>
	<h1>Agenda de contatos</h1>
	<p><a href="novo-contato.html">Novo contato</a></p>
		
		<%@include file="tabela-contatos.jsp"%>
 
    <footer>
        <p>&copyThiago Abdul</p>
    </footer>
	<script src="scripts/ordenar.js"></script>
    <script src="scripts/confirmaExclusao.js"></script>
</body>
</html>