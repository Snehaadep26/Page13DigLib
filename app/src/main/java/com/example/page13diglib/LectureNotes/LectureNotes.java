package com.example.page13diglib.LectureNotes;

public class LectureNotes {

    private int imageView;
    String infoText;

    public LectureNotes(int imageView, String infoText) {
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
