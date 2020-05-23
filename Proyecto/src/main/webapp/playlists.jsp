<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Mis playlists</title>
	<link rel="stylesheet" type="text/css" href="../css/results.css">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link href="https://fonts.googleapis.com/css2?family=Fjalla+One&display=swap" rel="stylesheet">
</head>
<body>
		<div class="spotify">
				<div class="info">
				<c:forEach items="${requestScope.playlists}" var="playlist">
					<div class="spotify-track"> 
						<span>Nombre: <c:out value="${playlist.name}"/></span>
						<span>Id: <c:out value="${playlist.id }"></c:out></span>
						<span>Canciones: <c:out value="${playlist.tracks.total}"></c:out></span>
					</div>
				</c:forEach>
				</div>
		  </div>
</body>