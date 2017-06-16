<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ page language="java" pageEncoding="UTF-8" session="false"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>	
	<meta charset="utf-8">
	<title>Controle Acadêmico</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
	<style>
	    /* Remove the navbar's default rounded borders and increase the bottom margin */ 
	    .navbar {
	      margin-bottom: 50px;
	      border-radius: 0;
	    }
	    
	    /* Remove the jumbotron's default bottom margin */ 
	     .jumbotron {
	      margin-bottom: 0;
	    }
	   
	    /* Add a gray background color and some padding to the footer */
	    footer {
	      background-color: #f2f2f2;
	      padding: 25px;
	    }
	  </style>
</head>
<body>
	
	<!-- ### MENU ####################################################################################################################### -->
	<jsp:include page = "../header.jsp" />		
	
	<!-- ### CONTEINER ################################################################################################################### -->    
    <c:url var="url" value="/turma" /> 
	<legend>Turmas</legend>
	
    <span style="color: red">${erro}</span>
    <span style="color: green">${mensagem}</span>
     
    <div class="row item-margem">
    	<div class="col-md-1">
    		<a href="${url}/new"><button type="button" class="btn btn-primary">Novo</button></a>    	
    	</div>
    </div>
    
    <table class="table table-striped " style="margin:auto"> <!--    table-responsive-inverse -->
		<thead class="table-inverse">
			<tr>
				<th>#</th>
				<th>Ano</th>
				<th>Semestre</th>
				<th>Professor</th>
				<th></th>
			</tr>		
		</thead>
		<tbody>
		<c:forEach var="turma" items="${turmas}">
			<tr>
				<td>${turma.id}</td>
				<td>${turma.ano}</td>				
				<td>${turma.semestre}</td>		
				<td>${turma.professor.nome}</td>
				<td>
					<a href="${url}/${turma.id}/update"><button type="button" class="btn btn-warning">Editar</button></a>
					<!-- <a href="${url}/${turma.id}/excluir"><button type="button" class="btn btn-warning">Excluir</button></a> -->
				</td> 
				
			</tr>
		</c:forEach>
		</tbody>
	</table>
</body>
</html>