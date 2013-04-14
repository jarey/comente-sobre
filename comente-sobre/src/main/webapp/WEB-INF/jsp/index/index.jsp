<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link media="screen" rel="stylesheet" type="text/css" href="<c:url value="/resources/css/style.css" />">
	<title>Postar comentario</title>
</head>
<body>
	<div class="box">
		<h2>O que você gostaria de comentar?</h2>
				
		<div class="error"></div>
		
		<form id="form">
			<input type="text" name="descricao" id="descricao" class="descricao" maxlength="100">
			<input type="button" id="enviar" value="Enviar">
		</form>
	</div>
	
	<script type="text/javascript" src="<c:url value="/resources/jquery/jquery-1.9.1.min.js" />"></script>
	<script type="text/javascript" src="<c:url value="/resources/jquery/jquery.validate.js" />"></script>
	<script type="text/javascript" src="<c:url value="/resources/jquery/additional-methods.js" />"></script>		
	<script type="text/javascript" src="<c:url value="js/index.js" />"></script>
</body>
</html>