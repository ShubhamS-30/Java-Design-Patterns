package org.observerDesignPattern.Observable;

import org.observerDesignPattern.Observer.NotificationObserver;

/**
 * stockObservable - Observable/Subject Interface in Observer Design Pattern
 *
 * Purpose: Defines the contract for observable objects that can be watched
 * by multiple observer objects
 *
 * Responsibilities:
 * 1. Manage a list of observers
 * 2. Notify all observers when state changes
 *
 * Observable = Subject = Product Stock in this example
 * When stock count changes, all observers are notified
 *
 * Methods:
 * - add(): Observer subscribes to notifications
 * - remove(): Observer unsubscribes from notifications
 * - notifyObservers(): Alert all observers of state change
 * - setStockCount() & getStockCount(): Manage the observable's state
 */
public interface stockObservable {
    /**
     * Adds an observer to the subscription list
     * Observer will be notified whenever state changes
     */
    public void add(NotificationObserver observer);

    /**
     * Removes an observer from the subscription list
     * Observer will no longer receive notifications
     */
    public void remove(NotificationObserver observer);

    /**
     * Notifies all subscribed observers about state change
     * Calls update() on each observer
     */
    public void notifyObservers();

    /**
     * Updates the observable's state (stock count)
     * Usually called notifyObservers() after this
     */
    public void setStockCount(int count);

    /**
     * Gets the current state (stock count)
     */
    public int getStockCount();
}
