package org.iteratorDesignPattern;

/**
 * SimplePlayListIterator class - Concrete Iterator implementation.
 * This iterator traverses the playlist in sequential order (first to last).
 * It implements the PlayListIterator interface to provide a standard way to 
 * iterate through songs in the playlist.
 * The iterator encapsulates the iteration logic and maintains the iteration state 
 * (current position), allowing the client to traverse the collection without 
 * knowing its internal structure.
 */
public class SimplePlayListIterator implements PlayListIterator{
    private final PlayList playList;  // Reference to the collection being iterated
    private int curIndex;              // Current position in the iteration (0-based index)

    /**
     * Constructor - Creates an iterator for the given playlist.
     * Initializes the current index to 0 (start of the playlist).
     * 
     * @param playList The playlist to iterate over
     */
    public SimplePlayListIterator(PlayList playList) {
        this.playList = playList;
        this.curIndex = 0;
    }

    /**
     * Checks if there are more songs to iterate over in sequential order.
     * 
     * @return true if current index is within the bounds of the playlist, false otherwise
     */
    @Override
    public boolean hasNext() {
        return curIndex < playList.getSongs().size();
    }

    /**
     * Returns the next song in sequential order and advances the iterator.
     * 
     * @return The next Song object at the current index
     * @throws IndexOutOfBoundsException if hasNext() was false (no more songs)
     */
    @Override
    public Song next() {
        if (!hasNext()) {
            throw new IndexOutOfBoundsException("No more songs in the playlist.");
        }
        // Return current song and increment index for next iteration
        return playList.getSongs().get(curIndex++);
    }
}
