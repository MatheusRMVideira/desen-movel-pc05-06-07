package com.example.p05_06_07.bookService;
import android.content.Context;
import android.util.Log;

import com.example.p05_06_07.bookService.response.BookResponse;
import com.example.p05_06_07.bookService.response.Main;
import com.example.p05_06_07.persistence.Book;
import com.example.p05_06_07.persistence.BookDao;
import com.example.p05_06_07.persistence.BookDatabase;
import com.google.gson.JsonElement;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BookRepository {
    public static void getBookByTitle(String title, BookCallback cb, Context ctx) {
        //Try to get cached version
        BookDao bookDao = BookDatabase.getInstance(ctx).bookDao();
        List<Main> cachedResponse = new ArrayList<>();
        bookDao.getByTitle(title)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(bookList -> {
                    for(Book book: bookList) {
                        Main temp = new Main();
                        temp.setTitle(book.getTitle());
                        temp.setAuthorName(book.getAuthorName());
                        temp.setNumberOfPagesMedian(book.getNumberOfPagesMedian());
                        cachedResponse.add(temp);
                    }
                });
        if (cachedResponse.size() > 0) {
            cb.onSuccess(cachedResponse);
        }

        BookInterface client = BookAPIClient.getClient().create(BookInterface.class);
        Call<BookResponse> call = client.getBookByTitle(title);
        call.enqueue(new Callback<BookResponse>() {
            @Override
            public void onResponse(Call<BookResponse> call, Response<BookResponse> response) {
                if (response.isSuccessful())
                    Log.d("BookRepository", "" + response.body().toString());

                try {
                    List<Main> rMain = response.body().getMain();
                    cb.onSuccess(rMain);
                } catch (Exception e) {
                    e.printStackTrace();
                    cb.onError("Falha ao obter/parsear Json");
                }
            }

            @Override
            public void onFailure(Call<BookResponse> call, Throwable t){
                cb.onError(t.getMessage());
            }
        });
    }

    public interface BookCallback {
        public void onSuccess(List<Main> bookList);

        public void onError(String errorMessage);
    }
}
