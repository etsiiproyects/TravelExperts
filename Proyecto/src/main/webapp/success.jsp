<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Music Experts</title>
	<link rel="stylesheet" type="text/css" href="../css/results2.css">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link href="https://fonts.googleapis.com/css2?family=Fjalla+One&display=swap" rel="stylesheet">
</head>

<body>
	
	
	<!--
	<p class="token">Spotify:<c:out value="${requestScope.tokenS}"/> </p>
	<p class="token">GCalendar:<c:out value="${requestScope.tokenGC}"/> </p>
	-->

	
	
	<div class="ticketmaster">
			<h1> Eventos </h1>
			<div class="infoTM">
			<c:forEach items="${requestScope.tickets.events}" var="ticket">
				<a href="#" class="btn-toggle"><b> <c:out value="${ticket.embedded.venues[0].city.name}" /></b></a>
				<div class="tmaster-info">
					<div class="wrap">
						<form action="addEvent" method="post" accept-charset="utf-8">
							<span>Evento: <strong><c:out value="${ticket.name}"/></strong></span><br/>
							<input id="nombre" name="nombre" type="hidden" value="${ticket.name}"> 
							<span>Fecha: <strong><c:out value="${ticket.dates.start.localDate}"/></strong></span><br/>
							<input id="fecha" name="fecha" type="hidden" value="${ticket.dates.start.localDate}"> 
							<span>Hora: <strong><c:out value="${ticket.dates.start.localTime}"/></strong></span><br/>
							<input id="hora" name="hora" type="hidden" value="${ticket.dates.start.localTime}"> 
							<span>Direccion: <strong><c:out value="${ticket.embedded.venues[0].address.line1}"/></strong></span><br/>
							<input id="direccion" name="direccion" type="hidden" value="${ticket.embedded.venues[0].address.line1}"> 
							<!--  <img class="img-tm" src="${ticket.images[0].url}"> -->
							<button type="submit" class="addGC">Add to calendar</button>
						</form>
					</div>
				</div>	
			</c:forEach>
			
			</div>
			<div class="botonB">
				<a href="index.html"><div class="buscar">Volver al buscador</div></a>
			</div>	
		</div>
	
	<div class="contenido">
		
		
		
		<% if (request.getAttribute("spot").toString()=="true") { 
		
				Integer i = 0; %>
				<div class="spotify">
				<form action="PlaylistController" method="post"><input class="allSongs" type="submit" name="searchBtn" title="search" value="Ver mis playlist y mis canciones seguidas"></form>
				<h1> Top canciones: </h1>
				<div class="artist">
				<iframe src="https://open.spotify.com/follow/1/?uri=${requestScope.artistUri}&size=detail&theme=dark" height="56" scrolling="no" frameborder="0" style="border:none; overflow:hidden;" allowtransparency="true"></iframe>
				</div>
				<form>
					<select id="seleccion">
					<option value="" hidden selected disabled>Selecciona tu PlayList</option>
						<c:forEach items="${requestScope.playlists}" var="play">
							<option class="opcion" value="${play.id}">${play.name}</option>
						</c:forEach>
					</select>
				</form>
				<button type="button" class="allSongs" onclick="mostrar()"> All songs </button>
				<div class="infoS">
				<c:forEach items="${requestScope.tracks}" var="track">
					<div id="<%= i %>" class="spotify-track"> 
						<span>Nombre: <c:out value="${track.name}"/></span>
						<iframe src="https://open.spotify.com/embed/track/${track.id}"width="100%" height="80"></iframe>
						
							
						<div class="botones"> 
							<button class="boton" onclick="ocultar(<%=i%>)">&nbsp;&nbsp;Delete&nbsp;&nbsp;</button>
							<form action="/AddSongController">
								<input class="id_play" name="id_play" type="hidden">
								<input name="uri_song" value="${track.uri}" type="hidden">
								<button class="boton" >&nbsp;&nbsp;Añadir a tu PlayList &nbsp;&nbsp;&nbsp;</button>
							</form>
							<form action="/followSongController">
								<input type="hidden" name="songId" value="${track.id}">
								<button class="boton">&nbsp;&nbsp;&nbsp;Seguir la Cancion&nbsp;&nbsp;&nbsp;</button>
							</form>
							<form action="/UnFollowSongController">
								<input type="hidden" name="songId" value="${track.id}">
								<button class="boton">&nbsp;&nbsp;&nbsp;Dejar de seguir la Cancion&nbsp;&nbsp;&nbsp;</button>
							</form>
						</div>
					</div>
					<% i++; %>
				</c:forEach>
				</div>
			</div>
		<% } else{ %>
		<div class="iniciaS">
			<a href="AuthController/Spotify"> Inicia sesion en Spotify </a>
		</div>
		<% } %>
		  
		<div class="gcalendar">
			
		<% if (request.getAttribute("gc").toString()=="true") { %>
				<h1> Calendario: </h1>
				<div class="cal">
				<iframe src="https://calendar.google.com/calendar/embed?src=${requestScope.email}&ctz=Europe%2FMadrid" width="100%" height="100%" style="border: 0"  frameborder="0" scrolling="no"></iframe>
				</div>
			<div class="infoGC">
				<c:forEach items="${requestScope.eventos}" var="evento">
					<div class="gcalendar-evento"> 
					<div class="infoEvento"> 
						<h3><c:out value="${evento.summary}"/></h3>
					</div>
					<div class="infoEvento">
						<span><c:out value="${evento.start.date}"/></span>
					</div>
					</div>
				</c:forEach>
			</div>
			
		<% } else{ %>
			<a href="AuthController/GoogleCalendar"> Inicia sesion en Google Calendar </a>
		<% } %>
		</div>
	</div>
	
	<script>
	let botones = document.querySelectorAll('.btn-toggle');
    let toggles = document.querySelectorAll('.tmaster-info');
    for (var i = 0; i < botones.length; i++) {

        let boton = botones[i];
        let toggle = toggles[i];
        console.log(typeof(boton));
        boton.addEventListener('click', (e) => {
            console.log(toggle);
            toggle.classList.toggle("active");
        });


        console.log("funciona");
    };
    
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
	
	let seleccion=document.getElementById("seleccion");
    var id_p;
    seleccion.addEventListener("input", function(){
        let value=seleccion.value;
        id_p=value;
        console.log(id_p);
        var ids = document.getElementsByClassName("id_play");
        for(var j = 0; j < ids.length; j++){
            ids[j].value = id_p;
            console.log(ids[j].value);
        }
    });
    
    
    
	</script>
	
	
	
</body>
</html>