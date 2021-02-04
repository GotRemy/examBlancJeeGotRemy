<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Accueil</title>
</head>
<body>

<h1>Bienvenue !</h1>
		<a href='<%out.println(request.getContextPath());%>/loginServlet'>Connexion</a><br>
		<a href='<%out.println(request.getContextPath());%>/listeAnnonceServlet'>Liste des annonces</a>
	           
</body>
</html>