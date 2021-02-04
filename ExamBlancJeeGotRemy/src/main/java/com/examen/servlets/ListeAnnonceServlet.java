package com.examen.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.examen.models.Annonce;
import com.examen.services.AnnonceService;

/**
 * Servlet implementation class indexServlet
 */
public class ListeAnnonceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private AnnonceService annonceService;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListeAnnonceServlet() {
        super();
        this.annonceService = new AnnonceService();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Annonce> annonces = new ArrayList<>();
		
		annonces = this.annonceService.getAll();
        if (annonces == null) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
        else {
    		request.setAttribute("annonces", annonces);
    		request.getRequestDispatcher("listeAnnonce.jsp").forward(request, response);
        }

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
