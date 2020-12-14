package com.example.myapplication;

public class Quantity {
   private String text;
    private int image;
    private String num;

    public Quantity(String text, int image,String num) {
        this.text = text;
        this.image = image;
        this.num = num;
    }

    public String getText() {
        return text;
    }

    public int getImage() {
        return image;
    }

    public String getNum() {
        return num;
    }
}
