package com.cognizant.moviecruiser.dao;

import java.util.List;

import com.cognizant.moviecruiser.model.Movie;

public class FavoriteDaoCollectionImplTest {

	public static void main(String[] args) throws FavoriteEmptyException {
		testGetAllFavorite();
		System.out.println("-----------------------");
		testAddFavorite();
		System.out.println("-----------------------");
		testGetAllFavorite();
		System.out.println("-----------------------");
		testRemoveFavorite();
		System.out.println("-- ---------------------");
		testGetAllFavorite();
	}

	public static void testGetAllFavorite() throws FavoriteEmptyException {
		FavoriteDao favorite = new FavoriteDaoCollectionImpl();
		List<Movie> movieItemListCustomer = favorite.getAllFavoriteList(1);
		System.out.println("Favorite Movie List");
		for (Movie movieItem : movieItemListCustomer) {
			System.out.println(movieItem.actionDelete());

		}

	}

	public static void testAddFavorite() throws FavoriteEmptyException {
		FavoriteDao favorite = new FavoriteDaoCollectionImpl();
		List<Movie> movieItemListCustomer = favorite.getAllFavoriteList(1);
		System.out.println("User added Movie List - Checkout");

		favorite.addFavorite(1, 2l);
		favorite.addFavorite(1, 3l);
		for (Movie movieItem : movieItemListCustomer) {

			System.out.println(movieItem.actionFavorite());
		}
	}

	public static void testRemoveFavorite() throws FavoriteEmptyException {
		FavoriteDao favorite = new FavoriteDaoCollectionImpl();
		List<Movie> movieItemListCustomer = favorite.getAllFavoriteList(1);
		System.out.println("User Deleted Movie List - Checkout");

		for (Movie movieItem : movieItemListCustomer) {
			favorite.removeFavorite(1, 2l);
			System.out.println(movieItem.actionFavorite());
		}

	}

}
