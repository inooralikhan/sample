package com.ibm.demorest;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Movie {
	
	int mid;
	String moviename;
	String theatre;
	String time;
	public Movie() {
		// TODO Auto-generated constructor stub
	}
	public Movie(int mid, String moviename, String theatre, String time) {
		super();
		this.mid = mid;
		this.moviename = moviename;
		this.theatre = theatre;
		this.time = time;
	}
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public String getMoviename() {
		return moviename;
	}
	public void setMoviename(String moviename) {
		this.moviename = moviename;
	}
	public String gettheatre() {
		return theatre;
	}
	public void settheatre(String theatre) {
		this.theatre = theatre;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	

}
