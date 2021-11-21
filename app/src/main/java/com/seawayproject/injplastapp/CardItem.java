package com.seawayproject.injplastapp;

/**
 * @author : Alexandr Onuferco
 * @created : 21/11/2021, Sunday
 * This project was created for educational purposes
 * all the referenced works are properties of respected copyright owners
 **/
public class CardItem {

    private String title;
    private String info;


    private final int imageResource;

    public CardItem(String title, String info, int imageResource) {
        this.title = title;
        this.info = info;
        this.imageResource = imageResource;
    }

    String getTitle() {
        return title;
    }

    String getInfo() {
        return info;
    }

    public int getImageResource() {
        return imageResource;
    }
}
