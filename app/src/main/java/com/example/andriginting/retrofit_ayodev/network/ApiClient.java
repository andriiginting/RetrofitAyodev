package com.example.andriginting.retrofit_ayodev.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Andri Ginting on 12/9/2017.
 */

public class ApiClient {
    //TODO (5) buat class ApiClient yang gunanya untuk melakukan spesifikasi URL dan akses API

    public static final String BASE_URL="http://api.themoviedb.org/3/";
    public static Retrofit retrofit = null;

    public static Retrofit getClient(){
        if (retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return  retrofit;
    }
}
