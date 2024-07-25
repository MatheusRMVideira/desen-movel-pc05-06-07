package com.example.p05_06_07.persistence;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import java.util.List;
import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Single;

@Dao
public interface BookDao {
    @Query("SELECT * FROM books ORDER BY title ASC")
    public Flowable<List<Book>> getAllBooks();

    @Query("SELECT * FROM books WHERE query_title = :queryTitle")
    public Flowable<List<Book>> getByTitle(String queryTitle);

    @Insert
    public Completable insertBook(Book book);

    @Query("DELETE FROM books")
    public Single<Integer> deleteAllBooks();
}
