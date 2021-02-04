package com.examen.servlets;

import java.io.IOException;
import java.util.Set;


import com.examen.models.Utilisateur;
import com.examen.services.UtilisateurService;


import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class AjouterUtilisateurServlet
 */
public class AjouterUtilisateurServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UtilisateurService utilisateurService;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjouterUtilisateurServlet() {
        super();
        this.utilisateurService = new UtilisateurService();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("ajouterUtilisateur.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		
		Utilisateur utilisateur = new Utilisateur(login, nom, prenom, password);
		Set<ConstraintViolation<Utilisateur>> errors = validator.validate(utilisateur);
		
		if(errors.size() == 0) {
			this.utilisateurService.create(utilisateur);
			request.getRequestDispatcher("dashboard.jsp").forward(request, response);
		}
		else {
			request.setAttribute("errors", errors);
			this.doGet(request, response);
		}
	}

}
