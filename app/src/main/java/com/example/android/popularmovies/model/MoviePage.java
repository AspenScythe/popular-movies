package com.example.android.popularmovies.model;

public class MoviePage {

    /* Page number this is out of total pages */
    private int pageNumber;
    /* Total number of pages for the query */
    private int totalPages;
    /* Total number of results in the query */
    private int totalResults;
    /* Array of movie objects extracted from the page */
    private Movie[] movies;

    /**
     * For use in serialization, no args constructor
     */
    public MoviePage() {
    }

    public MoviePage(int pageNumber, int totalPages, int totalResults, Movie[] movies) {
        this.pageNumber = pageNumber;
        this.totalPages = totalPages;
        this.totalResults = totalResults;
        this.movies = movies;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public Movie[] getMovies() {
        return movies;
    }

    public void setMovies(Movie[] movies) {
        this.movies = movies;
    }
}
