package com.example.demo.movie;

public class Movie {

    private final Integer movieId;
    private final String movieName;
    private final String movieSynopsis;
    private final Integer year;
    private final String director;

    public Movie(Integer movieId, String movieName, String movieSynopsis, Integer year, String director) {
        this.movieId = movieId;
        this.movieName = movieName;
        this.movieSynopsis = movieSynopsis;
        this.year = year;
        this.director = director;
    }

    public Integer getMovieId() {
        return movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public String getMovieSynopsis() {
        return movieSynopsis;
    }

    public Integer getYear() {
        return year;
    }

    public String getDirector() {
        return director;
    }
}
