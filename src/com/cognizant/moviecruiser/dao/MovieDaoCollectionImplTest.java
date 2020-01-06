package com.cognizant.moviecruiser.dao;

import java.text.ParseException;
import java.util.List;

import com.cognizant.moviecruiser.model.Movie;
import com.cognizant.moviecruiser.util.DateUtil;


public class MovieDaoCollectionImplTest {

	public static void main(String[] args) {
		try {
			System.out.println("Admin Menu Items");
			System.out.println("-----------------------------");
			testGetMovieListAdmin();
			System.out.println("-----------------------------");
			System.out.println("Customer Menu Items");
			System.out.println("-----------------------------");
			testGetMovieListCustomer();
			System.out.println("-----------------------------");
			System.out.println("Modified Menu Items");
			System.out.println("-----------------------------");
			testModifyMovie();
			
			testGetMovieListAdmin();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	public static void testGetMovieListAdmin() throws ParseException {
		MovieDao movieDao = new MovieDaoCollectionImpl();
		List<Movie> movieItemList = movieDao.getMovieListAdmin();
		for (Movie x : movieItemList) {
			System.out.println(x);
		}
	}

	public static void testGetMovieListCustomer() throws ParseException {
		MovieDao movieDao = new MovieDaoCollectionImpl();
		List<Movie> movieItemList = movieDao.getMovieListCustomer();
		for (Movie x : movieItemList) {
			System.out.println(x.actionFavorite());
		}

	}

	public static void testModifyMovie() throws ParseException {
		Movie newItem = new Movie(2, "Frozen", 218746548, true, DateUtil.convertToDate("11/09/2018"),
				"Science Fiction", false);
		MovieDao movieDao = new MovieDaoCollectionImpl();
		movieDao.modifyMovieItem(newItem);

	}

	public static void testgetMovieList() {

	}

}
