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
<title>Controle Acadêmico</title>
</head>
<body>
	
	
    <c:url var="url" value="/logar" />
    
    <span style="color: red">${erro}</span>
    
    <form:form method="POST" action="${url}" modelAttribute="usuario">
    	Login:<form:input path="login"/><br />
    	Senha:<form:password path="senha"/><br />
    	<input type="submit" value="Enviar">
    </form:form>
	
</body>
</html>