package com.ibm.demorest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("movies")
public class MovieResource {
	
	MovieRepository mr = new MovieRepository();	
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public List<Movie> getMovie() {
		
		return mr.getMovie();
	}
	
	@GET
	@Path("movie/{id}")
	@Produces(MediaType.APPLICATION_XML)
	public Movie getMovies(@PathParam("id")int id) {
		MovieRepository mr = new MovieRepository();
		return mr.getMovie(id);
	}
	
	@POST
	@Path("movie")
	@Consumes(MediaType.APPLICATION_XML)
	public Movie createMovie(Movie m) {
		mr.insertMovie(m);
		return m;
	}
	
	@DELETE
	@Path("delete/{id}")
    @Produces(MediaType.APPLICATION_XML)
	public void delete(@PathParam("id") int  id) {

		mr.deleteMovie(id);
	}
	

}
