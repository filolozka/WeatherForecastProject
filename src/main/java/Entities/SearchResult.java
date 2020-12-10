package Entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SearchResult {
    private String woeid;

    public SearchResult(String woeid) {
        this.woeid = woeid;
    }

    public SearchResult() {
    }

    public String getWoeid() {
        return woeid;
    }

    public void setWoeid(String woeid) {
        this.woeid = woeid;
    }

    @Override
    public String toString() {
        return "SearchResult{" +
                "woeid='" + woeid + '\'' +
                '}';
    }
}
