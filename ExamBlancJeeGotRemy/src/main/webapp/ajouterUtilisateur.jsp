<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ajouter un utilisateur</title>
</head>
<body>
<%
		if (request.getSession().getAttribute("logSession") == null) {
		response.sendRedirect("loginServlet");
	}
	%>
	
<a href='<%out.println(request.getContextPath());%>/adminDashboardServlet'>Retour au dashboard</a>
<a href='<%out.println(request.getContextPath());%>/logoutServlet'>Déconnection</a>
	
	<form action="ajouterUtilisateurServlet" method="post">

		Nom <br>
		<input type="text" name="nom" value=""/><br>
		Prénom <br>
		<input type="text" name="prenom" value=""/><br>
		Login <br>
		<input type="text" name="login" value=""/><br>
		Password <br>
		<input type="password" name="password" value=""/><br>		
		<input type="submit" />
	</form>
</body>
</html>