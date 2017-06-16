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
	<jsp:include page = "header.jsp" />	
	
	<!-- //< c : import url = "header.jsp" />   teste remover espaço do c-->	
	
	<!-- ### CONTEINER ################################################################################################################### -->
	<c:url var="url" value="/" />
	<div class="container">    
	  <div class="row">
	    <div class="col-sm-6">
	      <div class="panel panel-primary">
	        <div class="panel-heading">-----</div>
	        <div class="panel-body"><a href="${url}professor">
	        	<img class="aligncenter" src="https://placehold.it/300x160?text=IMG1" style="width:100%" alt="Image"></a>
	        </div>
	        <!-- <div class="panel-footer">Buy 50 mobiles and get a gift card</div> //https://placehold.it/300x160?text=IMAGE" class="img-responsive 
	        http://s2.glbimg.com/09mLRUlAJKuH8bHysf3FMFh0DVs=/s.glbimg.com/jo/g1/f/original/2016/06/17/professor-girafales.jpg   width="150" height="225"-->
	      </div>
	    </div>
	    
	    <div class="col-sm-6"> 
	      <div class="panel panel-primary">
	        <div class="panel-heading">-----</div>
	        <div class="panel-body"><a href="${url}disciplina"><img class="alingcenter" src="https://placehold.it/300x160?text=IMG2" class="img-responsive" style="width:100%" alt="DISCIPLINA"></a></div>
	        <!-- <div class="panel-footer">Gerencia as disciplinas (listar, criar, excluir , alterar)</div><!--  -->
	      </div>
	    </div>
	  </div>
	</div>
	<br>
	
	<footer class="container-fluid text-center">
	  <p>Oten Copyright</p>  
	  <form class="form-inline">Get deals:
	    <input type="email" class="form-control" size="50" placeholder="Email Address">
	    <button type="button" class="btn btn-danger">Sign Up</button>
	  </form>
	</footer>
	
	
	
</body>
</html>