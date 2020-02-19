package com.example.android.popularmovies.model;

import java.util.List;


/**
 * This class is meant to help with serialization of Movie data from TMdb
 */
public class Movie {

    private int id;
    /* Path to Movie poster */
    private String posterPath;
    /* Whether to include adult movies */
    private boolean adult;
    /* Overview description of Movie */
    private String overview;
    /* Movie release date */
    private String releaseDate;
    /* An array of integers showing Movie genres */
    private List<Integer> genreIds;
    /* Original title of Movie */
    private String originalTitle;
    /* Original Movie language */
    private String originalLanguage;
    /* Title of Movie (English) */
    private String title;
    /* Path of Movie backdrop */
    private String backdropPath;
    /* Calculated popularity value */
    private double popularity;
    /* Total vote count for Movie */
    private int voteCount;
    /* Related videos */
    private boolean video;
    /* Vote average for Movie */
    private double voteAverage;


    /**
     * For use in serialization, no args constructor
     */
    public Movie(){
    }

    public Movie(int id, String posterPath, boolean adult, String overview, String releaseDate,
                 List<Integer> genreIds, String originalTitle, String originalLanguage, String title,
                 String backdropPath, double popularity, int voteCount, boolean video,
                 double voteAverage) {
        this.id = id;
        this.posterPath = posterPath;
        this.adult = adult;
        this.overview = overview;
        this.releaseDate = releaseDate;
        this.genreIds = genreIds;
        this.originalTitle = originalTitle;
        this.originalLanguage = originalLanguage;
        this.title = title;
        this.backdropPath = backdropPath;
        this.popularity = popularity;
        this.voteCount = voteCount;
        this.video = video;
        this.voteAverage = voteAverage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public boolean getAdult() {
        return adult;
    }

    public void setAdult(boolean adult) {
        this.adult = adult;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public List<Integer> getGenreIds() {
        return genreIds;
    }

    public void setGenreIds(List<Integer> genreIds) {
        this.genreIds = genreIds;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public void setOriginalLanguage(String originalLanguage) {
        this.originalLanguage = originalLanguage;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBackdropPath() {
        return backdropPath;
    }

    public void setBackdropPath(String backdropPath) {
        this.backdropPath = backdropPath;
    }

    public double getPopularity() {
        return popularity;
    }

    public void setPopularity(double popularity) {
        this.popularity = popularity;
    }

    public int getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(int voteCount) {
        this.voteCount = voteCount;
    }

    public boolean getVideo() {
        return video;
    }

    public void setVideo(boolean video) {
        this.video = video;
    }

    public double getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(double voteAverage) {
        this.voteAverage = voteAverage;
    }
}
