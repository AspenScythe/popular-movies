package com.example.android.popularmovies.utilities;

import com.example.android.popularmovies.model.Movie;
import com.example.android.popularmovies.model.MoviePage;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;

/**
 * Utility functions to handle TMdb JSON data.
 */
public class JsonUtils {
    /**
     * This method parses JSON from a query to The Movie Database into a movie page object
     *
     * @param movieJsonStr JSON response from server
     *
     * @return A movie page containing all the movie objects and other data
     *
     * @throws JSONException If JSON data cannot be properly parsed
     */
    public static MoviePage getMovieInfoFromJson(String movieJsonStr)
            throws JSONException {

        /* Page number of results */
        final String TMDB_PAGE = "page";

        /* Total results */
        final String TMDB_TOTAL_RESULTS = "total_results";

        /* Total pages */
        final String TMDB_TOTAL_PAGES = "total_pages";

        /* All Movie details are children of the results array */
        final String TMDB_RESULTS = "results";

        /* If there is an error, it would return a code and message */
        final String TMDB_STATUS_CODE = "status_code";

        /* Strings describing the movies */
        final String TMDB_MOVIE_ID = "id";
        final String TMDB_MOVIE_POSTER = "poster_path";
        final String TMDB_MOVIE_ADULT = "adult";
        final String TMDB_MOVIE_OVERVIEW = "overview";
        final String TMDB_MOVIE_RELEASE = "release_date";
        final String TMDB_MOVIE_GENRE = "genre_ids";
        final String TMDB_MOVIE_TITLE = "title";
        final String TMDB_MOVIE_ORIG_TITLE = "original_title";
        final String TMDB_MOVIE_ORIG_LANG = "original_language";
        final String TMDB_MOVIE_BACKDROP = "backdrop_path";
        final String TMDB_MOVIE_POPULARITY = "popularity";
        final String TMDB_MOVIE_VOTE_CNT = "vote_count";
        final String TMDB_MOVIE_VIDEO = "video";
        final String TMDB_MOVIE_VOTE_AVG = "vote_average";

        Movie[] parsedMovie;

        JSONObject movieJson = new JSONObject(movieJsonStr);

        /* Is there an error? */
        if (movieJson.has(TMDB_STATUS_CODE)) {
            int errorCode = movieJson.getInt(TMDB_STATUS_CODE);

            switch (errorCode) {
                case HttpURLConnection.HTTP_OK:
                    break;
                case HttpURLConnection.HTTP_NOT_FOUND:
                    /* Location invalid */
                    return null;
                default:
                    /* Server probably down */
                    return null;
            }
        }

        /* Populate general data not related to movies */
        int currentPage = movieJson.getInt(TMDB_PAGE);
        int totalResults = movieJson.getInt(TMDB_TOTAL_RESULTS);
        int totalPages = movieJson.getInt(TMDB_TOTAL_PAGES);

        JSONArray movieArray = movieJson.getJSONArray(TMDB_RESULTS);
        parsedMovie = new Movie[movieArray.length()];

        for (int i = 0; i < movieArray.length(); i++) {

            /* Get the JSON object representing the movie */
            JSONObject movieData = movieArray.getJSONObject(i);

            /*
             * Shove all the data into the movie object
             */
            int id = movieData.getInt(TMDB_MOVIE_ID);
            String posterPath = movieData.getString(TMDB_MOVIE_POSTER);
            boolean adult = movieData.getBoolean(TMDB_MOVIE_ADULT);
            String overview = movieData.getString(TMDB_MOVIE_OVERVIEW);
            String releaseDate = movieData.getString(TMDB_MOVIE_RELEASE);
            String originalTitle = movieData.getString(TMDB_MOVIE_ORIG_TITLE);
            String originalLanguage = movieData.getString(TMDB_MOVIE_ORIG_LANG);
            String title = movieData.getString(TMDB_MOVIE_TITLE);
            String backdropPath = movieData.getString(TMDB_MOVIE_BACKDROP);
            double popularity = movieData.getDouble(TMDB_MOVIE_POPULARITY);
            int voteCount = movieData.getInt(TMDB_MOVIE_VOTE_CNT);
            boolean video = movieData.getBoolean(TMDB_MOVIE_VIDEO);
            double voteAverage = movieData.getDouble(TMDB_MOVIE_VOTE_AVG);

            JSONArray genreIdArray = movieData.getJSONArray(TMDB_MOVIE_GENRE);
            List<Integer> genreIds = new ArrayList<>();
            for(int a=0; a < genreIdArray.length(); a++) {
                genreIds.add(genreIdArray.getInt(a));
            }

            Movie movie = new Movie(id, posterPath, adult, overview, releaseDate,
                    genreIds, originalTitle, originalLanguage, title,
                    backdropPath, popularity, voteCount,  video, voteAverage);

            parsedMovie[i] = movie;
        }

        return new MoviePage(currentPage, totalPages, totalResults, parsedMovie);
    }
}
