<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ajouter une annonce</title>
</head>
<body>
<%
		if (request.getSession().getAttribute("logSession") == null) {
		response.sendRedirect("loginServlet");
	}
	%>
	
<a href='<%out.println(request.getContextPath());%>/adminDashboardServlet'>Retour au dashboard</a>
<a href='<%out.println(request.getContextPath());%>/logoutServlet'>Déconnection</a>
	
	<form action="ajouterAnnonceServlet" method="post">

		Nom de l'image <br>
		<input type="text" name="image_link"/><br>
		Titre <br>
		<input type="text" name="titre"/><br>
		Contenu <br>
		<textarea rows="20" cols="50" name="contenu"></textarea><br>


		<input type="submit" />
	</form>
</body>
</html>