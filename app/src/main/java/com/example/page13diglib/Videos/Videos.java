package com.example.page13diglib.Videos;

public class Videos {
    private int imageView;
    String infoText;

    public Videos(int imageView, String infoText) {
        this.imageView = imageView;
        this.infoText = infoText;
    }

    public int getImageView() {
        return imageView;
    }

    public String getInfoText() {
        return infoText;
    }
}
