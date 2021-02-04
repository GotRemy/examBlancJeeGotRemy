<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Accueil admin</title>
</head>
<body>
<%
		if (request.getSession().getAttribute("logSession") == null) {
		response.sendRedirect("loginServlet");
	}
	%>
	<h1>Dashboard</h1>
	<ul>
		<li><a
			href='<%out.println(request.getContextPath());%>/ajouterUtilisateurServlet'>Ajouter un utilisateur</a></li>
		<li><a
			href='<%out.println(request.getContextPath());%>/ajouterAnnonceServlet'>Ajouter une annonce</a></li>

		<li><a
			href='<%out.println(request.getContextPath());%>/logoutServlet'>Déconnection</a></li>
	</ul>
</body>
</html>