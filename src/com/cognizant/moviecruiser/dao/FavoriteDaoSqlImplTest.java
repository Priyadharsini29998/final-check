package com.cognizant.moviecruiser.dao;

import java.util.List;

import com.cognizant.moviecruiser.model.Movie;

public class FavoriteDaoSqlImplTest {

	public static void main(String[] args) throws FavoriteEmptyException {
        testGetAllFavorite();
        testaddFavorite();
        testremoveFavorite(); 


	}
	private static void testaddFavorite() throws FavoriteEmptyException {
        FavoriteDao favoriteDao = new FavoriteDaoSqlImpl();
        long totalGross = 0l;
        favoriteDao.addFavorite(1, 2l); 
        favoriteDao.addFavorite(1, 4l);
        favoriteDao.addFavorite(2, 5l);
        favoriteDao.addFavorite(2, 3l);
        List<Movie> movieItemListCustomer = favoriteDao.getAllFavoriteList(1);
        System.out.println("User Added Favorite Movie");
        for (Movie movieItem : movieItemListCustomer) {
                        System.out.println(movieItem);
                        totalGross += movieItem.getBoxOffice();

        }
        System.out.println("Favorite are:" + movieItemListCustomer.size());
        System.out.println("total gross is:" + totalGross);

}

private static void testGetAllFavorite() throws FavoriteEmptyException {
        FavoriteDao favoriteDao = new FavoriteDaoSqlImpl();
        try {
        List<Movie> movieItemListCustomer = favoriteDao.getAllFavoriteList(1);
        System.out.println("All Favorite Movie");
        for (Movie movieItem : movieItemListCustomer) {
                        System.out.println(movieItem);
        }}catch (Exception e) {
                        e.getMessage();
        }

}

private static void testremoveFavorite() {
        FavoriteDao favoriteDao = new FavoriteDaoSqlImpl();
        long totalGross = 0l; 
        try {
                        favoriteDao.removeFavorite(1, 3l); 
                        List<Movie> movieItemListCustomer = favoriteDao.getAllFavoriteList(1);
                        System.out.println("User After Remove Favorite Movie");
                        for (Movie movieItem : movieItemListCustomer) {
                                        System.out.println(movieItem);
                                        totalGross+= movieItem.getBoxOffice(); 
                        }
        } catch (Exception e) {
                        e.getMessage();

        }
}


}
