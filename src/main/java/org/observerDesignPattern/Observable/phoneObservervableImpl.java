package org.observerDesignPattern.Observable;

import org.observerDesignPattern.Observer.NotificationObserver;

import java.util.ArrayList;
import java.util.List;

/**
 * phoneObservableImpl - Concrete Observable/Subject in Observer Pattern
 *
 * Role: Maintains the state (stock count) and notifies all registered observers
 *       when the state changes
 *
 * Key Points:
 * 1. Maintains a list of observers interested in stock changes
 * 2. When stock changes, notifies all observers
 * 3. Observers don't need to poll for updates - they get pushed updates
 * 4. Observable doesn't need to know about observer implementations
 *
 * In this example:
 * - Observable represents a phone's stock/inventory
 * - When stock becomes available (changes from 0), all observers are notified
 * - Observers (Email, SMS) react by sending notifications to customers
 */
public class phoneObservervableImpl implements stockObservable {

    // Current stock/inventory count
    private int stock = 0;

    // List of all observers interested in stock changes
    // This allows one-to-many relationships
    private List<NotificationObserver> observers = new ArrayList<NotificationObserver>();

    /**
     * Adds a new observer to the notification list
     * Observer subscribes to receive updates when stock changes
     *
     * @param observer - The observer object to add
     */
    @Override
    public void add(NotificationObserver observer) {
        observers.add(observer);
    }

    /**
     * Removes an observer from the notification list
     * Observer will no longer receive updates
     *
     * @param observer - The observer object to remove
     */
    @Override
    public void remove(NotificationObserver observer) {
        observers.remove(observer);
    }

    /**
     * Notifies all registered observers about state change
     * This is the "push" mechanism - updates are sent to observers
     * instead of observers polling for updates
     */
    @Override
    public void notifyObservers() {
        // Iterate through all observers and call their update() method
        for (NotificationObserver observer : observers) {
            observer.update();  // Each observer decides what to do with the update
        }
    }

    /**
     * Updates the stock count
     * If stock changes from 0 (out of stock) to available, notify all observers
     * This is the key event that triggers observer notifications
     *
     * @param count - New stock count
     */
    @Override
    public void setStockCount(int count) {
        // Stock becoming available (0 -> positive) is the important event
        if (this.stock == 0)
        {
            // Stock was 0, now becoming available - NOTIFY OBSERVERS!
            this.stock = count;
            notifyObservers();  // Alert all observers about stock availability
        }
        else
            // Stock already available, just update count
            this.stock = count;
    }

    /**
     * Returns the current stock count
     * Observers can call this to get details when update() is called
     *
     * @return Current stock count
     */
    @Override
    public int getStockCount() {
        return this.stock;
    }
}
