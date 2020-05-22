<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Music Experts</title>
	<link rel="stylesheet" type="text/css" href="../css/results.css">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link href="https://fonts.googleapis.com/css2?family=Fjalla+One&display=swap" rel="stylesheet">
</head>

<body>
	
	
	
	<p class="token">Spotify:<c:out value="${requestScope.tokenS}"/> </p>
	<p class="token">GCalendar:<c:out value="${requestScope.tokenGC}"/> </p>
	

	<div class="botonB">
	<a href="index.html"><div class="buscar"> Buscador </div></a>
	</div>
	<div class="contenido">
		<div class="ticketmaster">
			<h1> Eventos </h1>
			<div class="info">
			<c:forEach items="${requestScope.tickets.events}" var="ticket">
				<div class="tmaster-info">
				<form action="addEvent" method="post" accept-charset="utf-8">
					<span>Evento: <c:out value="${ticket.name}"/></span><br/>
					<input id="nombre" name="nombre" type="hidden" value="${ticket.name}"> 
					<span>Fecha: <c:out value="${ticket.dates.start.localDate}"/></span><br/>
					<input id="fecha" name="fecha" type="hidden" value="${ticket.dates.start.localDate}"> 
					<span>Hora: <c:out value="${ticket.dates.start.localTime}"/></span><br/>
					<input id="hora" name="hora" type="hidden" value="${ticket.dates.start.localTime}"> 
					<span>Direccion: <c:out value="${ticket.embedded.venues[0].address.line1}"/></span><br/>
					<input id="direccion" name="direccion" type="hidden" value="${ticket.embedded.venues[0].address.line1}"> 
					<img class="img-tm" src="${ticket.images[0].url}">
					<button type="submit" class="addGC">Add to calendar</button>
				</form>
				</div>	
			</c:forEach>
			</div>
		</div>
		<div class="spotify">
		<% if (request.getAttribute("spot").toString()=="true") { 
		
				Integer i = 0; %>
			
				<h1> Top canciones: </h1>
				<button type="button" class="boton" onclick="mostrar()"> All songs </button>
				<div class="info">
				<c:forEach items="${requestScope.tracks}" var="track">
					<div id="<%= i %>" class="spotify-track"> 
						<span>Nombre: <c:out value="${track.name}"/></span>
						<iframe src="https://open.spotify.com/embed/track/${track.id}"width="100%" height="80"></iframe>
						<button type="button" class="boton" onclick="ocultar(<%=i%>)"> Delete </button>
					</div>
					<% i++; %>
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
		
		
		<!--  <div class="ticketmaster">
			<h1> Artistas </h1>
			<div class="info">
			<c:forEach items="${requestScope.artistas}" var="ticket">
				<div class="tmaster-info">
					<span>Nombre: <c:out value="${ticket.name}"/></span><br/>
					
					<span>Categoria: <c:out value="${ticket.dates.start.branch}"/></span><br/>
					
					<span>Nacimiento: <c:out value="${ticket.dates.start.birth}"/></span><br/>
			
				</div>	
			</c:forEach>
			</div>
		</div>-->
	</div>
	
	<script>
	function ocultar(i){
		var id = i;
		document.getElementById(id).style.display = 'none';
	}
	
	function mostrar(){
		var elementos = document.getElementsByClassName("spotify-track");
		 console.log(elementos);
		for (var i = 0; i < elementos.length; i++){
			
			var elemento = elementos[i];
			console.log(elemento);
			elemento.style.display = 'block';
		}
	}
	</script>
</body>
</html>