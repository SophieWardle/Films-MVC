package controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.FilmDAO;
import model.Film;

/**
 * Servlet implementation class SearchFilmServlet
 */
@WebServlet("/search-film-servlet")
public class SearchFilmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchFilmServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("./search-film.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String searchOption = request.getParameter("searchOptions");
		String userInput = request.getParameter("userInput");
		
		FilmDAO dao = new FilmDAO();
		System.out.print(searchOption);
		
		ArrayList<Film> allFilms = dao.searchFilms(searchOption, userInput);
		request.setAttribute("films", allFilms);
			
		RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
		rd.include(request, response);
		}
	}




