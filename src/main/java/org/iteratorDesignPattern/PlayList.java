package org.iteratorDesignPattern;

import java.util.ArrayList;
import java.util.List;

public class PlayList {
    private final List<Song> songs;

    public PlayList() {
        this.songs = new ArrayList<>();
    }

    public void addSong(Song song) {
        songs.add(song);
    }

    public void removeSong(Song song) {
        songs.remove(song);
    }

    public List<Song> getSongs() {
        return songs;
    }

    public PlayListIterator createIteratot(String type) {
        return switch (type.toLowerCase()) {
            case "simple" -> new SimplePlayListIterator(this);
            case "shuffle" -> new ShufflePlayListIterator(this);
            case "favorite" -> new FavoritePlayListIterator(this);
            default -> throw new IllegalArgumentException("Unknown iterator type: " + type);
        };
    }
}
