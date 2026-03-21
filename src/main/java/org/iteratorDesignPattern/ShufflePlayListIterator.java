package org.iteratorDesignPattern;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * ShufflePlayListIterator class - Concrete Iterator implementation for random order traversal.
 * This iterator traverses the playlist in a randomized/shuffled order.
 * It creates a copy of the playlist and shuffles it in the constructor,
 * then iterates through the shuffled list without affecting the original order.
 * This demonstrates how different iterator implementations can provide different
 * traversal strategies on the same collection without modifying the collection itself.
 */
public class ShufflePlayListIterator implements PlayListIterator{
    private final PlayList playList;      // Reference to the original collection
    private int curIndex;                  // Current position in the shuffled iteration
    private List<Song> shuffledSongs;      // A shuffled copy of the songs for random traversal

    /**
     * Constructor - Creates a shuffled iterator for the given playlist.
     * Creates a copy of all songs and shuffles them in random order.
     * The original playlist remains unchanged.
     * 
     * @param playList The playlist to iterate over in shuffled order
     */
    public ShufflePlayListIterator(PlayList playList) {
        this.playList = playList;
        this.curIndex = 0;
        // Create a copy of the songs list to avoid modifying the original
        this.shuffledSongs = new ArrayList<>(playList.getSongs());
        // Shuffle the copied list to randomize the order
        Collections.shuffle(this.shuffledSongs);
    }

    /**
     * Checks if there are more songs to iterate over in the shuffled order.
     * 
     * @return true if current index is within the bounds of the shuffled list, false otherwise
     */
    @Override
    public boolean hasNext() {
        return curIndex < shuffledSongs.size();
    }

    /**
     * Returns the next song in shuffled (random) order and advances the iterator.
     * 
     * @return The next Song object from the shuffled list at the current index
     * @throws IndexOutOfBoundsException if hasNext() was false (no more songs)
     */
    @Override
    public Song next() {
        if (!hasNext()) {
            throw new IndexOutOfBoundsException("No more songs in the playlist.");
        }
        // Return current song from shuffled list and increment index for next iteration
        return shuffledSongs.get(curIndex++);
    }

}
