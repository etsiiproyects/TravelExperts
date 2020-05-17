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
		<div class="ticketmaster">
			<h1> Eventos </h1>
			<div class="info">
			<c:forEach items="${requestScope.tickets.events}" var="ticket">
				<div class="tmaster-info">
					<span>Evento: <c:out value="${ticket.name}"/></span><br/>
					<span>Fecha: <c:out value="${ticket.dates.start.localDate}"/></span><br/>
					<span>Hora: <c:out value="${ticket.dates.start.localTime}"/></span><br/>
					<span>Direccion: <c:out value="${ticket.embedded.venues[0].address.line1}"/></span><br/>
					<img class="img-tm" src="${ticket.images[0].url}">
				</div>	
			</c:forEach>
			</div>
		</div>
		<div class="spotify">
		<% if (request.getAttribute("spot").toString()=="true") { %>
			
				<h1> Top canciones: </h1>
				<div class="info">
				<c:forEach items="${requestScope.tracks}" var="track">
					<div class="spotify-track">
						<span>Nombre: <c:out value="${track.name}"/></span>
						<iframe src="https://open.spotify.com/embed/track/${track.id}"width="100%" height="80"></iframe>
					</div>
				</c:forEach>
				</div>
			
		<% } else{ %>
			<a href="AuthController/Spotify"> Inicia sesion en Spotify </a>
			
		<% } %>
		  </div>
		<div class="gcalendar">
		<% if (request.getAttribute("gc").toString()=="true") { %>
				<h1> Calendario: </h1>
			<div class="info">
				<c:forEach items="${requestScope.eventos}" var="evento">
					<div class="gcalendar-evento">
						
						<span>Nombre:<c:out value="${evento.summary}"/></span>
						<span>Fecha:<c:out value="${evento.start.date}"/></span>
					</div>
				</c:forEach>	
				<iframe src="https://calendar.google.com/calendar/embed?src=${requestScope.email}&ctz=Europe%2FMadrid" style="border: 0" width="450px" height="500px"  frameborder="0" scrolling="no"></iframe>
			</div>
		<% } else{ %>
			<a href="AuthController/GoogleCalendar"> Inicia sesion en Google Calendar </a>
		<% } %>
		</div>
		
		<a href=""AuthController/Spotify""><div>Inicia Sesion en spotify Spotify</div></a>
	</div>
</body>
</html>