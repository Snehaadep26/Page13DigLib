package com.example.page13diglib.QuestionBank;

public class QuestionBank {
    private int imageView;
    String infoText;

    public QuestionBank(int imageView, String infoText) {
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
