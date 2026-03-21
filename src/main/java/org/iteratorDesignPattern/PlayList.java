package org.iteratorDesignPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * PlayList class - Represents a collection of songs (the Aggregate/Collection object).
 * In the Iterator Pattern, this is the object that holds the collection of elements (songs).
 * Instead of exposing its internal structure directly, it provides methods to create 
 * different iterator implementations to traverse the songs in different ways.
 * This class encapsulates the collection and provides a factory method to create iterators.
 */
public class PlayList {
    // The underlying collection of songs
    private final List<Song> songs;

    /**
     * Constructor - Initializes an empty playlist.
     */
    public PlayList() {
        this.songs = new ArrayList<>();
    }

    /**
     * Adds a song to the playlist.
     * @param song The song to add
     */
    public void addSong(Song song) {
        songs.add(song);
    }

    /**
     * Removes a song from the playlist.
     * @param song The song to remove
     */
    public void removeSong(Song song) {
        songs.remove(song);
    }

    /**
     * Gets the underlying collection of songs.
     * @return List of all songs in the playlist
     */
    public List<Song> getSongs() {
        return songs;
    }

    /**
     * Factory method - Creates an iterator of the specified type.
     * This demonstrates the Factory Pattern within the Iterator Pattern.
     * 
     * @param type The type of iterator to create: "simple", "shuffle", or "favorite"
     * @return A PlayListIterator implementation based on the type
     * @throws IllegalArgumentException if the type is not recognized
     */
    public PlayListIterator createIteratot(String type) {
        return switch (type.toLowerCase()) {
            case "simple" -> new SimplePlayListIterator(this);
            case "shuffle" -> new ShufflePlayListIterator(this);
            case "favorite" -> new FavoritePlayListIterator(this);
            default -> throw new IllegalArgumentException("Unknown iterator type: " + type);
        };
    }
}
