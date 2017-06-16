<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Tela de Listagem de Contas</title>
</head>
<body>
Seja bem vindo : ${usuario.login}
<c:url var="url" value="/logout" />
	<a href='${url}'>Logout</a>
<br />
<br />
<br />
<br />
	
    <c:url var="url" value="/conta/novo" />
	<a href='${url}'>Novo</a>
	<br />
	<c:url var="url" value="/conta/filtrar" />
	<form:form action="${url}" method="get" modelAttribute="filtro">
		Nome:<form:input path="nome" /> 
		Tipo de Conta:
		<form:select path="tipoConta.id">
        <form:option label="--selecione--" value=""/>
        <form:options items="${contasMap}" />
        <input type="submit" value="pesquisar">
        </form:select> 
	</form:form>
	<br />
		${mensagem}
	<br />
	<table>
		<tr>
			<td>Tipo da Conta</td>
			<td>Nome</td>
			<td>Data de Abertura</td>
			<td>Data de Fechamento</td>
			<td>Débito bloqueado</td>
			<td>Açoes</td>
		</tr>

		<c:forEach var="conta" items="${contas}">
			<tr>
				<td>${conta.tipoConta.nome}</td>
				<td>${conta.nome}</td>
				<td><fmt:formatDate pattern="dd/MM/yyyy" value="${conta.dataAbertura}"/></td>
				<td><fmt:formatDate pattern="dd/MM/yyyy" value="${conta.dataFechamento}"/></td>
				<td>${conta.debitoBloqueado ? 'sim' : 'não' }</td>
				<td>
					<c:url var="url" value="/conta/${conta.id}/update" />
					<a href="${url}/">editar</a>
					<c:url var="url" value="/conta/${conta.id}/excluir" />
					<a href="${url}/">excluir</a>				
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>