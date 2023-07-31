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
 * Servlet implementation class DeleteFilmServlet
 */
@WebServlet("/delete-film-servlet")
public class DeleteFilmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteFilmServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//Request film ID and store in string
		//Parse string into an int so we can use it with methods
		String stringId = request.getParameter("id");
		int intId = Integer.parseInt(stringId.trim());
		
		//Create an instance of FilmDAO so we can use methods
		//Select the film with ID to be deleted, assign to film f
		FilmDAO dao = new FilmDAO();
		Film f = dao.getFilmByID(intId);
		
		//Try to delete film f
		try {
			dao.deleteFilm(f);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		response.sendRedirect("./home-servlet");
	}
}
