package com.example.p05_06_07.persistence;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.ColumnInfo;

import java.util.List;

//title author_name number of pages median

@Entity(tableName = "books")
public class Book {
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name="query_title")
    private String queryTitle;

    @ColumnInfo(name = "title")
    private String title;

    @ColumnInfo(name = "author_name")
    private List<String> authorName;

    @ColumnInfo(name = "number_of_pages_median")
    private int numberOfPagesMedian;

    public void Save(String title, List<String> authorName, int numberOfPagesMedian) {
        this.title = title;
        this.authorName = authorName;
        this.numberOfPagesMedian = numberOfPagesMedian;
    }

    public String getQueryTitle(){
        return queryTitle;
    }

    public String getTitle() {
        return title;
    }

    public List<String> getAuthorName() {
        return authorName;
    }

    public int getNumberOfPagesMedian() {
        return numberOfPagesMedian;
    }

    public void setQueryTitle(String queryTitle){
        this.queryTitle = queryTitle;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public void setAuthorName(List<String> authorName) {
        this.authorName = authorName;
    }

    public void setNumberOfPagesMedian(int numberOfPagesMedian) {
        this.numberOfPagesMedian = numberOfPagesMedian;
    }

}
