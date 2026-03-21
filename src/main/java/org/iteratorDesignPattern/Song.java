package org.iteratorDesignPattern;

public class Song {
    private final String title;
    private final String artist;
    private final boolean isFavorite;

    public Song(String title, String artist, boolean isFavorite) {
        this.title = title;
        this.artist = artist;
        this.isFavorite = isFavorite;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public boolean isFavorite() {
        return isFavorite;
    }
}
