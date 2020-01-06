package com.cognizant.moviecruiser.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognizant.moviecruiser.dao.MovieDao;
import com.cognizant.moviecruiser.dao.MovieDaoCollectionImpl;
import com.cognizant.moviecruiser.model.Movie;
import com.cognizant.moviecruiser.util.DateUtil;

/**
 * Servlet implementation class EditMovieListServlet
 */
@WebServlet({ "/EditMovieServlet", "/EditMovie" })
public class EditMovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditMovieServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			long id = Integer.parseInt(request.getParameter("movieid"));
			String title = request.getParameter("txtTitle");
			float gross = Float.parseFloat(request.getParameter("txtGross"));
			boolean active = Boolean.parseBoolean(request.getParameter("rdoActive"));
			String launch = request.getParameter("txtLaunch");
			String genre = request.getParameter("genre");
			boolean hasTeaser = Boolean.parseBoolean(request.getParameter("checkkval"));
			Movie movie = new Movie(id, title, gross, active, DateUtil.convertToDate(launch), genre, hasTeaser);
			MovieDao movieDao = new MovieDaoCollectionImpl();
			movieDao.modifyMovieItem(movie);
			request.setAttribute("msg", "Movie details saved Successfully");
			RequestDispatcher rd = request.getRequestDispatcher("edit-movie-status.html");
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
