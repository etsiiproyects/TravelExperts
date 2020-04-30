<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Music Experts</title>
	<link rel="stylesheet" type="text/css" href="../css/results.css">
	
	<link href="https://fonts.googleapis.com/css2?family=Fjalla+One&display=swap" rel="stylesheet">
</head>
<body>
	
	<nav>
        <ul>
            <li><img src="images/logo96x96.png" alt="Logo Travel Experts"></li>
            <li class="nav_bottom"><a href="index.html">Volver</a></li>
		</ul>
	</nav>
	

	<div class="contenido">
		<div class="gcalendar">
			<h1> Eventos: </h1>
			<div class="info">
				<c:forEach items="${requestScope.eventos}" var="evento">
					<div class="gcalendar-evento">
						<span>Nombre:<c:out value="${evento.summary}"/></span>
					</div>
				</c:forEach>	
			</div>
		</div>
	</div>
</body>
</html>