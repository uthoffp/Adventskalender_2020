package com.uthoff.adeventskalender;

public class AlertTexts {
    private String text;
    private String button;

    public AlertTexts(String text, String button) {
        this.text = text;
        this.button = button;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getButton() {
        return button;
    }

    public void setButton(String button) {
        this.button = button;
    }
}
