package com.example.p05_06_07.bookService.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BookResponse {
    @SerializedName("numFound")
    private Integer numFound;

    @SerializedName("start")
    @Expose
    private Integer start;

    @SerializedName("numFoundExact")
    @Expose
    private Boolean numFoundExact;

    @SerializedName("q")
    @Expose
    private String q;

    @SerializedName("docs")
    @Expose
    private List<Main> main;

    public List<Main> getMain() {
        return main;
    }

    public Integer getNumFound() {
        return numFound;
    }

    public Integer getStart() {
        return start;
    }

    public Boolean getNumFoundExact() {
        return numFoundExact;
    }

    public String getQ() {
        return q;
    }

    public void setMain(List<Main> mainList) {
        this.main = mainList;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public void setNumFound(Integer numFound) {
        this.numFound = numFound;
    }

    public void setNumFoundExact(Boolean numFoundExact) {
        this.numFoundExact = numFoundExact;
    }

    public void setQ(String q){
        this.q = q;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("numFound");
        sb.append("=");
        sb.append(((this.numFound == null) ? "<null>" : this.numFound));
        sb.append(",");
        sb.append("start");
        sb.append("=");
        sb.append(((this.start == null) ? "<null>" : this.start));
        sb.append(",");
        sb.append("numFoundExact");
        sb.append("=");
        sb.append(((this.numFoundExact == null) ? "<null>" : this.numFoundExact));
        sb.append(",");
        sb.append("q");
        sb.append("=");
        sb.append(((this.q == null) ? "<null>" : this.q));
        sb.append(",");
        sb.append("books");
        sb.append("=");
        if (this.main == null) {
            sb.append("<null>");
            sb.append(",");
        } else {
            for (int j = 0; j < this.main.size(); j++) {
                sb.append(this.main.get(j));
                sb.append(",");
            }
        }
        return sb.toString();
    }
}
