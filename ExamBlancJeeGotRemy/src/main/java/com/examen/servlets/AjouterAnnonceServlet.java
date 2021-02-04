package com.examen.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.examen.models.Annonce;
import com.examen.models.Utilisateur;
import com.examen.services.AnnonceService;
import com.examen.services.UtilisateurService;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;


/**
 * Servlet implementation class AjouterAnnonceServlet
 */
public class AjouterAnnonceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private AnnonceService annonceService;
    private UtilisateurService utilisateurService;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjouterAnnonceServlet() {
        super();
        this.annonceService = new AnnonceService();
        this.utilisateurService = new UtilisateurService();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("ajouterAnnonce.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String image_link = "#";
		if(!request.getParameter("image_link").isEmpty()) {
			image_link = request.getParameter("image_link");
		}

		String contenu = request.getParameter("contenu");
		String titre = request.getParameter("titre");			
		int id_utilisateur = (int) request.getSession().getAttribute("logSession");
		Utilisateur utilisateur = this.utilisateurService.getById(id_utilisateur);
		
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		
		Annonce annonce = new Annonce(image_link, contenu, titre, utilisateur);
		Set<ConstraintViolation<Annonce>> errors = validator.validate(annonce);
		
		if(errors.size() == 0) {
			this.annonceService.create(annonce);
			request.getRequestDispatcher("dashboard.jsp").forward(request, response);
		}
		else {
			request.setAttribute("errors", errors);
			this.doGet(request, response);
		}
		
	}

}
