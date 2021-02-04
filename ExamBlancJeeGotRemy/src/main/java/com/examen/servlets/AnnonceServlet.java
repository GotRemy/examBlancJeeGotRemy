package com.examen.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.examen.models.Annonce;
import com.examen.services.AnnonceService;

/**
 * Servlet implementation class AnnonceServlet
 */
public class AnnonceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AnnonceService annonceService;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AnnonceServlet() {
        super();
        this.annonceService = new AnnonceService();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Integer id = Integer.parseInt(request.getParameter("id"));
		
		Annonce annonce = this.annonceService.getById(id);
		
		request.setAttribute("annonce", annonce);
		request.getRequestDispatcher("annonce.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
