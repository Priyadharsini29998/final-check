package com.cognizant.moviecruiser.model;

import java.util.ArrayList;
import java.util.List;

public class Favorite {
	private List<Movie> movieItem;
	private int noOfFavorites;

	public void setMovieItem(List<Movie> movieItem) {
		this.movieItem = movieItem;
	}

	public int getNoOfFavorites() {
		return noOfFavorites;
	}

	public void setNoOfFavorites(int noOfFavorites) {
		this.noOfFavorites = noOfFavorites;
	}

	public List<Movie> getMovieItem() {
		// TODO Auto-generated method stub
		return movieItem;
	}

	public Favorite(List<Movie> movieItem, int noOfFavorites) {
		super();
		this.movieItem = movieItem;
		this.noOfFavorites = noOfFavorites;
	}

	public Favorite() {
		super();
		movieItem = new ArrayList<>();
	}

}
