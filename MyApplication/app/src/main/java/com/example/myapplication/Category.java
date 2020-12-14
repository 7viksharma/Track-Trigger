package com.example.myapplication;

public class Category {

       private String text;
       private int image;

    public Category(String text,int image) {
        this.text = text;
        this.image= image;
    }

    public String getText() {
        return text;
    }

    public int getImage() {
        return image;
    }

}
