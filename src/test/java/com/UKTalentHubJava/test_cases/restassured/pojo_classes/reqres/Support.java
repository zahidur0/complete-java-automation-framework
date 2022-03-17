package com.UKTalentHubJava.test_cases.restassured.pojo_classes.reqres;

public class Support {

    private String url;
    private String text;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "ClassPOJO [url = " + url + ", text = " + text + "]";
    }
}