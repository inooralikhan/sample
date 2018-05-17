package com.ibm.demorest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import java.sql.PreparedStatement;
public class MovieRepository {
	Connection con = null;
	public MovieRepository() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/moviedatabase","root","@Noor860@");
			System.out.println("Database connection");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public List<Movie> getMovie() {
		
		List<Movie> movies = new ArrayList<Movie>();
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from movie");
			while(rs.next()) {
				Movie mv = new Movie();
				mv.setMid(rs.getInt(1));
				mv.setMoviename(rs.getString(2));
				mv.settheatre(rs.getString(3));
				mv.setTime(rs.getString(4));
				movies.add(mv);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return movies;
	}
	
	public Movie getMovie(int id) {
		Movie movie = new Movie();
		try {
			PreparedStatement st =  con.prepareStatement("select * from movie where mid=?");
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();
		while(rs.next()) {

			movie.setMid(rs.getInt(1));
			movie.setMoviename(rs.getString(2));
			movie.settheatre(rs.getString(3));
			movie.setTime(rs.getString(4));
		}
		}catch(Exception e)
		{
			e.printStackTrace();
		} 
		return movie;
	}   
	public void insertMovie(Movie movie) {
		String sql = "insert into movie values(?,?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, movie.getMid());
			ps.setString(2, movie.getMoviename());
			ps.setString(3, movie.gettheatre());
			ps.setString(4, movie.getTime());
			ps.execute();
		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deleteMovie(int id) {
		String sql = "delete from movie where mid=?";
		try {
			PreparedStatement ps =  con.prepareStatement(sql);
			ps.setInt(1,id);
			ps.executeUpdate();
			System.out.println("deleted");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
