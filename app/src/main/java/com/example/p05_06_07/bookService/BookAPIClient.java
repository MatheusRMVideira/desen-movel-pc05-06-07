package com.example.p05_06_07.bookService;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BookAPIClient {
    private static Retrofit retrofit = null;

    public static Retrofit getClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl("https://openlibrary.org/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit;
    }
}
