package org.iteratorDesignPattern;

/**
 * Song class - Represents a single song in the playlist.
 * This is the element/item class that will be iterated over by different iterator implementations.
 */
public class Song {
    private final String title;    // The title of the song
    private final String artist;   // The artist who performed the song
    private final boolean isFavorite; // Flag indicating if the song is marked as favorite

    /**
     * Constructor to create a Song object.
     * @param title The title of the song
     * @param artist The artist name
     * @param isFavorite Whether this song is marked as favorite
     */
    public Song(String title, String artist, boolean isFavorite) {
        this.title = title;
        this.artist = artist;
        this.isFavorite = isFavorite;
    }

    /**
     * Gets the title of the song.
     * @return The song title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Gets the artist name of the song.
     * @return The artist name
     */
    public String getArtist() {
        return artist;
    }

    /**
     * Checks if the song is marked as favorite.
     * @return true if favorite, false otherwise
     */
    public boolean isFavorite() {
        return isFavorite;
    }
}
