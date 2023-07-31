package controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.FilmDAO;
import model.Film;

/**
 * Servlet implementation class InsertFilmServlet
 */
@WebServlet("/insert-film-servlet")
public class InsertFilmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertFilmServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * 
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.getRequestDispatcher("./new-film.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//Request all parameters from form
		//Parse year to int to be able to store to db
		String title = request.getParameter("title");
		String director = request.getParameter("director");
		String stars = request.getParameter("stars");
		String review = request.getParameter("review");
		String stringYear = request.getParameter("year");
		int intYear = Integer.parseInt(stringYear.trim());
		
		//New instance of Film set with user's input
		Film f = new Film();
		f.setTitle(title);
		f.setYear(intYear);
		f.setDirector(director);
		f.setStars(stars);
		f.setReview(review);
		
		//New instance of FilmDAO 
		//Try to insert the film into database
		FilmDAO dao = new FilmDAO();
		try {
			dao.insertFilm(f);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		response.sendRedirect("./home-servlet");
	}
}
