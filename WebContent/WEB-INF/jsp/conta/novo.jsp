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
<title>Tela de Cadastro de Nova Conta</title>
</head>
<body>
Seja bem vindo : ${usuario.login}

    <c:url var="url" value="/conta/salvar" />
    <form:form method="post" modelAttribute="conta" action="${url}">
        Tipo da Conta:<form:select path="tipoConta.id">
          <form:option label="--selecione--" value=""/>
          <form:options items="${contasMap}" />
        </form:select>
        <br />
    	Nome:<form:input path="nome" />
    	<form:hidden path="id" />
    	<form:errors path="nome"/><br />
    	Data de Abertura:<form:input path="dataAbertura" />
    	<br />
    	Debito bloqueado?
    	<form:radiobutton path="debitoBloqueado" label="Sim" value="${true}" />
    	<form:radiobutton path="debitoBloqueado" label="Não" value="${false}" />
    	<input type="submit" value="salvar" />
    </form:form>
</body>
</html>