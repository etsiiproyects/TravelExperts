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
	<link rel="shortcut icon" href="../images/favicon.ico">
</head>
<body>
			<c:forEach items="${requestScope.songssaved }" var="song">
				<span>Nombre: <c:out value="${song.name}"/></span>
				<iframe src="https://open.spotify.com/embed/track/${song.id}"width="100%" height="80"></iframe>
			</c:forEach>
			<c:forEach items="${requestScope.playlists}" var="playlist">
				<iframe src="https://open.spotify.com/embed/playlist/${playlist.id }" width="300" 
				height="380" frameborder="0" allowtransparency="true" allow="encrypted-media" class="songlist"></iframe>
			</c:forEach>
</body>