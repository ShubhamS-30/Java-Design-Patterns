package org.iteratorDesignPattern;

/**
 * FavoritePlayListIterator class - Concrete Iterator implementation for filtered traversal.
 * This iterator traverses only the songs marked as favorites in the playlist.
 * It skips over non-favorite songs and only returns songs where isFavorite() is true.
 * This is a more sophisticated iterator that implements filtering logic while maintaining
 * the Iterator interface, demonstrating how iterators can provide different views of 
 * the same collection based on custom criteria.
 */
public class FavoritePlayListIterator implements PlayListIterator{
    private final PlayList playList;  // Reference to the collection being iterated
    private int curIndex;              // Current position in the original playlist

    /**
     * Constructor - Creates a favorite-songs iterator for the given playlist.
     * Initializes the current index to 0 (start of the playlist).
     * 
     * @param playList The playlist to iterate over, returning only favorite songs
     */
    public FavoritePlayListIterator(PlayList playList) {
        this.playList = playList;
        this.curIndex = 0;
    }

    /**
     * Checks if there are more favorite songs to iterate over.
     * This method implements filtering logic by advancing the current index 
     * through non-favorite songs until it finds a favorite song or reaches 
     * the end of the playlist.
     * 
     * @return true if a favorite song is found from current position onwards, false if no more favorites
     */
    @Override
    public boolean hasNext() {
        // Continue advancing through the playlist while songs are not favorites
        while (curIndex < playList.getSongs().size()) {
            // Check if the current song is marked as favorite
            if (playList.getSongs().get(curIndex).isFavorite()) {
                return true;  // Found a favorite song
            }
            // Skip non-favorite songs by incrementing the index
            curIndex++;
        }
        // No more favorite songs found
        return false;
    }

    /**
     * Returns the next favorite song in the playlist.
     * The hasNext() method ensures the current index points to a favorite song.
     * This method returns that song and increments the index for the next iteration.
     * 
     * @return The next favorite Song object
     * @throws IndexOutOfBoundsException if hasNext() was false (no more favorite songs)
     */
    @Override
    public Song next() {
        if (!hasNext()) {
            throw new IndexOutOfBoundsException("No more favorite songs in the playlist.");
        }
        // Return the favorite song at current index and increment for next call
        return playList.getSongs().get(curIndex++);
    }
}


