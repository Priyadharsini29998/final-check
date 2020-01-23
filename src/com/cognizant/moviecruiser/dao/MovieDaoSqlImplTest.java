package com.cognizant.moviecruiser.dao;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import com.cognizant.moviecruiser.model.Movie;
import com.cognizant.moviecruiser.util.DateUtil;

public class MovieDaoSqlImplTest {

	public static void main(String[] args) throws ParseException, SQLException {
        System.out.println("Admin List");
        testMovieItemListAdmin();
        System.out.println("Customer List");
        testMovieItemListCustomer();
        testmodifyMovieItem();
        System.out.println("After modifying");
        testMovieItemListAdmin();


	}
	public static void testMovieItemListAdmin() throws ParseException, SQLException{
        MovieDao movieItemDao = new MovieDaoSqlImpl();
        List<Movie> movieItemList = movieItemDao.getMovieListAdmin();
        for (Movie x : movieItemList) {
                        System.out.println(x);
        }
}

public static void testMovieItemListCustomer() throws ParseException, SQLException {
        MovieDao movieItemDao = new MovieDaoSqlImpl(); 
        List<Movie> movieItemList = movieItemDao.getMovieListCustomer();
        for (Movie x : movieItemList) {
                        System.out.println(x);
        }
}

private static void testmodifyMovieItem() throws ParseException {
        Movie m = new Movie(2, "Jungle Book", 151856554, false, DateUtil.convertToDate("12/12/2018"), "Super Hero",
                                        true);
        MovieDaoSqlImpl movieItemDao = new MovieDaoSqlImpl();
        movieItemDao.modifyMovieItem(m);
        Movie modifyMovieItem = movieItemDao.getMovieList(m.getMovieid()); 
}



}
