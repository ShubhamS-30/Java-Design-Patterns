package org.iteratorDesignPattern;

/**
 * Client class - Demonstrates the Iterator Design Pattern in action.
 * The Iterator Pattern is a behavioral design pattern that provides a way to access 
 * elements of a collection sequentially without exposing its underlying representation.
 * Key Benefits:
 * 1. Separates the collection structure from the traversal algorithm
 * 2. Allows multiple simultaneous iterations over the same collection
 * 3. Provides different iteration strategies without modifying the collection
 * 4. Simplifies client code - no need to understand collection internals
 * This example demonstrates three different ways to iterate over the same playlist:
 * - Simple/Sequential iteration (in order)
 * - Shuffled/Random iteration (randomized order)
 * - Filtered iteration (only favorite songs)
 */
public class Client {
    public static void main(String[] args) {
        
        // Create a playlist and populate it with songs
        // Each song has a title, artist, and a boolean flag indicating if it's a favorite
        PlayList playList = new PlayList();
        playList.addSong(new Song("Song 1", "Artist A", false));
        playList.addSong(new Song("Song 2", "Artist B", true));
        playList.addSong(new Song("Song 3", "Artist C", false));
        playList.addSong(new Song("Song 4", "Artist D", true));
        playList.addSong(new Song("Song 5", "Artist E", false));
        playList.addSong(new Song("Song 6", "Artist F", true));

        // Example 1: Simple Iterator - Iterates through all songs in order
        System.out.println("All songs in the playlist:");
        // Create a SimplePlayListIterator that traverses songs sequentially
        PlayListIterator simpleIterator = new SimplePlayListIterator(playList);
        // Iterate through all songs using standard iterator pattern
        while (simpleIterator.hasNext()) {
            Song song = simpleIterator.next();
            System.out.println(song.getTitle() + " by " + song.getArtist());
        }

        // Example 2: Favorite Iterator - Iterates only through favorite songs
        System.out.println("\nFavorite songs in the playlist:");
        // Create a FavoritePlayListIterator that filters for only favorite songs
        PlayListIterator favoriteIterator = new FavoritePlayListIterator(playList);
        // Iterate through favorite songs only
        while (favoriteIterator.hasNext()) {
            Song song = favoriteIterator.next();
            System.out.println(song.getTitle() + " by " + song.getArtist());
        }

        // Example 3: Shuffle Iterator - Iterates through all songs in random order
        System.out.println("\nShuffled songs in the playlist:");
        // Create a ShufflePlayListIterator that randomizes the song order
        PlayListIterator shuffleIterator = new ShufflePlayListIterator(playList);
        // Iterate through songs in random order
        while (shuffleIterator.hasNext()) {
            Song song = shuffleIterator.next();
            System.out.println(song.getTitle() + " by " + song.getArtist());
        }
    }
}
