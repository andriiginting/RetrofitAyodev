package com.example.andriginting.retrofit_ayodev.network;

import com.example.andriginting.retrofit_ayodev.model.MovieResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Andri Ginting on 12/9/2017.
 */

public interface ApiInterface {
    // TODO (6) buat class ApiInterface
    //class ini berfungsi untuk mendefinisikan interface untuk retrofit

    @GET("movie/top_rated")
    Call<MovieResponse>getTopRatedMovies(@Query("api_key") String apiKey);

    @GET("move/{id}")
    Call<MovieResponse> getMovieDetails(@Path("id")int id,@Query("api_key")String apiKey);
}
