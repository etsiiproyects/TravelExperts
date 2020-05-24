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
			<iframe src="https://open.spotify.com/collection/tracks" width="300" 
					height="380" frameborder="0" allowtransparency="true" allow="encrypted-media" class="songlist"></iframe>
			<c:forEach items="${requestScope.playlists}" var="playlist">
					<iframe src="https://open.spotify.com/embed/playlist/${playlist.id }" width="300" 
					height="380" frameborder="0" allowtransparency="true" allow="encrypted-media" class="songlist"></iframe>
			</c:forEach>
</body>