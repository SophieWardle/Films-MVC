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
 * Servlet implementation class UpdateFilmServlet
 */
@WebServlet("/update-film-servlet")
public class UpdateFilmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateFilmServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String stringId = request.getParameter("id");
		int intId = Integer.parseInt(stringId.trim());
		
		FilmDAO dao = new FilmDAO();
		Film f = dao.getFilmByID(intId);
		
		request.setAttribute("film", f);
		request.getRequestDispatcher("./update-film.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String title = request.getParameter("title");
		String director = request.getParameter("director");
		String stars = request.getParameter("stars");
		String review = request.getParameter("review");
		String stringYear = request.getParameter("year");
		String stringId = request.getParameter("id");
		
		int intYear = Integer.parseInt(stringYear.trim());
		int intId = Integer.parseInt(stringId.trim());
		
		FilmDAO dao = new FilmDAO();
		Film f = new Film(intId,title,intYear,director,stars,review);
		
		try {
			dao.updateFilm(f);
			System.out.print("updated");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		response.sendRedirect("./home-servlet");
	}
}
