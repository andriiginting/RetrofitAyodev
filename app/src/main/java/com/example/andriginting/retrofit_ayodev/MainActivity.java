package com.example.andriginting.retrofit_ayodev;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.example.andriginting.retrofit_ayodev.adapter.MoviesAdapter;
import com.example.andriginting.retrofit_ayodev.model.Movie;
import com.example.andriginting.retrofit_ayodev.model.MovieResponse;
import com.example.andriginting.retrofit_ayodev.network.ApiClient;
import com.example.andriginting.retrofit_ayodev.network.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String API_KEY = "f38bc9d1907b81b6b4f890fc62c73a61";
    List<Movie> movies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (API_KEY.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Periksa API KEY anda", Toast.LENGTH_SHORT).show();
        }


        final RecyclerView recyclerView = findViewById(R.id.recycler_ayodev);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ApiInterface apiService =
                ApiClient.getClient()
                        .create(ApiInterface.class);

        Call<MovieResponse> call = apiService.getTopRatedMovies(API_KEY);

        call.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
//                int statusCode = response.code();

                List<Movie> movies = response.body().getResults();

                recyclerView.setAdapter(new MoviesAdapter(movies, R.layout.konten_ayodev, getApplicationContext()));
            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {
                Log.e("erorr",t.getMessage());
            }

        });
    }
}
