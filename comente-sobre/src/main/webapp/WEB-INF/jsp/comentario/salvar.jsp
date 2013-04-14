<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Comentários</title>
	<link media="screen" rel="stylesheet" type="text/css" href="<c:url value="/resources/css/style.css" />">	
</head>
<body>
	<div class="box">
		<h2>Comentários</h2>
			
		<div class="content">
			<c:forEach items="${comentarioList}" var="comentario">
				<div class="comment">
					<div class="email"><c:out value="${comentario.email}" /></div>
					<div class="description"><c:out value="${comentario.texto}" /></div>
				</div>
			</c:forEach>
		</div>
	</div>
	<center>	
		<a href="<c:url value="/" />">voltar</a>
	</center>	
</body>
</html>