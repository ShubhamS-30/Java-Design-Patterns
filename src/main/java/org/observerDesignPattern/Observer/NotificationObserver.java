package org.observerDesignPattern.Observer;

/**
 * NotificationObserver - Observer Interface in Observer Design Pattern
 *
 * Purpose: Defines the contract for objects that want to be notified when
 *          the observable (subject) changes state
 *
 * Observer Design Pattern Key Concepts:
 * - Creates a subscription mechanism
 * - Observers (subscribers) get notified when observable (subject) changes
 * - Decouples observable from observers
 * - One-to-many dependency where when one object changes, all dependents are notified
 *
 * Real-world analogy:
 * - Observable: YouTube channel (subject)
 * - Observers: Subscribers (objects that care about notifications)
 * - update(): Notification sent to all subscribers when channel posts video
 *
 * Another example (in this code):
 * - Observable: Stock/Product inventory
 * - Observers: Email, SMS notification systems
 * - update(): Called when stock changes to notify all observers
 */
public interface NotificationObserver {
    /**
     * This method is called by the observable when state changes
     * Each observer implements this to react to the state change
     */
    public void update();
}
