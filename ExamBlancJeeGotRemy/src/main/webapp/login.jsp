<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Connexion</title>
</head>
<body>
<h1>Formulaire de login</h1>
<a href='<%out.println(request.getContextPath());%>/index.jsp'>Retour à l'accueil</a>
                <form action='loginServlet' method='post'>
                <label>Username</label>
                <input type='text' placeholder='username' name='username'/> <br>

                <label>Password</label>
                <input type='password' placeholder='password' name='password'/> <br>
                <input type='submit' value='valider'/>
                </form>           
</body>
</html>