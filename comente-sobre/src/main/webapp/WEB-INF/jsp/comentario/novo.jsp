<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Novo Comentário</title>
<link media="screen" rel="stylesheet" type="text/css" href="<c:url value="/resources/css/style.css" />">
</head>
<body>
	<div class="box">
		<h2>Comentário</h2>

		<div class="error"></div>
		<form name="form" id="form" action="comentarios" method="post">
			<div>
				<label for="email">E-mail: </label><input type="text" id="email" class="email" size="40" maxlength="100" name="comentario.email" />
			</div>
			<div>
				<label for="texto">Comentário: </label><textarea rows="4" cols="90" maxlength="400" id="texto" name="comentario.texto"></textarea>
			</div>
			<input type="hidden" id="assunto" name="comentario.assunto" value="${comentario.assunto}">
			<div> 
				<input type="submit" value="Enviar">
			</div>				
		</form>
	</div>

	<script type="text/javascript" src="<c:url value="/resources/jquery/jquery-1.9.1.min.js" />"></script>
	<script type="text/javascript" src="<c:url value="/resources/jquery/jquery.validate.js" />"></script>
	<script type="text/javascript" src="<c:url value="/resources/jquery/additional-methods.js" />"></script>	
	
	<script type="text/javascript" src="<c:url value="js/novo.js" />"></script>	
</body>
</html>