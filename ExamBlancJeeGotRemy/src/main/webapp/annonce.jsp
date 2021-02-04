<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>${annonce.titre}</title>
</head>
<body>
	<a href='<%out.println(request.getContextPath());%>/index.jsp'>Retour à l'accueil</a>
	<a href='<%out.println(request.getContextPath());%>/loginServlet'>Connexion</a>
	
	<h1>${annonce.titre}</h1>
	<h3>${annonce.utilisateur.nom} ${annonce.utilisateur.prenom}</h3>

	<c:if test="${!annonce.image_link.equals('#')}">
		<img src="${annonce.image_link}" sizes="(max-width:600px) (max-height:600px)">
	</c:if>
	<p>
		${annonce.contenu}
	</p>
</body>
</html>