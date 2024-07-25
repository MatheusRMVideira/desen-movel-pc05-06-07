package com.example.p05_06_07.bookService;

import com.example.p05_06_07.bookService.response.BookResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface BookInterface {
    @GET("search.json")
    public Call<BookResponse> getBookByTitle(
            @Query("title") String title
    );

    @GET("search.json")
    public Call<BookResponse> getBookByAuthor(
            @Query("author") String author
    );
}
