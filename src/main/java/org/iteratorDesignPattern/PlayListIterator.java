package org.iteratorDesignPattern;

/**
 * PlayListIterator interface - Defines the contract for all iterator implementations.
 * The Iterator Pattern is a behavioral design pattern that provides a way to access elements 
 * of a collection sequentially without exposing its underlying representation.
 * This interface defines two key methods:
 * - hasNext(): Checks if there are more elements to iterate over
 * - next(): Returns the next element in the iteration
 * Different implementations can traverse the collection in different ways:
 * - Sequential order (SimplePlayListIterator)
 * - Random order (ShufflePlayListIterator)  
 * - Filtered order (FavoritePlayListIterator)
 */
public interface PlayListIterator {
    /**
     * Checks if there are more elements to iterate over.
     * @return true if there are more elements, false otherwise
     */
    boolean hasNext();
    
    /**
     * Returns the next element in the iteration.
     * @return The next Song object
     * @throws IndexOutOfBoundsException if there are no more elements
     */
    Song next();
}
