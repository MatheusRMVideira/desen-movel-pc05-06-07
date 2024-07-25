package com.example.p05_06_07.persistence;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Book.class}, version =  1)
public abstract class BookDatabase extends RoomDatabase {
    private static volatile BookDatabase INSTANCE;

    public abstract BookDao bookDao();

    public static BookDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (BookDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            BookDatabase.class, "book.db").build();
                }
            }
        }
        return INSTANCE;
    }
}
