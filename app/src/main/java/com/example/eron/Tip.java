package com.example.eron;

public class Tip {
    private int number;
    private String tags;
    private String tip;
    private String url;

    public Tip(int number, String tags, String tip, String url) {
        this.number = number;
        this.tags = tags;
        this.tip = tip;
        this.url = url;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }


    public String getURL() {
        return url;
    }

    public void setURL(String url) {
        this.url = url;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
