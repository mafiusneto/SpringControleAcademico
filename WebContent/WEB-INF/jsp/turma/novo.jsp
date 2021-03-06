<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html; charset=iso-8859-1" pageEncoding="iso-8859-1"%>
<html>
    <head>
    	<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1"/>
		<title>Controle Acad�mico</title>
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
	<legend>
		
		<!-- define de � cadastro ou atualiza��o -->
		<c:choose>
			<c:when test="${turma.id > 0}">
			  Turma Altera��o 
			</c:when>
			<c:otherwise>
			  Turma Cadastro 
			</c:otherwise>
		</c:choose>
		
	</legend>
	
    <span style="color: red">${erro}</span>
	
	<c:url var="url" value="/turma/save" />
	
	<!-- FORMULARIO #####################################################################  -->
	<form class="form-horizontal" method="post" action="${url}"  modelAttribute="turma">
		<fieldset>
					
		 <input id="id" name="id" value="${turma.id}" type="hidden" >
		  
		
		<!-- Text input-->
		<div class="form-group">
		  <label class="col-md-4 control-label" for="ano">Ano</label>  
		  <div class="col-md-4">
		  <input id="ano" name="ano" value="${turma.ano}" type="text" placeholder="ano" class="form-control input-md" required="">
		  </div>
		</div>
		
		<!-- Text input-->
		<div class="form-group">
		  <label class="col-md-4 control-label" for="semestre">Semestre</label>  
		  <div class="col-md-4">
		  <input id="semestre" name="semestre" value="${turma.semestre}" type="text" placeholder="descri��o semestre" class="form-control input-md" required="">
		  </div>
		</div>
		
		
		<!-- PROFESSORES ########################################################################################## -->
		<div class="form-group">
		  <label class="col-md-4 control-label" for="professor">Professor</label>  
		  <div class="col-md-4">		  	  
			<c:forEach var="professor" items="${professores}">
				<div class="radio">
				  <label>
				  	<input type="radio" id="profId" name="profId" value="${professor.id}" required="required" 
					  <c:if test="${turma.professor.id == professor.id}">
						  checked
					  </c:if>
				  >${professor.nome} - ${professor.matricula}</label>
				</div>
			</c:forEach>
		  </div>
		</div>
		
		
		<!-- DISCIPLINAS ########################################################################################## -->
		<div class="form-group">
		  <label class="col-md-4 control-label" for="disciplina">Disciplina</label>  
		  <div class="col-md-4">		  	  
			<c:forEach var="disciplina" items="${disciplinas}">
				<div class="radio">
				  <label>
				  	<input type="radio" id="disciplinaId" name="disciplinaId" value="${disciplina.id}" required="required" 
					  <c:if  test="${turma.disciplina.id == disciplina.id}">
						  checked
					  </c:if>
				  >${disciplina.nome} - ${disciplina.id}</label>
				</div>
			</c:forEach>
		  </div>
		</div>
		
		
		
		<!-- Button -->
		<div class="form-group">
		  <label class="col-md-4 control-label" for="singlebutton"></label>
		  <div class="col-md-4">
		    <button id="singlebutton" name="singlebutton" class="btn btn-primary">
		    	<!-- define de � cadastro ou atualiza��o -->
				<c:choose>
					<c:when test="${turma.id > 0}">
					  Alterar 
					</c:when>
					<c:otherwise>
					  Cadastrar 
					</c:otherwise>
				</c:choose>
		    </button>
		  </div>
		</div>
		
		</fieldset>
	</form>
</body>
</html>