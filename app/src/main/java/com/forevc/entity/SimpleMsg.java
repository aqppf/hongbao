package com.forevc.entity;

import java.io.Serializable;

public class SimpleMsg implements Serializable {

    private String title;
    private String content;

    public SimpleMsg(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
