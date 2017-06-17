<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html; charset=iso-8859-1" pageEncoding="iso-8859-1"%>
<html>
    <head>
    	<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1"/>
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
    <c:url var="url" value="/aluno" /> 
	<legend>
		
		<!-- define de é cadastro ou atualização -->
		<c:choose>
			<c:when test="${aluno.id > 0}">
			  Professor Alteração 
			</c:when>
			<c:otherwise>
			  Professor Cadastro 
			</c:otherwise>
		</c:choose>
		
	</legend>
	
    <span style="color: red">${erro}</span>
	
	<c:url var="url" value="/aluno/save" />
	<form class="form-horizontal" method="post" action="${url}"  modelAttribute="aluno">
		<fieldset>
					
		 <input id="id" name="id" value="${aluno.id}" type="hidden" >
		  
		
		<!-- Text input-->
		<div class="form-group">
		  <label class="col-md-4 control-label" for="nome">Nome</label>  
		  <div class="col-md-4">
		  <input id="nome" name="nome" value="${aluno.nome}" type="text" placeholder="Nome" class="form-control input-md" required="">
		  </div>
		</div>
		
		<!-- Text input-->
		<div class="form-group">
		  <label class="col-md-4 control-label" for="matricula">Mátricula</label>  
		  <div class="col-md-4">
		  <input id="matricula" name="matricula" value="${aluno.matricula}" type="text" placeholder="número matricula" class="form-control input-md" required="">
		  </div>
		</div>		
		
		
		
		<!-- Text input-->
		<div class="form-group">
		  <label class="col-md-4 control-label" for="login">Login</label>  
		  <div class="col-md-4">
		  <input id="login" name="login" value="${aluno.login}" type="text" placeholder="login" class="form-control input-md" required="">
		  </div>
		</div>
		
		<!-- Text input-->
		<div class="form-group">
		  <label class="col-md-4 control-label" for="senha">Senha</label>  
		  <div class="col-md-4">
		  <input id="senha" name="senha" value="${aluno.senha}" type="password" placeholder="senha" class="form-control input-md" required="">
		  </div>
		</div>
		
		<!-- Text input-->
		<div class="form-group">
		  <label class="col-md-4 control-label" for="matricula">Endereço</label>  
		  <div class="col-md-4">
		  <!-- <input id="matricula" name="matricula" value="${aluno.matricula}" type="text" placeholder="número matricula" class="form-control input-md" required=""> -->
		  </div>
		</div>
		
		
		<!-- Button -->
		<div class="form-group">
		  <label class="col-md-4 control-label" for="singlebutton"></label>
		  <div class="col-md-4">
		    <button id="singlebutton" name="singlebutton" class="btn btn-primary">
		    	<!-- define de é cadastro ou atualização -->
				<c:choose>
					<c:when test="${aluno.id > 0}">
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