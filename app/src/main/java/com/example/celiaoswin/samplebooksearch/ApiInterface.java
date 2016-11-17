package com.example.celiaoswin.samplebooksearch;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Celia Oswin on 09-11-2016.
 */
public interface ApiInterface {
    @GET("exampledocs/books.json")
    Call<List<Book>> getBooks();

}
