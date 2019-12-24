package com.cognizant.moviecruiser.model;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Movie {
	private long movieid;
	private String title;
	private float boxOffice;
	private boolean active;
	private Date dateOfLaunch;
	private String genre;
	private boolean hasTeaser;

	public Movie(long movieid, String title, float boxOffice, boolean active, Date dateOfLaunch, String genre,
			boolean hasTeaser) {
		super();
		this.movieid = movieid;
		this.title = title;
		this.boxOffice = boxOffice;
		this.active = active;
		this.dateOfLaunch = dateOfLaunch;
		this.genre = genre;
		this.hasTeaser = hasTeaser;
	}

	public Movie(String string, String string2, boolean b, String string3, String string4, boolean c) {
		// TODO Auto-generated constructor stub
	}

	public long getMovieid() {
		return movieid;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (movieid ^ (movieid >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Movie other = (Movie) obj;
		if (movieid != other.movieid)
			return false;
		return true;
	}

	public void setMovieid(long movieid) {
		this.movieid = movieid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public float getBoxOffice() {
		return boxOffice;
	}

	public void setBoxOffice(float boxOffice) {
		this.boxOffice = boxOffice;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Date dateOfLaunch() {
		return dateOfLaunch;
	}

	public void setDateOFLaunch(Date dateOfLaunch) {
		this.dateOfLaunch = dateOfLaunch;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public boolean isHasTeaser() {
		return hasTeaser;
	}

	public void setHasTeaser(boolean hasTeaser) {
		this.hasTeaser = hasTeaser;
	}

	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String pattern = "#,###,###,###";
		DecimalFormat df = new DecimalFormat(pattern);

		String details = String.format("%-20s $%-20s %-5s %-18s %-15s %-15s Edit", title, df.format(boxOffice),
				active ? "Yes" : "No", sdf.format(dateOfLaunch), genre, hasTeaser ? "Yes" : "No");
		return details;

	}

	public String actionFavorite() {
		String pattern = "#,###,###,###";
		DecimalFormat df = new DecimalFormat(pattern);
		String custDetails = String.format("%-20s $%-20s %-20s %-10s Add to Favorite", title, df.format(boxOffice),
				genre, hasTeaser ? "Yes" : "No");
		return custDetails;

	}

	public String actionDelete() {
		String pattern = "#,###,###,###";
		DecimalFormat df = new DecimalFormat(pattern);
		String custDetails = String.format("%-20s $%-20s %-20s %-10s Delete", title, df.format(boxOffice), genre,
				hasTeaser ? "Yes" : "No");
		return custDetails;

	}

}
