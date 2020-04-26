package com.studia.backend.util;

public enum BookCategory {
    FANTASY("Fantasy"), SCIFI("Sci-fi"), ROMANCE("Romace"), ACTION("Action"), ADVENTURE("Adventure"), HORROR("Horror");

    private String value;

    BookCategory(String value) {
        this.value= value;
    }

    public String getValue() {
        return this.value;
    }
}
