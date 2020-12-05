package com.uthoff.adeventskalender;

import android.graphics.drawable.Drawable;

public class Door {
    private String Text;
    private Drawable Picture;

    public Door(String text, Drawable picture) {
        Text = text;
        Picture = picture;
    }

    public Door(String text) {
        Text = text;
        Picture = null;
    }

    public String getText() {
        return Text;
    }

    public void setText(String text) {
        Text = text;
    }

    public Drawable getPicture() {
        return Picture;
    }

    public void setPicture(Drawable picture) {
        Picture = picture;
    }
}
