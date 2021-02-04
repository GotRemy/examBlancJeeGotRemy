package com.examen.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.examen.models.Utilisateur;
import com.examen.services.UtilisateurService;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UtilisateurService utilisateurService;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
       this.utilisateurService = new UtilisateurService();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		boolean redirection = true;
		for(Utilisateur utilisateur : this.utilisateurService.getAll()) {
			
			if(utilisateur.getLogin().equals(username) && utilisateur.getPassword().equals(password)) {
				request.getSession().setAttribute("logSession", utilisateur.getId());	
				request.getRequestDispatcher("adminDashboardServlet").forward(request, response);
				redirection=false;
			}
		}
		if(redirection) {
			response.sendRedirect("loginServlet");
		}
		
	}

}
