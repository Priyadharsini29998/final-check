package com.cognizant.moviecruiser.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cognizant.moviecruiser.model.Movie;

public class MovieDaoSqlImpl implements MovieDao {

	@Override
	public List<Movie> getMovieListAdmin() {
		// TODO Auto-generated method stub
		List<Movie> MovieItemList = new ArrayList<>();
        Connection con=ConnectionHandler.getConnection();
        try {
                        try {
                                        String sql="select * from movie_item";
                                        PreparedStatement ps=con.prepareStatement(sql);
                                        ResultSet rs=ps.executeQuery();
                                        while(rs.next()) {
                                                        Movie m=new Movie(); 
                                                        m.setMovieid(rs.getInt(1));  
                                                        m.setTitle(rs.getString(2));
                                                        m.setBoxOffice(rs.getLong(3));
                                                        m.setActive(rs.getString(4).equalsIgnoreCase("Yes"));
                                                        m.setDateOfLaunch(rs.getDate(5));
                                                        m.setGenre(rs.getString(6)); 
                                                        m.setHasTeaser(rs.getString(7).equalsIgnoreCase("Yes"));
                                                        MovieItemList.add(m);
                                        }
                                        }catch(Exception e) { 
                                                        e.printStackTrace();
                                                        
                                        }finally { 
                                                        con.close();  
                                        }
        } catch (Exception e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
        }
        return MovieItemList;
	}

	@Override
	public List<Movie> getMovieListCustomer() {
		// TODO Auto-generated method stub
		List<Movie> CustList=new ArrayList<>();
        Connection con=ConnectionHandler.getConnection();
        try {
                        String sql="select * from movie_item where mv_active=? AND mv_date_of_launch<=?";
                        PreparedStatement ps=con.prepareStatement(sql);
                        ps.setString(1, "Yes");
                        ps.setDate(2, new java.sql.Date(System.currentTimeMillis()));
                        ResultSet rs=ps.executeQuery();
                        while(rs.next()) {
                                        Movie m=new Movie(); 
                                        m.setMovieid(rs.getInt(1));
                                        m.setTitle(rs.getString(2));  
                                        m.setBoxOffice(rs.getLong(3));
                                        m.setActive(rs.getString(4).equalsIgnoreCase("Yes"));
                                        m.setDateOfLaunch(rs.getDate(5));
                                        m.setGenre(rs.getString(6)); 
                                        m.setHasTeaser(rs.getString(7).equalsIgnoreCase("Yes"));
                                        CustList.add(m);
                        }
                        }catch(Exception e) {
                                        e.printStackTrace();
                                        
                        }finally {
                                        try { 
                                                        con.close();
                                        } catch (SQLException e) {
                                                        // TODO Auto-generated catch block 
                                                        e.printStackTrace();
                                        }
                        }
        return CustList;

	}

	@Override
	public void modifyMovieItem(Movie movieItem) {
		Connection con=ConnectionHandler.getConnection();
        try {
                        String sql="update movie_item set  mv_title=?,mv_box=?,mv_active=?,mv_date_of_launch=?,mv_genre=?,mv_teaser=? where mv_id=?";
                        PreparedStatement ps=con.prepareStatement(sql);
                        
                        ps.setString(1,movieItem.getTitle());
                        ps.setDouble(2,movieItem.getBoxOffice());
                        ps.setString(3, movieItem.isActive()?"Yes":"No");
                        ps.setDate(4,new java.sql.Date(movieItem.getDateOfLaunch().getTime()));
                        ps.setString(5,movieItem.getGenre());
                        ps.setString(6, movieItem.isHasTeaser()?"Yes":"No");
                        ps.setLong(7, movieItem.getMovieid());
                        int count=ps.executeUpdate();
                        
                        }catch(Exception e) { 
                        e.printStackTrace();
                        }finally {
                        try {
                                        con.close();
                        } catch (SQLException e) {
                                        // TODO Auto-generated catch block
                                        e.printStackTrace();
                        }
        }

		
	}

	@Override
	public Movie getMovieList(long movieItemId) {
		// TODO Auto-generated method stub
		Movie movieItem=new Movie();
        Connection con=ConnectionHandler.getConnection();
        try {
                        String sql="select * from movie_item";
                        PreparedStatement ps=con.prepareStatement(sql);
                        ResultSet rs=ps.executeQuery();
                        if(rs.next()) {
                                        Movie m=new Movie();
                                        m.setMovieid(rs.getLong(1));
                                        m.setTitle(rs.getString(2)); 
                                        m.setBoxOffice(rs.getLong(3));
                                        m.setActive(rs.getString(4).equalsIgnoreCase("Yes"));
                                        m.setDateOfLaunch(rs.getDate(5));
                                        m.setGenre(rs.getString(6)); 
                                        m.setHasTeaser(rs.getString(7).equalsIgnoreCase("Yes"));
                                        
        } 
        }catch(Exception e) {
                        e.printStackTrace();  
                        
        }finally {
                        try {
                                        con.close();
                        } catch (SQLException e) {
                                        // TODO Auto-generated catch block 
                                        e.printStackTrace();
                        }
        }
        return movieItem;
}

	}


