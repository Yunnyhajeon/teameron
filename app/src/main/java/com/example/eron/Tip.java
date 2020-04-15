package com.example.eron;

public class Tip {
    private String number;
    private String tags;
    private String tip;
    private String body;
    private boolean expand;

    public Tip(String number, String tags, String tip, String body) {
        this.number = number;
        this.tags = tags;
        this.tip = tip;
        this.body = body;
        this.expand = false;
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

    public String getBody() { return body; }

    public void setBody(String body) { this.body = body; }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public boolean isExpand() {return expand;}

    public void setExpand(boolean expand) {this.expand = expand;}
}
