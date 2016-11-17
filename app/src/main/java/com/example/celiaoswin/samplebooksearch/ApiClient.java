package com.example.celiaoswin.samplebooksearch;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Celia Oswin on 09-11-2016.
 */
public class ApiClient {

    public static final String URL = "https://raw.githubusercontent.com/tamingtext/book/master/apache-solr/example/";


    private static Retrofit retro =null;

    public static Retrofit getClient() {
        if(retro == null) {
            retro = new Retrofit.Builder()
                    .baseUrl(URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retro;
    }
}
