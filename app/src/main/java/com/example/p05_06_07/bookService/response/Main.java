package com.example.p05_06_07.bookService.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Main {
    @SerializedName("title")
    @Expose
    private String title;

    @SerializedName("author_name")
    @Expose
    private List<String> authorName;

    @SerializedName("number_of_pages_median")
    @Expose
    private Integer numberOfPagesMedian;

    public String getTitle() {
        return title;
    }

    public List<String> getAuthorName() {
        return authorName;
    }

    public Integer getNumberOfPagesMedian() {
        return numberOfPagesMedian;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthorName(List<String> authorName) {
        this.authorName = authorName;
    }

    public void setNumberOfPagesMedian(Integer numberOfPagesMedian) {
        this.numberOfPagesMedian = numberOfPagesMedian;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("title");
        sb.append("=");
        sb.append(((this.title == null) ? "<null>" : this.title));
        sb.append(",");
        sb.append("author");
        sb.append("=");
        if (this.authorName == null) {
            sb.append("<null>");
            sb.append(",");
        } else {
            sb.append("[");
            for (int i = 0; i < this.authorName.size(); i++) {
                sb.append(this.authorName.get(i));
                sb.append(",");
            }
            sb.append("]");
            sb.append(",");
        }
        sb.append("numberOfPagesMedian");
        sb.append("=");
        sb.append(((this.numberOfPagesMedian == null) ? "<null>" : this.numberOfPagesMedian));
        return sb.toString();

    }
}
