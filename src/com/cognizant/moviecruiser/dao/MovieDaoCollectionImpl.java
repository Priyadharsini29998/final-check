package com.cognizant.moviecruiser.dao;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cognizant.moviecruiser.model.Movie;
import com.cognizant.moviecruiser.util.DateUtil;

public class MovieDaoCollectionImpl implements MovieDao {
	private static List<Movie> movieItemList;

	public MovieDaoCollectionImpl() throws ParseException {
		if (movieItemList == null) {
			movieItemList = new ArrayList<>();
			movieItemList.add(new Movie(1, "Avatar", 27879658, true, DateUtil.convertToDate("15/07/2017"),
					"Science Fiction", true));
			movieItemList.add(new Movie(2, "The Avengers", 151881988, true, DateUtil.convertToDate("23/12/2017"),
					"Super Hero", false));
			movieItemList.add(
					new Movie(3, "Titanic", 21876394, true, DateUtil.convertToDate("21/08/2017"), "Romance", false));
			movieItemList.add(new Movie(4, "Jurrasic World", 167173208, false, DateUtil.convertToDate("02/07/2017"),
					"Science Fiction", true));
			movieItemList.add(new Movie(5, "Avengers: End Game", 27576034, true, DateUtil.convertToDate("02/11/2022"),
					"Super Hero", true));

		}
	}

	@Override
	public List<Movie> getMovieListAdmin() {
		return movieItemList;
	}

	@Override
	public List<Movie> getMovieListCustomer() {
		List<Movie> movieItem = new ArrayList<>();
		Date date = new Date();
		for (Movie x : movieItemList) {
			if (x.isActive() && x.getDateOfLaunch().before(date)) {
				movieItem.add(x);
			}
		}
		return movieItem;

	}

	@Override
	public void modifyMovieItem(Movie movieItem) {

		Movie menuId = getMovieList(movieItem.getMovieid());
		menuId.setTitle(movieItem.getTitle());
		menuId.setBoxOffice(movieItem.getBoxOffice());
		menuId.setActive(movieItem.isActive());
		menuId.setDateOfLaunch(movieItem.getDateOfLaunch());
		menuId.setGenre(movieItem.getGenre());
		menuId.setHasTeaser(movieItem.isHasTeaser());
	}

	@Override
	public Movie getMovieList(long movieItemId) {
		Movie movieId = null;
		for (Movie x : movieItemList) {
			if (x.getMovieid() == movieItemId) {
				movieId = x;
				break;
			}
		}
		return movieId;
	}

}
