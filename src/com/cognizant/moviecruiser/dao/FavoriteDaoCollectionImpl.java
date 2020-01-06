package com.cognizant.moviecruiser.dao;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;

import com.cognizant.moviecruiser.model.Favorite;
import com.cognizant.moviecruiser.model.Movie;

public class FavoriteDaoCollectionImpl implements FavoriteDao {
	private static HashMap<Long, Favorite> userFavorites;

	public FavoriteDaoCollectionImpl() {
		super();
		if (userFavorites == null) {
			userFavorites = new HashMap<>();
			userFavorites.put(1L, new Favorite());
		}

	}

	@Override
	public void addFavorite(long userId, long movieId) {

		try {
			MovieDao movieDao = new MovieDaoCollectionImpl();
			Movie movie = movieDao.getMovieList(movieId);

			if (userFavorites.containsKey(userId)) {
				Favorite favorite = userFavorites.get(userId);
				favorite.getMovieItem().add(movie);
			} else {
				Favorite favorite = new Favorite();
				favorite.getMovieItem().add(movie);
				userFavorites.put(userId, favorite);
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<Movie> getAllFavoriteList(long userId) {
		List<Movie> movieItemList = userFavorites.get(userId).getMovieItem();
		Favorite favorite = userFavorites.get(userId);
		int noOfFavorites = 0;
		if (favorite == null || favorite.getMovieItem() == null || favorite.getMovieItem().isEmpty()) {
			try {
				throw new FavoriteEmptyException("Favorite List of Movies is Empty");
			} catch (FavoriteEmptyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {

			System.out.println("No of Favorites " + movieItemList.size());

		}

		return movieItemList;
	}

	@Override
	public void removeFavorite(long userId, long movieId) throws FavoriteEmptyException {
		List<Movie> movieItemList = userFavorites.get(userId).getMovieItem();
		if (movieItemList == null || movieItemList.isEmpty()) {
			
				throw new FavoriteEmptyException();
			
		}
		for (int i = 0; i < movieItemList.size(); i++) {
			if (movieItemList.get(i).getMovieid() == movieId) {
				movieItemList.remove(i);
				break;
			}
		}
	}

}
