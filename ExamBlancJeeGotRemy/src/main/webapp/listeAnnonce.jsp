<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Liste des annonces</title>
</head>
<body>
<h1>Bienvenue !</h1>
		<a href='<%out.println(request.getContextPath());%>/loginServlet'>Connexion</a>
		<br/>
		<table>
		    <thead>

		            <th colspan="1">Titre</th>
		            <th colspan="1">Ecrit par</th>

   			</thead>
		    <tbody>
		    <c:forEach var="annonce" items="${requestScope.annonces}">
		        <tr>
		            <td><a href="<%out.println(request.getContextPath());%>/annonceServlet?id=${annonce.id}"><c:out value="${annonce.titre}"/></a></td>
		            <td>${annonce.utilisateur.nom} ${annonce.utilisateur.prenom}</td>
		        </tr>
	        </c:forEach>
		    </tbody>
		</table>
</body>
</html>